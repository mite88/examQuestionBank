CREATE TABLE members
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    created_date datetime              NULL,
    update_date  datetime              NULL,
    username     VARCHAR(255)          NOT NULL,
    password     VARCHAR(255)          NULL,
    `role`       BLOB                  NULL,
    CONSTRAINT pk_members PRIMARY KEY (id)
);

ALTER TABLE members
    ADD CONSTRAINT uc_members_username UNIQUE (username);