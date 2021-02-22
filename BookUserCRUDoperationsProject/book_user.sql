
CREATE USER 'bookuser'@'localhost' IDENTIFIED BY 'bookuser';

GRANT ALL PRIVILEGES ON * . * TO 'bookuser'@'localhost';


ALTER USER 'bookuser'@'localhost' IDENTIFIED WITH mysql_native_password BY 'bookuser';



CREATE DATABASE IF NOT EXISTS hb_book_user;
USE hb_book_user;

DROP TABLE IF EXISTS books;

CREATE TABLE books(
	book_id INT NOT NULL auto_increment primary KEY,
    author VARCHAR(45) DEFAULT NULL,
    publisher VARCHAR(45) DEFAULT NULL,
    publish_date date 
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;