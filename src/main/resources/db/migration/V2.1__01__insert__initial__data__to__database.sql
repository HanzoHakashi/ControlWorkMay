ALTER TABLE usr ALTER COLUMN password TYPE VARCHAR(255);

-- Insert users


INSERT INTO usr (name, email, login, password, enable, role)
VALUES ('Manager', 'manager@example.com', 'manager', '{bcrypt}$2a$10$CiCpWbNTaW6xUd5H6QKu1eUMoT5XtXNq/jCqBX/ih88qHwujUGZRC', true, 'MANAGER');

INSERT INTO usr (name, email, login, password, enable, role)
VALUES ('Developer 1', 'developer1@example.com', 'developer1', '{bcrypt}$2a$10$CiCpWbNTaW6xUd5H6QKu1eUMoT5XtXNq/jCqBX/ih88qHwujUGZRC', true, 'DEVELOPER');

INSERT INTO usr (name, email, login, password, enable, role)
VALUES ('Developer 2', 'developer2@example.com', 'developer2', '{bcrypt}$2a$10$CiCpWbNTaW6xUd5H6QKu1eUMoT5XtXNq/jCqBX/ih88qHwujUGZRC', true, 'DEVELOPER');

-- Insert tasks
INSERT INTO tasks (name, creationDate, developerId, status)
VALUES ('Task 1', CURRENT_DATE, (SELECT id FROM usr WHERE email = 'developer1@example.com'), 'CREATED');

INSERT INTO tasks (name, creationDate, developerId, status)
VALUES ('Task 2', CURRENT_DATE, (SELECT id FROM usr WHERE email = 'developer2@example.com'), 'IN_PROGRESS');
