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
	<c:if test="${loginMember == null}">
	<form method="post" action="${contextPath}/login.do">
		<input type="text" name="id" placeholder="아이디"><br>
		<input type="password" name="pw" placeholder="패스워드"><br>
		<button>로그인</button>
	</form>
	<a href="${contextPath}/member/join.jsp">회원가입</a>
	</c:if>
	
	<c:if test="${loginMember != null}">
		${loginMember.name}님 어서오세요
		<input type="button" value="로그아웃하기" onclick="location.href='${contextPath}/logout.do'"><br>
		<a href="${contextPath}/out.do">회원탈퇴하기</a>
	</c:if> 
	
	
	
</body>
</html>