package com.study.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    void doFileUpload(MultipartFile file);

    void delFile(String url);
}
