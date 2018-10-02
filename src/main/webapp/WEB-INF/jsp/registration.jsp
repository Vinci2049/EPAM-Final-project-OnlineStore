<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Регистрация</title>
		
		<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" type="text/javascript"></script> -->
		<!-- <script src="/js/form-login-input-ajax-check.js" type="text/javascript"></script> -->
	
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

			<form action="/registration" method="post" id="registration-form">
				<fieldset>
					<H1>Регистрация</H1>
					<p>
						<label>Login<em>*</em></label>
						<input name="login" id="login">
					</p>
					<p>
						<label>Пароль<em>*</em></label>
						<input name="password">
					</p>
					<p>
						<label>Имя</label>
						<input name="name">
					</p>
					<p>
						<label>E-mail</label>
						<input name="email">
					</p>
					
				</fieldset>
		
				<p>
					<input type="submit" value="Регистрация">
				</p>
			</form>
			<br>

			${result}<br>

			
			<br>
			<c:forEach var="error" items="${errors}">
		
					${error.defaultMessage}<br>
		
			</c:forEach>
			
		</div>
		
	</body>
</html>