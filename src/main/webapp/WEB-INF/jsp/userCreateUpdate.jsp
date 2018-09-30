<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
 		<title>Пользователи</title>
		
		<c:url value="/resources/css/style.css" var="styleCss" />
		<c:url value="/resources/js/jquery-3.3.1.min.js" var="jqueryJs" />

		<link rel="stylesheet" href="${styleCss}"  />
   		<script src="${jqueryJs}"></script>
			
	</head>
	  
  	<body>

		<div id="menu">  
			<%@ include file="/WEB-INF/jsp/header.jsp" %>
		</div>

		<div id="middle">
		
			<H1>
				<!-- th:block th:if="${pet['new']}">New </th:block-->
				<c:if test="${user['new']}">New</c:if>
				Пользователь
	    	</H1>
		
			<form method="post">
				
		        <table>
		        	<tr><td>id: </td><td><input value="${user.id}" type="text" name="id"><td></tr>
		        	<tr><td>Логин: </td><td><input value="${user.login}" type="text" name="login"><td></tr>
		        	<tr><td>Пароль: </td><td><input value="${user.password}" type="text" name="password"><td></tr>
		        	<tr><td>Имя: </td><td><input value="${user.name}" type="text" name="name"><td></tr>
 		        	<tr><td>E-mail:</td><td><input value="${user.email}" type="text" name="email"><td></tr>
		        	<tr><td>В черном списке:</td><td><input value="${user.inBlackList}" type="checkbox" name="InBlackList"></td></tr>
		        	<tr><td>Это админ:</td><td><input value="${user.isAdmin}" type="checkbox" name="IsAdmin"></td></tr>
				</table>
	            <button type="submit">Записать</button>
		
			</form>
			
		</div>
			
	</body>
	
</html>
