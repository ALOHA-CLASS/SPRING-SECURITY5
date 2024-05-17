
DROP TABLE IF EXISTS user_auth;

-- user_auth
CREATE TABLE `user_auth` (
    --   `NO` int NOT NULL AUTO_INCREMENT PRIMARY KEY       -- 권한번호
      `ID` CHAR(36) PRIMARY KEY                             -- ID
    , `USER_ID` CHAR(36) NOT NULL                      -- 회원아이디
    , `AUTH` VARCHAR(100) NOT NULL                          -- 권한 (ROLE_USER, ROLE_ADMIN, ...)
);


-- 권한
-- 사용자 
-- * 권한 : ROLE_USER
INSERT INTO user_auth ( id, username,  auth )
VALUES ( UUID(), 'user', 'ROLE_USER' );

-- 관리자
-- * 권한 : ROLE_USER, ROLE_ADMIN
INSERT INTO user_auth ( id, username,  auth )
VALUES ( UUID(), 'admin', 'ROLE_USER' );

INSERT INTO user_auth ( id, username,  auth )
VALUES ( UUID(), 'admin', 'ROLE_ADMIN' );


-- 권한 전체 조회
SELECT * FROM user_auth;