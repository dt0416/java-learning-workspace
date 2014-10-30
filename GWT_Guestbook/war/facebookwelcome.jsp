<%@page import="java.util.List"%>
<%@page import="com.restfb.Connection"%>
<%@page import="com.fb.UrlFetcher"%>
<%@page import="com.restfb.types.User"%>
<%@page import="com.restfb.DefaultFacebookClient"%>
<%@page import="com.restfb.FacebookClient"%>
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
// 取得授權碼
String code = request.getParameter("code");
// 應用程式ID
String client_id  = "493657330755676";
// 應用程式密鑰
String secret = "23ac48a587bada0e1b266f3975e12f38";
String redirect_uri = "http://127.0.0.1:8888/facebookwelcome.jsp";
String authURL = "https://graph.facebook.com/oauth/access_token?" +
  "client_id=" + client_id +
  "&redirect_uri=" + redirect_uri +
  "&client_secret=" + secret +
  "&code=" + code;
// 取得access token
String access_token = UrlFetcher.get(authURL);

FacebookClient fbClient = new DefaultFacebookClient(access_token);
User user = fbClient.fetchObject("me", User.class);
%>
帳號：<%=user.getName() %><br />
E-mail：<%=user.getEmail() %><br />

<%
Connection<User> friends = fbClient.fetchConnection("me/friends", User.class);
List<User> friendList = friends.getData();
%>
朋友個數：<%=friendList.size() %><br />
<%=friendList.get(1) %>
</body>
</html>