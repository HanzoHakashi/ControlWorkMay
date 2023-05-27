CREATE TABLE worklogs (
  id BIGSERIAL PRIMARY KEY,
  time DATE NOT NULL,
  description VARCHAR(50) NOT NULL,
  task_id BIGSERIAL,
  CONSTRAINT FK_worklogs_task FOREIGN KEY (task_id) REFERENCES tasks (id)
);
