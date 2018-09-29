<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Вход</title>

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

			<form action="/login" method="post" id="login-form">
				<fieldset>
					<H1>Вход</H1>
					<p>
						<label>Login</label>
						<input name="login" id="login">
					</p>
					<p>
						<label>Пароль<em>*</em></label>
						<input name="password">
					</p>
				</fieldset>
		
				<p>
					<input type="submit" value="Войти">
				</p>
			</form>
			
			
			<br>
			
			${result}<br>
			
			<br>
			<a href="/registration">Регистрация</a>
			<br>
			<br>
		

		</div>	
	
	</body>
</html>