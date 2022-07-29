package com.quick.response.application.global.controller;

import com.quick.response.application.global.entities.ConfigUploadDocument;
import com.quick.response.application.global.entities.Document;
import com.quick.response.application.global.services.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/documents")
@AllArgsConstructor
public class DocumentUploadController {

    private DocumentService documentService;

    @RequestMapping(value = "/get-uploadable-documents", method = RequestMethod.GET)
    public List<ConfigUploadDocument> getUploadableDocuments(@RequestParam("userId") Long userId) {
        return documentService.getUploadableDocuments(userId);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Document upload(@RequestParam("file") MultipartFile file,
                           @RequestParam(value = "omschrijving", required = false) String omschrijving,
                           @RequestParam(value = "vervaldatum", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") LocalDate vervaldatum,
                           @RequestParam(value = "documentType") Long uploadDocumentId,
                           @RequestParam(value = "userId", required = false) Long userId) throws IOException {
        return documentService.addDocument(uploadDocumentId, vervaldatum, omschrijving, file, userId);
    }

}
