CREATE TABLE document
(
    id               BIGINT(20) NOT NULL AUTO_INCREMENT,
    content_type     VARCHAR(255) NOT NULL,
    filename         VARCHAR(255) NOT NULL,
    omschrijving     VARCHAR(255) NULL,
    vervaldatum      date NULL,
    user_id          BIGINT(20) NOT NULL,
    document_type_id BIGINT(20) NOT NULL,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT fk_document_user_id FOREIGN KEY (user_id) REFERENCES user (id),
    CONSTRAINT fk__document_type_id__ref_upload_definitie FOREIGN KEY (document_type_id) REFERENCES ref_upload_definitie (id)
);
