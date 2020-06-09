DROP TABLE IF EXISTS issue;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS label;
DROP TABLE IF EXISTS milestone;

CREATE TABLE IF NOT EXISTS issue
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    title       VARCHAR(45),
    created_time DATETIME,
    author      VARCHAR(45),
    assignees   VARCHAR(45),
    is_opened   BOOLEAN,
    user_id     INT REFERENCES user (id)
);

CREATE TABLE IF NOT EXISTS comment
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    contents    VARCHAR(2000),
    created_time DATETIME,
    issue_id    INT REFERENCES issue (id),
    user_id     INT REFERENCES user (id)
);

CREATE TABLE IF NOT EXISTS user
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(45),
    email       VARCHAR(45),
    github_id   VARCHAR(45),
    created_time DATETIME
);

CREATE TABLE IF NOT EXISTS label
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(45),
    description VARCHAR(45),
    hex_code    VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS milestone
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    title       VARCHAR(45),
    description VARCHAR(2000),
    due_date    DATE,
    created_time DATETIME,
    updated_time DATETIME
);

CREATE TABLE IF NOT EXISTS issue_label
(
    issue_id INT REFERENCES issue (id),
    label_id INT REFERENCES label (id)
);

CREATE TABLE IF NOT EXISTS issue_milestone
(
    issue_id INT REFERENCES issue (id),
    milestone_id INT REFERENCES milestone(id)
);
