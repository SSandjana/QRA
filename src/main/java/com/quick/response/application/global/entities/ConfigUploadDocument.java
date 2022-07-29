package com.quick.response.application.global.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cnf_upload_document", uniqueConstraints = @UniqueConstraint(columnNames = {"upload_document_id", "user_id"}))
public class ConfigUploadDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "upload_document_id")
    @Where(clause = "deleted = false and enabled = true")
    private UploadDocument uploadDocument;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdByUser;

    @NotNull
    private boolean verplicht;

    @NotNull
    private boolean zichtbaar;

    @NotNull
    @Min(0)
    private Long aantal;

    @Min(0)
    private Long geldigheidDagen;

    private String infoText;

    private String notes;
}
