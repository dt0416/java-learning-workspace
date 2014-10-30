<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <a href="goAdd">新增用戶</a>
    <table>
        <tr><td>UserName</td><td>Password</td><td>NickName</td><td>Email</td><td></td><td></td></tr>
	    <c:forEach items="${users}" var="user">
	        <tr>
		        <td><a href="${user.value.userName}">${user.value.userName}</a></td>
		        <td>${user.value.password}</td>
		        <td>${user.value.nickName}</td>
		        <td>${user.value.email}</td>
		        <td><a href="${user.value.userName}/update">修改</a></td>
		        <td><a href="${user.value.userName}/delete">刪除</a></td>
	        </tr>
	    </c:forEach>
    </table>
</body>
</html>