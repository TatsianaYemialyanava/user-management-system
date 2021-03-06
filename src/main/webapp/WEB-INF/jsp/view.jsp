<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
			<a href="#" onclick="this.parentNode.submit()"><spring:message
					code="main.logout" /></a>
			<sec:csrfInput />
		</form>
		<br />
		<h1>
			<spring:message code="local.message" />
		</h1>
		<h1>
			<sec:authentication property="principal.username" />
			!
		</h1>
	</div>

	<c:if test="${param.message != 'null'}">
		<div align="center">
			<font color="green"> <c:out value="${param.message}" />
			</font>
		</div>
	</c:if>

	<br />

	<div align="center">
		<c:set var="n" value='${requestScope["singleUser"]}' />
		<hr />

		Name: <c:out value="${n.name}" /> <br> 
		Surname: <c:out value="${n.surname}" /> <br> 
		Login: <c:out value="${n.login}" /> <br> 
		Password: <c:out value="${n.password}" /> <br> 
		Role: <c:out value="${n.role}" /> <br> 
		Status:	<c:choose>
   			 		<c:when test="${!n.status}">
   				 		<c:out value="active"/>
   		 			</c:when>
   		  			<c:otherwise>
    					<c:out value="inactive"/>
   			 		</c:otherwise>
				</c:choose><br>
		Date: <c:out value="${n.date}" /> <br>
					
		<hr />

	</div>


	<div align="center">
		<table>
			<tr>
				<td>
					<form action="${pageContext.request.contextPath}/Controller/user" method="get">
						<button>
							<spring:message code="fullUser.button.backToMainPage" />
						</button>
					</form>
				</td>

				<sec:authorize access="hasRole('admin')">
					<td>
						<form action="${pageContext.request.contextPath}/AdminController/user/${n.idUser}/edit" method="get">
							<button>
								<spring:message code="fullUser.button.edit" />
							</button>
						</form>
					</td>
				</sec:authorize>
			</tr>
		</table>
	</div>
	</div>

</body>
</html>