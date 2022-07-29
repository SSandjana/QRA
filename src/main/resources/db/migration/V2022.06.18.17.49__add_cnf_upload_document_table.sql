CREATE TABLE IF NOT EXISTS `cnf_upload_document`
(
    `id`                 BIGINT        NOT NULL AUTO_INCREMENT,
    `aantal`             bigint        NOT NULL,
    `geldigheid_dagen`   bigint        NULL,
    `verplicht`          bit DEFAULT 1 NOT NULL,
    `zichtbaar`          bit DEFAULT 1 NOT NULL,
    `upload_document_id` bigint        NOT NULL,
    `user_id`            bigint        NOT NULL,
    `info_text`          varchar(50)   NULL,
    `notes`              varchar(50)   NULL,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT UK__upload_document_id__user_id UNIQUE (upload_document_id, user_id)
);

ALTER TABLE `cnf_upload_document`
    ADD CONSTRAINT FK__cnf_upload_document__ref_user FOREIGN KEY (user_id) REFERENCES `user` (id);
ALTER TABLE `cnf_upload_document`
    ADD CONSTRAINT FK__cnf_upload_document__ref_upload_definitie FOREIGN KEY (upload_document_id) REFERENCES ref_upload_definitie (id);
