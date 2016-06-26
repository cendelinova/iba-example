CREATE TABLE students (
  id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
  name VARCHAR(60) NOT NULL,
  surname  VARCHAR(60) NOT NULL,
  birthday DATE NOT NULL,
  gender VARCHAR(4)
);
