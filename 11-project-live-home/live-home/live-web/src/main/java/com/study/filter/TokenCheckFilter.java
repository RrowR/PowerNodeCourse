package com.study.filter;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.common.Result;
import com.study.constant.LoginConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * token的校验
 */
@Component
public class TokenCheckFilter extends OncePerRequestFilter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 1.拿到请求路径
     * 2.判断是否需要放行
     * 3.拿到请求头
     * 4.拿到token
     * 5.查询redis    换用户对象
     * 6.放到securityContext里面去
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 拿到请求路径
        String path = request.getRequestURI();
        if (Arrays.asList(LoginConstant.ALLOW_URL).contains(path)) {
            // 如果请求的地址包含集合里的地址，那么就直接放行
            filterChain.doFilter(request, response);
            return;
        }
        if (path.contains("swagger") || path.contains("api")) {
            // 如果请求的地址包含集合里的地址，那么就直接放行
            filterChain.doFilter(request, response);
            return;
        }
        String authorization = request.getHeader(LoginConstant.AUTHORIZATION);
        if (StringUtils.hasText(authorization)) {
            String token = authorization.replaceAll("bearer ", "");
            // 拿到token去查询redis
            String token_res = stringRedisTemplate.opsForValue().get(LoginConstant.LOGIN_PREFIX + token);
            if (StringUtils.hasText(token_res)) {
                UsernamePasswordAuthenticationToken authenticationToken = JSON.parseObject(token_res, UsernamePasswordAuthenticationToken.class);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                // 如果拿到的token不为空，就放行
                filterChain.doFilter(request, response);
                return;
            }
        }
        Result result = new Result();
        result.setMsg("没有权限，请重新登录");
        result.setCode(401);
        ObjectMapper objectMapper = new ObjectMapper();
        PrintWriter writer = response.getWriter();
        writer.write(objectMapper.writeValueAsString(result));
    }
}
