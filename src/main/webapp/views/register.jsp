<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

    <style>
        body {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: #f8f9fa;
        }
        form {
            width: 400px;
            padding: 30px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        section {
            margin-bottom: 15px;
        }
        .btn {
            width: 100%;
        }
        .input-group-addon {
            display: flex;
            align-items: center;
            padding: 0 10px;
            background: #e9ecef;
            border: 1px solid #ced4da;
            border-right: none;
            border-radius: .25rem 0 0 .25rem;
        }
        .input-group .form-control {
            border-radius: 0 .25rem .25rem 0;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method="post">
    <h2>Tạo tài khoản mới</h2>

    <c:if test="${alert != null}">
        <h3 class="alert alert-danger">${alert}</h3>
    </c:if>

    <section>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                <input type="email" placeholder="Email" name="email"
                       class="form-control" required>
            </div>
        </label>
    </section>

    <section>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" placeholder="Tài khoản" name="username"
                       class="form-control" required>
            </div>
        </label>
    </section>

    <section>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-id-card"></i></span>
                <input type="text" placeholder="Họ và tên" name="fullname"
                       class="form-control" required>
            </div>
        </label>
    </section>

    <section>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                <input type="password" placeholder="Mật khẩu" name="password"
                       class="form-control" required>
            </div>
        </label>
    </section>

    <section>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-phone"></i></span>
                <input type="text" placeholder="Số điện thoại" name="phone"
                       class="form-control">
            </div>
        </label>
    </section>

    <section>
        <button type="submit" class="btn btn-primary">Đăng ký</button>
        <div class="text-center mt-3">
            <a href="${pageContext.request.contextPath}/login">Đã có tài khoản? Đăng nhập</a>
        </div>
    </section>
</form>
</body>
</html>
