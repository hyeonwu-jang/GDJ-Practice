<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${contextPath}/join.do">
		<input type="text" name="id" placeholder="아이디"><br>
		<input type="password" name="pw" placeholder="비밀번호"><br>
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="email" placeholder="이메일"><br>
		<button>회원가입</button>
		<input type="reset" value="입력초기화">
	</form>
</body>
</html>