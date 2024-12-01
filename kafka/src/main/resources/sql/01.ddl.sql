DROP DATABASE study;
DROP USER 'study'@'%';

create database study character set utf8mb4 collate utf8mb4_general_ci;

CREATE USER 'study'@'localhost' IDENTIFIED BY 'study@1234';
CREATE USER 'study'@'%' IDENTIFIED BY 'study@1234';

GRANT ALL PRIVILEGES ON study.* TO 'study'@'localhost';
GRANT ALL PRIVILEGES ON study.* TO 'study'@'%';

use study;

