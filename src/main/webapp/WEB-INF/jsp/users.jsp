<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

	<head>

		<c:url value="/resources/css/style.css" var="styleCss" />
		<c:url value="/resources/js/jquery-3.3.1.min.js" var="jqueryJs" />

		<c:url value="/resources/images/pencil.png" var="edit" />
		<c:url value="/resources/images/delete.png" var="delete" />

		<link rel="stylesheet" href="${styleCss}"  />
   		<script src="${jqueryJs}"></script>

	</head>
	
	<body>

		<div id="menu">  
			<%@ include file="/WEB-INF/jsp/header.jsp" %>
		</div>

		<div id="middle">
		
			<H1>Пользователи</H1>

			<c:if test="${currentUserIsAdmin}">
				<a href="/registration">Добавить нового пользователя</a>			
			</c:if>
			
			<br />
			<br />

			<table>
    			<tr>
    				<th>Логин</th>
   					<th>Имя</th>
   					<th>E-mail</th>
   					<th>В черном списке</th>
   					<th>Это администратор</th>
    			</tr>
	    		<c:forEach var="userIterator" items="${users}">
					<tr>				
						<td>${userIterator.login}</td>
						<td>${userIterator.name}</td>
						<td>${userIterator.email}</td>
						<td>${userIterator.inBlackList}</td>
						<td>${userIterator.isAdmin}</td>
						
						<td>
		 					<c:if test="${currentUserIsAdmin}">
								<a href="/users/${userIterator.id}/edit">
									<img src="${edit}" title="Редактировать пользователя" alt="Редактировать пользователя">
								</a>
							</c:if>
						</td>
						
						<td>
		 					<c:if test="${currentUserIsAdmin}">
								<a href="/users/${userIterator.id}/delete">
									<img src="${delete}" title="Удалить пользователя" alt="Удалить пользователя">
								</a>			
							</c:if>
						</td>
	 
					</tr>
				</c:forEach>

			</table>
		
		</div>

	</body>
</html>



