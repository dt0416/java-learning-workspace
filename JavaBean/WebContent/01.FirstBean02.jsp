<!-- �g�k2 -->
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<%-- <jsp:useBean></jsp:useBean>�N��g�k1���H�U���, �]�t��l��, ����l�ƬO�ΤϮg�����{(Class.forName) --%>
<%-- <%@ page import="learning.sample.javabean.FirstBean"%> --%>
<!-- 	FirstBean fb = new FirstBean(); -->
<jsp:useBean id="fb" class="ln.javabean.FirstBean" scope="page"></jsp:useBean>
<!-- scope: page, request, session, application -->
<%
	fb.setName("�i�T");
	fb.setAge(18);
%>
�m�W:<%=fb.getName() %><br />
�~��:<%=fb.getAge() %><br />
</body>
</html>