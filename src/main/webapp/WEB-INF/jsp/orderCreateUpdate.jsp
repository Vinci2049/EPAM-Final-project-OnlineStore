<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
	<head>
    	<title>Заказ</title>

		<c:url value="/resources/css/style.css" var="styleCss" />
		<c:url value="/resources/js/jquery-3.3.1.min.js" var="jqueryJs" />

		<c:url value="/resources/images/delete.png" var="delete" />

		<link rel="stylesheet" href="${styleCss}"  />
   		<script src="${jqueryJs}"></script>

	</head>
	
	<body>

		<div id="menu">  
			<%@ include file="/WEB-INF/jsp/header.jsp" %>
		</div>

		<div id="middle">

			<H1>
				<c:if test="${order['new']}">New</c:if>
				Заказ
	    	</H1>

			 <!-- >form method="POST" name="order"-->
			 <!-- form method="post"-->
			 <c:url value="/orders/new" var="myPostAction" />
			<form:form method="post" modelAttribute="order" action="${myPostAction}">

				<!--  >table id="purchases"-->
				<table>
					
						
			        	<tr><td>id: </td><td><input value="${order.id}" type="text" id = "id" name="id"><td></tr>
			        	 		        	
			        	<tr><td>Дата: </td><td><!-- input value="${order.date}" type="datetime" id = "order.date" name="order.date"-->
			        	 <form:input path="date" value="${order.date}" type="datetime"/>
			        	 <td></tr>
			        	
			        	<tr><td>Клиент: </td><td><input value="${userLogin}" type="text"><td></tr>
			        	
			        	<%-- 
			        	<tr><td>Клиент: </td><td><!-- input value="${order.user}" type="text" id = "user" name="user"-->
				        	 <form:input path="user"/>
				        	 <td></tr>
	   					--%>
	   					
	   
			        	<tr><td>Оплачен: </td><td><!-- input value="${order.isPaid}" type="checkbox" id = "order.isPaid" name="order.isPaid"-->
			        	 <form:input path="isPaid" value="${order.isPaid}" />
			        	<td></tr>
	 
			        	<tr><td>Сумма: </td><td><input value="${order.cost}" type="text" id = "cost" name="cost"><td></tr>

 			        	 
 			        	
						<c:forEach var="productList" items="${order.productList}" varStatus="status">
						<tr>


			        	<td><!-- input value="${productIterator.product}" type="text" id="order.productList.product" name="order.productList.quantity"-->
			        	 <form:input path="productList[${status.index}].product" value="${productList.product}" />
			        	 </td>
			        	<!-- td><input value="${productIterator.product.name}" type="text" name="name"></td-->
			        	<td><!-- input value="${productIterator.quantity}" type="text" id = "productList.quantity" name="productList.quantity"-->
			        	 <form:input path="productList[${status.index}].quantity" value="${productList.quantity}" />
			        	 </td>
			        	<!-- td><input value="${productIterator.product.price}" type="text" name="price"></td-->
						 
						</tr>
						
						</c:forEach>
						

				</table>

	            <!-- button type="submit">Подтвердить заказ</button-->

	        </form:form>
			
			<form action="<c:url value="/orders/pay"/>" method="post">
				<button type="submit">Оплатить</button>
			</form>
			
		</div>

	</body>
</html>