<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

	<head>

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
		
			<form action="<c:url value="/products/new"/>" method="post">
				<button type="submit">Добавить</button>
			</form>
		
			<H1>Товары</H1>

    		<!-- Товары -->
    		<ul class="tiny_products">
    		<c:forEach var="productIterator" items="${products}">
				<!-- Товар -->
				<li class="product">
					<!-- Фото товара -->
					<div class="image">
						<img src="${image}">
					</div>
					<!-- Фото товара (The End) -->
					<!-- Название товара -->
					<h3>
						<a href="/product/${productIterator.id}">${productIterator.name}</a>
					</h3>
					<!-- Название товара (The End) -->
					<!-- Цена -->
					<span class="price">
						${productIterator.price} $
					</span>
						<!--  >form class="variants" action="/cart/addToCart?ProductId=${productIterator.id}" method="post"-->
						<form class="variants" action="<c:url value="/cart/addToCart/${productIterator.id}"/>" method="post">
							<!-- >input type="button" value="Купить" id="prod1" onClick="addToCard(this.id);"-->
							<!-- >button type="submit" id=${productIterator.id}>Купить</button-->
							<button type="submit">Добавить</button>
						</form>
						<!--input type='button' name='bt' value='ok1' id="prod1" onClick="addToCard(this.id);"/-->
 
				</li>
				<!-- Товар (The End) -->
			</c:forEach>

      		</ul>
		
		</div>

	</body>
</html>



