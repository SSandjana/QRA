package com.quick.response.application.global.services.impl;

import com.quick.response.application.client.entities.Voertuig;
import com.quick.response.application.client.entities.VoertuigDocument;
import com.quick.response.application.global.entities.ConfigUploadDocument;
import com.quick.response.application.global.entities.Document;
import com.quick.response.application.global.entities.UploadDocument;
import com.quick.response.application.global.entities.User;
import com.quick.response.application.global.repositories.ConfigUploadDocumentRepository;
import com.quick.response.application.global.repositories.DocumentRepository;
import com.quick.response.application.global.repositories.UploadDocumentRepository;
import com.quick.response.application.global.repositories.VoertuigDocumentRepository;
import com.quick.response.application.global.services.DocumentService;
import com.quick.response.application.global.services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.quick.response.application.global.utilities.Constants.UPLOAD_LOCATION_SETTINGS;

@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class DocumentServiceImpl implements DocumentService {

    private final ConfigUploadDocumentRepository configUploadDocumentRepository;
    private final FileService fileService;
    private final UploadDocumentRepository uploadDocumentRepository;
    private final VoertuigDocumentRepository voertuigDocumentRepository;
    private final DocumentRepository documentRepository;

    @Override
    public List<ConfigUploadDocument> getUploadableDocuments(Long userId) {
        return configUploadDocumentRepository.findAll();
    }

    @Override
    @Transactional
    public Document addDocument(Long uploadDocumentId,
                                LocalDate vervaldatum,
                                String omschrijving,
                                MultipartFile file,
                                Long userId) throws IOException {

        String[] allowedFileTypes = {"image/png", "image/jpeg", "application/pdf"};
        fileService.validateFileNameAndTypes(file, allowedFileTypes);
        String origName = file.getOriginalFilename();
        String contentType = file.getContentType();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        String uniqueName = userId.toString() + "_" + timestamp + "_" + origName;

        UploadDocument uploadDocument = uploadDocumentRepository.findById(uploadDocumentId)
                .orElseThrow(() -> new RuntimeException("Upload document definitie niet gevonden"));

        Document document = Document.builder()
                .user(User.builder().id(userId).build())
                .contentType(contentType)
                .documentType(uploadDocument)
                .filename(uniqueName)
                .omschrijving(omschrijving)
                .vervaldatum(vervaldatum)
                .build();
        Document doc = documentRepository.save(document);

        fileService.save(file, uniqueName, UPLOAD_LOCATION_SETTINGS);

        return doc;
    }

    @Override
    public VoertuigDocument addDocument(Long uploadDocumentId,
                                        LocalDate vervaldatum,
                                        String omschrijving,
                                        MultipartFile file,
                                        Long userId,
                                        Long voertuigId) throws IOException {

        String[] allowedFileTypes = {"image/png", "image/jpeg", "application/pdf"};
        fileService.validateFileNameAndTypes(file, allowedFileTypes);
        String origName = file.getOriginalFilename();
        String contentType = file.getContentType();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        String uniqueName = userId.toString() + "_" + timestamp + "_" + origName;

        UploadDocument uploadDocument = uploadDocumentRepository.findById(uploadDocumentId)
                .orElseThrow(() -> new RuntimeException("Upload document definitie niet gevonden"));

        VoertuigDocument document = VoertuigDocument.builder()
                .user(User.builder().id(userId).build())
                .voertuig(Voertuig.builder().id(voertuigId).build())
                .contentType(contentType)
                .documentType(uploadDocument)
                .filename(uniqueName)
                .omschrijving(omschrijving)
                .vervaldatum(vervaldatum)
                .build();
        VoertuigDocument doc = voertuigDocumentRepository.save(document);

        fileService.save(file, uniqueName, UPLOAD_LOCATION_SETTINGS);

        return doc;

    }
}
