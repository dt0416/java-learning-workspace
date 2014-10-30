<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 此為JSP範例程式, 目的在顯示GAE站台也可支援JSP -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String uname = request.getParameter("username");
	if (uname != null) {
		out.println(uname + ", 您好");
	}
	%><br />
	<form method="post">
		姓名：<input type="text" name="username" />
		<input type="submit" value="送出" />
	</form>
</body>
</html>