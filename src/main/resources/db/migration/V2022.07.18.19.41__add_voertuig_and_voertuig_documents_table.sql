CREATE TABLE voertuig
(
    id              BIGINT(20) NOT NULL AUTO_INCREMENT,
    merk            VARCHAR(255) NOT NULL,
    voertuig_type   BIGINT(20) NOT NULL,
    user_id         BIGINT(20) NOT NULL,
    bouw_jaar       BIGINT(20) NOT NULL,
    kenteken_nummer VARCHAR(255) NOT NULL UNIQUE,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT fk_voertuig_voertuig_type FOREIGN KEY (voertuig_type) REFERENCES voertuig_type (id),
    CONSTRAINT fk_voertuig_user_id FOREIGN KEY (user_id) REFERENCES user (id)
);


CREATE TABLE voertuig_document
(
    id               BIGINT(20) NOT NULL AUTO_INCREMENT,
    content_type     VARCHAR(255) NOT NULL,
    filename         VARCHAR(255) NOT NULL,
    omschrijving     VARCHAR(255) NULL,
    vervaldatum      date NULL,
    user_id          BIGINT(20) NOT NULL,
    document_type_id BIGINT(20) NOT NULL,
    voertuig_id      BIGINT(20) NOT NULL,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT fk_voertuig_document_user_id FOREIGN KEY (user_id) REFERENCES user (id),
    CONSTRAINT fk__voertuig_document_type_id__ref_upload_definitie FOREIGN KEY (document_type_id) REFERENCES ref_upload_definitie (id),
    CONSTRAINT fk__voertuig_id_voertuig FOREIGN KEY (voertuig_id) REFERENCES voertuig (id)
);
