CREATE TABLE IF NOT EXISTS `user`
(
    `id`                BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `first_name`         VARCHAR(255) NULL DEFAULT NULL,
    `last_name`          VARCHAR(255) NULL DEFAULT NULL,
    `id_number`          VARCHAR(255) NULL DEFAULT NULL,
    `dob`               DATE         NULL DEFAULT NULL,
    `email`             VARCHAR(255) NULL DEFAULT NULL,
    `telephone`         VARCHAR(255) NULL DEFAULT NULL,
    `username`          VARCHAR(255) NULL DEFAULT NULL,
    `password`          VARCHAR(255) NULL DEFAULT NULL,
    `registration_date` DATE         NULL DEFAULT NULL,
    `role_id`           BIGINT(20)   NOT NULL,
        PRIMARY KEY (`id`),
     KEY `fk_user_role_id` (`role_id`),
     CONSTRAINT `fk_user_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
);
