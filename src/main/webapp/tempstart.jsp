<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Choose role</title>
</head>
<body>
<form action="MainServlet" method="get"><input type="checkbox"  name="role" value="user"/>User<input type="checkbox"  name="role" value="mentor"/>Mentor<input type="checkbox"  name="role" value="moderator"/>Moder<input type="checkbox"  name="role" value="admin"/>Admin<input type="submit" name="action" value="temp_start"/></form>
</body>
</html>