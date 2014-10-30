<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String fbLoginURL = "https://www.facebook.com/dialog/oauth?" +
  "client_id=493657330755676" +
  "&redirect_uri=http://127.0.0.1:8888/facebookwelcome.jsp";
%>
有登入Facebook則會自動導至歡迎頁面，沒有則會先導至Facebook登入後再導至歡迎頁面<br />
<a href="<%=fbLoginURL %>">Facebook登入</a>
</body>
</html>