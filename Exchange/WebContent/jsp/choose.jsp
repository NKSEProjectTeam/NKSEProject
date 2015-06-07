<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>布局文件</title>

<link rel="shortcut icon" href="images/icon.png">
<link href="jsp/css/postcss/style.css" media="screen" rel="stylesheet"
	type="text/css">
<link href="jsp/css/postcss/grid.css" media="screen" rel="stylesheet"
	type="text/css">

<script src="jsp/js/postjs/jquery-1.7.2.min.js"></script>
<script src="jsp/js/postjs/html5.js"></script>
<script src="jsp/js/postjs/jflow.plus.js"></script>
<script src="jsp/js/postjs/jquery.carouFredSel-5.2.2-packed.js"></script>
<script src="jsp/js/postjs/checkbox.js"></script>
<script src="jsp/js/postjs/radio.js"></script>
<script src="jsp/js/postjs/selectBox.js"></script>

<script type="text/javascript">
	function cfmLogout() {
		if(confirm("您确认要退出？")) {
			window.location="/Exchange/LogoutServlet";
		}
	}
</script>

<script>
	$(document).ready(function() {
		$("select").selectBox();
	});
</script>

<script>
	$(document).ready(function() {
		$("#myController").jFlow({
			controller : ".control", // must be class, use . sign
			slideWrapper : "#jFlowSlider", // must be id, use # sign
			slides : "#slider", // the div where all your sliding divs are nested in
			selectedWrapper : "jFlowSelected", // just pure text, no sign
			width : "984px", // this is the width for the content-slider
			height : "480px", // this is the height for the content-slider
			duration : 400, // time in miliseconds to transition one slide
			prev : ".slidprev", // must be class, use . sign
			next : ".slidnext", // must be class, use . sign
			auto : true
		});
	});
</script>
<script>
	$(function() {
		$('#list_product').carouFredSel({
			prev : '#prev_c1',
			next : '#next_c1',
			auto : false
		});
		$('#list_product2').carouFredSel({
			prev : '#prev_c2',
			next : '#next_c2',
			auto : false
		});
		$('#list_banners').carouFredSel({
			prev : '#ban_prev',
			next : '#ban_next',
			scroll : 1,
			auto : false
		});
		$(window).resize();
	});
</script>
<script>
	$(document).ready(function() {
		$("button").click(function() {
			$(this).addClass('click')
		});
	})
</script>

<style type="text/css">
.theme-div {
 	display:none;
}
</style>

</head>
<body>

	<div class="container_12">
		<!-- #top -->
		<header id="branding">
		<div class="grid_3">
			<hgroup>
			<h1 id="site_logo">
				<a href="#" title=""><img src="images/bingo logo.png"
					alt="Online Store Theme Logo" width="259" height="132" /></a>
			</h1>
			</hgroup>
		</div>
		<!-- .grid_3 -->

		<div class="grid_3">
			<form class="search" method="post"
					action="/Exchange/SearchProductsServlet">
					<table>
						<tr>
							<td><select name="select2" id="select2" style="width: 110px">
									<option value="19">教科书</option>
									<option value="9">课外书</option>
									<option value="1">音像</option>
									<option value="2">箱包</option>
									<option value="3">化妆品</option>
									<option value="4">日常用品</option>
									<option value="5">饰品</option>
									<option value="6">数码产品</option>
									<option value="7">电器</option>
									<option value="8">娱乐</option>
									<option value="10">女装</option>
									<option value="11">乐器</option>
									<option value="12">男装</option>
									<option value="13">其他</option>
									<option value="14">电脑类</option>
									<option value="15">手机类</option>
									<option value="16">特产</option>
									<option value="17">体育辅助用品</option>
									<option value="18">体育用品</option>
									<option value="20">虚拟产品</option>
							</select></td>
							<td><input type="hidden" id="intPage" name="intPage"
								value="0" /> <input type="text" name="name" class="entry_form"
								value="" placeholder="请先选择分类，再输入商品名" /></td>
						</tr>
					</table>
				</form>
		</div>
		<!-- .grid_3 -->

		<div class="grid_6">
			<ul id="cart_nav">
				<li><a href="javascript:" class="cart_li STYLE1" onclick="cfmLogout()">退出登录</a></li>
			</ul>

			<nav class="private">
			<ul>
				<li><a href="showOrders.jsp">我的订单</a></li>
				<li class="separator">|</li>
				<li><a href="post.jsp">发布帖子</a></li>
			</ul>
			</nav>
			<!-- .private -->
		</div>
		<!-- .grid_6 --> </header>
		<!-- #branding -->
	</div>
	<!-- .container_12 -->

	<div class="clear"></div>

	<div id="block_nav_primary">
		<div class="container_12">
			<div class="grid_12">
				<nav class="primary">
				<ul>
					<li class="curent"><a href="">返回主页</a></li>
					<li><a href="#">商品分类</a>
						<ul class="sub">
							<li><a href="#">图书</a>
								<ul class="sub" style="margin-left: 230px; top: 3px;">
									<li><a href="display/showtb.jsp">教科书</a></li>
									<li><a href="display/showeb.jsp">课外书</a></li>
									<li><a href="display/showaudio.jsp">音像</a></li>
								</ul></li>
							<li><a href="#">电子</a>
								<ul class="sub" style="margin-left: 230px; top: 3px;">
									<li><a href="display/showphone.jsp">手机类</a></li>
									<li><a href="display/showpc.jsp">电脑类</a></li>
									<li><a href="display/showdigit.jsp">数码类</a></li>
								</ul></li>
							<li><a href="#">体育</a>
								<ul class="sub" style="margin-left: 230px; top: 3px;">
									<li><a href="display/showse.jsp">体育器械</a></li>
									<li><a href="display/showsa.jsp">辅助用品</a></li>
								</ul></li>
							<li><a href="#">生活</a>
								<ul class="sub" style="margin-left: 230px; top: 3px;">
									<li><a href="display/showdp.jsp">日常用品</a></li>
									<li><a href="display/showele.jsp">家用电器</a></li>
									<li><a href="display/showcos.jsp">化妆品</a></li>
									<li><a href="display/showenter.jsp">娱乐</a></li>
									<li><a href="display/showsp.jsp">特产</a></li>
								</ul></li>
							<li><a href="#">服饰</a>
								<ul class="sub" style="margin-left: 230px; top: 3px;">
									<li><a href="display/showmale.jsp">男装</a></li>
									<li><a href="display/showfemale.jsp">女装</a></li>
									<li><a href="display/showbag.jsp">箱包</a></li>
									<li><a href="display/showdec.jsp">饰品</a></li>
								</ul></li>
							<li><a href="display/showinstrument.jsp">乐器</a></li>
							<li><a href="display/showvirtual.jsp">虚拟</a></li>
							<li><a href="display/showother.jsp">其他</a></li>
						</ul></li>
				</ul>
				</nav>
				<!-- .primary -->
			</div>
			<!-- .grid_12 -->
		</div>
		<!-- .container_12 -->
	</div>
	<!-- .block_nav_primary -->
	<div class="clear"></div>

	<section>
	<div class="container_12">
		<div id="sidebar" class="grid_3">
			<!-- #categories_nav -->
			<aside id="banners"> <a id="ban_next" class="next arows"
				href="#"><span>Next</span></a> <a id="ban_prev" class="prev arows"
				href="#"><span>Prev</span></a>
			<h3>最新推荐</h3>
			<div class="list_carousel">
				<ul id="list_banners">
					<li class="banner"><a href="#">
							<div class="prev">
								<img src="images/ppp.jpg" alt="" title="" style="width:226px; height:150px"/>
							</div> <!-- .prev -->
							<h2>新商品1</h2>
							<p>点击查看详情</p>
					</a></li>
					<li class="banner"><a href="#">
							<div class="prev">
								<img src="images/banner.png" alt="" title="" />
							</div> <!-- .prev -->
							<h2>新商品2</h2>
							<p>点击查看详情</p>
					</a></li>
					<li class="banner"><a href="#">
							<div class="prev">
								<img src="images/banner.png" alt="" title="" />
							</div> <!-- .prev -->
							<h2>新商品3</h2>
							<p>点击查看详情</p>
					</a></li>
					<li class="banner"><a href="#">
							<div class="prev">
								<img src="images/banner.png" alt="" title="" />
							</div> <!-- .prev -->
							<h2>新商品4</h2>
							<p>点击查看详情</p>
					</a></li>
				</ul>
			</div>
			<!-- .list_carousel --> </aside>
			<!-- #categories_nav -->
			<aside id="tags">
			<h3>标签</h3>
			<a class="t1" href="#">Java</a> <a class="t2" href="#">C++</a>
			<a class="t3" href="#">Python</a> <a class="t4" href="#">Lua</a> <a
				class="t5" href="#">Php</a> <a class="t6" href="#">平凡的世界</a>
			<a class="t7" href="#">DIY</a> <a class="t8" href="#">世界是平的</a> <a
				class="t9" href="#">iPhone 6</a> <a class="t10" href="#">Mac Pro</a> <a
				class="t11" href="#">Air</a> <a class="t12" href="#">联想</a> <a
				class="t13" href="#">苹果</a> <a class="t14" href="#">扑克</a> <a
				class="t15" href="#">数据库</a> <a class="t16" href="#">操作系统</a> <a
				class="t17" href="#">？？？</a></aside>
			<!-- #tags -->

		</div>
		<!-- .sidebar -->
		
		<div id="content" class="grid_9">
		
			<article class="post view_post">
			  <h1 class="post_title">这里添加标题！！！</h1><!-- .content_article -->
			</article><!-- .comments_blog -->
			
			<div class="grid_product">
				<div id="content" class="grid_9">
				<h1>这里添加主内容！！！</h1>
					<table class="cart_product">
						<tr>
							<th  width="100" class="edit">我的商品名称</th>
							<th width="100" class="bg price">交换日期</th>
							<th width="100" class="edit"></th>
						</tr>
						<c:if test="${!empty requestScope.lstMsg }">
						<c:forEach items="${requestScope.lstMsg }" var="msg">
							<tr>
								<form method="post" action="/Exchange/TradeServlet">
								<input type="hidden" name="id" value="${msg.id }">
								<input type="hidden" name="type" value="${msg.type }">
								<input type="hidden" name="typeid1" value="${requestScope.typeid1 }">
								<input type="hidden" name="typeid2" value="${requestScope.typeid2 }">
								<input type="hidden" name="uid" value="${requestScope.uid }">
								<td width="100" class="edit">${msg.name }</td>
								<td width="100" class="bg price">${msg.posttime }</td>
								<td width="100" class="edit" style="align:center;"><input type="submit" value="用这个交换"></td>
								</form>
							</tr>
						</c:forEach>
						</c:if>
					</table>
					
				</div>
			</div>
		
		</div>
		
		
	</div>
	</section>
	
	<div class="clear"></div>
	
	<footer>
	<div class="f_navigation">
		<div class="container_12">
			<div class="grid_3">
				<h3>联系我们</h3>
				<ul class="f_contact">
					<li></li>
					<li></li>
					<li></li>
				</ul>
				<!-- .f_contact -->
			</div>
			<!-- .grid_3 -->

			<div class="grid_3">
				<h3>相关信息</h3>
				<nav class="f_menu">
				<ul>

					<li><a href="#">关于我们</a></li>
					<li><a href="#">隐私政策</a></li>
					<li><a href="#">相关条款</a></li>
					<li></li>
				</ul>
				</nav>
				<!-- .private -->
			</div>
			<!-- .grid_3 -->

			<div class="grid_3">
				<h3>客户服务</h3>
				<nav class="f_menu">
				<ul>
					<li><a href="contact_us.html">联系我们</a></li>
					<li><a href="#">返回首页</a></li>
					<li><a href="#">帮助文档</a></li>
					<li><a href="#">站点地图</a></li>
				</ul>
				</nav>
				<!-- .private -->
			</div>
			<!-- .grid_3 -->

			<div class="grid_3">
				<h3>我的账户</h3>
				<nav class="f_menu">
				<ul>
					<li><a href="#">我的物品</a></li>
					<li><a href="#">我的订单</a></li>
					<li><a href="#">我想换的</a></li>
					<li><a href="#">最新消息</a></li>
				</ul>
				</nav>
				<!-- .private -->
			</div>
			<!-- .grid_3 -->

			<div class="clear"></div>
		</div>
		<!-- .container_12 -->
	</div>
	<!-- .f_navigation -->

	<div class="f_info">
		<div class="container_12">
			<div class="grid_6">
				<p class="copyright">&nbsp;</p>
			</div>
			<!-- .grid_6 -->

			<!-- .grid_6 -->

			<div class="grid_6">
				<a href="#"><img src="images/renren2.png" width="35" height="21"
					align="right"></a> <a href="#"><img src="images/friend2.png"
					width="30" height="30" align="right"></a> <a href="#"><img
					src="images/tecent2.png" width="30" height="30" align="right"></a>
				<a href="#"><img src="images/weibo2.png" width="30" height="30"
					align="right"></a> <a href="#"><img src="images/wechat2.png"
					width="30" height="30" align="right"></a> <a href="#"><img
					src="images/QQzone2.png" width="30" height="30" align="right"></a>
				<a href="#"><img src="images/QQ2.png" width="30" height="30"
					align="right"></a>
			</div>
			<!-- .grid_6 -->

			<div class="clear"></div>
		</div>
		<!-- .container_12 -->
	</div>
	<!-- .f_info --> </footer>

</body>
</html>