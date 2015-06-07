<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作失败</title>
</head>
<body>
<c:if test="${!empty requestScope.msgcode }">
<%
	int msgcode = Integer.parseInt(request.getAttribute("msgcode").toString());
	switch (msgcode) {
	case 101:
		out.println("<script type=\"text/javascript\">alert('用户名不存在！');</script>");
		out.println("<script type=\"text/javascript\">window.location='jsp/login.jsp';</script>");
		break;
	case 104:
		out.println("<script type=\"text/javascript\">alert('密码错误！');</script>");
		out.println("<script type=\"text/javascript\">window.location='jsp/login.jsp';</script>");
		break;
	case 105:
		out.println("<script type=\"text/javascript\">alert('用户已经存在！');</script>");
		out.println("<script type=\"text/javascript\">window.location='jsp/login.jsp';</script>");
		break;
	case 107:
		out.println("<script type=\"text/javascript\">alert('注册失败！');</script>");
		out.println("<script type=\"text/javascript\">window.location='jsp/login.jsp';</script>");
		break;
	case 108:
		out.println("<script type=\"text/javascript\">alert('密码项错误！');</script>");
		out.println("<script type=\"text/javascript\">window.location='jsp/login.jsp';</script>");
		break;
	case 111:
		out.println("<script type=\"text/javascript\">alert('两次密码不同！');</script>");
		out.println("<script type=\"text/javascript\">window.location='jsp/scsbingo.jsp';</script>");
		break;
	case 112:
		out.println("<script type=\"text/javascript\">alert('密码项错误！');</script>");
		out.println("<script type=\"text/javascript\">window.location='jsp/scsbingo.jsp';</script>");
		break;
	}
	
%>
</c:if>
操作失败
</body>
</html>