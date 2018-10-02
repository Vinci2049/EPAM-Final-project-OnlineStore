<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
    	<title>Корзина</title>

		<c:url value="/resources/css/style.css" var="styleCss" />
		<c:url value="/resources/js/jquery-3.3.1.min.js" var="jqueryJs" />

		<c:url value="/resources/images/Yeni-Orijinal-Apple-iPhone-7-2-GB-RAM-32-GB-128-GB-ROM-IOS-10-LTE_50.jpg" var="image" />
		<c:url value="/resources/images/delete.png" var="delete" />

		<link rel="stylesheet" href="${styleCss}"  />
   		<script src="${jqueryJs}"></script>

	</head>
	
	<body>

		<div id="menu">  
			<%@ include file="/WEB-INF/jsp/header.jsp" %>
		</div>

		<div id="middle">

			<H1>Товары в корзине:</H1>

			 <form method="POST" name="cart">

				<table id="purchases">
					<tbody>
					
						<c:forEach var="productIterator" items="${products}">
						<tr>
						
							<td class="image">
								<a href="product1.html">
									<img src="${image}">
								</a>
							</td>
							<td class="name">
								<a href="product1.html">${productIterator.product.name}</a>
							</td>
							<td class="price">
								${productIterator.product.price} $
							</td>
							<td class="amount">
								<input class="quantity" type="text" value=${productIterator.quantity}>
							</td>
							<td class="remove" id="remove1">
								<a href="/cart/remove/${productIterator.product.id}">
									<img src="${delete}" title="Удалить из корзины" alt="Удалить из корзины">
								</a>								
							</td>
						
						</tr>
						</c:forEach>

					</tbody>

				</table>

			</form>			
						
			<form action="<c:url value="/orders/new"/>" method="post">
				<button type="submit">Оформить заказ</button>
			</form>			
			
		</div>

	</body>
</html>