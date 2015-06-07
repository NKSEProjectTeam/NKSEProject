<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
<!--
.STYLE1 {
	font-size: 18px
}
-->
</style>

<title>最新</title>

<link rel="shortcut icon" href="jsp/images/icon.png">
<link href="jsp/css/postcss/style.css" media="screen" rel="stylesheet"
	type="text/css">
<link href="jsp/css/postcss/grid.css" media="screen" rel="stylesheet"
	type="text/css">

<script src="jsp/js/postjs/jquery-1.7.2.min.js"></script>
<script src="jsp/js/postjs/html5.js"></script>
<script src="jsp/js/postjs/jflow.plus.js"></script>
<script src="jsp/js/postjs/jquery.carouFredSel-5.2.2-packed.js"></script>

<script type="text/javascript">
	function cfmLogout() {
		if (confirm("您确认要退出？")) {
			window.location = "/Exchange/LogoutServlet";
		}
	}
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
		$('#list_product3').carouFredSel({
			prev : '#prev_c3',
			next : '#next_c3',
			auto : false
		});
		$('#list_product4').carouFredSel({
			prev : '#prev_c4',
			next : '#next_c4',
			auto : false
		});
		$('#list_product5').carouFredSel({
			prev : '#prev_c5',
			next : '#next_c5',
			auto : false
		});
		$('#list_product6').carouFredSel({
			prev : '#prev_c6',
			next : '#next_c6',
			auto : false
		});
		$('#list_product7').carouFredSel({
			prev : '#prev_c7',
			next : '#next_c7',
			auto : false
		});
		$('#list_product8').carouFredSel({
			prev : '#prev_c8',
			next : '#next_c8',
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

</head>
<body>

	<c:if test="${empty requestScope.lstGoods }">
		<script type="text/javascript">
			window.location = "/Exchange/NewServlet";
		</script>
	</c:if>

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

	<div class="container_12">
		<div class="grid_12">
			<div class="slidprev">
				<span>Prev</span>
			</div>
			<div class="slidnext">
				<span>Next</span>
			</div>
			<div id="slider">
				<div id="slide1">
					<img src="jsp/images/ppp.jpg" alt="" title="" />
					<div class="slid_text">
						<h3 class="slid_title">
							<span>1</span>
						</h3>
						<p>
							<span>这里是</span>
						</p>
						<p>
							<span>展示商品</span>
						</p>
						<p>
							<span>1</span>
						</p>
					</div>
				</div>

				<div id="slide2">
					<img src="jsp/images/ppp.jpg" alt="" title="" />
					<div class="slid_text">
						<h3 class="slid_title">
							<span>2</span>
						</h3>
						<p>
							<span>这里是</span>
						</p>
						<p>
							<span>展示2</span>
						</p>
					</div>
				</div>

				<div id="slide3">
					<img src="jsp/images/ppp.jpg" alt="" title="" />
					<div class="slid_text">
						<h3 class="slid_title">
							<span>3</span>
						</h3>
						<p>
							<span>这里是</span>
						</p>
						<p>
							<span>展示3</span>
						</p>
					</div>
				</div>
			</div>
			<!-- .slider -->
			<div id="myController">
				<div class="control">
					<span>1</span>
				</div>
				<div class="control">
					<span>2</span>
				</div>
				<div class="control">
					<span>3</span>
				</div>
			</div>


		</div>
		<!-- .grid_12 -->
	</div>
	<!-- .container_12 -->

	<section id="main" class="home">
	<div class="container_12">
		<div id="top_button">
			<div class="grid_4">
				<!-- .物物交换 -->
				<a href="jsp/exchangepros.jsp" class="button_block"
					onMouseOut="this.className='button_block'"
					onMouseOver="this.className='button_block1'"><img
					src="jsp/images/exchange.png" alt="物物交换" width="280" height="125" /></a>
			</div>
			<!-- .grid_4 -->
			<div class="grid_4">
				<div class="grid_4">
					<!-- .短期出租 -->
					<a href="jsp/hirepros.jsp" class="button_block"
						onMouseOut="this.className='button_block'"
						onMouseOver="this.className='button_block1'"><img
						src="jsp/images/hire.png" alt="短期出租" width="280" height="125" /></a>
				</div>
				<!-- .求助专区 -->
			</div>
			<!-- .grid_4 -->
			<div class="grid_4">
				<a href="jsp/helppros.jsp" class="button_block"
					onMouseOut="this.className='button_block'"
					onMouseOver="this.className='button_block1'"> <img
					src="jsp/images/help.png" alt="求助专区" width="280" height="125" /></a>

			</div>
			<!-- .grid_4 -->
			<div class="clear"></div>
		</div>
		<!-- #top_button -->
		<div class="clear"></div>


		<%
			int i = -1;
			request.setAttribute("i", i);
		%>

		<c:forEach items="${requestScope.lstGoods }" var="lst">
			<%
				i += 1;
				request.setAttribute("i", i);
			%>

			<c:if test="${types[i]=='textbooks'}">
				<div class="carousel">
					<div class="c_header">
						<div class="grid_10">
							<h2>教科书</h2>
						</div>
						<!-- .grid_10 -->
						<div class="grid_2">
							<a id="next_c1" class="next arows" href="#"><span>Next</span></a>
							<a id="prev_c1" class="prev arows" href="#"><span>Prev</span></a>
						</div>
						<!-- .grid_2 -->
					</div>
					<!-- .c_header -->
					<div class="list_carousel">
						<ul id="list_product" class="list_product">
							<c:forEach items="${lst }" var="good">
								<li class="">
									<div class="grid_3 product">
										<div class="prev" style="background-image:url('jsp/images/none2.png')">
											<a href="/Exchange/DetailServlet?typeid1=textbooks&typeid2=${good.tbid }"><img
												src="${good.tbresource }" alt="" title="" /></a>
										</div>
										<!-- .prev -->
										<h3 class="title">${good.tbname }</h3>
										<div class="cart">
											<div class="price">
												<div class="vert">
													<div class="price_new">${good.tbauthor }&nbsp${good.tbpublish
														}</div>
												</div>
											</div>
											<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
												href="#" class="bay"></a>
										</div>
										<!-- .cart -->
									</div> <!-- .grid_3 -->
								</li>
							</c:forEach>

						</ul>
						<!-- #list_product -->
					</div>
					<!-- .list_carousel -->
				</div>
				<!-- .carousel -->
			</c:if>

			<c:if test="${types[i]=='extrabooks'}">
				<div class="carousel">
					<div class="c_header">
						<div class="grid_10">
							<h2>课外书</h2>
						</div>
						<!-- .grid_10 -->
						<div class="grid_2">
							<a id="next_c${i+1 }" class="next arows" href="#"><span>Next</span></a>
							<a id="prev_c${i+1 }" class="prev arows" href="#"><span>Prev</span></a>
						</div>
						<!-- .grid_2 -->
					</div>
					<!-- .c_header -->
					<div class="list_carousel">
						<ul id="list_product${i+1 }" class="list_product">
							<c:forEach items="${lst }" var="good">
								<li class="">
									<div class="grid_3 product">
										<div class="prev" style="background-image:url('jsp/images/none2.png')">
											<a href="/Exchange/DetailServlet?typeid1=extrabooks&typeid2=${good.ebid }"><img
												src="${good.ebresource }" alt="" title="" /></a>
										</div>
										<!-- .prev -->
										<h3 class="title">${good.ebname }</h3>
										<div class="cart">
											<div class="price">
												<div class="vert">
													<div class="price_new">${good.ebauthor }&nbsp${good.ebpublish
														}</div>
												</div>
											</div>
											<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
												href="#" class="bay"></a>
										</div>
										<!-- .cart -->
									</div> <!-- .grid_3 -->
								</li>
							</c:forEach>

						</ul>
						<!-- #list_product -->
					</div>
					<!-- .list_carousel -->
				</div>
				<!-- .carousel -->
			</c:if>

			<c:if test="${types[i]=='bags'}">
				<div class="carousel">
					<div class="c_header">
						<div class="grid_10">
							<h2>箱包</h2>
						</div>
						<!-- .grid_10 -->
						<div class="grid_2">
							<a id="next_c${i+1 }" class="next arows" href="#"><span>Next</span></a>
							<a id="prev_c${i+1 }" class="prev arows" href="#"><span>Prev</span></a>
						</div>
						<!-- .grid_2 -->
					</div>
					<!-- .c_header -->
					<div class="list_carousel">
						<ul id="list_product${i+1 }" class="list_product">
							<c:forEach items="${lst }" var="good">
								<li class="">
									<div class="grid_3 product">
										<div class="prev" style="background-image:url('jsp/images/none2.png')">
											<a href="/Exchange/DetailServlet?typeid1=bags&typeid2=${good.bagid }"><img
												src="${good.bagresource }" alt="" title="" /></a>
										</div>
										<!-- .prev -->
										<h3 class="title">${good.bagtype }</h3>
										<div class="cart">
											<div class="price">
												<div class="vert">
													<div class="price_new">${good.bagbrand }</div>
												</div>
											</div>
											<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
												href="#" class="bay"></a>
										</div>
										<!-- .cart -->
									</div> <!-- .grid_3 -->
								</li>
							</c:forEach>

						</ul>
						<!-- #list_product -->
					</div>
					<!-- .list_carousel -->
				</div>
				<!-- .carousel -->
			</c:if>

			<c:if test="${types[i]=='cosmitics'}">
				<div class="carousel">
					<div class="c_header">
						<div class="grid_10">
							<h2>化妆品</h2>
						</div>
						<!-- .grid_10 -->
						<div class="grid_2">
							<a id="next_c${i+1 }" class="next arows" href="#"><span>Next</span></a>
							<a id="prev_c${i+1 }" class="prev arows" href="#"><span>Prev</span></a>
						</div>
						<!-- .grid_2 -->
					</div>
					<!-- .c_header -->
					<div class="list_carousel">
						<ul id="list_product${i+1 }" class="list_product">
							<c:forEach items="${lst }" var="good">
								<li class="">
									<div class="grid_3 product">
										<div class="prev" style="background-image:url('jsp/images/none2.png')">
											<a href="/Exchange/DetailServlet?typeid1=cosmitics&typeid2=${good.cosid }"><img
												src="${good.cosresource }" alt="" title="" /></a>
										</div>
										<!-- .prev -->
										<h3 class="title">${good.cosname }</h3>
										<div class="cart">
											<div class="price">
												<div class="vert">
													<div class="price_new">${good.cosbrand }&nbsp;${good.costype }</div>
												</div>
											</div>
											<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
												href="#" class="bay"></a>
										</div>
										<!-- .cart -->
									</div> <!-- .grid_3 -->
								</li>
							</c:forEach>

						</ul>
						<!-- #list_product -->
					</div>
					<!-- .list_carousel -->
				</div>
				<!-- .carousel -->
			</c:if>

			<c:if test="${types[i]=='dailypros'}">
				<div class="carousel">
					<div class="c_header">
						<div class="grid_10">
							<h2>日常用品</h2>
						</div>
						<!-- .grid_10 -->
						<div class="grid_2">
							<a id="next_c${i+1 }" class="next arows" href="#"><span>Next</span></a>
							<a id="prev_c${i+1 }" class="prev arows" href="#"><span>Prev</span></a>
						</div>
						<!-- .grid_2 -->
					</div>
					<!-- .c_header -->
					<div class="list_carousel">
						<ul id="list_product${i+1 }" class="list_product">
							<c:forEach items="${lst }" var="good">
								<li class="">
									<div class="grid_3 product">
										<div class="prev" style="background-image:url('jsp/images/none2.png')">
											<a href="/Exchange/DetailServlet?typeid1=dailypros&typeid2=${good.dpid }"><img
												src="${good.dpresource }" alt="" title="" /></a>
										</div>
										<!-- .prev -->
										<h3 class="title">${good.dpname }</h3>
										<div class="cart">
											<div class="price">
												<div class="vert">
													<div class="price_new">${good.dptype }</div>
												</div>
											</div>
											<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
												href="#" class="bay"></a>
										</div>
										<!-- .cart -->
									</div> <!-- .grid_3 -->
								</li>
							</c:forEach>

						</ul>
						<!-- #list_product -->
					</div>
					<!-- .list_carousel -->
				</div>
				<!-- .carousel -->
			</c:if>

			<c:if test="${types[i]=='electrics'}">
				<div class="carousel">
					<div class="c_header">
						<div class="grid_10">
							<h2>电器</h2>
						</div>
						<!-- .grid_10 -->
						<div class="grid_2">
							<a id="next_c${i+1 }" class="next arows" href="#"><span>Next</span></a>
							<a id="prev_c${i+1 }" class="prev arows" href="#"><span>Prev</span></a>
						</div>
						<!-- .grid_2 -->
					</div>
					<!-- .c_header -->
					<div class="list_carousel">
						<ul id="list_product${i+1 }" class="list_product">
							<c:forEach items="${lst }" var="good">
								<li class="">
									<div class="grid_3 product">
										<div class="prev" style="background-image:url('jsp/images/none2.png')">
											<a href="/Exchange/DetailServlet?typeid1=electrics&typeid2=${good.eleid }"><img
												src="${good.eleresource }" alt="" title="" /></a>
										</div>
										<!-- .prev -->
										<h3 class="title">${good.elename }</h3>
										<div class="cart">
											<div class="price">
												<div class="vert">
													<div class="price_new">${good.eletype }</div>
												</div>
											</div>
											<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
												href="#" class="bay"></a>
										</div>
										<!-- .cart -->
									</div> <!-- .grid_3 -->
								</li>
							</c:forEach>

						</ul>
						<!-- #list_product -->
					</div>
					<!-- .list_carousel -->
				</div>
				<!-- .carousel -->
			</c:if>

			<c:if test="${types[i]=='entertainments'}">
				<div class="carousel">
					<div class="c_header">
						<div class="grid_10">
							<h2>娱乐</h2>
						</div>
						<!-- .grid_10 -->
						<div class="grid_2">
							<a id="next_c${i+1 }" class="next arows" href="#"><span>Next</span></a>
							<a id="prev_c${i+1 }" class="prev arows" href="#"><span>Prev</span></a>
						</div>
						<!-- .grid_2 -->
					</div>
					<!-- .c_header -->
					<div class="list_carousel">
						<ul id="list_product${i+1 }" class="list_product">
							<c:forEach items="${lst }" var="good">
								<li class="">
									<div class="grid_3 product">
										<div class="prev" style="background-image:url('jsp/images/none2.png')">
											<a href="/Exchange/DetailServlet?typeid1=entertainments&typeid2=${good.enterid }"><img
												src="${good.entertainmenttype }" alt="" title="" /></a>
										</div>
										<!-- .prev -->
										<h3 class="title">${good.entertainmentname }</h3>
										<div class="cart">
											<div class="price">
												<div class="vert">
													<div class="price_new">${good.entertainmenttype }</div>
												</div>
											</div>
											<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
												href="#" class="bay"></a>
										</div>
										<!-- .cart -->
									</div> <!-- .grid_3 -->
								</li>
							</c:forEach>

						</ul>
						<!-- #list_product -->
					</div>
					<!-- .list_carousel -->
				</div>
				<!-- .carousel -->
			</c:if>

			<c:if test="${types[i]=='females'}">
				<div class="carousel">
					<div class="c_header">
						<div class="grid_10">
							<h2>女装</h2>
						</div>
						<!-- .grid_10 -->
						<div class="grid_2">
							<a id="next_c${i+1 }" class="next arows" href="#"><span>Next</span></a>
							<a id="prev_c${i+1 }" class="prev arows" href="#"><span>Prev</span></a>
						</div>
						<!-- .grid_2 -->
					</div>
					<!-- .c_header -->
					<div class="list_carousel">
						<ul id="list_product${i+1 }" class="list_product">
							<c:forEach items="${lst }" var="good">
								<li class="">
									<div class="grid_3 product">
										<div class="prev" style="background-image:url('jsp/images/none2.png')">
											<a href="/Exchange/DetailServlet?typeid1=females&typeid2=${good.femaleid }"><img
												src="${good.femaleresource }" alt="" title="" /></a>
										</div>
										<!-- .prev -->
										<h3 class="title">${good.femaletype }</h3>
										<div class="cart">
											<div class="price">
												<div class="vert">
													<div class="price_new">${good.femalesize }</div>
												</div>
											</div>
											<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
												href="#" class="bay"></a>
										</div>
										<!-- .cart -->
									</div> <!-- .grid_3 -->
								</li>
							</c:forEach>

						</ul>
						<!-- #list_product -->
					</div>
					<!-- .list_carousel -->
				</div>
				<!-- .carousel -->
			</c:if>

			<c:if test="${types[i]=='males'}">
				<div class="carousel">
					<div class="c_header">
						<div class="grid_10">
							<h2>男装</h2>
						</div>
						<!-- .grid_10 -->
						<div class="grid_2">
							<a id="next_c${i+1 }" class="next arows" href="#"><span>Next</span></a>
							<a id="prev_c${i+1 }" class="prev arows" href="#"><span>Prev</span></a>
						</div>
						<!-- .grid_2 -->
					</div>
					<!-- .c_header -->
					<div class="list_carousel">
						<ul id="list_product${i+1 }" class="list_product">
							<c:forEach items="${lst }" var="good">
								<li class="">
									<div class="grid_3 product">
										<div class="prev" style="background-image:url('jsp/images/none2.png')">
											<a href="/Exchange/DetailServlet?typeid1=males&typeid2=${good.maleid }"><img
												src="${good.maleresource }" alt="" title="" /></a>
										</div>
										<!-- .prev -->
										<h3 class="title">${good.maletype }</h3>
										<div class="cart">
											<div class="price">
												<div class="vert">
													<div class="price_new">${good.malesize }</div>
												</div>
											</div>
											<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
												href="#" class="bay"></a>
										</div>
										<!-- .cart -->
									</div> <!-- .grid_3 -->
								</li>
							</c:forEach>

						</ul>
						<!-- #list_product -->
					</div>
					<!-- .list_carousel -->
				</div>
				<!-- .carousel -->
			</c:if>

			<c:if test="${types[i]=='pc'}">
				<div class="carousel">
					<div class="c_header">
						<div class="grid_10">
							<h2>电脑类</h2>
						</div>
						<!-- .grid_10 -->
						<div class="grid_2">
							<a id="next_c${i+1 }" class="next arows" href="#"><span>Next</span></a>
							<a id="prev_c${i+1 }" class="prev arows" href="#"><span>Prev</span></a>
						</div>
						<!-- .grid_2 -->
					</div>
					<!-- .c_header -->
					<div class="list_carousel">
						<ul id="list_product${i+1 }" class="list_product">
							<c:forEach items="${lst }" var="good">
								<li class="">
									<div class="grid_3 product">
										<div class="prev" style="background-image:url('jsp/images/none2.png')">
											<a href="/Exchange/DetailServlet?typeid1=pc&typeid2=${good.pcid }"><img
												src="${good.pcresource }" alt="" title="" /></a>
										</div>
										<!-- .prev -->
										<h3 class="title">${good.pcmodel }</h3>
										<div class="cart">
											<div class="price">
												<div class="vert">
													<div class="price_new">${good.pcbrand }&nbsp;${good.pctype }</div>
												</div>
											</div>
											<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
												href="#" class="bay"></a>
										</div>
										<!-- .cart -->
									</div> <!-- .grid_3 -->
								</li>
							</c:forEach>

						</ul>
						<!-- #list_product -->
					</div>
					<!-- .list_carousel -->
				</div>
				<!-- .carousel -->
			</c:if>

			<c:if test="${types[i]=='phones'}">
				<div class="carousel">
					<div class="c_header">
						<div class="grid_10">
							<h2>手机类</h2>
						</div>
						<!-- .grid_10 -->
						<div class="grid_2">
							<a id="next_c${i+1 }" class="next arows" href="#"><span>Next</span></a>
							<a id="prev_c${i+1 }" class="prev arows" href="#"><span>Prev</span></a>
						</div>
						<!-- .grid_2 -->
					</div>
					<!-- .c_header -->
					<div class="list_carousel">
						<ul id="list_product${i+1 }" class="list_product">
							<c:forEach items="${lst }" var="good">
								<li class="">
									<div class="grid_3 product">
										<div class="prev" style="background-image:url('jsp/images/none2.png')">
											<a href="/Exchange/DetailServlet?typeid1=phones&typeid2=${good.phoneid }"><img
												src="${good.phoneresource }" alt="" title="" /></a>
										</div>
										<!-- .prev -->
										<h3 class="title">${good.phonemodel }</h3>
										<div class="cart">
											<div class="price">
												<div class="vert">
													<div class="price_new">${good.phonebrand }&nbsp;${good.phonetype }</div>
												</div>
											</div>
											<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
												href="#" class="bay"></a>
										</div>
										<!-- .cart -->
									</div> <!-- .grid_3 -->
								</li>
							</c:forEach>

						</ul>
						<!-- #list_product -->
					</div>
					<!-- .list_carousel -->
				</div>
				<!-- .carousel -->
			</c:if>

			<c:if test="${types[i]=='sppros'}">
				<div class="carousel">
					<div class="c_header">
						<div class="grid_10">
							<h2>特产</h2>
						</div>
						<!-- .grid_10 -->
						<div class="grid_2">
							<a id="next_c${i+1 }" class="next arows" href="#"><span>Next</span></a>
							<a id="prev_c${i+1 }" class="prev arows" href="#"><span>Prev</span></a>
						</div>
						<!-- .grid_2 -->
					</div>
					<!-- .c_header -->
					<div class="list_carousel">
						<ul id="list_product${i+1 }" class="list_product">
							<c:forEach items="${lst }" var="good">
								<li class="">
									<div class="grid_3 product">
										<div class="prev" style="background-image:url('jsp/images/none2.png')">
											<a href="/Exchange/DetailServlet?typeid1=sppros&typeid2=${good.spid }"><img
												src="${good.spresource }" alt="" title="" /></a>
										</div>
										<!-- .prev -->
										<h3 class="title">${good.spname }</h3>
										<div class="cart">
											<div class="price">
												<div class="vert">
													<div class="price_new">${good.splocation }&nbsp;${good.sptype }</div>
												</div>
											</div>
											<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
												href="#" class="bay"></a>
										</div>
										<!-- .cart -->
									</div> <!-- .grid_3 -->
								</li>
							</c:forEach>

						</ul>
						<!-- #list_product -->
					</div>
					<!-- .list_carousel -->
				</div>
				<!-- .carousel -->
			</c:if>

		</c:forEach>


		<div id="content_bottom">
			<!-- .grid_4 -->
			<!-- .grid_4 -->
			<!-- .grid_4 -->
			<div class="clear"></div>
		</div>
		<!-- #content_bottom -->
		<div class="clear"></div>
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