package com.study.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable, UserDetails {
    private Integer userid;

    private String username;

    private String userpwd;

    private String sex;

    private String address;

    private List<String> auths;

    /**
     * 用户状态字段(1:正常 0:禁用)
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return auths.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public String getUsername(){
        return username;
    }

    @Override
    public String getPassword() {
        return userpwd;
    }

    @Override
    public boolean isAccountNonExpired() {
        return status == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return status == 1;
    }

    @Override
    public boolean isEnabled() {
        return status == 1;
    }
}