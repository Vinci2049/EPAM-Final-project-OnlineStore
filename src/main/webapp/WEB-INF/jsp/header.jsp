<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul id="menu">
    <li><a href="/index.html">Товары</a></li>
    <li><a href="/login.html">Авторизация</a></li>
    <li><a href="/registration.html">Регистрация</a></li>
</ul>

<div id="cart_informer">
	<a href="/cart">Корзина</a>
    : <span class="counter">${cartProductCount}</span> товара(ов)
</div>

