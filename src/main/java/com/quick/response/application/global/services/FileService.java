package com.quick.response.application.global.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface FileService {
    void validateFileNameAndTypes(MultipartFile file, String[] allowedFileTypes);

    Path save(MultipartFile fileData, String filename, String uploadLocationSettings) throws IOException;

}
