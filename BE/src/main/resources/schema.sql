-- CREATE TABLE IF NOT EXISTS user  (
--     id                BIGINT AUTO_INCREMENT,
--     name              VARCHAR(128),
--     email             VARCHAR(128),
--     github_id         BIGINT,
--     avatar_url        VARCHAR(256),
--     created_date_time DATETIME,
--     PRIMARY KEY (id)
-- );
--
-- CREATE TABLE IF NOT EXISTS milestone (
--     id                INT AUTO_INCREMENT,
--     title             VARCHAR(128),
--     description       VARCHAR(2048),
--     due_date          DATE,
--     created_date_time DATETIME,
--     updated_date_time DATETIME,
--     PRIMARY KEY (id)
-- );
--
-- CREATE TABLE IF NOT EXISTS issue (
--     id                BIGINT AUTO_INCREMENT,
--     title             VARCHAR(128),
--     created_date_time DATETIME,
--     is_opened         BOOLEAN,
--     user_id           BIGINT,
--     milestone_id      INT,
--     PRIMARY KEY (id),
--     FOREIGN KEY (user_id) REFERENCES user (id),
--     FOREIGN KEY (milestone_id) REFERENCES milestone (id)
-- );
--
-- CREATE TABLE IF NOT EXISTS label (
--     id          INT AUTO_INCREMENT,
--     name        VARCHAR(128),
--     description VARCHAR(512),
--     hex_code    VARCHAR(64),
--     PRIMARY KEY (id)
-- );
--
-- CREATE TABLE IF NOT EXISTS issue_has_label (
--     label_id INT,
--     issue_id BIGINT,
--     FOREIGN KEY (label_id) REFERENCES label (id),
--     FOREIGN KEY (issue_id) REFERENCES issue (id)
-- );
--
-- CREATE TABLE IF NOT EXISTS assignee (
--     id       INT AUTO_INCREMENT,
--     issue_id BIGINT,
--     user_id  BIGINT,
--     PRIMARY KEY (id),
--     FOREIGN KEY (issue_id) REFERENCES issue (id),
--     FOREIGN KEY (user_id) REFERENCES user (id)
-- );
--
-- CREATE TABLE IF NOT EXISTS comment (
--     id                BIGINT AUTO_INCREMENT,
--     description       VARCHAR(2048),
--     created_date_time DATETIME,
--     issue_id          BIGINT,
--     user_id           BIGINT,
--     PRIMARY KEY (id),
--     FOREIGN KEY (issue_id) REFERENCES issue (id),
--     FOREIGN KEY (user_id) REFERENCES user (id)
-- );
