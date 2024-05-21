
CREATE TABLE `user_auth` (
    --   `NO` int NOT NULL AUTO_INCREMENT PRIMARY KEY       -- 권한번호
      `ID` CHAR(36) PRIMARY KEY                             -- ID
    , `USERNAME` varchar(100) NOT NULL                      -- 회원 아이디
    , `AUTH` VARCHAR(100) NOT NULL                          -- 권한 (ROLE_USER, ROLE_ADMIN, ...)
);
