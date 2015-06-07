<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="description" content="">
<meta name="keywords" content="">
<title>发布物品</title>

<link rel="shortcut icon" href="images/icon.png">
<link href="css/postcss/style.css" media="screen" rel="stylesheet"
	type="text/css">
<link href="css/postcss/grid.css" media="screen" rel="stylesheet"
	type="text/css">

<script src="js/postjs/jquery-1.7.2.min.js"></script>
<script src="js/postjs/html5.js"></script>
<script src="js/postjs/jflow.plus.js"></script>
<script src="js/postjs/jquery.carouFredSel-5.2.2-packed.js"></script>
<script src="js/postjs/checkbox.js"></script>
<script src="js/postjs/radio.js"></script>
<script src="js/postjs/selectBox.js"></script>

<script type="text/javascript">
	function showDiv(id) {
		var divs = document.getElementsByName("divty");
		for(var i=0; i<divs.length; i++) {
			divs[i].style.display="none";
		}
		var divid=document.getElementById(id).value;
		document.getElementById(divid).style.display='block';
		showexc();
	}
	
	function showSubSel() {
		var select = document.getElementById("stype");
		var options = select.options;
		for(var i=0; i<options.length; i++) {
			if(options[i].value!="selecttype") {
				if(options[i].value=="instruments" || options[i].value=="virtuals" || options[i].value=="others"){
					var divs = document.getElementsByName("divty");
					for(var i=0; i<divs.length; i++) {
						divs[i].style.display="none";
					}
				} else {
				document.getElementById(options[i].value).style.display='none';
				}
			}
			
		}
		
		var divid=document.getElementById("stype").value;
		document.getElementById(divid).style.display='block';
	}
	
	function showexc() {
		var divs = document.getElementsByName("divexc");
		for(var i=0; i<divs.length; i++) {
			divs[i].style.display="block";
		}
	}
	
	function hideexc() {
		var divs = document.getElementsByName("divexc");
		for(var i=0; i<divs.length; i++) {
			divs[i].style.display="none";
		}
	}
	
</script>

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
				<a href="scsbingo.jsp" title=""><img src="images/bingo logo.png"
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
				<li><a href="#">发布帖子</a></li>
				<li class="separator">|</li>
				<li><a href="myMsg.jsp">我的消息(${sessionScope.woLen })</a></li>
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
					<li class="curent"><a href="scsbingo.jsp">返回主页</a></li>
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
			<h3>热门商品推荐</h3>
			<div class="list_carousel">
				<ul id="list_banners">
					<li class="banner"><a href="#">
							<div class="prev">
								<img src="images/banner.png" alt="" title="" />
							</div> <!-- .prev -->
							<h2>1</h2>
							<p>点击查看详情</p>
					</a></li>
					<li class="banner"><a href="#">
							<div class="prev">
								<img src="images/banner.png" alt="" title="" />
							</div> <!-- .prev -->
							<h2>2</h2>
							<p>点击查看详情</p>
					</a></li>
					<li class="banner"><a href="#">
							<div class="prev">
								<img src="images/banner.png" alt="" title="" />
							</div> <!-- .prev -->
							<h2>3</h2>
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
		  <h1 class="post_title">发表帖子</h1><!-- .content_article -->
		</article><!-- .comments_blog -->

		<div id="content" class="grid_9">
			<!-- .comments_blog -->

			<div class="nickname">
				<strong>分类</strong><sup class="surely">*</sup><br />
				<select id="stype" onchange="showSubSel()" style="width:150px">
					<option value="selecttype">商品分类</option>
					<option value="book">图书</option>
					<option value="ele">电子</option>
					<option value="spt">体育</option>
					<option value="life">生活</option>
					<option value="cloth">服饰</option>
					<option value="instruments">乐器</option>
					<option value="virtuals">虚拟</option>
					<option value="others">其他</option>
				</select>
			</div>

			<p>&nbsp;</p>
			<div class="nickname" id="book" style="display:none">
				<strong>图书分类</strong><sup class="surely">*</sup><br />
				<select id="sbook" onchange="showDiv('sbook')" style="width:150px">
					<option value="selecttype">商品分类</option>
					<option value="textbooks">教科书</option>
					<option value="extrabooks">课外书</option>
					<option value="audios">音像</option>
				</select>
			</div>
			
			<div class="nickname" id="ele" style="display:none">
				<strong>电子分类</strong><sup class="surely">*</sup><br />
				<select id="sele" onchange="showDiv('sele')" style="width:150px">
					<option value="selecttype">商品分类</option>
					<option value="pc">电脑类</option>
					<option value="phones">手机类</option>
					<option value="digits">数码类</option>
				</select>
			</div>
			
			<div class="nickname" id="spt" style="display:none">
				<strong>体育分类</strong><sup class="surely">*</sup><br />
				<select id="sspt" onchange="showDiv('sspt')" style="width:150px">
					<option value="selecttype">商品分类</option>
					<option value="sptasts">体育辅助</option>
					<option value="spteqpts">体育器械</option>
				</select>
			</div>
			
			<div class="nickname" id="life" style="display:none">
				<strong>日常分类</strong><sup class="surely">*</sup><br />
				<select id="slife" onchange="showDiv('slife')" style="width:150px">
					<option value="selecttype">商品分类</option>
					<option value="dailypros">日常用品</option>
					<option value="electrics">电器</option>
					<option value="entertainments">娱乐</option>
					<option value="cosmetics">化妆品</option>
					<option value="sppros">特产</option>
				</select>
			</div>
			
			<div class="nickname" id="cloth" style="display:none">
				<strong>服饰分类</strong><sup class="surely">*</sup><br />
				<select id="scloth" onchange="showDiv('scloth')" style="width:150px">
					<option value="selecttype">商品分类</option>
					<option value="males">男装</option>
					<option value="females">女装</option>
					<option value="decorations">饰品</option>
					<option value="bags">箱包</option>
				</select>
			</div>

			<!-- 教科书 -->
			<div id="textbooks" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>教科书</h4>
				
				<input type="hidden" name="type" value="textbooks">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="tbstate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="tbstate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="tbstate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>名称</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="tbname" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>作者</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="tbauthor" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>出版社</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="tbpublish" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>版本</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="tbversion" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" name="tbresource" id="tbresource">
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="tbmark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				<div class="clear"></div>
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="extrabooks" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>课外书</h4>
				
				<input type="hidden" name="type" value="extrabooks">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="ebstate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="ebstate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="ebstate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>名称</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="ebname" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>作者</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="ebauthor" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>出版社</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="ebpublish" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="ebresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="ebmark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="audios" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>音像</h4>

				<input type="hidden" name="type" value="audios">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="audiostate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="audiostate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="audiostate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>名称</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="audioname" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>出版社</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="audiopublish" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="audioresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="audiomark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="bags" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>箱包</h4>
				
				<input type="hidden" name="type" value="bags">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="bagstate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="bagstate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="bagstate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>品牌</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="bagbrand" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="bagtype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="bagresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="bagmark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="cosmetics" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>化妆品</h4>

				<input type="hidden" name="type" value="cosmetics">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="cosstate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="cosstate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="cosstate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>名称</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="cosname" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>品牌</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="cosbrand" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="costype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="cosresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="cosmark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="dailypros" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>日常用品</h4>

				<input type="hidden" name="type" value="dailypros">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="dpstate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="dpstate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="dpstate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>名称</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="dpname" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="dptype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="dpresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="dpmark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="decorations" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>饰品</h4>
				<input type="hidden" name="type" value="decorations">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="decstate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="decstate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="decstate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>名称</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="decname" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="dectype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="decresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="decmark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="digits" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>数码</h4>
				<input type="hidden" name="type" value="digits">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="digitstate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="digitstate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="digitstate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>品牌</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="digitbrand" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>型号</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="digitmodel" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="digittype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="digitresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="digitmark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="electrics" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>电器</h4>
				<input type="hidden" name="type" value="electrics">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="elestate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="elestate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="elestate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>名称</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="elename" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="eletype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="eleresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="elemark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="entertainments" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>娱乐</h4>
				<input type="hidden" name="type" value="entertainments">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="enterstate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="enterstate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="enterstate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>名称</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="entername" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="entertype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="enterresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="entermark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="females" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>女装</h4>
				<input type="hidden" name="type" value="females">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="femalestate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="femalestate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="femalestate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="femaletype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>尺寸</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="femalesize" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="femaleresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="femalemark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="instruments" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>乐器</h4>
				<input type="hidden" name="type" value="instruments">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="instrumentstate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="instrumentstate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="instrumentstate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>名称</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="instrumentname" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>品牌</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="instrumentbrand" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="instrumenttype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="instrumentresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="instrumentmark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="males" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>男装</h4>
				<input type="hidden" name="type" value="males">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="malestate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="malestate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="malestate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="maletype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>尺寸</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="malesize" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="maleresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="malemark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="others" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>其他</h4>
				<input type="hidden" name="type" value="others">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="otherstate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="otherstate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="otherstate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>名称</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="othername" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="othertype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="otherresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="othermark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="pc" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>电脑类</h4>
				<input type="hidden" name="type" value="pc">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="pcstate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="pcstate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="pcstate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>品牌</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="pcbrand" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>型号</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="pcmodel" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="pctype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="pcresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="pcmark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="phones" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>手机类</h4>
				<input type="hidden" name="type" value="phones">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="phonestate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="phonestate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="phonestate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>品牌</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="phonebrand" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>型号</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="phonemodel" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="phonetype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="phoneresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="phonemark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="sppros" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>特产</h4>
				<input type="hidden" name="type" value="sppros">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="spstate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="spstate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="spstate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>名称</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="spname" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>地点</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="splocation" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="sptype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="spresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="spmark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="sptasts" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>体育辅助</h4>
				<input type="hidden" name="type" value="sptasts">
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="sastate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="sastate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="sastate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>名称</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="saname" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="satype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="saresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="samark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="spteqpts" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>体育器械</h4>
				<input type="hidden" name="type" value="digits">
				
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="sastate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="sastate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="sastate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>名称</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="sename" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>类型</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="setype" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="seresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="semark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>
			
			<div id="virtuals" name="divty" style="display:none">
			<form class="add_comments" action="/Exchange/PostServlet" method="post" enctype="multipart/form-data">
				<p>&nbsp;</p>
				<h4>虚拟产品</h4>
				<input type="hidden" name="type" value="virtuals">
				
				
				<div>
					<strong>帖子类型</strong><sup class="surely">*</sup><br />
					<input type="radio" value="0" checked="checked" name="virtualstate" onclick="showexc()"/>&nbsp;换物贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="1" name="virtualstate" onclick="hideexc()"/>&nbsp;出租贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="virtualstate" onclick="hideexc()"/>&nbsp;求助贴
				</div>
				<p>&nbsp;</p>
				<div class="nickname">
					<strong>名称</strong><sup class="surely">*</sup><br/>
					<input type="text" value="" name="virtualname" />
				</div>
				<div class="clear"></div>
				<div class="nickname">
					<strong>资源</strong><sup class="surely">*</sup><br/>
					<input type="file" value="" name="virtualresource" />
				</div>
				<div class="clear"></div>

				<div class="text_review">
					<strong>商品描述</strong><sup class="surely">*</sup><br/>
					<textarea name="virtualmark" style="resize:none"></textarea>
				</div>
				<!-- .text_review -->
				
				<div name="divexc">
					<p>&nbsp;</p>
					<div class="nickname">
						<strong>要交换的分类</strong><sup class="surely">*</sup><br />
						<select name="sexc" style="width:150px">
							<option value="selecttype">商品分类</option>
							<option value="books">图书</option>
							<option value="eles">电子</option>
							<option value="spts">体育</option>
							<option value="lifes">生活</option>
							<option value="clothes">服装</option>
							<option value="decs">饰品</option>
							<option value="bags">箱包</option>
							<option value="ins">乐器</option>
							<option value="vis">虚拟</option>
							<option value="others">其他</option>
						</select>
					</div>
					<div class="clear"></div>
					
					<div class="nickname">
						<strong>要交换的物品的名称</strong><sup class="surely">*</sup><br/>
						<input type="text" value="" name="iexcthing" placeholder="例：乔布斯传 或 iPhone6"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="submit">
					<div class="field" align="right">
						<sup class="surely">*</sup><span>必填字段</span>
					</div>
					<input type="submit" value="确认发帖" />
				</div>
				<!-- .submit -->
			</form>
			<!-- .add_comments -->
			</div>

		</div>
		<!-- #content -->

		<div class="clear"></div>

	</div>
	</div>
	<!-- .container_12 --> </section>


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
				<a href="#"><img src="images/人人2.png" width="35" height="21"
					align="right"></a> <a href="#"><img src="images/朋友网2.png"
					width="30" height="30" align="right"></a> <a href="#"><img
					src="images/腾讯微博2.png" width="30" height="30" align="right"></a>
				<a href="#"><img src="images/新浪微博2.png" width="30" height="30"
					align="right"></a> <a href="#"><img src="images/微信2.png"
					width="30" height="30" align="right"></a> <a href="#"><img
					src="images/QQ空间2.png" width="30" height="30" align="right"></a>
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