

## 스프링 MVC 첫 세팅
1. 우측 상단 gradle 눌러서 새로고침 한 번
2. src/main/resources 폴더로 가서 application-properties 파일에 `server.port = 80`으로 수정
3. src/main/java에 MvcApplication 클래스 main 메서드 실행해서 서버 띄우기
4. 한글 인코딩 필터 설정 (main/resources/application.properties)
```
# 서버 포트 변경
server.port = 80

# 한글 인코딩 적용
spring.http.encoding.charset=UTF-8
spring.http.encoding.enabled=true
spring.http.encoding.force=true
```

2. 데이터베이스 설정
- C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib 에서 ojbc6.jar
- 아래 설정 경로 /WEB-INF/lib에 추가하기
```groovy
//database 관련 라이브러리 추가
//jdbc 라이브러리
compile "org.springframework.boot:spring-boot-starter-jdbc"
//오라클 라이브러리 (11g edition - gradle, maven 라이센스 문제 공식 지원 불가)
compile fileTree(dir: '/src/main/webapp/WEB-INF/lib', include: ['*.jar'])
```

- 스프링에게 DataSource 정보 알려주기 (Hikari DataSource)



## JSP 파일 템플릿
```jsp

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>



</body>
</html>

```