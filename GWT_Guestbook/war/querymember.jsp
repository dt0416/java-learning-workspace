<%@page import="javax.jdo.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.gb.Member"%>
<%@page import="com.gb.PMF"%>
<%@page import="javax.jdo.PersistenceManager"%>
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
	<jsp:useBean id="member" class="com.gb.Member"></jsp:useBean>
	<c:forEach var="member" items="${member.allMembers }">
        ${member.userid }, ${member.nickname }, ${member.email }<br /> 
	</c:forEach>
</body>
</html>