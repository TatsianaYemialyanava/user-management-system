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
		<form action="logout" method="POST">
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
		<c:set var="n" value='${requestScope["singleNews"]}' />
		<hr />

		Name: <c:out value="${n.name}" /> <br> 
		Surname: <c:out value="${n.surname}" /> <br> 
		Email: <c:out value="${n.email}" /> <br> 
		Login: <c:out value="${n.login}" /> <br> 
		Password: <c:out value="${n.password}" /> <br> 
		Role: <c:out value="${n.role}" /> <br> 
		Date: <br>
		<hr />

	</div>


	<div align="center">
		<table>
			<tr>
				<td>
					<form action="Controller" method="get">
						<input type="hidden" name="command" value="gotomainpage" />
						<button>
							<spring:message code="fullNews.button.backToMainPage" />
						</button>
					</form>
				</td>

				<sec:authorize access="hasRole('admin')">
					<td>
						<form action="AdminController" method="get">
							<input type="hidden" name="command" value="go_to_edit_page" /> <input
								type="hidden" name="idUser" value="${param['idUser']}">
							<button>
								<spring:message code="fullNews.button.edit" />
							</button>
						</form>
					</td>
					<td>
						<!-- <form action="AdminController" method="get">
							<input type="hidden" name="command" value="delete_news" /> <input
								type="hidden" name="id" value="${param['idUser']}">
							<button>
								<spring:message code="fullNews.button.delete" />
							</button>
						</form> -->
					</td>
				</sec:authorize>
			</tr>
		</table>
	</div>
	</div>

</body>
</html>