DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 1;

CREATE TABLE users
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name VARCHAR NOT NULL,
  email VARCHAR NOT NULL,
  password VARCHAR NOT NULL
);
CREATE UNIQUE INDEX email_idx ON users(email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);