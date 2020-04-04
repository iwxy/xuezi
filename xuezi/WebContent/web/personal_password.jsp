<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/orders.css" rel="Stylesheet"/>
    <link href="../css/header.css" rel="Stylesheet"/>
    <link href="../css/footer.css" rel="Stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
</head>
<body>
<!-- 页面顶部、导航-->
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
    <jsp:include page="left.jsp"></jsp:include>
    <!-- 右边栏-->
    <!--个人信息头部-->
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span ><a href="../user/showPersonage.do">我的信息</a></span>
            <span class="rs_header_active"><a href="../user/showPersonal_password.do">安全管理</a></span>
        </div>

        <!--安全管理 -->
        <div class="rs_content">
            <p class="change_password_title">更改密码</p>
            <div class="new_password">
                <span class="word">输入旧密码：</span><input type="password" id="oldPwd"/>
                <span class="change_hint" id="showResult">请输入旧密码</span>
            </div>
            <div class="new_password">
                <span class="word">输入新密码：</span><input type="password" id="newPwd"/>
                <span class="change_hint" id="showResult">密码长度在6到12位之间</span>
            </div>
            <div class="confirm_password">
                <span class="word">确认新密码：</span><input type="password" id="newPwdconfirm"/>
                <span class="confirm_hint" id="showResult">密码长度在6到12位之间</span>
            </div>
            <div class="save_password" id="updatePassword">
               	 保存更改
            </div>
        </div>
    </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<jsp:include page="footer.jsp"></jsp:include>
</body>

<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>
<script>
	$('#updatePassword').click(function() {
		var lengths = 0;
		$('.form-group').each(function() {
			if ($(this).find('span').hasClass('msg-success')) {
				lengths++;
				alert(lengths);
			}
		});
		if (lengths == 3) {
			$.ajax({
				url : "../user/register.do",
				data : $("#form-register").serialize(),
				type : "post",
				dataType : "json",
				success : function(obj) {
					//弹出提示信息
					alert(obj.message);
					location.href="../main/showIndex.do";
				}
			});
		}
	})
	</script>
<script>
	//异步验证密码
    $("#oldPwd").blur(function(){
        var data = $("#oldPwd").val();
        if (data == null || data == "") {
            $("#showResult").text("旧密码栏不能为空！");
            $("#showResult").css("color","red");
            return false;
        }
        $.ajax({
        	url:"../user/checkOldPwd.do",
        	data:"oldPwd="+data,
            type:"get",
            dataType : "json",
            beforeSend:function(XMLHttpRequest)
            {
                $("#showResult").text("开始验证旧密码");

            },
            success : function(obj) 
            {
				$("#showResult").html(obj.message);
				//显示服务器的响应信息
				if (obj.state == 0) {
					$("#showResult").html(obj.message);
				} else {
					$("#showResult").html(obj.message);
					$("#showResult").css("color","red");
				}
			}
        });
    });
</script>
<script>
	//新密码匹配验证
	newPwd.onblur = function() {
		this.nextElementSibling.innerHTML = '密码长度在6到12位之间';
		this.nextElementSibling.className = 'msg-default';
		var newPwd=$("#newPwd").val();
		if (newPwd == null || newPwd == "") {
			this.nextElementSibling.innerHTML = '密码不能为空';
			this.nextElementSibling.className = 'msg-error';
			this.setCustomValidity('密码不能为空');
		} else if (newPwd.length<6) {
			this.nextElementSibling.innerHTML = '密码长度在尽量别少于6位';
			this.nextElementSibling.className = 'msg-error';
			this.setCustomValidity('密码长度在尽量别少于6位');
		} else {
			this.nextElementSibling.innerHTML = '密码格式正确';
			this.nextElementSibling.className = 'msg-success';
			this.setCustomValidity('');
		}
	}
	newPwdconfirm.onblur = function() {
		this.nextElementSibling.innerHTML = '密码长度在6到12位之间';
		this.nextElementSibling.className = 'msg-default';
		var newPwdconfirm=$("#newPwdconfirm").val();
		if (newPwdconfirm == null || newPwdconfirm == "") {
			this.nextElementSibling.innerHTML = '密码不能为空';
			this.nextElementSibling.className = 'msg-error';
			this.setCustomValidity('密码不能为空');
		} else if (newPwdconfirm.length<6) {
			this.nextElementSibling.innerHTML = '密码长度在尽量别少于6位';
			this.nextElementSibling.className = 'msg-error';
			this.setCustomValidity('密码长度在尽量别少于6位');
		}else if (newPwdconfirm != document.getElementById("newPwd").value) {
			this.nextElementSibling.innerHTML = '两次密码输入不一致';
			this.nextElementSibling.className = 'msg-error';
			this.setCustomValidity('两次密码输入不一致');  
		}else{
			this.nextElementSibling.innerHTML = '密码格式正确';
			this.nextElementSibling.className = 'msg-success';
			this.setCustomValidity('');
		}
		
	}

</script>
<script>
    $('#updatePassword').click(function(){
        //异步提交请求修改密码
        
        $.ajax({
        	url:"../user/updatePassword.do",
        	data:"oldPwd="+$("#oldPwd").val()+
        	    "&newPwd="+$("#newPwd").val(),
        	type:"post",
        	dataType : "json",
        	success:function(obj){
        		if(obj.state==0){
        			alert(obj.message);
        		}else{
        			alert(obj.message);
        		}
        	}
        });
    });
</script>

<script type="text/javascript">
	/* 左菜单栏 js*/
	$(function(){
		//把所有的dd标签项隐藏
		$("#leftsidebar_box dd").hide();
		//设置账号管理的列表显示
		$("#leftsidebar_box .count_managment dd").show();
		//把所有的箭头改为向右的箭头
		$("#leftsidebar_box dt img").attr("src","../images/myOrder/myOrder1.png");
		//把所有的箭头改为向下的箭头
		$("#leftsidebar_box .count_managment img").attr("src","../images/myOrder/myOrder2.png");
		
	});
</script>
</html>