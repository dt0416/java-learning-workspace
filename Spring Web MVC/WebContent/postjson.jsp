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
		   url: 'receiveJSONandGetNewUserJSON',
		   data: $('#input').val(),
		   dataType: "text", // 取回來直接轉成文字, 原始應該是json
		   success: function(resposeJsonObject){    
			   $('#output').val(resposeJsonObject);
	        },
	        contentType: "application/json; charset=utf-8"
		 });
   });
   
   $('#submit2').click(function() {
       $.ajax({
           type: "POST",
           url: 'receiveJSONandGetNewUserJSON2',
           data: $('#input2').val(),
           dataType: "text", // 取回來直接轉成文字, 原始應該是json
           success: function(resposeJsonObject){    
               $('#output2').val(resposeJsonObject);
            },
            contentType: "application/json; charset=utf-8"
         });
   });
});

</script>
</head>
<body>
	<h3>receiveJSONandGetNewUserJSON</h3>
	Input<br />
	<textarea rows="10" cols="100" id="input">{"userName":"John","password":"111","nickName":"jo","email":"jo@gmail.com"}</textarea><br />
	<button id="submit">Submit</button><br />
	Output<br />
	<textarea rows="10" cols="100" id="output"></textarea>
	
	<h3>receiveJSONandGetNewUserJSON2</h3>
	Input<br />
    <textarea rows="10" cols="100" id="input2">{"userName":"John","password":"111","nickName":"jo","email":"jo@gmail.com"}</textarea><br />
    <button id="submit2">Submit</button><br />
    Output<br />
    <textarea rows="10" cols="100" id="output2"></textarea>
</body>
</html>