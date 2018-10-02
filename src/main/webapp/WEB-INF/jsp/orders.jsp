<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

	<head>

		<c:url value="/resources/css/style.css" var="styleCss" />
		<c:url value="/resources/js/jquery-3.3.1.min.js" var="jqueryJs" />

		<c:url value="/resources/images/pencil.png" var="edit" />
		<c:url value="/resources/images/delete.png" var="delete" />
		<c:url value="/resources/images/cash_stack.png" var="PaidImg" />
		<c:url value="/resources/images/cash_stack_gray.png" var="NotPaidImg" />

		<link rel="stylesheet" href="${styleCss}"  />
   		<script src="${jqueryJs}"></script>

	</head>
	
	<body>

		<div id="menu">  
			<%@ include file="/WEB-INF/jsp/header.jsp" %>
		</div>

		<div id="middle">
		
			<H1>Заказы</H1>

    		
  				<table id="purchases">

    		<c:forEach var="orderIterator" items="${orders}">
  				
  				
					<!-- tbody-->
					
						<tr>
						
							<td>
							${orderIterator.id}
							</td>

							<td>
								${orderIterator.date}
							</td>
							
							<td>
							<c:if test="${orderIterator.user != null}">
								${orderIterator.user.login}
							</c:if>	
							</td>
							 
							<td id="pay">
								<c:if test="${orderIterator.isPaid == true}">
									<img src="${PaidImg}" title="Оплачено" alt="Оплачено">
								</c:if>
								<c:if test="${orderIterator.isPaid == false}">
								<a href="/orders/${orderIterator.id}/setPaid">
									<img src="${NotPaidImg}" title="Оплатить" alt="Оплатить">
								</a>								
								</c:if>

							</td>

							<%--
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
 							--%>
						</tr>

						<c:forEach var="productIterator" items="${orderIterator.productList}">
						<tr>
						<td></td>
						<td></td>

							<td>
								${productIterator.quantity}
							</td>

							<td>
								${productIterator.product.name}
							</td>

							<td>
								${productIterator.product.price} $
							</td>
							
						
						</tr>
						</c:forEach>

					<!-- /tbody-->
    		
			</c:forEach>
				</table>

		</div>

	</body>
</html>



