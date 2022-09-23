DROP TABLE users;

CREATE TABLE IF NOT EXISTS users (
  user_id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  login VARCHAR(30) NOT NULL UNIQUE,
  password VARCHAR(50) NOT NULL
);

