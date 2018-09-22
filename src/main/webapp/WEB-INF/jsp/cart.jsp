<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="utf-8">
    	<title>Корзина</title>
    	<link rel="stylesheet" href="css/style.css">
    	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    	<script>
      		$(function(){
			  $("#menu").load("menu.html");
			});
		</script>

	</head>
	
	<body>

		<div id="menu">
		</div>

		<div id="middle">

			<H1>Товары в корзине:</H1>

			 <form method="POST" name="cart">

				<table id="purchases">
					<tbody>
						<tr>
						<c:forEach var="productIterator" items="${products}">
						
							<td class="image">
								<a href="product1.html">
									<img src="images/Yeni-Orijinal-Apple-iPhone-7-2-GB-RAM-32-GB-128-GB-ROM-IOS-10-LTE_50.jpg">
								</a>
							</td>
							<td class="name">
								<a href="product1.html">${productIterator.product.name}</a>
							</td>
							<td class="price">
								200 $
							</td>
							<td class="amount">
								<span class="minus">-</span>
								<input class="quantity" type="text" value="1"/>
								<span class="plus">+</span>
							</td>
							<!--td class="remove" id="remove1">
								<img src="images/delete.png" title="Удалить из корзины" alt="Удалить из корзины">								
							</td-->
						
						</c:forEach>
						</tr>

					</tbody>

				</table>


			</form>
		</div>

			<script>
			$(document).ready(function() {
				$('.minus').click(function () {
					var $input = $(this).parent().find('input');
					var count = parseInt($input.val()) - 1;
					count = count < 1 ? 1 : count;
					$input.val(count);
					$input.change();
	
					var $input2 = $('.counter');
					var count2 = parseInt($input2.text()) - 1;
					count2 = count2 < 2 ? 2 : count2
					$input2.text(count2);
					return false;
				});
				$('.plus').click(function () {
					var $input = $(this).parent().find('input');
					$input.val(parseInt($input.val()) + 1);
					$input.change();
	
					var $input2 = $('.counter');
					$input2.text(parseInt($input2.text()) + 1);
					return false;
				});
			});
			</script>

	</body>
</html>