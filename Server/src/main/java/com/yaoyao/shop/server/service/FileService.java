package com.yaoyao.shop.server.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author yoki
 * @create 2020-12-20  20:39
 */
public interface FileService {

    /**
     * 上传文件
     * @param multipartFile
     * @param fileName
     * @return
     * @throws IOException
     */
    boolean uploadFile(MultipartFile multipartFile,String fileName)throws IOException;
}
