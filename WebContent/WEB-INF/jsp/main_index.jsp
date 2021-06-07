<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="java.util.List, by.htp.les04.bean.News"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/main_index.css" type="text/css" rel="stylesheet" />
<style>
input {
	width: 20%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid brown;
	border-radius: 4px;
}
input[type=submit] {
	width: 10%;
	border: 2px solid brown;
	padding: 10px;
	border-radius: 25px;
}
</style>

</head>
<body>
	<div class="header" align="center" style="font-size: 200%">
		<h1>User management system</h1>
	</div>
	
	<c:if test="${param.message != 'null'}">
		<div align="center">
			<font color="green"> 
			<c:out value="${param.message}" />
			</font>
		</div>
	</c:if>

	<br />
	
	<form:form style="text-align: center" action="login" modelAttribute="user">	
	    <spring:message code="index.login" />: <br>
		<form:input path="login" />
		<br><br>
	    <spring:message code="index.password" />:<br>
		<form:input path="password" />
		<br/><br/>
		<input type="submit" value="<spring:message code='index.send' />" />
	</form:form>

	<br />

	<div align="center">
		<a href="AnonymousController?command=registration"><spring:message code="index.registration" /></a>	
	</div>

</body>
</html>