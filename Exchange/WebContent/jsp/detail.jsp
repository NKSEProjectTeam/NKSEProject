<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>物品详情</title>

<link rel="shortcut icon" href="jsp/images/icon.png">
<link href="jsp/css/postcss/style.css" media="screen" rel="stylesheet"
	type="text/css">
<link href="jsp/css/postcss/grid.css" media="screen" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="css/jquery.jqzoom.css" type="text/css">

<script src="jsp/js/postjs/jquery-1.7.2.min.js"></script>
<script src="jsp/js/postjs/html5.js"></script>
<script src="jsp/js/postjs/jflow.plus.js"></script>
<script src="jsp/js/postjs/jquery.carouFredSel-5.2.2-packed.js"></script>
<script src="jsp/js/postjs/checkbox.js"></script>
<script src="jsp/js/postjs/radio.js"></script>
<script src="jsp/js/postjs/selectBox.js"></script>
<script src="jsp/js/postjs/jquery.jqzoom-core.js"></script>

<script>
	$(document).ready(function() {
		// 		$('.jqzoom').jqzoom({
		// 			//zoomType : 'standard',
		// 			//lens : true,
		// 			//preloadImages : true,
		// 			//alwaysOn : false
		// 		});
	});
</script>

<script type="text/javascript">
	function cfmLogout() {
		if (confirm("您确认要退出？")) {
			window.location = "/Exchange/LogoutServlet";
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
		$('#wrapper_tab a').click(function() {
			if ($(this).attr('class') != $('#wrapper_tab').attr('class')) {
				$('#wrapper_tab').attr('class', $(this).attr('class'));
			}
			return false;
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
		$('#list_banners').carouFredSel({
			prev : '#ban_prev',
			next : '#ban_next',
			scroll : 1,
			auto : false
		});
		$('#thumblist').carouFredSel({
			prev : '#img_prev',
			next : '#img_next',
			scroll : 1,
			auto : false,
			circular : false,
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

</head>
<body>

	<div class="container_12">
		<!-- #top -->
		<header id="branding">
		<div class="grid_3">
			<hgroup>
			<h1 id="site_logo">
				<a href="#" title="jsp/scsbingo.jsp"><img src="jsp/images/bingo logo.png"
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
				<li><a href="javascript:" class="cart_li STYLE1"
					onclick="cfmLogout()">退出登录</a></li>
			</ul>

			<nav class="private">
			<ul>
				<li><a href="jsp/showOrders.jsp">我的订单</a></li>
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

	<section id="main">
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
								<img src="images/ppp.jpg" alt="" title=""
									style="width: 226px; height: 150px" />
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
		
		<c:if test="${!empty requestScope.tb}">
		<div>
		<!-- 教科书 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.tb.tbresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.tb.tbname }</p>
						<p>${requestScope.tb.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>教科书</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=textbooks&typeid2=${requestScope.tb.tbid }&uid=${requestScope.tb.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.tb.tbname }</li>
								<li>作者：${requestScope.tb.tbauthor }</li>
								<li>出版社：${requestScope.tb.tbpublish }</li>
								<li>版本：${requestScope.tb.tbversion }</li>
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.tb.tbmark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.eb}">
		<div>
		<!-- 课外书 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.eb.ebresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.eb.ebname }</p>
						<p>${requestScope.eb.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>课外书</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=extrabooks&typeid2=${requestScope.eb.ebid }&uid=${requestScope.eb.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.eb.ebname }</li>
								<li>作者：${requestScope.eb.ebauthor }</li>
								<li>出版社：${requestScope.eb.ebpublish }</li>
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.eb.ebmark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.audio}">
		<div>
		<!-- 音像 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.audio.audioresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.audio.audioname }</p>
						<p>${requestScope.audio.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>音像</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=audios&typeid2=${requestScope.audio.audioid }&uid=${requestScope.audio.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.audio.audioname }</li>
								<li>出版社：${requestScope.audio.audiopublish }</li>
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.audio.audiomark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		<c:if test="${!empty requestScope.bag}">
		<div>
		<!-- 箱包 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.bag.bagresource }" title="" alt="" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.bag.bagbrand }</p>
						<p>${requestScope.bag.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>箱包</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=bags&typeid2=${requestScope.bag.bagid }&uid=${requestScope.bag.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>品牌：${requestScope.bag.bagbrand }</li>
								<li>类型：${requestScope.bag.bagtype }</li>
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.bag.bagmark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.cos}">
		<div>
		<!-- 化妆品 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.cos.cosresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.cos.cosname }</p>
						<p>${requestScope.cos.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>化妆品</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=cosmetics&typeid2=${requestScope.cos.cosid }&uid=${requestScope.cos.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>品牌：${requestScope.cos.cosname }</li>
								<li>类型：${requestScope.cos.cosbrand }</li>
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.cos.cosmark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.dp}">
		<div>
		<!-- 日常用品 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.dp.dpresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.dp.dpname }</p>
						<p>${requestScope.dp.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>日常用品</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=dailypros&typeid2=${requestScope.dp.dpid }&uid=${requestScope.dp.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.dp.dpname }</li>
								<li>类型：${requestScope.dp.dptype }</li>
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.dp.dpmark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.dec}">
		<div>
		<!-- 饰品 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.dec.decresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.dec.decname }</p>
						<p>${requestScope.dec.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>饰品</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=decorations&typeid2=${requestScope.dec.decid }&uid=${requestScope.dec.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.dec.decname }</li>
								<li>类型：${requestScope.dec.dectype }</li>
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.dec.decmark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.digit}">
		<div>
		<!-- 数码 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.digit.digitresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.digit.digitmodel }</p>
						<p>${requestScope.digit.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>数码</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=digits&typeid2=${requestScope.digit.digitid }&uid=${requestScope.digit.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.digit.digitbrand }</li>
								<li>类型：${requestScope.digit.digittype }</li>
								<li>型号：${requestScope.digit.digitmodel }</li>
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.digit.digitmark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.ele}">
		<div>
		<!-- 电器 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.ele.eleresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.ele.elename }</p>
						<p>${requestScope.ele.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>电器</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=electrics&typeid2=${requestScope.ele.eleid }&uid=${requestScope.ele.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.ele.elename }</li>
								<li>类型：${requestScope.ele.eletype }</li>
								
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.ele.elemark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.enter}">
		<div>
		<!-- 娱乐 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.enter.enterresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.enter.entername }</p>
						<p>${requestScope.enter.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>电器</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=entertainment&typeid2=${requestScope.enter.enterid }&uid=${requestScope.enter.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.enter.entername }</li>
								<li>类型：${requestScope.enter.entertype }</li>
								
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.enter.entermark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.female}">
		<div>
		<!-- 女装 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.female.femaleresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.female.femaletype }</p>
						<p>${requestScope.female.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>电器</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=females&typeid2=${requestScope.female.femaleid }&uid=${requestScope.female.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.female.femaletype }</li>
								<li>尺寸：${requestScope.female.femalesize }</li>
								
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.female.femalemark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		<c:if test="${!empty requestScope.ins}">
		<div>
		<!-- 乐器 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.ins.instrumentresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.ins.instrumentname }</p>
						<p>${requestScope.ins.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>电器</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=instruments&typeid2=${requestScope.ins.instrumentid }&uid=${requestScope.ins.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.ins.instrumentname }</li>
								<li>尺寸：${requestScope.ins.instrumentbrand }</li>
								
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.ins.instrumentmark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.male}">
		<div>
		<!-- 男装 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.male.maleresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.male.maletype }</p>
						<p>${requestScope.male.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>电器</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=males&typeid2=${requestScope.male.maleid }&uid=${requestScope.male.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.male.maletype }</li>
								<li>尺寸：${requestScope.male.malesize }</li>
								
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.male.malemark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.other}">
		<div>
		<!-- 其他 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.other.otherresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.other.othername }</p>
						<p>${requestScope.other.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>其他</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=others&typeid2=${requestScope.other.otherid }&uid=${requestScope.other.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.other.othername }</li>
								<li>类型：${requestScope.other.othertype }</li>
								
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.other.othermark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.pc}">
		<div>
		<!-- 电脑 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.pc.pcresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.pc.pcmodel }</p>
						<p>${requestScope.pc.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>电脑</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=pc&typeid2=${requestScope.pc.pcid }&uid=${requestScope.pc.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.pc.pcbrand }</li>
								<li>类型：${requestScope.pc.pcmodel }</li>
								<li>类型：${requestScope.pc.pctype }</li>
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.pc.pcmark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.phone}">
		<div>
		<!-- 手机 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.phone.phoneresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.phone.phonemodel }</p>
						<p>${requestScope.phone.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>手机</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=phones&typeid2=${requestScope.phone.phoneid }&uid=${requestScope.phone.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.phone.phonebrand }</li>
								<li>类型：${requestScope.phone.phonemodel }</li>
								<li>类型：${requestScope.phone.phonetype }</li>
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.phone.phonemark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.sp}">
		<div>
		<!-- 特产 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.sp.spresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.sp.spname }</p>
						<p>${requestScope.sp.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>特产</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=sppros&typeid2=${requestScope.sp.spid }&uid=${requestScope.sp.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.sp.spname }</li>
								<li>类型：${requestScope.sp.splocation }</li>
								<li>类型：${requestScope.sp.sptype }</li>
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.sp.spmark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		<c:if test="${!empty requestScope.sa}">
		<div>
		<!-- 体育辅助 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.sa.saresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.sa.saname }</p>
						<p>${requestScope.sa.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>特产</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=sptasts&typeid2=${requestScope.sa.said }&uid=${requestScope.sa.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.sa.saname }</li>
								<li>类型：${requestScope.sa.satype }</li>
								
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.sa.samark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.se}">
		<div>
		<!-- 体育 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.se.seresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.se.sename }</p>
						<p>${requestScope.se.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>体育用具</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=spteqpts&typeid2=${requestScope.se.seid }&uid=${requestScope.se.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.se.sename }</li>
								<li>类型：${requestScope.se.setype }</li>
								
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.se.semark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>
		
		
		<c:if test="${!empty requestScope.virtual}">
		<div>
		<!-- 虚拟 -->
		<div id="content" class="grid_9">
			<h1 class="page_title">商品详情</h1>

			<div class="product_page">
				<div class="grid_4 img_slid" id="products">
					<div class="preview slides_container">
						<div class="prev_bg" style="background-image:url('jsp/images/none1.png')">
							<a href="images/produkt_slid.png" class="jqzoom" rel='gal1'
								title=""> <img src="upload/goodsimg/${requestScope.virtual.virtualresource }" title="" alt=""
								style="width: 294px; height: 294px" />
							</a>
						</div>
					</div>
					<!-- .prev -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_5">
					<div class="entry_content">

						<p>${requestScope.virtual.virtualname }</p>
						<p>${requestScope.virtual.posttime }</p>
						<div class="ava_price">
							<div class="availability_sku">
								<div class="availability">
									分类: <span>虚拟产品</span>
								</div>
								<div class="sku">
									状态: <span>交换</span>
								</div>
							</div>
							<!-- .availability_sku -->
						</div>
						<!-- .ava_price -->

						<div class="block_cart">

							<div class="cart">
								<a href="/Exchange/DoExcServlet?typeid1=virtuals&typeid2=${requestScope.virtual.virtualid }&uid=${requestScope.virtual.uid }" class="bay">交换</a>
							</div>
							<div class="clear"></div>
						</div>
						<!-- .block_cart -->

					</div>
					<!-- .entry_content -->

				</div>
				<!-- .grid_5 -->

				<div class="clear"></div>

				<div class="grid_9">
					<div id="wrapper_tab" class="tab1">
						<a href="#" class="tab1 tab_link">详细信息</a> <a href="#"
							class="tab2 tab_link">物品描述</a>

						<div class="clear"></div>

						<div class="tab1 tab_body">
							<h4>详细信息</h4>
							<ul>
								<li>名称：${requestScope.virtual.virtualname }</li>
								
								
							</ul>

							<div class="clear"></div>
						</div>
						<!-- .tab1 .tab_body -->

						<div class="tab2 tab_body">
							<h4>物品描述</h4>

							<p>${requestScope.virtual.virtualmark }</p>
							<p>${requestScope.user.username }&nbsp;${requestScope.user.usernum }</p>

							<!-- .comments -->

							<!-- .add_comments -->
							<div class="clear"></div>
						</div>
						<!-- .tab2 .tab_body -->

						<div class="clear"></div>
					</div>
					​
					<!-- #wrapper_tab -->
					<div class="clear"></div>
				</div>
				<!-- .grid_9 -->

				<div class="clear"></div>


			</div>
			<!-- .product_page -->
			<div class="clear"></div>

		</div>
		<!-- #content -->
		<div class="clear"></div>
		</div>
		</c:if>

	</div>
	<!-- .container_12 --> </section>
	<!-- #main -->

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