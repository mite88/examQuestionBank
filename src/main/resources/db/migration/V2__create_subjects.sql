CREATE TABLE subjects
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    created_date datetime              NULL,
    update_date  datetime              NULL,
    name         VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_subjects PRIMARY KEY (id)
);

ALTER TABLE subjects
    ADD CONSTRAINT uc_subjects_name UNIQUE (name);