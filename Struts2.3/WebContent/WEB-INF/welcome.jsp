<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	Welcome!!<%=request.getParameter("userName") %><br />
	
	<h1>取得自己的ActionForm</h1>
	<!-- 不用另外寫程式也可直接取得自己的ActionForm，預設scope為session，可在struts-config.xml裡將action scope改成request/session -->
	${sessionScope["loginActionForm"].passWord }<br />
	
</body>
</html>