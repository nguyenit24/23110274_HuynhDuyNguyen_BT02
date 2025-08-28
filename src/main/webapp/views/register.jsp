<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<form  action="${pageContext.request.contextPath}/register" method="post">
		<h2>Tạo tài khoản mới</h2>

		<c:if test="${alert != null}">
			<h3 class="alert alert-danger">${alert}</h3>
		</c:if>

		<!-- Email -->
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
					<input type="email" placeholder="Email" name="email"
						class="form-control" required>
				</div>
			</label>
		</section>

		<!-- Username -->
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="Tài khoản" name="username"
						class="form-control" required>
				</div>
			</label>
		</section>

		<!-- Full name -->
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-id-card"></i></span>
					<input type="text" placeholder="Họ và tên" name="fullname"
						class="form-control" required>
				</div>
			</label>
		</section>

		<!-- Password -->
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span> <input
						type="password" placeholder="Mật khẩu" name="password"
						class="form-control" required>
				</div>
			</label>
		</section>

		<!-- Avatar (link ảnh) -->
	<!--  <section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-image"></i></span>
					<input type="text" placeholder="Link ảnh đại diện" name="avatar"
						class="form-control">
				</div>
			</label>
		</section>
	-->	

		<!-- Phone -->
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-phone"></i></span>
					<input type="text" placeholder="Số điện thoại" name="phone"
						class="form-control">
				</div>
			</label>
		</section>

		<!-- Created Date -->
		<!--<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
					<input type="date" name="createdDate" class="form-control">
				</div>
			</label>
		</section>

		<!-- Submit -->
		<section>
			<button type="submit" class="btn btn-primary">Đăng ký</button>
		</section>
	</form>

</body>
</html>