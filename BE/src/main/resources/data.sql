INSERT INTO user (name, email, github_id, created_date_time, avatar_url) VALUES ('hamill', 'hamill@naver.com', '100', '2020-06-11 01:17:32', 'https://cdn.pixabay.com/photo/2016/08/11/10/52/emoji-1585401_960_720.png');
INSERT INTO user (name, email, github_id, created_date_time, avatar_url) VALUES ('ragdoll', 'ragdoll@naver.com', '101', '2020-06-11 01:17:32', 'https://cdn.pixabay.com/photo/2017/09/16/21/31/emoji-2756891_960_720.png');
INSERT INTO user (name, email, github_id, created_date_time, avatar_url) VALUES ('ed', 'ed@naver.com', '102', '2020-06-11 01:17:32', 'https://cdn.pixabay.com/photo/2016/08/11/09/50/emoji-1585197_960_720.png');
INSERT INTO user (name, email, github_id, created_date_time, avatar_url) VALUES ('ellin', 'ellin@naver.com', '103', '2020-06-11 01:17:32', 'https://cdn.pixabay.com/photo/2019/02/19/19/45/thumbs-up-4007573_960_720.png');

INSERT INTO milestone (title, description, due_date, created_date_time, updated_date_time) VALUES ('마일스톤1', '마일스톤1입니다.', '2020-06-18', '2020-06-11 01:22:32', '2020-06-11 01:22:32');
INSERT INTO milestone (title, description, due_date, created_date_time, updated_date_time) VALUES ('마일스톤2', '마일스톤2입니다.', '2020-06-19', '2020-06-11 01:22:32', '2020-06-11 01:22:32');
INSERT INTO milestone (title, description, due_date, created_date_time, updated_date_time) VALUES ('마일스톤3', '마일스톤3입니다.', '2020-06-20', '2020-06-11 01:22:32', '2020-06-11 01:22:32');
INSERT INTO milestone (title, description, due_date, created_date_time, updated_date_time) VALUES ('마일스톤4', '마일스톤4입니다.', '2020-06-21', '2020-06-11 01:22:32', '2020-06-11 01:22:32');

INSERT INTO label (name, description, hex_code) VALUES ('레이블1', '레이블1입니다.', '#aaaaaa');
INSERT INTO label (name, description, hex_code) VALUES ('레이블2', '레이블2입니다.', '#bbbbbb');
INSERT INTO label (name, description, hex_code) VALUES ('레이블3', '레이블3입니다.', '#cccccc');
INSERT INTO label (name, description, hex_code) VALUES ('레이블4', '레이블4입니다.', '#dddddd');
INSERT INTO label (name, description, hex_code) VALUES ('레이블5', '레이블5입니다.', '#eeeeee');
INSERT INTO label (name, description, hex_code) VALUES ('레이블6', '레이블6입니다.', '#ffffff');

INSERT INTO issue (title, created_date_time, is_opened, user_id, milestone_id) VALUES ('이슈제목1', '2020-06-11 01:28:30', true, 1, 1);
INSERT INTO issue (title, created_date_time, is_opened, user_id, milestone_id) VALUES ('이슈제목2', '2020-06-11 01:28:30', true, 2, 1);
INSERT INTO issue (title, created_date_time, is_opened, user_id, milestone_id) VALUES ('이슈제목3', '2020-06-11 01:28:30', true, 3, 2);
INSERT INTO issue (title, created_date_time, is_opened, user_id, milestone_id) VALUES ('이슈제목4', '2020-06-11 01:28:30', true, 4, 3);
INSERT INTO issue (title, created_date_time, is_opened, user_id, milestone_id) VALUES ('이슈제목5', '2020-06-11 01:28:30', true, 4, 4);

INSERT INTO issue_has_label (label_id, issue_id) VALUES (1, 1);
INSERT INTO issue_has_label (label_id, issue_id) VALUES (2, 1);
INSERT INTO issue_has_label (label_id, issue_id) VALUES (3, 1);
INSERT INTO issue_has_label (label_id, issue_id) VALUES (3, 2);
INSERT INTO issue_has_label (label_id, issue_id) VALUES (3, 3);
INSERT INTO issue_has_label (label_id, issue_id) VALUES (4, 3);
INSERT INTO issue_has_label (label_id, issue_id) VALUES (5, 4);
INSERT INTO issue_has_label (label_id, issue_id) VALUES (6, 4);
INSERT INTO issue_has_label (label_id, issue_id) VALUES (5, 5);

INSERT INTO assignee (issue_id, user_id) VALUES (1, 1);
INSERT INTO assignee (issue_id, user_id) VALUES (1, 2);
INSERT INTO assignee (issue_id, user_id) VALUES (1, 3);
INSERT INTO assignee (issue_id, user_id) VALUES (2, 3);
INSERT INTO assignee (issue_id, user_id) VALUES (2, 4);
INSERT INTO assignee (issue_id, user_id) VALUES (3, 3);
INSERT INTO assignee (issue_id, user_id) VALUES (4, 4);
INSERT INTO assignee (issue_id, user_id) VALUES (5, 1);
