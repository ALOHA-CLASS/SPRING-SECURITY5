-- Active: 1714007442487@@127.0.0.1@3306@aloha

DROP TABLE IF EXISTS user;

TRUNCATE user;

CREATE TABLE `user` (
  `ID` CHAR(36) PRIMARY KEY,
  `USERNAME` VARCHAR(100) NOT NULL UNIQUE,
  `PASSWORD` VARCHAR(200) NOT NULL,
  `NAME` VARCHAR(100) NOT NULL,
  `EMAIL` varchar(200) DEFAULT NULL,
  `PROFILE` TEXT DEFAULT NULL, 
  `CREATED_AT` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `UPDATED_AT` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ENABLED` int DEFAULT 1
) COMMENT='회원';


-- 사용자
INSERT INTO user ( id, username, password, name, email )
VALUES ( UUID(), 'user', '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92', '사용자', 'user@mail.com' );

-- 관리자
INSERT INTO user ( id,  username, password, name, email )
VALUES ( UUID(), 'admin', '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92', '관리자', 'admin@mail.com' );

-- 회원 전체 조회
SELECT * FROM user;

