<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
 		<title>Товары</title>
		
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
		
			<H1>
				<!-- th:block th:if="${pet['new']}">New </th:block-->
				<c:if test="${product['new']}">New</c:if>
				Товар
	    	</H1>
		
			<!--form action="<c:url value="/product/${product.id}/edit"/>" method="post"-->
			<!-- >form action="<c:url value="/product/${product.id}/edit"/>" method="post"-->
			<form method="post">
				<!-- form:form modelAttribute="product"-->
				
				<!-- >table>
		        <tr>
		            <td><label><input type="text" name="name"></label></td>
		            <td><label><input type="number" name="price"></label></td>
		            <td><button type="submit">Добавить</button></td>
		        </tr>
		    	</table-->
		        
		        <table>
		        	<tr><td>id: </td><td><input value="${product.id}" type="text" name="id"><td></tr>
		        	<tr><td>Наименование: </td><td><input value="${product.name}" type="text" name="name"><td></tr>
 		        	<tr><td>Цена:</td><td><input value="${product.price}" type="number" name="price"><td></tr>
		        	<tr><td>Описание:</td><td><input value="${product.description}" type="text" name="description"></td></tr>
				</table>
	            <button type="submit">Записать</button>
	            <!--button
          th:with="text=${pet['new']} ? 'Add Pet' : 'Update Pet'"
          class="btn btn-default" type="submit" th:text="${text}">Add
          Pet</button-->
		
			</form>
			
		</div>
			
	</body>
	
</html>
