<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 页面顶部-->
<header id="top" class="fixed_nav">
    <div id="logo" class="lf">
        <img class="animated jello" src="../images/header/logo.png" alt="logo"/>
    </div>
    <div id="top_input" class="lf">
        <input id="input" type="text" placeholder="请输入您要搜索的内容" style="width:360px;"/>
        <a href="search.html" class="rt"><img id="search" src="../images/header/search.png" alt="搜索"/></a>
    </div>
    <div class="rt">
        <ul class="lf">
        	
            <li><a href="../favorites/showFavorites.do" title="我的收藏"><img class="care" src="../images/header/care.png" alt=""/></a><b>|</b></li>
            <li><a href="../order/showUserOrders.do" title="我的订单"><img class="order" src="../images/header/order.png" alt=""/></a><b>|</b></li>
            <li><a href="../cart/viewCart.do" title="我的购物车"><img class="shopcar" src="../images/header/shop_car.png" alt=""/></a><b>|</b></li>
            <li><a href="help.html">帮助</a><b>|</b></li>
            <c:if test="${user==null }">
            	 <li><a href="../user/showLogin.do">登录</a></li>
            </c:if>
            <c:if test="${user!=null }">
            	<li><a href="../user/showPersonal_password.do">${user.username }</a><b>|</b></li>
            	<li><a href="../user/exit.do">退出</a></li>
            </c:if>
        </ul>
    </div>
</header>
<!-- nav主导航-->
<nav id="nav">
    <ul>
        <li><a href="../main/showIndex.do" class="acti">首页</a></li>
        <li><a href="../main/showIndex.do" >电脑办公</a></li>
        <li><a href="../main/showIndex.do" >办公文具</a></li>
    </ul>
</nav>