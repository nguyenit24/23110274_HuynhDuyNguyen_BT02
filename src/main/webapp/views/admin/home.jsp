<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="model.User" %>
<%
    User u = (User) session.getAttribute("account");
    if (u == null) {
        response.sendRedirect(request.getContextPath() + "/views/login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
</head>
<body>
	<h2>Xin chào, <%= u.getUserName() %>!</h2>
    <p>Email: <%= u.getEmail() %></p>
    <h1>Welcome to Admin Home Page ${username}</h1>
    <p>This is a placeholder for admin functionalities.</p>
    <a href="${pageContext.request.contextPath}/logout">Đăng Xuất</a>
</body>
</html>