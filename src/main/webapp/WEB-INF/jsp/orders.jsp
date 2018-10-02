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
		
			<H1>Заказы</H1>

    		<c:forEach var="orderIterator" items="${orders}">
    		
  				<table id="purchases">
					<tbody>
					
						<tr>
						
							<td class="name">
								<a href="product1.html">${ordertIterator.user}</a>
							</td>
							<td class="price">
								${orderIterator.date} $
							</td>
							<td class="price">
								${orderIterator.date} $
							</td>
							<td class="remove" id="pay">
								<a href="/order/${orderIterator.id}"/pay>
									<img src="${delete}" title="Оплатить" alt="Оплатить">
								</a>								
							</td>

							<td class="remove" id="edit">
								<a href="/orders/${orderIterator.id}/edit">
									<img src="${edit}" title="Редактировать" alt="Редактировать заказ">
								</a>
							</td>

							<td class="remove" id="delete">

								<a href="/orders/${orderIterator.id}/delete">
									<img src="${delete}" title="Удалить заказ" alt="Удалить заказ">
								</a>			
							</td>

						<tr>

						<c:forEach var="productIterator" items="${orderIterator.productList}">
						<tr>
							<td class="price">
								${productIterator.product.name}
							</td>
							<td class="price">
								${productIterator.product.price} $
							</td>

						
						</tr>
						</c:forEach>

					</tbody>

				</table>
    		
			</c:forEach>

		</div>

	</body>
</html>



