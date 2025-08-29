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
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
        }
        .sidebar {
            width: 220px;
            height: 100vh;
            background-color: #343a40;
            color: white;
            padding-top: 20px;
            position: fixed;
        }
        .sidebar a {
            color: white;
            text-decoration: none;
            display: block;
            padding: 10px 20px;
        }
        .sidebar a:hover {
            background-color: #495057;
        }
        .content {
            margin-left: 220px;
            padding: 20px;
            width: 100%;
        }
    </style>
</head>
<body>
<div class="sidebar">
    <h4 class="text-center">Admin</h4>
    <p class="text-center">Xin chào, <%= u.getUserName() %></p>
    <a href="<%=request.getContextPath()%>/admin/home.jsp">🏠 Dashboard</a>
    <a href="<%=request.getContextPath()%>/admin/categories">📂 Category</a>
    <a href="<%=request.getContextPath()%>/product/list">📦 Product</a>
    <a href="<%=request.getContextPath()%>/user/list">👤 User</a>
    <a href="<%=request.getContextPath()%>/logout">🚪 Logout</a>
</div>

<div class="content">
    <h2>Dashboard</h2>
    <p>Email: <%= u.getEmail() %></p>
    <div class="alert alert-primary">
        Welcome to Admin Dashboard
    </div>
    <p>Chọn menu bên trái để quản lý Category, Product, User,...</p>
</div>
</body>
</html>
