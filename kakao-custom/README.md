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


2. 스프링 시큐리티 설정
    - 📄 ~/config/SecurityConfig.java
        ✅ /** 또는 /login 경로 모두 허용
        ✅ 커스텀 로그인 페이지 경로 지정 : 🔗 /login

3. 요청 경로 매핑
    📄 ~/controller/HomeController.java
        - 로그인 화면
            - 🔗 /login
            - 📄 login.html

        

    
