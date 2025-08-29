<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home User</title>
</head>
<body>
    <h1>Welcome to User Home Page</h1>
    <p>This is a placeholder for user functionalities.</p>
   	<p>Xin chào, ${sessionScope.account.fullName}!</p>
   	<a href="${pageContext.request.contextPath}/logout">Đăng Xuất</a>
</body>
</html>