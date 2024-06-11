CREATE DATABASE library;
USE library;
CREATE USER 'librarian'@'localhost' IDENTIFIED BY 'ilovebooks';
GRANT ALL PRIVILEGES ON library.* TO 'librarian'@'localhost';

CREATE TABLE books
(
    id INT AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) DEFAULT 'Unknown',
    year YEAR NOT NULL,
    pageCount INT DEFAULT 10,
    genre VARCHAR(255),


    PRIMARY KEY(id)
);

CREATE TABLE people
(
    id INT AUTO_INCREMENT,
    fullName VARCHAR(255) NOT NULL,
    email VARCHAR(255) DEFAULT Unknown,

    PRIMARY KEY (id)
);