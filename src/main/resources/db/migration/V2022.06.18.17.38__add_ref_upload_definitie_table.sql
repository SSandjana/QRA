CREATE TABLE IF NOT EXISTS `ref_upload_definitie`
(
    `id`      BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `naam`    VARCHAR(150) NULL DEFAULT NULL,
    `code`    VARCHAR(20) NULL DEFAULT NULL,
    `deleted` bit(1) NOT NULL,
    `enabled` bit(1) NOT NULL,
    PRIMARY KEY (`id`)
);
