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
	<jsp:useBean id="fb" class="ln.javabean.FirstBean" scope="page"></jsp:useBean>
	<%
		request.setCharacterEncoding("Big5");
	%>
	<!-- ********************************************************** -->
	<!-- �]�w�ݩ�                                                   -->
	<!-- ********************************************************** -->
	<jsp:setProperty name="fb" property="*" /><!-- name:JavaBean(useBean)��id, property:�̾�request��name�M��setXxx, ��property="age"�|�M��setAge -->
	<!-- �W�@�浥��H�U2�� -->
	<%
		//fb.setName(request.getParameter("name")) ;
		//fb.setAge(Integer.parseInt(request.getParameter("age"))) ;
	%>
	<!-- �]����H�U2�� -->
	<%-- <jsp:setProperty name="fb" property="name" /> --%>
	<%-- <jsp:setProperty name="fb" property="age" /> --%>
	
	<!-- �ۦ�]�w�t�� -->
	<%-- <jsp:setProperty name="fb" property="name" param="age" /> --%><!-- �Nrequest��age���ȳ]�w��fb��name -->
	
	<!-- �ۦ�]�w��(value) -->
	<%-- <jsp:setProperty name="fb" property="name" value="XXX" /> --%><%-- value���ȥi�H��<%="" %>, ��:value="<%=\"TTT2\" %>, �Ϊ�String name1=""; value="<%=name1 %> --%>
	
	<!-- ********************************************************** -->
	<!-- ���o�ݩ�                                                   -->
	<!-- ********************************************************** -->
	<h1>���k1</h1>
	�m�W:<%=fb.getName() %><br />
	�~��:<%=fb.getAge() %><br />
	<h1>���k2</h1>
	�m�W:<jsp:getProperty name="fb" property="name" /><br />
	�~��:<jsp:getProperty name="fb" property="age" /><br />
</body>
</html>