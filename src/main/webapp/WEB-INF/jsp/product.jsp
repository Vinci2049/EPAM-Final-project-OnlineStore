<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
 		<title>Интернет-магазин</title>
		
		<c:url value="/resources/css/style.css" var="styleCss" />
		<c:url value="/resources/js/jquery-3.3.1.min.js" var="jqueryJs" />

		<!-- ВРЕМЕННО! -->
		<c:url value="/resources/images/Yeni-Orijinal-Apple-iPhone-7-2-GB-RAM-32-GB-128-GB-ROM-IOS-10-LTE.jpg" var="image" />

		<link rel="stylesheet" href="${styleCss}"  />
   		<script src="${jqueryJs}"></script>
			
	</head>
	  
  	<body>

		<div id="menu">  
			<%@ include file="/WEB-INF/jsp/header.jsp" %>
		</div>

		<div id="middle">
			<H1>${product.name}</H1>
			<div class="product">
				<!-- Большое фото -->
				<div class="image">
					<!-- >img src="${image}"-->
					<img src=${product.image}>
				</div>
				<!-- Большое фото (The End) -->

				<!-- Описание товара -->
				<div class="description">
					${product.description}
					<!-- Цена -->
					<div class="price">
						${product.price} $
  					</div>
					<!-- Цена (The End) -->
					<form action="/cart">
						<input type="button" value="Купить" id="prod1" onClick="addToCard(this.id);">
					</form>
				</div>
				<!-- Описание товара (The End) -->
			</div>
		</div>
	</body>
</html>
