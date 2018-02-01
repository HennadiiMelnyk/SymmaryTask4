DROP DATABASE IF EXISTS faculty;

CREATE DATABASE faculty;

use faculty;

CREATE TABLE users(
id INTEGER PRIMARY KEY  AUTO_INCREMENT,
name VARCHAR(30),
email VARCHAR(30) NOT NULL UNIQUE,
password VARCHAR(30) NOT NULL,
role VARCHAR(20),
active BOOLEAN
);

CREATE TABLE course(
id INTEGER PRIMARY KEY NOT NULL,
name VARCHAR(30) NOT NULL
);

CREATE TABLE schedule(
id INTEGER PRIMARY KEY AUTO_INCREMENT,
id_course INT,
id_user INT,
mark INT,
progress VARCHAR(30) NOT NULL,
FOREIGN KEY (id_course) REFERENCES course(id)
ON DELETE CASCADE
ON UPDATE CASCADE,
FOREIGN KEY (id_user) REFERENCES users(id)
ON DELETE CASCADE
ON UPDATE CASCADE
);

INSERT INTO users VALUES(1, 'vanya', 'email', 'pa', 'STUDENT', true);

INSERT INTO course VALUES (1, 'math');
INSERT INTO course VALUES (2, 'physics');
INSERT INTO course VALUES (3, 'biology');

INSERT INTO schedule VALUES (DEFAULT, 1, 1, 5, 'In progress');
INSERT INTO schedule VALUES (DEFAULT, 2, 1, 0, 'Pending');

SELECT * FROM users;
SELECT * FROM course;
SELECT * FROM schedule;
