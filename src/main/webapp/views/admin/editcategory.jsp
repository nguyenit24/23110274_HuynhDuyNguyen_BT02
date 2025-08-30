<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Edit Category</h2>

    <!-- Form edit category -->
    <form action="<c:url value='/admin/category/update'/>" method="post" enctype="multipart/form-data">

        <input id="categoryid" name="categoryid" value="${cate.categoryid}" />

        <div class="mb-3">
            <label for="categoryname" class="form-label">Category Name</label>
            <input type="text" class="form-control" id="categoryname" name="categoryname"
                   value="${cate.categoryname}" required>
        </div>

        <div class="mb-3">
            <label for="image" class="form-label">Upload Image</label>
            <br />
            <c:if test="${cate.images.substring(0, 5) != 'https'}">
                <c:url value="/image?fname=${cate.images}" var="imgUrl"/>
            </c:if>
            <c:if test="${cate.images.substring(0, 5) == 'http'}">

                <c:url var="imgUrl" value="${cate.images}" />
            </c:if>
            <img src="${imgUrl}" alt="Category Image" style="max-width: 200px; max-height: 200px;"/>
            <input type="file" class="form-control mt-2" id="image" name="image" accept="image/*">
        </div>

        <div class="mb-3">
            <label for="status" class="form-label">Status</label>
            <select class="form-select" id="status" name="status">
                <option value="1" <c:if test="${cate.status == 1}">selected</c:if>>Hoạt động</option>
                <option value="0" <c:if test="${cate.status == 0}">selected</c:if>>Khóa</option>
            </select>
        </div>

        <button type="submit" class="btn btn-success">Save</button>
        <a href="<c:url value='/admin/categories'/>" class="btn btn-secondary">Back</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
