<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

	<head>

		<c:url value="/resources/css/style.css" var="styleCss" />
		<c:url value="/resources/js/jquery-3.3.1.min.js" var="jqueryJs" />

		<c:url value="/resources/images/Yeni-Orijinal-Apple-iPhone-7-2-GB-RAM-32-GB-128-GB-ROM-IOS-10-LTE.jpg" var="image" />
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
		
			<H1>Товары</H1>

			<c:if test="${currentUserIsAdmin}">
				<a href="/products/new">Добавить новый товар</a>			
			</c:if>
			
			<br />
			<br />

    		<!-- Товары -->
    		<ul class="tiny_products">
    		<c:forEach var="productIterator" items="${products}">
				<!-- Товар -->
				<li class="product">

					<!-- Кнопки админа -->			
					<c:if test="${currentUserIsAdmin}">
						<a href="/products/${productIterator.id}/edit">
							<img src="${edit}" title="Редактировать товар" alt="Редактировать товар">
						</a>
						
						<a href="/products/${productIterator.id}/delete">
							<img src="${delete}" title="Удалить товар" alt="Удалить товар">
						</a>			
					</c:if>
					<!-- Кнопки админа (The End) -->
				
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

						<form class="variants" action="<c:url value="/cart/addToCart/${productIterator.id}"/>" method="post">
							<button type="submit">Купить</button>
						</form>
 
				</li>
				<!-- Товар (The End) -->
			</c:forEach>

      		</ul>
		
		</div>

	</body>
</html>



