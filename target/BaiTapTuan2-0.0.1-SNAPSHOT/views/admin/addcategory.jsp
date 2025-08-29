<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Add New Category</h2>

    <!-- Hiển thị message khi thêm thành công/thất bại -->
    <c:if test="${not empty message}">
        <div class="alert alert-info">${message}</div>
    </c:if>

    <!-- Form add category -->
    <form action="<c:url value='/admin/category/insert'/>" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="categoryname" class="form-label">Category Name</label>
            <input type="text" class="form-control" id="categoryname" name="categoryname" required>
        </div>

        <div class="mb-3">
            <label for="image" class="form-label">Upload Image</label>
            <input type="file" class="form-control" id="image" name="image" accept="image/*">
        </div>

        <div class="mb-3">
            <label for="status" class="form-label">Status</label>
            <select class="form-select" id="status" name="status">
                <option value="1">Hoạt động</option>
                <option value="0">Khóa</option>
            </select>
        </div>

        <button type="submit" class="btn btn-success">Save</button>
        <a href="<c:url value='/admin/categories'/>" class="btn btn-secondary">Back</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
