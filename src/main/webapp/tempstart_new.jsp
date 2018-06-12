<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Choose role</title>
</head>
<body>
	<form action="temp_start_new" method="post">
		<input type="checkbox" name="role" value="ROLE_USER" />
		User
		<input type="checkbox" name="role" value="ROLE_MENTOR" />Mentor<input
			type="checkbox" name="role" value="ROLE_MODERATOR" />Moder<input
			type="checkbox" name="role" value="ROLE_ADMIN" />Admin<input type="submit"
			value="temp start" />
	</form>
</body>
</html>