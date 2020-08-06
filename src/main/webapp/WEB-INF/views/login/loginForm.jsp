<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	    <title>로그인 페이지</title>
	</head>
	
	<body onload="document.f.id.focus();">
	
		<h3>아이디와 비밀번호를 입력해주세요.</h3>
		
		<c:url value="/login" var="loginUrl" />
		<p>${loginUrl}</p>
		<form:form name="f" action="${loginUrl}" method="POST"> 
		<!--
		 action에 디폴트로 "/login" 넣어줌
		 action을 보내야 하는데 예전에는 컨트롤러에서 action 처리를 해줬음
		 지금은 시큐리티가 보내주는 주체이다 -> 시큐리티가 알아듣는 주소를 써줘야하는데 그것이 디폴트로 "/login"을 넣어주면 됨
		 -->
		    <c:if test="${param.error != null}">
		        <p>아이디와 비밀번호가 잘못되었습니다.</p>
		    </c:if>
		    <c:if test="${param.logout != null}">
		        <p>로그아웃 하였습니다.</p>
		    </c:if>
		    <p>
		        <label for="username">아이디</label>
		        <input type="text" id="id" name="id" />
		    </p>
		    <p>
		        <label for="password">비밀번호</label>
		        <input type="password" id="password" name="password"/>
		    </p>
		    <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
		    <button type="submit" class="btn">로그인</button>
		</form:form>
	
	</body>
</html>