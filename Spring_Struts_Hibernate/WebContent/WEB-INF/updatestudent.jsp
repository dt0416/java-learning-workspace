<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
    <form action="student.do?method=updStudent" method="post">
        <table>
            <tr>
                <td>ID</td><td><input type="text" name="id" readonly="readonly" value="${student.id }" /></td>
            </tr>
            <tr>
                <td>Name</td><td><input type="text" name="name" value="${student.name }" /></td>
            </tr>
            <tr>
                <td>Email</td><td><input type="text" name="email" value="${student.email }" /></td>
            </tr>
            <tr>
                <td>Age</td><td><input type="text" name="age" value="${student.age }" /></td>
            </tr>
        </table>
        <input type="submit" value="送出" />
    </form>
</body>
</html>