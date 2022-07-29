CREATE TABLE aanrijdingsformulieren
(
    id              BIGINT(20) NOT NULL AUTO_INCREMENT,
    name            VARCHAR(255),
    idNumber        VARCHAR(255),
    username        VARCHAR(255),
    naam            VARCHAR(255),
    user_id         BIGINT(20) NOT NULL,
    afgehandeld     VARCHAR(255),
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (user_id) REFERENCES user (id)
);