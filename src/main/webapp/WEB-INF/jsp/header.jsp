<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul id="menu">
    <li><a href="/index.html">Товары</a></li>

    <c:if test="${currentUser == 'Не определен' || currentUser == null}">
	    <li><a href="/login">Авторизация</a></li>
	</c:if>
	   
    <c:if test="${currentUserName != ''}">
    	<li><a href="/logout">Выход</a></li>
    </c:if>
    
    <li><a href="/registration">Регистрация</a></li>
    
    <c:if test="${currentUserIsAdmin}">
	    <li><a href="/users">Пользователи</a></li>    
    </c:if>

    <!-- >c:if test="${currentUserIsAdmin}"-->
	    <li><a href="/orders">Заказы</a></li>    
    <!-- >/c:if-->
    
</ul>

<div id="cart_informer">
	<a href="/cart">Корзина</a>
    : <span class="counter">${cartProductCount}</span> товара(ов)
</div>

<div id="user_informer">
	Пользователь: ${currentUserName}
</div>



