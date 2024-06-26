
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