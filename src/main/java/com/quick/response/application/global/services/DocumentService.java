package com.quick.response.application.global.services;

import com.quick.response.application.client.entities.VoertuigDocument;
import com.quick.response.application.global.entities.ConfigUploadDocument;
import com.quick.response.application.global.entities.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface DocumentService {
    List<ConfigUploadDocument> getUploadableDocuments(Long userId);

    Document addDocument(Long uploadDocumentId, LocalDate vervaldatum, String omschrijving, MultipartFile file, Long userId) throws IOException;
    VoertuigDocument addDocument(Long uploadDocumentId, LocalDate vervaldatum, String omschrijving, MultipartFile file, Long userId, Long voertuigId) throws IOException;
}
