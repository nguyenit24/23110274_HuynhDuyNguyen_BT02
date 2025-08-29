<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quên mật khẩu</title>
</head>
<body>
    <h2>Quên mật khẩu</h2>
	<c:if test="${not empty message}">
        <p style="color: red;">${message}</p>
     </c:if>
    <form action="${pageContext.request.contextPath}/forgetpass" method="post">
        <label>Nhập Email:</label>
        <input type="text" name="email" required />
        <input type="hidden" name="email" />
        <label>Mật khẩu mới:</label>
        <input type="password" name="newpass" required />
        <button type="submit" name="action" value="reset">Đặt lại</button>
        <a href="${pageContext.request.contextPath}/login">Quay lại đăng nhập</a>
    </form>
</body>
</html>
