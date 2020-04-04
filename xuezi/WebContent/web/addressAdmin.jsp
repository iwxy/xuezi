<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/orders.css" rel="stylesheet"/>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
</head>
<body>

<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
    </ul>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
    <jsp:include page="../web/left.jsp"></jsp:include>
   <!-- 右边栏-->
    <div class="rightsidebar_box rt">	
        <!--标题栏-->
        <div class="rs_header">
            <span class="address_title">收获地址管理</span>
        </div>
        <!--收货人信息填写栏-->
        <div class="rs_content">
        	<form method="post" action="">
	            <!--收货人姓名-->
	            <div class="recipients">
	                <span class="red">*</span><span class="kuan">收货人：</span><input type="text" name="receiverName" value="${address.receiverName}" autofocus id="receiverName"/>
	            </div>
	            <!--收货人所在城市等信息-->
	            <div data-toggle="distpicker" class="address_content">
					 <span class="red">*</span><span class="kuan">省&nbsp;&nbsp;份：</span><select data-province="---- 选择省 ----"  id="receiverState" name="receiverProvince"></select>
					  城市：<select data-city="---- 选择市 ----" value="${address.receiverCity}" id="receiverCity" name="receiverCity"></select>
					  区/县：<select data-district="---- 选择区 ----" value="${address.receiverCounty}" id="receiverDistrict" name="receiverCounty"></select>
				</div> 
	            
	            <!--收货人详细地址-->
	            <div class="address_particular">
	                <span class="red">*</span><span class="kuan">详细地址：</span><textarea   name="receiverAddress" id="receiverAddress" cols="60" rows="3" placeholder="建议您如实填写详细收货地址">${address.receiverAddress }</textarea>
	            </div>
	            <!--收货人地址-->
	            <div class="address_tel">
	                <span class="red">*</span><span class="kuan">手机号码：</span><input type="tel" value="${address.receiverMobile}" id="receiverMobile" name="receiverMobile"/>固定电话：<input type="text" name="receiverPhone" id="receiverPhone"/>
	            </div>
	            <!--邮政编码-->
	            <div class="address_postcode">
	                <span class="red">&nbsp;</span class="kuan"><span>邮政编码：</span>&nbsp;<input type="text" value="${address.receiverZip}" id="receiverZip" name="receiverZip"/>
	            </div>
	            <!--地址名称-->
	            <div class="address_name">
	                <span class="red">&nbsp;</span class="kuan"><span>地址名称：</span>&nbsp;<input type="text" value="${address.addressName}" id="addressName" name="addressName"/>如：<span class="sp">家</span><span class="sp">公司</span><span class="sp">宿舍</span>
	            </div>
	            <!--保存收货人信息-->
	            <div class="save_recipient">
	                保存收货人信息
	            </div>
	
    		</form>
            <!--已有地址栏-->
            <div class="address_information_manage">
                <div class="aim_title">
                    <span class="dzmc dzmc_title">地址名称</span><span class="dzxm dzxm_title">姓名</span><span class="dzxq dzxq_title">地址详情</span><span class="lxdh lxdh_title">联系电话</span><span class="operation operation_title">操作</span>
                </div>
                <c:forEach items="${addressList }" var="addressList">
                <div class="aim_content_two ">               
                    <span class="dzmc dzmc_active"><c:out value="${addressList.addressName}"/></span>
                    <span class="dzxm dzxm_normal"><c:out value="${addressList.receiverName}"/></span>
                    <span class="dzxq dzxq_normal"><c:out value="${addressList.receiverAddress}"/></span>
                    <span class="lxdh lxdh_normal"><c:out value="${addressList.receiverMobile}"/></span>
                    <span class="operation operation_normal">
                    	<span class="aco_change" onclick="changeReceiver(${addressList.addressId})">修改</span>|<span class="aco_delete" onclick="deleteRecipient(${addressList.addressId})">删除</span>
                    </span>
                    <c:if test="${addressList.receiverStatus eq '0'}">
                    <span class="swmr swmr_normal" onclick="changeStatus(${addressList.receiverStatus},${addressList.addressId})">设为默认</span>
                    </c:if>
                    <c:if test="${addressList.receiverStatus eq '1'}">
                    <span class="swmr swmr_normal" onclick="changeStatus(${addressList.receiverStatus},${addressList.addressId})"></span>
                    </c:if>
                </div>
               
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<!-- 品质保障，私人定制等-->
<jsp:include page="foot_box.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>
<script type="text/javascript" src="../js/distpicker.data.js"></script>
<script type="text/javascript" src="../js/distpicker.js"></script>
<script type="text/javascript" src="../js/personal.js"></script>
<script type="text/javascript">
	function deleteRecipient(addressId){
		$.ajax({
			url:"../address/deleteAddress.do",
			data:"addressId="+addressId,
			type:"post",
			dataType:"json",
			success:function(obj)
	        {
				if(obj.state==1){
					alert(obj.message);
					location.href='../address/saveAddressList.do';
				}
	        }
		});
	}
	function changeStatus(receiverStatus,addressId){
		$.ajax({
			url:"../address/updateAddress.do",
			data:"addressId="+addressId+"&receiverStatus="+receiverStatus,
			type:"post",
			dataType:"json",
			success:function(obj)
	        {
				if(obj.state==1){
					alert(obj.message);
				}
	        }
		});
	}
	function changeReceiver(addressId){
		$.ajax({
			url:"../address/showAddressdatil.do",
			data:"addressId="+addressId,
			type:"post",
			dataType:"json",
			success:function(obj)
	        {
				if(obj.state==1){
					alert(obj.message);
					location='../address/saveAddressList.do';
				}
	        }
		});
		
	}
	
/* 	function saveRecipient(){
		alert("save");
		var receiverName=$("#receiverName").val();
		$.ajax({
			url:"../address/saveAddress.do",
			data:"receiverName="+receiverName+"&receiverProvince="+$("#receiverState").val()+
				"&receiverCity="+$("#receiverCity").val()+"&receiverCounty="+$("#receiverDistrict").val()+
				"&receiverAddress="+$("#receiverAddress").val()+"&receiverMobile="+$("#receiverMobile").val()+
				"&receiverPhone="+$("#receiverPhone").val()+"&receiverZip="+$("#receiverZip").val()+
				"&addressName="+$("#addressName").val()+"&addressId="+addressId,
			type:"post",
			dataType:"json",
			success:function(obj)
	        {
				if(obj.state==1){
					alert(obj.message);
					location.href='../address/showAddressAdmin.do';
				}
	        }
		});
	} */
</script>
<script type="text/javascript">
	$(function(){
		//把所有的dd隐藏
		$("leftsidebar_box dd").hide();
		//设置账号管理dd显示
		$("leftsidebar_box .address dd").show();
		//把所有的向右
		$("leftsidebar_box dt img").attr("src","../images/myOrder/myOrder1.png");
		//设置账号管理的向下
		$("leftsidebar_box .address img").attr("src","../images/myOrder/myOrder2.png");
	})
</script>
<script type="text/javascript">
	$(".lxdh_normal").each(function(i,e) {
		var phone = $(e).html();
		$(e).html(changePhone(phone));
	});
</script>
</html>