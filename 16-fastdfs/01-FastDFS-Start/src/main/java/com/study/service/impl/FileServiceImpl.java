package com.study.service.impl;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.study.config.MyConfig;
import com.study.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Autowired
    private MyConfig myConfig;


    @Override
    public void doFileUpload(MultipartFile file) {
        PrintWriter writer = null;
        ServletRequestAttributes servletRequestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 前端name属性的名字
        String name = file.getName();
//        System.out.println(name);
        // 获取文件原始名称
        String originalFilename = file.getOriginalFilename();
        // 获取文件大小
        long size = file.getSize();
        // 获取文件类型
        String contentType = file.getContentType();
        if (!myConfig.getAllowType().contains(contentType)) {
            writer.write( "不匹配的文件类型");
        }
        // 获取文件扩展名
        String ext = StringUtils.getFilenameExtension(originalFilename);
        StorePath storePath = null;
        try {
            storePath = fastFileStorageClient.uploadFile(file.getInputStream(), size, ext, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fullPath = storePath.getFullPath();
        writer.write("图片的地址为: "+ myConfig.getServerHost() + fullPath);
        writer.close();
    }

    /*
        这里传的是fullPath
        eg: group1/M00/00/00/rBEDu2GBHPmACnIiAAsZ8aN-xcE878.gif
     */
    @Override
    public void delFile(String url) {
        fastFileStorageClient.deleteFile(url);
    }
}
