<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
 		<title>Интернет-магазин</title>
		
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
		
			<form action="<c:url value="/product/new"/>" method="post">
				<!-- form:form modelAttribute="product"-->
				
				<!-- >table>
		        <tr>
		            <td><label><input type="text" name="name"></label></td>
		            <td><label><input type="number" name="price"></label></td>
		            <td><button type="submit">Добавить</button></td>
		        </tr>
		    	</table-->
		                    
		        <input type="text" name="name"><br />
		        <input type="number" name="price"> <br />
		        <input type="text" name="description"> <br />
	
				<input type='file' name="image2" onchange="readURL(this);" />
				<img id="image" src="#" alt="your image" /> <br />
	
	            <button type="submit">Добавить</button>
		
			</form>
		</div>
		
		<script type="text/javascript">		
			function readURL(input) {
				if (input.files && input.files[0]) {
					var reader = new FileReader();
					reader.onload = function (e) {
			 			$('#image')
						.attr('src', e.target.result)
						.width(150)
						.height(200);
					};
					reader.readAsDataURL(input.files[0]);
				}
}
		</script>
		
	</body>
</html>
