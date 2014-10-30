<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script>
$(document).ready(function() {
   $('#submit').click(function() {
	   $.ajax({
		   type: "POST",
		   url: 'helloWithName',
		   data: $('#input').val(),
		   //dataType: "text", // 取回來不需轉成文字， 原始就是text
		   success: function(resposeObject){    
			   $('#output').val(resposeObject);
	        },
	        contentType: "text/plain;charset=UTF-8"
		 });
   });
});

</script>
</head>
<body>
	Input<br />
	<textarea rows="10" cols="100" id="input">John</textarea><br />
	<button id="submit">Submit</button><br />
	Output<br />
	<textarea rows="10" cols="100" id="output"></textarea>
</body>
</html>