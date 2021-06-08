<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main_index.css" />
<style>
input[type=hidden] {
	width: 20%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid brown;
	border-radius: 4px;
}
input[type=submit] {
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
			<font color="green"> <c:out value="${param.message}" />
			</font>
		</div>
	</c:if>

	<br />

	<div id="container" align="center" style="position: absolute; left: 150px; right: 150px;">
		<form:form action="AdminController?command=save_new_information" modelAttribute="singleUser" method="POST">
			<form:hidden path="idUser" />

			Name: <br>    	<form:textarea path="name" rows="2" cols="100"></form:textarea> <br>
			Surname: <br> 	<form:textarea path="surname" rows="2" cols="100"></form:textarea> <br>
			Email: <br>		<form:textarea path="email" rows="2" cols="100"></form:textarea> <br>
			Login: <br>		<form:textarea path="login" rows="2" cols="100"></form:textarea> <br>
			Password: <br> 	<form:textarea path="password" rows="2" cols="100"></form:textarea> <br>
			Role: <br> 		<form:textarea path="role" rows="2" cols="100"></form:textarea> <br>	
				
			<input type="submit" value="<spring:message code='editPageUser.button.save' />" class="save" />

		</form:form>

		<form action="Controller" method="get">
			<input type="hidden" name="command" value="go_to_full_user_information_page" />
			<input type="hidden" name="idUser" value="${param['idUser']}" />
			<input type="submit" value="<spring:message code='editPageUser.button.cancel' />" />
		</form>
		<br />

	</div>

</body>
</html>