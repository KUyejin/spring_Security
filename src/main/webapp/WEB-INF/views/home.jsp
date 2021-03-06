<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>메인페이지</title>
	</head>
	
	<body>
	
		<h1>메인페이지</h1>
		
		<sec:authorize access="isAnonymous()"> <!-- isAnonymous는 누구나 다  접근할수 있다-->
			<p><a href="<c:url value="/login/loginForm" />">로그인</a></p>
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()"> <!-- isAuthenticated 인증된 사람만 접근할수 있다 -->
			<form:form action="${pageContext.request.contextPath}/logout" method="POST"> 
			<!--로그아웃을 post로 보내는 것은 규칙이다 -->
			    <input type="submit" value="로그아웃" />
			</form:form>
			
			<sec:authentication var="principal" property="principal"/>
			<p>${principal.username} 님 환영합니다</p>
			<!-- principal이라는 객체가 생긴다  -> Model로 넘기면 안됨 -->
			
			
			<p><a href="<c:url value="/loginInfo" />">로그인 정보 확인 방법3 가지</a></p>
		</sec:authorize>
		
		<h3>
		    [<a href="<c:url value="/user/userForm" />">회원가입</a>]
		    [<a href="<c:url value="/user/userHome" />">유저 홈</a>]
		    [<a href="<c:url value="/admin/adminHome" />">관리자 홈</a>]
		</h3>
	</body>
</html>
