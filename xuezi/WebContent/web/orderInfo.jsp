<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>阿甲学子商城-订单详情页</title>
    <link rel="stylesheet" href="../css/header.css"/>
    <link rel="stylesheet" href="../css/footer.css"/>
    <link rel="stylesheet" href="../css/order.css"/>
</head>
<body>
<!-- 页面顶部-->
<jsp:include page="../web/header.jsp"></jsp:include>
<!--详细信息-->
<div id="container">
        <!-- 导航 -->
        <div class="container_nav">
            首页&gt;订单管理&gt;订单<span>${thisOrder.orderId }</span>
        </div>
        <div class="orderInfo_icon"><!-- // 0：已完成；1：待付款；2：待收货；3：待评价； -->
                          
            <p>订单
            <span class="order-num">${thisOrder.orderId }</span>
            &nbsp;&nbsp;&nbsp;当前状态：<c:if test="${thisOrder.orderStatus eq '0'}"><span class="state">已完成</span></c:if>
                          <c:if test="${thisOrder.orderStatus eq '1'}"><span class="state">待付款</span></c:if>
                          <c:if test="${thisOrder.orderStatus eq '2'}"><span class="state">已发货</span></c:if>
                          <c:if test="${thisOrder.orderStatus eq '3'}"><span class="state">待评价</span></c:if></p>
        </div>
        <!-- 订单状态流程图-->
        <div id="orderStatusChart">
              <dl>
                  <dt><img src="../images/orderinfo/orderinfo_img1_2.png" alt=""/></dt>
                  <dd>
                      <p>提交订单</p>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="../images/orderinfo/orderinfo_img6_2.png" alt=""/></dt>
              </dl>
              <!-- // 0：已完成；1：待付款；2：待收货；3：待评价； -->
              <!-- 付款成功（0,1,2,3） -->
			<c:if test="${thisOrder.orderStatus eq '0'||thisOrder.orderStatus eq '2'||thisOrder.orderStatus eq '3'}">
              <dl>
                  <dt><img src="../images/orderinfo/orderinfo_img2_1.png" alt=""/></dt>
                  <dd>
                      <p>付款成功</p>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="../images/orderinfo/orderinfo_img6_2.png" alt=""/></dt>
              </dl>
              </c:if>
              <!-- 待付款（1） -->
              <c:if test="${thisOrder.orderStatus eq '1'}">
              <dl>
                <dt><img src="../images/orderinfo/orderinfo_img2.png" alt=""/></dt>
              </dl>
				
              <dl>
                <dt class="point"><img src="../images/orderinfo/orderinfo_img6.png" alt=""/></dt>
              </dl>
				</c:if>
				<!-- 已收货（0,3） -->
				<c:if test="${thisOrder.orderStatus eq '0'||thisOrder.orderStatus eq '2'||thisOrder.orderStatus eq '3'}">
					<dl>
                  <dt><img src="../images/orderinfo/orderinfo_img3_1.png" alt=""/></dt>
                  <dd>
                      <p style="display: block">配送中</p>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="../images/orderinfo/orderinfo_img6_2.png" alt=""/></dt>
              </dl>
				</c:if>
				<!-- 待收货（1） -->
				<c:if test="${thisOrder.orderStatus eq '1'}">
					<dl>
                  <dt><img src="../images/orderinfo/orderinfo_img3.png" alt=""/></dt>
                  <dd>
                      <p style="display: none">配送中</p>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="../images/orderinfo/orderinfo_img6.png" alt=""/></dt>
              </dl>
				</c:if>
				
				<!-- 已收货，待评价（3） -->
				<c:if test="${thisOrder.orderStatus eq '0'||thisOrder.orderStatus eq '3'}">
              <dl>
                  <dt><img src="../images/orderinfo/orderinfo_img4_1.png" alt=""/></dt>
                  <dd>
                      <p style="display: block">确认收货</p>
                   </dd>
              </dl>
              <dl>
                <dt class="point"><img src="../images/orderinfo/orderinfo_img6_2.png" alt=""/></dt>
              </dl>
              </c:if>
              <!-- 未收货（1,2） -->
              <c:if test="${thisOrder.orderStatus eq '1'||thisOrder.orderStatus eq '2'}">
              <dl>
                  <dt><img src="../images/orderinfo/orderinfo_img4.png" alt=""/></dt>
                  <dd>
                      <p style="display: none">确认收货</p>
                   </dd>
              </dl>
              <dl>
                <dt class="point"><img src="../images/orderinfo/orderinfo_img6.png" alt=""/></dt>
              </dl>
              </c:if>
              <!-- 未评价（1,2,3） -->
				<c:if test="${thisOrder.orderStatus eq '1'||thisOrder.orderStatus eq '2'||thisOrder.orderStatus eq '3'}">
              <dl>
                  <dt><img src="../images/orderinfo/orderinfo_img5.png" alt=""/></dt>
                  
                  <dd>
                      <p style="display: none">评价</p>
                  </dd>
              </dl>
				</c:if>
				 <!-- 已完成0 -->
				<c:if test="${thisOrder.orderStatus eq '0'}">
              <dl>
                  <dt><img src="../images/orderinfo/orderinfo_img5_1.png" alt=""/></dt>
                  
                  <dd>
                      <p style="display: block">评价</p>
                  </dd>
              </dl>
				</c:if>
				
        </div>
        <div class="clear">
<!-- ==============================加入地址模块========================================== -->
        <!-- 详细信息-->
            <h1>详细信息</h1>
            收货人：<span class="consignee">${address.receiverName }</span>&nbsp;&nbsp;&nbsp;&nbsp;邮编：<span class="postcode">${address.receiverZip }</span>&nbsp;&nbsp;&nbsp;&nbsp;联系电话：<span class="tel">${address.receiverPhone }</span>
            <br/>
            <p>收货地址：<span>${address.receiverProvince }${address.receiverCity }${address.receiverCounty }${address.receiverAddress}</span></p>
        </div>

        <!-- 商品信息-->
        <div style="width: 1000px; margin:0px auto">
            <h1 class="commodity">商品信息</h1>
            <div class="product_confirm">
                <ul class="item_title">
                    <li class="p_info">商品信息</li>
                    <li class="p_price">单价(元)</li>
                    <li class="p_count">数量</li>
                    <li class="p_tPrice">实付款</li>
                </ul>
                <div>订单编号：<span>${thisOrder.orderId }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;成交时间：${thisOrder.orderTime }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系客服：<img src="../images/orderinfo/kefuf.gif" alt=""/></div>
                <ul class="item_detail">
                    <li class="p_info">
                        <b><img src="../images/goodstore/${thisOrder.goodsImage }" /></b>
                        <p class="product_name lf" >
                           ${thisOrder.goodsName}&nbsp;&nbsp;${thisOrder.goodsStandard}&nbsp;&nbsp;${thisOrder.goodsSystem}
                        </p>
                        <br/>
                <span class="product_color ">
                   ${thisOrder.goodsColor}
                </span>
                    </li>
                    <li class="p_price">
                        <i>&nbsp;&nbsp;专属价</i>
                        <br/><br>
                        <span class="pro_price">￥${thisOrder.goodsMoney}</span>
                    </li>
                    <li class="p_count">${thisOrder.goodsNum}件</li>
                    <li class="p_tPrice">￥${thisOrder.goodsNum*thisOrder.goodsMoney}</li>
                    <!--<li class="remark">备注</li>-->
                    <li></li>
                </ul>
            </div>

        </div>

    </div>
<!-- 品质保障，私人定制等-->
<jsp:include page="../web/footer.jsp"></jsp:include>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script>
    //搜索下拉
    $('.seek').focus(function(){

        if($(this).hasClass('clickhover')){

            $(this).removeClass('clickhover');
            $(this).find('.seek_content').hide();
            $(this).find('img').attr('src','../images/header/header_normal.png');

        }else{
            $(this).addClass('clickhover');
            $(this).find('.seek_content').show();
            $(this).find('img').attr('src','../images/header/header_true.png');
        }
    })
    $('.seek_content>div').click(function(){
        $('.seek').removeClass('clickhover');
        var text=$(this).html();
        $('.seek span').html(text);
        $(this).parent().hide();
        $('.seek').find('img').attr('src','../images/header/header_normal.png');
        $('.seek').blur();

    })

    $('.seek').blur(function(){

        $('.seek').removeClass('clickhover');
        $('.seek_content').hide();

        $('.seek').find('img').attr('src','../images/header/header_normal.png');
        console.log(1);
    })
    //头部hover
    $(".care").hover(function(){
        $(this).attr('src',"../images/header/care1.png");
    },function(){
        $(this).attr('src',"../images/header/care.png");
    });
    $(".order").hover(function(){
        $(this).attr('src',"../images/header/order1.png");
    },function(){
        $(this).attr('src',"../images/header/order.png");
    });
    $(".shopcar").hover(function(){
        $(this).attr('src',"../images/header/shop_car1.png");
    },function(){
        $(this).attr('src',"../images/header/shop_car.png");
    });
</script>
</html>