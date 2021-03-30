

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