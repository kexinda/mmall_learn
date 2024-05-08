package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by kexi955 on 5/6/2024.
 */
public interface IFileService {
    String upload(MultipartFile file, String path);
}
