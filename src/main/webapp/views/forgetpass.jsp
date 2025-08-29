<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quên mật khẩu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: #fff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            width: 350px;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-top: 12px;
            font-weight: bold;
            color: #444;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }
        button {
            margin-top: 18px;
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 6px;
            background: #007bff;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s ease;
        }
        button:hover {
            background: #0056b3;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 15px;
            text-decoration: none;
            color: #007bff;
            font-size: 14px;
        }
        .back-link:hover {
            text-decoration: underline;
        }
        .message {
            color: red;
            text-align: center;
            margin-bottom: 12px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Quên mật khẩu</h2>
    <c:if test="${not empty message}">
        <p class="message">${message}</p>
    </c:if>
    <form action="${pageContext.request.contextPath}/forgetpass" method="post">
        <label>Nhập Email:</label>
        <input type="text" name="email" required />
        <label>Mật khẩu mới:</label>
        <input type="password" name="newpass" required />
        <button type="submit" name="action" value="reset">Đặt lại</button>
        <a href="${pageContext.request.contextPath}/login" class="back-link">Quay lại đăng nhập</a>
    </form>
</div>
</body>
</html>
