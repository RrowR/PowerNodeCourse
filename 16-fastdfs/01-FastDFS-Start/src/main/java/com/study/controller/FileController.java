package com.study.controller;

import com.study.service.FileService;
import com.study.service.impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("upload")
    public void uploadFile(MultipartFile file){
        fileService.doFileUpload(file);
    }

    @GetMapping("doDel")
    public void doDel(String path){
        fileService.delFile(path);
    }
}
