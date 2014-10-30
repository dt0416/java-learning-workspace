<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>01.FirstMvc</h3>
    <li><a href="firstMvc">FirstMvc</a></li>
    
    <h3>02.AnnotationHandlerMapping</h3>
    <li><a href="annotationHandlerMapping">AnnotationHandlerMapping</a></li>
    <li><a href="annotationHandlerMapping2">AnnotationHandlerMapping2</a></li>
    
    <h3>03.PassValue</h3>
    <li><a href="passValue?username=Jordan&age=18">PassValue</a></li>
    <li><a href="passValue?age=18">PassValue(會出錯，沒傳username)</a></li>
    <li><a href="passValue?username=Kobe">PassValue</a></li>
    
    <h3>04.PassValueBetweenUrl</h3>
    <li><a href="Jordan/passValueBetweenUrl">PassValueBetweenUrl</a></li>
    
    <h3>05.SimpleUser</h3>
    <li><a href="user/list">顯示所有用戶</a></li>
    <li><a href="user/goAdd">新增用戶</a></li>
    <li><a href="user/goAdd1">新增用戶範例2(差別在controller的參數寫法)</a></li>
    <li><a href="user/Jordan/addSession">將資料存入session</a></li>
    
    <h3>06.ExceptionHandle</h3>
    <li><a href="exceptionHandle">單一例外擷取</a></li>
    <li><a href="throwGlobalException">全局例外擷取</a>(需在mvc-config.xml設定SimpleMappingExceptionResolver)</li>
    
    <h3>07.Apply css</h3>
    <li><a href="applyCss.html">套用css</a>(需在mvc-config.xml裡設定指定靜態文件)</li>
    
    <h3>08.File Upload</h3>
    <li><a href="upload.html">上傳檔案</a></li>

	<h3>09.JSON</h3>
	<li><a href="getUserJSON">取得JSON</a></li>
	<li><a href="postjson.jsp">Post JSON 並取得JSON</a></li>

    <h3>10.XML</h3>
    <li><a href="getXmlPojo">取得XML</a></li>
    <li><a href="postxml.jsp">Post XML 並取得XML</a></li>

    <h3>12.CommonController</h3>
    <li><a href="helloWithoutName">直接返回文字</a></li>
    <li><a href="posttext.jsp">post文字並返回文字</a></li>
	
    <h3>11.SiteMesh</h3>
    <li><a href="applysitemesh/passValue?username=Jordan&age=18">套用SiteMesh</a>(此範例與03.passValue套用同個controller，為了使用不同url分辨有套用sitemesh的差別))</li>

</body>
</html>