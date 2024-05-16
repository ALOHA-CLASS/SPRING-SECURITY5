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

2. 프로젝트 설정
    - profile 파일 생성하기
        * 📄 application-oauth.properties
    - profile 파일 포함하기
        * 📄 application.properties
            ```
                spring.profiles.include=oauth
            ```

3. 스프링 시큐리티 설정
    - 📄 ~/config/SecufityConfig.java

        ```
            @EnableWebSecurity
        ```
        * 스프링 시큐리티 웹 보안 지원 설정 활성화
        
        ```
            @Configuration
        ```
        * 스프링 빈 등록 설정 클래스로 지정

        ```
            oauth2Login()
        ```
        * OAuth2 로그인 기능 활성화


4. 요청 경로 매핑
    📄 ~/controller/HomeController.java
        - 메인 화면
            * 🔗 /  
            * 📄 index.html

        

    
