<!-- 寫法2 -->
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
	<!-- 設定屬性                                                   -->
	<!-- ********************************************************** -->
	<jsp:setProperty name="fb" property="*" /><!-- name:JavaBean(useBean)的id, property:依據request的name尋找setXxx, 例property="age"會尋找setAge -->
	<!-- 上一行等於以下2行 -->
	<%
		//fb.setName(request.getParameter("name")) ;
		//fb.setAge(Integer.parseInt(request.getParameter("age"))) ;
	%>
	<!-- 也等於以下2行 -->
	<%-- <jsp:setProperty name="fb" property="name" /> --%>
	<%-- <jsp:setProperty name="fb" property="age" /> --%>
	
	<!-- 自行設定配對 -->
	<%-- <jsp:setProperty name="fb" property="name" param="age" /> --%><!-- 將request裡age的值設定給fb的name -->
	
	<!-- 自行設定值(value) -->
	<%-- <jsp:setProperty name="fb" property="name" value="XXX" /> --%><%-- value的值可以為<%="" %>, 例:value="<%=\"TTT2\" %>, 或者String name1=""; value="<%=name1 %> --%>
	
	<!-- ********************************************************** -->
	<!-- 取得屬性                                                   -->
	<!-- ********************************************************** -->
	<h1>取法1</h1>
	姓名:<%=fb.getName() %><br />
	年齡:<%=fb.getAge() %><br />
	<h1>取法2</h1>
	姓名:<jsp:getProperty name="fb" property="name" /><br />
	年齡:<jsp:getProperty name="fb" property="age" /><br />
</body>
</html>