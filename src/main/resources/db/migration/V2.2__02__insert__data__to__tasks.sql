-- Insert tasks
INSERT INTO tasks (name, creation_date, developer_id, status)
VALUES ('Task 1', CURRENT_DATE, (SELECT id FROM usr WHERE email = 'developer1@example.com'), 'CREATED');

INSERT INTO tasks (name, creation_date, developer_id, status)
VALUES ('Task 2', CURRENT_DATE, (SELECT id FROM usr WHERE email = 'developer2@example.com'), 'IN_PROGRESS');
