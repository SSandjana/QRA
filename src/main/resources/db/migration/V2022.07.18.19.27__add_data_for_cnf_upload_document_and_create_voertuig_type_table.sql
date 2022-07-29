INSERT INTO quick_response_application.cnf_upload_document (aantal, geldigheid_dagen, verplicht, zichtbaar,
                                                            upload_document_id, user_id)
VALUES (1, 365, 0, 1, 5, 1);


CREATE TABLE voertuig_type
(
    id           BIGINT(20) NOT NULL AUTO_INCREMENT,
    type         VARCHAR(255) NOT NULL,
    omschrijving VARCHAR(255) NULL,
    CONSTRAINT PRIMARY KEY (id)
);

