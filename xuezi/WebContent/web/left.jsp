<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script type="text/javascript">
/* 左菜单栏 */
	$(function(){
		//把所有的dd标签项隐藏
		$("#leftsidebar_box dd").hide();
		//设置账号管理的列表显示
		$("#leftsidebar_box .count_managment dd").show();
		//把所有的箭头改为向右的箭头
		$("#leftsidebar_box dt img").attr("src","../images/myOrder1.png");
		//把所有的箭头改为向下的箭头
		$("#leftsidebar_box .count_managment img").attr("src","../images/myOrder2.png");
		
	});

</script>
<!-- 左边栏-->
<div id="leftsidebar_box" class="lf">
        <div class="line"></div>
        <dl class="my_order">
            <dt >我的订单
                <img src="../images/myOrder/myOrder2.png">
            </dt>
            <dd class="first_dd"><a href="../order/showUserOrders.do">全部订单</a></dd>
            <dd>
                <a href="../order/showDifferentOrders.do?type=1">
                    待付款
                    <span><!--待付款数量--></span>
                </a>
            </dd>
            <dd>
                <a href="../order/showDifferentOrders.do?type=2">
                    待收货
                    <span><!--待收货数量-->1</span>
                </a>
            </dd>
            <dd>
                <a href="../order/showDifferentOrders.do?type=3">
                    待评价<span><!--待评价数量--></span>
                </a>
            </dd>
            <dd>
                <a href="../web/lookforward.html">退货退款</a>
            </dd>
        </dl>

        <dl class="footMark">
            <dt >我的优惠卷<img src="../images/myOrder/myOrder1.png"></dt>
        </dl>
        <dl class="address">
                <dt>收货地址<img src="../images/myOrder/myOrder1.png"></dt>
				<dd><a href="../address/saveAddressList.do">地址管理</a></dd>
            </dl>
            <dl class="count_managment">
                <dt >帐号管理<img src="../images/myOrder/myOrder1.png"></dt>
                <dd class="first_dd"><a href="../user/showPersonage.do">我的信息</a></dd>
                <dd><a href="../user/showPersonal_password.do">安全管理</a></dd>
            </dl>
    </div>