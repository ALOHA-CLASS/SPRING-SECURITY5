1. 프로젝트 생성
    - 📄 build.gradle
    - spring boot version       : 2.x.x
    - spring security version   : 5.x.x
    - 의존성 설정
        * Spring Web
        * Spring Boot DevTools
        * Spring Security
        * OAuth2 Client
        * Lombok
        * Thymeleaf
        * MySQL Driver
        * Mybatis Framework

2. 프로젝트 설정
    - 📄 application.properties
        - 데이터 소스 설정
        - MyBatis 설정

3. ERD
    https://www.erdcloud.com/d/gqtj2t7rW3R46Cy8z


4. 테이블 정의
    - USER
    - USER_AUTH
    - USER_SOCIAL


4. 도메인
    - Users.java
    - UserAuth.java
    - UserSocial.java
    - CustomeUser.java
    - OAuthAttributes.java

5. 데이터
    - UserMapper.xml
    - UserMapper.java

6. 서비스
    - UserService.java
    - UserServiceImpl.java
    - OAuthService.java
    - OAuthServiceImpl.java



7. 스프링 시큐리티 설정
    - 📄 ~/config/SecufityConfig.java
        

8. 요청 경로 매핑
    📄 ~/controller/HomeController.java
    - 메인 화면
        - 🔗 /
        - 📄 index.html

        

    
