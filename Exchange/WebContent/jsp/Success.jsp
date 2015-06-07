<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作成功</title>
</head>
<body>
<c:if test="${!empty requestScope.msgcode }">
<%
	int msgcode = Integer.parseInt(request.getAttribute("msgcode").toString());
	switch (msgcode) {
	case 103:
		out.println("<script type=\"text/javascript\">window.location='jsp/scsbingo.jsp';</script>");
		break;
	case 106:
		out.println("<script type=\"text/javascript\">window.location='jsp/bingo.jsp';</script>");
		break;
	case 110:
		out.println("<script type=\"text/javascript\">window.location='jsp/scsbingo.jsp';</script>");
		break;
	}
%>
</c:if>
操作成功
</body>
</html>