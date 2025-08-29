<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Category CRUD</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Category List</h2>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>STT</th>
            <th>Category Name</th>
            <th>Image</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cateList}" var="cate" varStatus="STT">
            <tr>
                <td>${STT.index + 1}</td>
                <c:url value="/image?fname=${cate.icon}" var="imgUrl"></c:url>
                <td><img height="150" width="200" src="${imgUrl}" alt="${cate.name}"/></td>
                <td>${cate.name}</td>
                <td>
                    <a href="<c:url value='/admin/category/edit?id=${cate.id}'/>" class="btn btn-sm btn-primary">Edit</a>
                    <a href="<c:url value='/admin/category/delete?id=${cate.id}'/>" class="btn btn-sm btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button class="btn btn-success">Add New Category</button>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>