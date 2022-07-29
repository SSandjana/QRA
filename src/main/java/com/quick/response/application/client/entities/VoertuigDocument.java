package com.quick.response.application.client.entities;

import com.quick.response.application.global.entities.UploadDocument;
import com.quick.response.application.global.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class VoertuigDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @NotNull
    @Size(max = 255)
    private String filename;
    @Size(max = 255)
    private String omschrijving;

    @NotNull
    @Size(max = 255)
    private String contentType;

    private LocalDate vervaldatum;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "document_type_id")
    @NotNull
    private UploadDocument documentType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "voertuig_id")
    @NotNull
    private Voertuig voertuig;
}
