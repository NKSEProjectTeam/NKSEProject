<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
<!--
body {
	margin-right: 0px;
}
-->
</style>

<title>用户订单</title>

<link rel="shortcut icon" href="jsp/images/icon.png">
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
	$(document).ready(function(){
		$("#myController").jFlow({
			controller: ".control", // must be class, use . sign
			slideWrapper : "#jFlowSlider", // must be id, use # sign
			slides: "#slider",  // the div where all your sliding divs are nested in
			selectedWrapper: "jFlowSelected",  // just pure text, no sign
			width: "984px",  // this is the width for the content-slider
			height: "480px",  // this is the height for the content-slider
			duration: 400,  // time in miliseconds to transition one slide
			prev: ".slidprev", // must be class, use . sign
			next: ".slidnext", // must be class, use . sign
			auto: true
		});
	});
  </script>
<script>
	$(function() {
	  $('#list_product').carouFredSel({
		prev: '#prev_c1',
		next: '#next_c1',
		auto: false
	  });
          $('#list_product2').carouFredSel({
		prev: '#prev_c2',
		next: '#next_c2',
		auto: false
	  });
	  $('#list_banners').carouFredSel({
		prev: '#ban_prev',
		next: '#ban_next',
		scroll: 1,
		auto: false
	  });
	  $(window).resize();
	});
  </script>
<script>
       $(document).ready(function(){
	      $("button").click(function(){
		     $(this).addClass('click')
	      });
       })
  </script>

</head>
<body>

<c:if test="${empty requestScope.msg}">
	<script type="text/javascript">window.location="/Exchange/OrderServlet";</script>
</c:if>
	
	<div class="container_12">
		<!-- #top -->
		<header id="branding">
		<div class="grid_3">
			<hgroup>
			<h1 id="site_logo">
				<a href="jsp/scsbingo.jsp" title=""><img src="jsp/images/bingo logo.png"
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
				<li><a href="#">我的订单</a></li>
				<li class="separator">|</li>
				<li><a href="jsp/post.jsp">发布帖子</a></li>
				<li class="separator">|</li>
				<li><a href="jsp/myMsg.jsp">我的消息(${sessionScope.woLen })</a></li>
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
					<li class="curent"><a href="jsp/scsbingo.jsp">返回主页</a></li>
					<li><a href="#">商品分类</a>
						<ul class="sub">
							<li><a href="#">图书</a>
								<ul class="sub" style="margin-left: 230px; top: 3px;">
									<li><a href="jsp/display/showtb.jsp">教科书</a></li>
									<li><a href="jsp/display/showeb.jsp">课外书</a></li>
									<li><a href="jsp/display/showaudio.jsp">音像</a></li>
								</ul></li>
							<li><a href="#">电子</a>
								<ul class="sub" style="margin-left: 230px; top: 3px;">
									<li><a href="jsp/display/showphone.jsp">手机类</a></li>
									<li><a href="jsp/display/showpc.jsp">电脑类</a></li>
									<li><a href="jsp/display/showdigit.jsp">数码类</a></li>
								</ul></li>
							<li><a href="#">体育</a>
								<ul class="sub" style="margin-left: 230px; top: 3px;">
									<li><a href="jsp/display/showse.jsp">体育器械</a></li>
									<li><a href="jsp/display/showsa.jsp">辅助用品</a></li>
								</ul></li>
							<li><a href="#">生活</a>
								<ul class="sub" style="margin-left: 230px; top: 3px;">
									<li><a href="jsp/display/showdp.jsp">日常用品</a></li>
									<li><a href="jsp/display/showele.jsp">家用电器</a></li>
									<li><a href="jsp/display/showcos.jsp">化妆品</a></li>
									<li><a href="jsp/display/showenter.jsp">娱乐</a></li>
									<li><a href="jsp/display/showsp.jsp">特产</a></li>
								</ul></li>
							<li><a href="#">服饰</a>
								<ul class="sub" style="margin-left: 230px; top: 3px;">
									<li><a href="jsp/display/showmale.jsp">男装</a></li>
									<li><a href="jsp/display/showfemale.jsp">女装</a></li>
									<li><a href="jsp/display/showbag.jsp">箱包</a></li>
									<li><a href="jsp/display/showdec.jsp">饰品</a></li>
								</ul></li>
							<li><a href="jsp/display/showinstrument.jsp">乐器</a></li>
							<li><a href="jsp/display/showvirtual.jsp">虚拟</a></li>
							<li><a href="jsp/display/showother.jsp">其他</a></li>
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
	
	<section id="main" class="entire_width">
    <div class="container_12">
       <div class="grid_12">
       <h1 class="page_title">我的订单--物物交换</h1>

       <table class="cart_product">
	      <tr>
		     <th width="150" class="images">我的商品图片</th>
		     <th width="200" class="bg name">我的商品名称</th>
		     <th width="122" class="edit">交换方</th>
		     <th width="200" class="bg price">交换商品名称</th>
		     <th width="100" class="qty">交换日期</th>
	      </tr>
	      <c:forEach items="${requestScope.lstTradeOrders }" var="torder">
	      <tr>
		     <td width="150" class="images">${torder.traresource }</td>
		     <td width="200" class="bg name">${torder.proname1 }</td>
		     <td class="edit">${torder.username2 }</td>
		     <td width="200" class="bg price">${torder.proname2 }</td>
		     <td class="qty">${torder.tradetime }</td>
	      </tr>
	      </c:forEach>
	      <tr>
		     <td colspan="5" class="cart_but">
			    <button class="update"><a href="#"><span>icon</span>刷新 我的订单</a></button>
		     </td>
	      </tr>
       </table>
       </div><!-- .grid_12 -->

       <div id="content_bottom"><!-- .grid_4 --><!-- .grid_4 --><!-- .grid_4 -->
        <div class="grid_12">
          <h1 class="page_title">我的订单--短期出租</h1>
          <table class="cart_product">
            <tr>
              <th width="150" class="images">出租商品图片</th>
              <th width="200" class="bg name">出租商品名称</th>
              <th width="122" class="edit">类型</th>
              <th width="200" class="bg price">交易方</th>
              <th width="100" class="qty">出租日期</th>
            </tr>
            <c:forEach items="${requestScope.lstHireOrders }" var="horder">
            	<tr>
	              <td width="150" class="images">${horder.hireresource }</td>
	              <td width="200" class="bg name">${horder.name }</td>
	              <td class="edit">出租</td>
	              <td width="200" class="bg price">${horder.username2 }</td>
	              <td class="qty">${horder.hiretime }</td>
	            </tr>
            </c:forEach>
            <tr>
              <td colspan="5" class="cart_but">
                <button class="update"><a href="#"><span>icon</span>刷新 我的订单</a></button></td>
            </tr>
          </table>
        </div>
       </div><!-- #content_bottom -->
      <div class="clear"></div>

      <div class="clear"></div>

    </div><!-- .container_12 -->
  </section><!-- #main -->

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