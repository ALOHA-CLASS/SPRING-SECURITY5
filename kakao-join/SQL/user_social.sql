
DROP TABLE IF EXISTS user_social;

TRUNCATE user_social;

CREATE TABLE user_social (
    `ID` CHAR(36) PRIMARY KEY,
    `USERNAME` VARCHAR(100) NOT NULL,
    `PROVIDER` VARCHAR(50) NOT NULL,
    `SOCIAL_ID` VARCHAR(255) NOT NULL,
    `CREATED_AT` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `UPDATED_AT` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    -- FOREIGN KEY (username) REFERENCES user(id)
);


select * from user_social;



SELECT username
    FROM user_social
WHERE provider = 'kakao'
    AND social_id = '2630976312'
    ;
