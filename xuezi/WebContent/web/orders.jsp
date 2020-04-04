<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 学子商城</title>
    <link href="../css/orders.css" rel="stylesheet"/>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
</head>
<body>
<!-- 页面顶部-->
<jsp:include page="../web/header.jsp"></jsp:include>
<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>订单管理</a></li>
    </ul>
</div>
    <!--我的订单内容区域 #container-->
    <div id="container" class="clearfix">
        <!-- 左边栏-->
        <jsp:include page="../web/left.jsp"></jsp:include>
         <!-- 右边栏-->
        <div class="rightsidebar_box rt">
            <!-- 商品信息标题-->
            <table id="order_list_title"  cellpadding="0" cellspacing="0" >
                <tr>
                    <th width="345">商品</th>
                    <th width="82">单价（元）</th>
                    <th width="50">数量</th>
                    <th width="82">售后</th>
                    <th width="100">实付款（元）</th>
                    <th width="90">交易状态</th>
                    <th width="92">操作</th>
                </tr>
            </table>
            <!-- 订单列表项 -->
            <a href="../order/showUserOrders.do"><font color="blue" size="3" style="text-align: center;"><c:out value="${msg }"></c:out></font></a>
            <c:forEach items="${orderList }" var="orderList">
            <div id="orderItem">
              <p class="orderItem_title">
                 <span id="order_id">
                     &nbsp;&nbsp;订单编号:<a href="#"><c:out value="${orderList.orderId }"></c:out></a>
                 </span>
                  &nbsp;&nbsp;成交时间：${orderList.orderTime}&nbsp;&nbsp;
                 <span>
                     <a href="#" class="servie">
                        联系客服<img src="../images/myOrder/kefuf.gif"/>
                      </a>
                 </span>
              </p>
            </div>
              <div id="orderItem_detail">
                  <ul>
                      <li class="product">
                          <b><a href="../goods/product_details.do?goodsId=1"><img src="../images/goodstore/${orderList.goodsImage}"  width=84px height=84px/></a></b>
                          <b class="product_name lf" >
                              <a href="">${orderList.goodsName}&nbsp;&nbsp;${orderList.goodsStandard}&nbsp;&nbsp;${orderList.goodsSystem}</a>
                              <br/>
                          </b>
                          <b class="product_color ">
                             ${orderList.goodsColor}
                          </b>
                      </li>
                      <li class="unit_price">
                          专属价
                          <br/>
                          ￥ ${orderList.goodsMoney}
                      </li>
                      <li class="count">
                          ${orderList.goodsNum}
                      </li>
                      <li class="sale_support">
                          退款/退货
                          <br/>
                          我要维权
                      </li>
                      <li class=" payments_received">
                          ￥${orderList.goodsMoney* 	orderList.goodsNum}
                      </li>
                      <li class="trading_status">
                          <img src="../images/myOrder/car.png" alt=""/>
                           <!-- // 0：已完成；1：待付款；2：待收货；3：待评价； -->
                          <c:if test="${orderList.orderStatus eq '0'}">已发货</c:if>
                          <c:if test="${orderList.orderStatus eq '1'}">待付款</c:if>
                          <c:if test="${orderList.orderStatus eq '2'}">已发货</c:if>
                          <c:if test="${orderList.orderStatus eq '3'}">已发货</c:if>
                          <br/>
                          <a href="../order/showThisOrderInfo.do?orderId=${orderList.orderId }">订单详情</a>
                          <br/>
                          <a href="#" class="view_logistics">查看物流</a>
                      </li>
                      <li class="operate">
                      <!-- // 0：已完成；1：待付款；2：待收货；3：待评价； -->
                      <c:if test="${orderList.orderStatus eq '0'}">
                          <a href="#">已完成</a>
                    	</c:if>
                      <c:if test="${orderList.orderStatus eq '1'}">
                          <a href="../order/trunToCartOrder.do?orderId=${orderList.orderId }">前往付款</a>
                     </c:if>
                       <c:if test="${orderList.orderStatus eq '2'}">
                          <a href="../order/updateOrder.do?type=3&orderId=${orderList.orderId }">确认收货</a>
                      </c:if>
                      <c:if test="${orderList.orderStatus eq '3'}">
                          <a href="../web/lookforward.html">前往评价</a>
                     </c:if>
                      </li>
                  </ul>
              </div>
			</c:forEach>
            <!-- <div id="orderItem">
                <p class="orderItem_title">
                 <span id="order_id">
                     &nbsp;&nbsp;订单编号:<a href="#">12345678910</a>
                 </span>
                    &nbsp;&nbsp;成交时间：2016-01-04 18:00&nbsp;&nbsp;
                 <span>
                     <a href="#" class="servie">
                         联系客服<img src="../images/myOrder/kefuf.gif"/>
                     </a>
                 </span>
                </p>
            </div>
            <div id="orderItem_detail">
                <ul>
                    <li class="product">
                        <b><a href="#"><img src="../images/myOrder/product_img1.png" /></a></b>
                        <b class="product_name lf" >
                            <a href="">联想(Lenovo)YoGA5 PRO 标配版电脑 (I5-7200U 8G 512G SSD IPS)</a>
                            <br/>
                        </b>
                        <b class="product_color ">
                            颜色：深空灰
                        </b>
                    </li>
                    <li class="unit_price">
                        专属价
                        <br/>
                        ￥8800
                    </li>
                    <li class="count">
                        1件
                    </li>
                    <li class="sale_support">
                        退款/退货
                        <br/>
                        我要维权
                    </li>
                    <li class=" payments_received">
                        ￥1222.00
                    </li>
                    <li class="trading_status">
                        <img src="../images/myOrder/car.png" alt=""/>已发货
                        <br/>
                        <a href="orderInfo.jsp">订单详情</a>
                        <br/>
                        <a href="#" class="view_logistics">查看物流</a>
                    </li>
                    <li class="operate">
                        <a href="#">确认收货</a>
                    </li>
                </ul>
            </div>

            <div id="orderItem">
                <p class="orderItem_title">
                 <span id="order_id">
                     &nbsp;&nbsp;订单编号:<a href="#">12345678910</a>
                 </span>
                    &nbsp;&nbsp;成交时间：2016-01-04 18:00&nbsp;&nbsp;
                 <span>
                     <a href="#" class="servie">
                         联系客服<img src="../images/myOrder/kefuf.gif"/>
                     </a>
                 </span>
                </p>
            </div>
            <div id="orderItem_detail">
                <ul>
                    <li class="product">
                        <b><a href="#"><img src="../images/myOrder/product_img1.png" /></a></b>
                        <b class="product_name lf" >
                            <a href="">联想(Lenovo)YoGA5 PRO 标配版电脑 (I5-7200U 8G 512G SSD IPS)</a>
                            <br/>
                        </b>
                        <b class="product_color ">
                            颜色：深空灰
                        </b>
                    </li>
                    <li class="unit_price">
                        专属价
                        <br/>
                        ￥8800
                    </li>
                    <li class="count">
                        1件
                    </li>
                    <li class="sale_support">
                        退款/退货
                        <br/>
                        我要维权
                    </li>
                    <li class=" payments_received">
                        ￥1222.00
                    </li>
                    <li class="trading_status">
                        <img src="../images/myOrder/car.png" alt=""/>已发货
                        <br/>
                        <a href="orderInfo.jsp">订单详情</a>
                        <br/>
                        <a href="#" class="view_logistics">查看物流</a>
                    </li>
                    <li class="operate">
                        <a href="#">确认收货</a>
                    </li>
                </ul>
            </div> -->


<!--分页器-->
            <div class="tcdPageCode"></div>

        </div>
    </div>

        <!--<iframe src="order_status.html" width="1000" height=500""></iframe>-->
<!-- 品质保障，私人定制等-->
<jsp:include page="../web/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>
</html>