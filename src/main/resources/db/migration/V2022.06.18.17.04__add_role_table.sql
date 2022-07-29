CREATE TABLE IF NOT EXISTS `role`
(
    `id`          BIGINT(20)  NOT NULL AUTO_INCREMENT,
    `type`        VARCHAR(50) NULL DEFAULT NULL,
    `description` VARCHAR(50) NULL DEFAULT NULL,
    PRIMARY KEY
        (`id`)
);
