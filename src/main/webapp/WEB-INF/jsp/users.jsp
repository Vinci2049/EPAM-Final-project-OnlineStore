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
		
			<H1>Товары</H1>

			<c:if test="${currentUserIsAdmin}">
				<a href="/newProduct">Добавить новый товар</a>			
			</c:if>

    		<!-- Товары -->
    		<ul class="tiny_products">
    		<c:forEach var="userIterator" items="${users}">
				<!-- Товар -->
				<li class="product">

					<!-- Кнопки админа -->			
					<c:if test="${currentUserIsAdmin}">
						<a href="/product/edit/${userIterator.id}">
							<img src="${edit}" title="Редактировать пользователя" alt="Редактировать пользователя">
						</a>
						<a href="/product/remove/${userIterator.id}">
							<img src="${delete}" title="Удалить пользователя" alt="Удалить пользователя">
						</a>			
					</c:if>
					<!-- Кнопки админа (The End) -->
				
					<!-- Название товара -->
					<h3>
						<a href="/product/${userIterator.id}">${userIterator.login}${userIterator.name}</a>
					</h3>
					<!-- Название товара (The End) -->
					<!-- Цена -->
					<span class="price">
						<!--${productIterator.price} $-->
					</span>

						<form class="variants" action="<c:url value="/cart/addToCart/${userIterator.id}"/>" method="post">
							<button type="submit">Купить</button>
						</form>
 
				</li>
				<!-- Товар (The End) -->
			</c:forEach>

      		</ul>
		
		</div>

	</body>
</html>



