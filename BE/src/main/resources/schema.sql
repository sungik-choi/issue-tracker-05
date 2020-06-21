DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS issue_has_label;
DROP TABLE IF EXISTS assignee;
DROP TABLE IF EXISTS label;
DROP TABLE IF EXISTS issue;
DROP TABLE IF EXISTS milestone;
DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user
(
    id                BIGINT AUTO_INCREMENT,
    name              VARCHAR(128),
    email             VARCHAR(128),
    github_id         BIGINT,
    created_date_time DATETIME,
    avatar_url        VARCHAR(1024),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS milestone
(
    id                INT AUTO_INCREMENT,
    title             VARCHAR(128),
    description       VARCHAR(2048),
    due_date          DATE,
    created_date_time DATETIME,
    updated_date_time DATETIME,
    progress          Double,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS issue
(
    id                BIGINT AUTO_INCREMENT,
    title             VARCHAR(128),
    created_date_time DATETIME,
    is_opened         BOOLEAN,
    user_id           BIGINT,
    milestone_id      INT,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (milestone_id) REFERENCES milestone (id)
);

CREATE TABLE IF NOT EXISTS label
(
    id               INT AUTO_INCREMENT,
    name             VARCHAR(128),
    description      VARCHAR(512),
    background_color VARCHAR(64),
    color            VARCHAR(64),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS issue_has_label
(
    label_id INT AUTO_INCREMENT,
    issue_id BIGINT,
    FOREIGN KEY (label_id) REFERENCES label (id),
    FOREIGN KEY (issue_id) REFERENCES issue (id)
);

CREATE TABLE IF NOT EXISTS assignee
(
    id       INT AUTO_INCREMENT,
    issue_id BIGINT,
    user_id  BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (issue_id) REFERENCES issue (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE IF NOT EXISTS comment
(
    id                BIGINT AUTO_INCREMENT,
    description       VARCHAR(2048),
    created_date_time DATETIME,
    issue_id          BIGINT,
    user_id           BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (issue_id) REFERENCES issue (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
);
