package com.quick.response.application.global.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
