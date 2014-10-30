<!-- 寫法2 -->
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<%-- <jsp:useBean></jsp:useBean>代表寫法1的以下兩行, 包含初始化, 但初始化是用反射機制實現(Class.forName) --%>
<%-- <%@ page import="learning.sample.javabean.FirstBean"%> --%>
<!-- 	FirstBean fb = new FirstBean(); -->
<jsp:useBean id="fb" class="ln.javabean.FirstBean" scope="page"></jsp:useBean>
<!-- scope: page, request, session, application -->
<%
	fb.setName("張三");
	fb.setAge(18);
%>
姓名:<%=fb.getName() %><br />
年齡:<%=fb.getAge() %><br />
</body>
</html>