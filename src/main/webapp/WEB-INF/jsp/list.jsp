<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main_index.css" />
	
</head>
<body>
	<div class="header" align="center" style="font-size: 200%">
		<h1>User management system</h1>
	</div>
	
	<div align="left">
		<form action="${pageContext.request.contextPath}/logout" method="POST">
			<a href="#" onclick="this.parentNode.submit()"><spring:message code="main.logout" /></a>
			<sec:csrfInput/>
		</form>
		<br />
		<h1><spring:message code="local.message" /></h1>
		<h1>
			<sec:authentication property="principal.username"/>!
		</h1>
	</div>
		
	<c:if test="${param.message != 'null'}">
		<div align="center">
			<font color="green"> 
			<c:out value="${param.message}" />
			</font>
		</div>
	</c:if>
	
	<sec:authorize access="hasRole('admin')">
		<div align="center">
			<a href="${pageContext.request.contextPath}/AdminController/user/new"><spring:message code="index.registration" /></a>	
		</div>
	</sec:authorize>
	
	<br>

	<div align="center">
		
		<table border="2" width="70%">
			<c:forEach var="n" items="${requestScope.users}">
				<tr>
					<td>
						<font size="6" color="black" align="left"> 
							<c:out value="${n.name}" />
							<c:out value="${n.surname}" />
							</font>
							<br />
							<div align="right">
								<a href="user/${n.idUser}">
									<spring:message code="main.fullUserDetails" />
								</a>

							</div>
						
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>