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
	
	<c:set var="n" value='${requestScope["singleUser"]}' />

	<div id="container" align="center" style="position: absolute; left: 150px; right: 150px;">
		<form:form action="${pageContext.request.contextPath}/AdminController/user/${n.idUser}/edit" modelAttribute="singleUser" method="POST">
			<form:hidden path="idUser" />

			Name: <br>    	<form:textarea path="name" rows="2" cols="100"></form:textarea> <br><br>
			Surname: <br> 	<form:textarea path="surname" rows="2" cols="100"></form:textarea> <br><br>
			Login: <br>		<form:textarea path="login" rows="2" cols="100"></form:textarea> <br><br>
			Password: <br> 	<form:textarea path="password" rows="2" cols="100"></form:textarea> <br><br>			
			Role <br>: 
				<form:select path="role">  
     		    <form:option value="user" label="User"/>  
       			<form:option value="admin" label="Admin"/>  
       			</form:select>  <br><br>
       		Status <br>:  
       			<form:select path="status">  
     		    <form:option value="true" label="Inactive"/>  
       			<form:option value="false" label="Active"/>  
       			</form:select> <br><br>	
				
		<input type="submit" value="<spring:message code='editPageUser.button.save' />" class="save" />

		</form:form>
		
		<br>

		<form action="${pageContext.request.contextPath}/Controller/user/${n.idUser}" method="get">
			<button>
				<spring:message code='editPageUser.button.cancel' />
			</button>
		</form>
		<br />

	</div>

</body>
</html>