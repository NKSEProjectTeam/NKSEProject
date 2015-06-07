<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bingo用户登录</title>

<link rel="shortcut icon" href="images/icon.png">
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="购物,交换,出租" />

<link rel="stylesheet" href="css/lanrenzhijia.css" media="all">
<script src="js/jquery.min2.js"></script>

<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.dropotron.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-panels.min.js"></script>
<script src="js/init.js"></script>
<noscript>
	<link rel="stylesheet" href="css/skel-noscript.
			css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-desktop.css" />
	<link rel="stylesheet" href="css/style-noscript.css" />
</noscript>
<!--[if lte IE 8]><link rel="stylesheet" href="css/ie8.css" /><![endif]-->


<script>
		jQuery(document).ready(function($) {
			$('.theme-login').click(function(){
				$('.theme-popover-mask').fadeIn(100);
				$('.theme-popover').slideDown(200);
			})
			$('.theme-poptit .close').click(function(){
				$('.theme-popover-mask').fadeOut(100);
				
				$('.theme-popover').slideUp(200);
			})
		
		})
		</script>
<script type="text/javascript">
		// 弹出隐藏层
		function ShowDiv(show_div,bg_div){
		document.getElementById(show_div).style.display='block';
		document.getElementById(bg_div).style.display='block' ;
		var bgdiv = document.getElementById(bg_div);
		//bgdiv.style.width = document.body.scrollWidth;
		// bgdiv.style.height = $(document).height();
		$("#"+bg_div).height($(document).height());
		};
		// 关闭弹出层
		function CloseDiv(show_div,bg_div)
		{
		document.getElementById(bg_div).style.display='none';
		document.getElementById(show_div).style.display='none';
		
		};
		
		function registerValidate() {
			if(document.getElementById("agreecheck").checked) {
				
				var uname = document.getElementById("rusername");
				var pwd = document.getElementById("ruserpwd");
				var pwd2 = document.getElementById("userpwd2");
				var mail = document.getElementById("usermail");
				var num = document.getElementById("usernum");
				//alert("sss");
				if(uname.value == null || uname.value.length == 0) {
					//alert("sss");
					msgname.innerHTML = "<font color='red'>不能为空！</font>";
					return false;
				}
				if(pwd.value == null || pwd.value.length == 0) {
					msgpwd.innerHTML = "<font color='red'>不能为空！</font>";
					return false;
				}
				if(pwd2.value == null || pwd2.value.length == 0) {
					msgpwd2.innerHTML = "<font color='red'>不能为空！</font>";
					return false;
				}
				if(mail.value == null || mail.value.length == 0) {
					msgmail.innerHTML = "<font color='red'>不能为空！</font>";
					return false;
				}
				if(num.value == null || num.value.length == 0) {
					msgnum.innerHTML = "<font color='red'>不能为空！</font>";
					return false;
				}
				if(pwd2.value != pwd.value) {
					msgpwd2.innerHTML = "<font color='red'>两次密码不同！</font>";
					return false;
				}
				return true;
			} else {
				msgag.innerHTML = "<font color='red'>同意协议！</font>";
				return false;
			}
		}
		
</script>

<style type="text/css">
html,body {
	height: 100%;
}

#login {
	height: 240px;
	width: 400px;
	margin: 0 0 0 -230px;
	padding: 30px;
	position: absolute;
	top: 50%;
	left: 50%;
	z-index: 0;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
}

#login:before {
	content: '';
	position: absolute;
	z-index: -1;
	top: 5px;
	bottom: 5px;
	left: 5px;
	right: 5px;
}

h1 {
	margin: 0 0 30px 0;
	position: absolute;
	top: -133px;
	bottom: 50px;
	left: 424px;
	width: 487px;
	height: 261px;
}

fieldset {
	border: 0;
	padding: 0;
	margin: 0;
}

#inputs input {
	background: #f1f1f1;
	padding: 15px 15px 15px 30px;
	margin: 0 0 10px 0;
	width: 353px; /* 353 + 2 + 45 = 400 */
	border: 1px solid #ccc;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	-moz-box-shadow: 0 1px 1px #ccc inset, 0 1px 0 #fff;
	-webkit-box-shadow: 0 1px 1px #ccc inset, 0 1px 0 #fff;
	box-shadow: 0 1px 1px #ccc inset, 0 1px 0 #fff;
}

#username {
	background-position: 5px -2px !important;
}

#password {
	background-position: 5px -52px !important;
}

#inputs input:focus {
	background-color: #fff;
	border-color: #e8c291;
	outline: none;
	-moz-box-shadow: 0 0 0 1px #e8c291 inset;
	-webkit-box-shadow: 0 0 0 1px #e8c291 inset;
	box-shadow: 0 0 0 1px #e8c291 inset;
}

#actions {
	margin: 25px 0 0 0;
}

#submit {
	background-color: #ffb94b;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#fddb6f),
		to(#ffb94b));
	background-image: -webkit-linear-gradient(top, #fddb6f, #ffb94b);
	background-image: -moz-linear-gradient(top, #fddb6f, #ffb94b);
	background-image: -ms-linear-gradient(top, #fddb6f, #ffb94b);
	background-image: -o-linear-gradient(top, #fddb6f, #ffb94b);
	background-image: linear-gradient(top, #fddb6f, #ffb94b);
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);
	-moz-box-shadow: 0 0 1px rgba(0, 0, 0, 0.3), 0 1px 0
		rgba(255, 255, 255, 0.3) inset;
	-webkit-box-shadow: 0 0 1px rgba(0, 0, 0, 0.3), 0 1px 0
		rgba(255, 255, 255, 0.3) inset;
	box-shadow: 0 0 1px rgba(0, 0, 0, 0.3), 0 1px 0 rgba(255, 255, 255, 0.3)
		inset;
	border-width: 1px;
	border-style: solid;
	border-color: #d69e31 #e3a037 #d5982d #e3a037;
	float: left;
	height: 35px;
	padding: 0;
	width: 120px;
	cursor: pointer;
	font: bold 15px Arial, Helvetica;
	color: #8f5a0a;
}

#submit:hover,#submit:focus {
	background-color: #fddb6f;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#ffb94b),
		to(#fddb6f));
	background-image: -webkit-linear-gradient(top, #ffb94b, #fddb6f);
	background-image: -moz-linear-gradient(top, #ffb94b, #fddb6f);
	background-image: -ms-linear-gradient(top, #ffb94b, #fddb6f);
	background-image: -o-linear-gradient(top, #ffb94b, #fddb6f);
	background-image: linear-gradient(top, #ffb94b, #fddb6f);
}

#submit:active {
	outline: none;
	-moz-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.5) inset;
	-webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.5) inset;
	box-shadow: 0 1px 4px rgba(0, 0, 0, 0.5) inset;
}

#submit::-moz-focus-inner {
	border: none;
}

#actions a {
	color: #3151A2;
	float: right;
	line-height: 35px;
	margin-left: 10px;
}

#back {
	display: block;
	text-align: center;
	position: relative;
	top: 60px;
	color: #999;
}

.black_overlay {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	z-index: 1001;
	-moz-opacity: 0.8;
	opacity: .80;
	filter: alpha(opacity = 80);
}

p {
	color: #FFFFFF
}
</style>

</head>
<body class="homepage">


	<!-- Header -->
	<div id="header">
		<!-- Inner -->
		<div class="inner">
			<header>
				<h1>
					<img src="images/bingo logo2.png" width="504" height="273">
				</h1>
			</header>
			
			<form id="login" method="post" action="/Exchange/LoginServlet">
				<fieldset id="inputs">
					<input id="username" name="username" type="text" placeholder="用户名/Username" autofocus required />
					<input id="userpwd" name="userpwd" type="password" placeholder="密码/Password" required />
				</fieldset>
				<fieldset id="actions">
					<div class="theme-buy">
						<input type="submit" id="submit" value="Bingo!">
						<a href=""><p>忘记密码?</p></a>
						<a href="javascript:;">
							<input class="btn btn-primary btn-large theme-login" type="button" value="注册" onClick="ShowDiv('registerDiv','fade')" />
						</a>
					</div>
				</fieldset>
			</form>

			<!-- registerDiv -->
			<div id="registerDiv" class="theme-popover">

				<div class="theme-poptit">
					<a href="javascript:;" title="关闭" class="close"><span
						style="font-size: 12px;" onClick="CloseDiv('registerDiv','fade')">关闭</span></a>
					<h3 style="font-family: 幼圆">
						<b>欢迎注册Bingo！</b>
					</h3>
				</div>
				<div class="theme-popbod dform">
				
					<form class="theme-signin" name="loginform" action="/Exchange/RegisterServlet" method="post" onsubmit="return registerValidate()">

						<strong>用 户 名：</strong><input class="ipt" type="text" id="rusername" name="username"/><span id="msgname"></span><br/>
						<strong>设置密码：</strong><input class="ipt" type="password" id="ruserpwd" name="userpwd"/><span id="msgpwd"></span><br />
						<strong>确认密码：</strong><input class="ipt" type="password" id="userpwd2" name="userpwd2"/><span id="msgpwd2"></span><br />
						<strong>性&nbsp;&nbsp;&nbsp;&nbsp;别：</strong>&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" value="0" checked="checked" name="sex" />&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" value="1" name="sex" />&nbsp;女<br/>
						<strong>电子邮箱：</strong><input class="ipt" type="text" name="usermail" id="usermail"/><span id="msgmail"></span><br/>
						<strong>联系电话：</strong><input class="ipt" type="text" name="usernum" id="usernum"/><span id="msgnum"></span><br/>
						<input type="checkbox" value="agree" id="agreecheck"/>&nbsp;我已仔细阅读并同意服务协议。
						<a href="protocol.html">【服务协议】</a><span id="msgag"></span><br />
						<input class="btn btn-primary" type="submit" name="submit" value="Bingo！"/><br/>

					</form>

				</div>
			</div><!-- end registerDiv -->

			<br>
			<div style="text-align: center; clear: both"></div>
		</div>
	</div>
</body>
</html>