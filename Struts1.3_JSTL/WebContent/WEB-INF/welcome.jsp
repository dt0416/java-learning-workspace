<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="ln.struts.actionform.LoginActionForm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<!-- 上下兩行相等，建議使用上面EL寫法，可規範jsp頁面不會有<% %>的符號出現，而且不用import及轉型 -->
	<%=((LoginActionForm)session.getAttribute("loginActionForm")).getPassWord() %>
	
	<!-- 以下為JSTL Demo -->
	
	<h1>c:out</h1>
	<c:out value="${login }" escapeXml="false" /><br />
	
	<c:set var="tokensDemoString" value="aaa;bbb;ccc;ddd"></c:set>

	<h1>c:if</h1>
	<c:if test="${ifDemo == 'mydemo' }">字串相等</c:if><br />
	<c:if test="${'mydemo' != 'mydemo1' }">字串不相等</c:if>
	
	<h1>c:choose</h1>
	<c:choose>
		<c:when test="${ifDemo == 'mydemo' }">mydemo</c:when>
		<c:when test="${ifDemo == 'mydemo1' }">mydemo1</c:when>
		<c:otherwise>otherwise</c:otherwise>
	</c:choose>

	<h1>c:forEach</h1>
	<c:forEach var="user" items="${requestScope['userList'] }"><!-- 此處也可使用begin、end來取要指定的範圍 -->
		${user }、
	</c:forEach><br />
	<c:forEach var="i" begin="0" end="10" step="2"><!-- step預設為1 -->
		${i }、
	</c:forEach>
	
	<h1>c:forTokens</h1>
	<!-- 使用變數 -->
	<c:forTokens items="${tokensDemoString }" delims=";" var="str">
		<c:out value="${str}">
	</c:out>、
	</c:forTokens><br />
	<!-- 不使用變數 -->
	<c:forTokens items="aaa;bbb;ccc" delims=";" var="str"><c:out value="${str}">
		</c:out>、
	</c:forTokens>
	
	<h1>c:import</h1>
	<c:import url="/ImportDemo.jsp">
		<c:param name="param1">paramValue</c:param>
	</c:import>
	
	<h1>c:url</h1>
	<c:url value="jsp/index.htm">
		<c:param name="param">測試</c:param>
	</c:url>
	
	<h1>EL:empty</h1>
	<%
	String strNotEmpty = "123";
	HashMap emptyMap= new HashMap();
	request.setAttribute("str", strNotEmpty);
	request.setAttribute("map", emptyMap);
	%>
	<c:if test="${empty str}">String is Empty</c:if>
	<c:if test="${empty map}">Map is Empty</c:if>
</body>
</html>