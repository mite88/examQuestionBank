CREATE TABLE keywords
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime              NULL,
    update_date   datetime              NULL,
    name          VARCHAR(255)          NOT NULL,
    `description` LONGTEXT              NULL,
    importance    INT                   NOT NULL,
    subject_id    BIGINT                NULL,
    member_id     BIGINT                NULL,
    CONSTRAINT pk_keywords PRIMARY KEY (id)
);

ALTER TABLE keywords
    ADD CONSTRAINT FK_KEYWORDS_ON_MEMBER FOREIGN KEY (member_id) REFERENCES members (id);

ALTER TABLE keywords
    ADD CONSTRAINT FK_KEYWORDS_ON_SUBJECT FOREIGN KEY (subject_id) REFERENCES subjects (id);