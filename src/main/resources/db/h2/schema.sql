DROP TABLE users IF EXISTS;
DROP TABLE user_info IF EXISTS;
DROP TABLE boards IF EXISTS;


CREATE TABLE users (
  id         INTEGER IDENTITY PRIMARY KEY,
  auth       VARCHAR(50),
  email      VARCHAR(100),
  password   VARCHAR(100),
  created_at TIMESTAMP
);
CREATE INDEX users_email ON users (email);


CREATE TABLE boards (
  id         INTEGER IDENTITY PRIMARY KEY,
  user_id    INTEGER,
  subject    VARCHAR(100),
  content    BLOB,
  view_count INTEGER,
  password   VARCHAR(100)
);
CREATE INDEX board_writer_id ON boards (user_id);
