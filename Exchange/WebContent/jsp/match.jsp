<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>匹配商品</title>

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
	display: none;
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

		<div id="content" class="grid_9">

			<article class="post view_post">
			<h1 class="post_title">匹配到的商品！！！</h1>
			<!-- .content_article --> </article>
			<!-- .comments_blog -->

			<div class="grid_product">

				<%
				int i = -1;
				request.setAttribute("i", i);
			%>

				<c:forEach items="${requestScope.lstItems }" var="lst">
					<%
					i += 1;
					request.setAttribute("i", i);
				%>
					<c:if test="${types[i]=='textbooks'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=textbooks&typeid2=${items.tbid }"><img src="${items.tbresource }"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.tbname}&nbsp;${items.tbversion }</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">&nbsp;${items.tbpublish }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>

					<c:if test="${types[i]=='extrabooks'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=extrabooks&typeid2=${items.ebid }"><img src="${items.ebresource }"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.ebname}&nbsp;${items.ebauthor }</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.ebpublish }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='audios'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=audios&typeid2=${items.audioid }"><img
										src="${items.audioresource }" alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.audioname}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.audiopublish }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>

					</c:if>


					<c:if test="${types[i]=='bags'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=bags&typeid2=${items.bagid }"><img
										src="${items.bagresource }" alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.bagbrand }</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.bagtype}</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='cosmetics'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=cosmetics&typeid2=${items.cosid }"><img
										src="${items.cosresource }" alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.cosname}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.cosbrand }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='dailypros'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=dailypros&typeid2=${items.dpid }"><img src="${items.dpresource }"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.dpname}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.dptype }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='decorations'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=decorations&typeid2=${items.decid }"><img
										src="${items.decresource }" alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.decname}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.dectype }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='digits'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=digits&typeid2=${items.digitid }"><img
										src="${items.digitresource }" alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.digitbrand }</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.digitmodel }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='electrics'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=electrics&typeid2=${good.eleid }"><img
										src="${items.eleresource }" alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.elename}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.eletype }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='entertainments'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=entertainments&typeid2=${items.enterid }"><img
										src="${items.enterresource }" alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.entername}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.entertype }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='females'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=females&typeid2=${items.femaleid }"><img
										src="${items.femaleresource}" alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.femaletype}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.femalesize }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='instruments'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=instruments&typeid2=${items.instrumentid }"><img
										src="${items.instrumentresource }" alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.instrumentname}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.instrumentbrand }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='males'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=males&typeid2=${items.maleid }"><img
										src="${items.maleresource }" alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.maletype}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.malesize }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='others'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=others&typeid2=${items.otherid }"><img
										src="${items.otherresource }" alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.othersname}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.othertype }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='pc'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=pc&typeid2=${items.pcid }"><img src="${items.pcresource }"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.pcbrand}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.pcmodel }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='phones'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=phones&typeid2=${items.phoneid }"><img
										src="${items.phoneresource }" alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.phonebrand}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.phonemodel }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='sppros'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=sppros&typeid2=${items.spid }"><img src="${items.spresource }"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.spname}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.sptype }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='sptasts'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=sptasts&typeid2=${items.said }"><img src="${items.saresource }"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.saname}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.satype }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='spteqpts'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=spteqpts&typeid2=${items.seid }"><img src="${items.seresource }"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.sename}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.setype }</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>


					<c:if test="${types[i]=='virtuals'}">
						<c:forEach items="${lst }" var="items">
							<div class="grid_3 product">
								<div class="prev" style="background-image:url('jsp/images/none2.png')">
									<a href="/Exchange/DetailServlet?typeid1=virtuals&typeid2=${items.virtualid }"><img
										src="${items.virtualresource }" alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">${items.virtualname}</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">${items.posttime}</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</c:forEach>
					</c:if>

				</c:forEach>
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