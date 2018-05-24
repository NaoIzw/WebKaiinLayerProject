<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BeanStartWebApp2</title>
</head>
<body>
 検索結果<br>

ID：<%=request.getAttribute("id") %> <br>
会員名：<%=request.getAttribute("name") %> <br>
登録日時：<%=request.getAttribute("date") %> <br>

</body>
</html>