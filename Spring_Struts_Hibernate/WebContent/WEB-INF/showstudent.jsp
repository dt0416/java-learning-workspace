<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
    <table>
        <tr>
            <td>ID</td><td>NAME</td><td>EMAIL</td><td>AGE</td><td>�ק�</td><td>�R��</td>
        </tr>
        <c:forEach var="student" items="${students }">
        <tr>
            <td>${student.id }</td>
            <td>${student.name }</td>
            <td>${student.email }</td>
            <td>${student.age }</td>
            <td><a href="student.do?method=goUpdStudent&id=${student.id }">�ק�</a></td>
            <td><a href="student.do?method=delStudent&id=${student.id }">�R��</a></td>
        </tr>
        </c:forEach>
    </table>
    <a href="index.html">��^����</a>
</body>
</html>