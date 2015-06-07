<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>功能分区</title>

<link rel="shortcut icon" href="images/icon.png">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="购物,交换,出租" />
<link rel="stylesheet" href="css/lanrenzhijia.css" media="all">
<script src="js/jquery.min2.js"></script>
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
<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.dropotron.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-panels.min.js"></script>
<script src="js/init.js"></script>
<noscript>
	<link rel="stylesheet" href="css/skel-noscript.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-desktop.css" />
	<link rel="stylesheet" href="css/style-noscript.css" />
</noscript>
<!--[if lte IE 8]><link rel="stylesheet" href="css/ie8.css" /><![endif]-->
<style type="text/css">
<!--
body {
	background-image: url(images/header2.png);
	background-size: cover;
}
-->
</style>

</head>
<body class="homepage">

	<!-- Banner -->
	<div id="banner">
		<h2 style="font-family: 'Lucida Handwriting'; font-size: 600%; opacity: 0.70; color: #FFFFFF;">
			Welcome to Bingo!
		</h2>
		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li><a href="">Bingo！移动端</a></li>
				<li><a href="#footer">分享给好友</a></li>
				<li><a class="theme-login" href="javascript:;">修改个人信息</a></li>
				<li><a class="theme-login" href="post.jsp">发布帖子</a></li>
				<fieldset id="actions">
					<div class="theme-popover">
						<div class="theme-poptit">
							<a href="javascript:;" title="关闭" class="close"></a>
							<h3 style="font-family: 幼圆">
								<b>修改您的个人信息</b>
							</h3>
						</div>
						<div class="theme-popbod dform">
							<form class="theme-signin" name="loginform" action="/Exchange/ChangeUserServlet"
								method="post">
								<ol>
									<li>原始密码：<input class="ipt" type="password" name="cpwd" /></li>
									<li>设置密码：<input class="ipt" type="password" name="pwd1" /></li>
									<li>确认密码：<input class="ipt" type="password" name="pwd2" /></li>
									<li>电子邮箱: <input class="ipt" type="text" name="mail" /></li>
									<li>联系电话：<input class="ipt" type="text" name="num" /></li>
									<li><input class="btn btn-primary" type="submit"
										name="submit" value="Bingo！" /></li>
								</ol>
							</form>

						</div>
					</div>
				</fieldset>
			</ul>
		</nav>
	</div>


	<!-- Carousel -->
	<div class="carousel">
		<div class="reel">
			<article>
				<p>&nbsp;</p>
				<p>
					<a href="exchangepros.jsp" class="image featured"><img
						src="images/exchange.png" alt="" /></a>
				</p>
				<p>把不想要的旧物换成别的东东~~</p>
			</article>

			<article>
				<p>&nbsp;</p>
				<p>
					<a href="hirepros.jsp" class="image featured"><img
						src="images/hire.png" alt="" /></a>
				</p>
				<p>短期不用的东东租出去赚钱啦~~</p>
			</article>

			<article>
				<p>&nbsp;</p>
				<p>
					<a href="newpros.jsp" class="image featured"><img
						src="images/new.png" alt="" /></a>
				</p>
				<p>给你推荐最新最热的东东~~</p>
			</article>

			<article>
				<p>&nbsp;</p>
				<p>
					<a href="helppros.jsp" class="image featured"><img
						src="images/help.png" alt="" /></a>
				</p>
				<p>想要的东东可在这发求助帖哟~~</p>
			</article>
		</div>
	</div>



	<!-- Footer -->
	<div id="footer">
		<div class="container">
			<div class="row"></div>
			<hr />
			<div class="row">
				<div class="12u">

					<!-- Contact -->
					<section class="contact">
						<header>
							<h3>喜欢我们的网站吗？</h3>
						</header>
						<p>喜欢的话就分享给你的朋友吧~~</p>
						<ul class="icons">

							<li><a href="http://connect.qq.com/widget/shareqq/index.html?title=qqhaoyou&url=http://www.bingo.com&desc=Bingo还不错哦&pics=&site=Bingo" target="_blank"><img src="images/QQ.png" width="50"
									height="50"></a></li>
							<li><a href="http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=http://www.bingo.com" target="_blank"><img src="images/QQzone.png" width="50"
									height="50"></a></li>
							<li><a href="#"><img src="images/wechat.png" width="50"
									height="50"></a></li>
							<li><a href="http://v.t.sina.com.cn/share/share.php?url=http://www.bingo.com&title='Bingo网站'" target="_blank"><img src="images/weibo.png" width="50"
									height="50"></a></li>
							<li><a href="http://v.t.qq.com/share/share.php?url=http://www.bingo.com&title='Bingo网站'" target="_blank"><img src="images/tecent.png" width="50"
									height="50"></a></li>
							<li><a href="#"><img src="images/friend.png" width="50"
									height="50"></a></li>
							<li><a href="http://share.renren.com/share/buttonshare.do?link=http://www.bingo.com"><img src="images/renren.png" width="71"
									height="42"></a></li>
						</ul>
					</section>


				</div>

			</div>
		</div>
	</div>

</body>
</html>