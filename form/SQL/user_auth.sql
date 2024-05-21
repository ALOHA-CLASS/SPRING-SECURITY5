
CREATE TABLE `user_auth` (
      `ID` CHAR(36) PRIMARY KEY                             -- ID
    , `USERNAME` varchar(100) NOT NULL                      -- 회원 아이디
    , `AUTH` VARCHAR(100) NOT NULL                          -- 권한 (ROLE_USER, ROLE_ADMIN, ...)
);
