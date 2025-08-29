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
            <th>Category ID</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cateList}" var="cate" varStatus="STT">
            <tr>
                <td>${STT.index + 1}</td>
                <td>${cate.categoryname}</td>
                <td><c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url></td>
                <td>${cate.categoryid}</td>
                <td>${cate.status}</td>
                <td>
                    <a href="<c:url value='/admin/category/edit?id=${cate.categoryid}'/>" class="btn btn-sm btn-primary">Edit</a>
                    <a href="<c:url value='/admin/category/delete?id=${cate.categoryid}'/>" class="btn btn-sm btn-danger">Delete</a>
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