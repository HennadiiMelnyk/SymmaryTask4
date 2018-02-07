DROP DATABASE IF EXISTS faculty;

CREATE DATABASE faculty;

USE faculty;

CREATE TABLE role(
  id INT NOT NULL PRIMARY KEY,
  role VARCHAR(25)
);

CREATE TABLE users (
  id       INTEGER PRIMARY KEY  AUTO_INCREMENT,
  name     VARCHAR(30),
  email    VARCHAR(30) NOT NULL UNIQUE,
  password VARCHAR(30) NOT NULL,
  active   BOOLEAN
);

CREATE TABLE course (
  id   INTEGER PRIMARY KEY NOT NULL,
  name VARCHAR(30)         NOT NULL
);

CREATE TABLE users_roles(
  id_user INT NOT NULL,
  id_role INT NOT NULL,
  FOREIGN KEY (id_user) REFERENCES users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (id_role) REFERENCES role(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE users_courses (
  id_user   INT NOT NULL,
  id_course INT NOT NULL,
  FOREIGN KEY (id_course) REFERENCES course (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (id_user) REFERENCES users (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE schedule (
  id        INTEGER PRIMARY KEY AUTO_INCREMENT,
  id_course INT,
  mark      INT,
  progress  VARCHAR(30) NOT NULL,
  FOREIGN KEY (id_course) REFERENCES course (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

INSERT INTO role VALUES (1, 'ADMIN');
INSERT INTO role VALUES (2, 'TEACHER');
INSERT INTO role VALUES (3, 'STUDENT');

INSERT INTO users VALUES (1, 'vanya', 'email@korki.com', 'pa', TRUE);
INSERT INTO users VALUES (2, 'admin', 'admin@admin.com', 'admin', TRUE);
INSERT INTO users VALUES (3, 'valeriy', 'val@teacher.com', 'teacher', TRUE);
INSERT INTO users VALUES (4, 'vova', 'vova17@gmail.com', 'vova', TRUE);

INSERT INTO course VALUES (1, 'math');
INSERT INTO course VALUES (2, 'physics');
INSERT INTO course VALUES (3, 'biology');
INSERT INTO course VALUES (4, 'Computer Science');
INSERT INTO course VALUES (5, 'History');
INSERT INTO course VALUES (6, 'sport');

INSERT INTO users_courses VALUE (1, 1);
INSERT INTO users_courses VALUE (1, 2);
INSERT INTO users_courses VALUE (1, 3);
INSERT INTO users_courses VALUE (3, 4);
INSERT INTO users_courses VALUE (4, 4);
INSERT INTO users_courses VALUE (4, 5);
INSERT INTO users_courses VALUE (4, 6);

INSERT INTO schedule VALUES (DEFAULT, 1, 5, 'In progress');
INSERT INTO schedule VALUES (DEFAULT, 2, 0, 'Pending');
INSERT INTO schedule VALUES (DEFAULT, 3, 4, 'Finished');
INSERT INTO schedule VALUES (DEFAULT, 4, 0, 'Started');

INSERT INTO users_roles VALUES (1, 3);
INSERT INTO users_roles VALUES (2, 1);
INSERT INTO users_roles VALUES (3, 2);
INSERT INTO users_roles VALUES (4, 3);


SELECT *
FROM users;
SELECT *
FROM course;
SELECT *
FROM users_courses;
SELECT *
FROM schedule;

/*SELECT
  u2.name,
  u2.email,
  u2.role,
  c.name,
  s.mark,
  s.progress
FROM schedule s
  JOIN course c ON s.id_course = c.id
  JOIN users_courses u ON c.id = u.id_course
  JOIN users u2 ON u.id_user = u2.id;

SELECT s.id, c.name, s.mark, s.progress FROM schedule s
  JOIN course c ON s.id_course = c.id
  JOIN users_courses u ON c.id = u.id_course
  JOIN users u2 ON u.id_user = u2.id
  WHERE u2.id = 1;*/

SELECT id_course FROM users_courses WHERE id_user = 1;
SELECT u.name FROM users u
WHERE u.id IN (SELECT users_courses.id_user FROM users_courses WHERE users_courses.id_course = 1)
      AND u.id IN (SELECT id_user from users_roles WHERE users_roles.id_role IN (SELECT id from role WHERE role LIKE 'STUDENT'));
