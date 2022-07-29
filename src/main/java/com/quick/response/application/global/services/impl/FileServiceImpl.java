package com.quick.response.application.global.services.impl;

import com.quick.response.application.global.services.FileService;
import org.apache.tika.Tika;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileServiceImpl implements FileService {
    private static final Pattern FILE_NAME_ALLOWED_PATTERNS = Pattern.compile("^[a-z0-9 `~!@#$%^&()_+={};',.\\[\\]\\-]+\\.[a-z0-9]+$", Pattern.CASE_INSENSITIVE);
    private static final Tika TIKA = new Tika();

    @Override

    public void validateFileNameAndTypes(MultipartFile file, String[] allowedFileTypes) {

        String contentType = file.getContentType();
        String fileNameOriginal = file.getOriginalFilename();

        // File type validation based on supplied filename suffix
        if (contentType != null && fileNameOriginal != null
                && !Arrays.asList(allowedFileTypes).contains(contentType)
                && Arrays.stream(allowedFileTypes).noneMatch(file.getName()::endsWith)
                && Arrays.stream(allowedFileTypes).noneMatch(fileNameOriginal::endsWith)) {
            throw new IllegalArgumentException("File type is not allowed");
        }

        // File name validation
        if (fileNameOriginal != null) {
            Matcher matcher = this.FILE_NAME_ALLOWED_PATTERNS.matcher(fileNameOriginal);

            if (!matcher.matches()) {
                throw new IllegalArgumentException("Filename contains illegal characters");
            }
        }

        // File content validation
        try (InputStream inputStream = file.getInputStream()) {
            String mimeType = this.TIKA.detect(inputStream);

            if (Arrays.stream(allowedFileTypes).noneMatch(mimeType::equalsIgnoreCase)) {
                throw new IllegalArgumentException("File type: " + mimeType);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Path save(MultipartFile fileData, String filename, String uploadLocationSettings) throws IOException {
        if (fileData == null || filename == null || filename.trim().isEmpty()) {
            return null;
        }

        Path fullPath = Paths.get(uploadLocationSettings, filename);

        if (!Files.exists(fullPath.getParent())) {
            Files.createDirectories(fullPath.getParent());
        }

        try (OutputStream outputStream = Files.newOutputStream(fullPath)) {
            outputStream.write(fileData.getBytes());
            return fullPath;
        }
    }


}
