<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        a {
            text-decoration: none;
            color: #007bff;
            padding: 10px 20px;
            background-color: #f8f9fa;
            border: 1px solid #007bff;
            border-radius: 5px;
            margin: 10px;
            transition: background-color 0.3s, color 0.3s;
        }
        a:hover {
            background-color: #007bff;
            color: #fff;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<form id="deleteForm" method="post" action="/?action=delete" style="display: none">
    <input type="hidden" name="id" id="deleteId">
</form>
<h1>Danh sách phòng trọ</h1>
<a href="/?action=addForm">Thêm phòng trọ</a>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Tên</th>
        <th>Số điện thoại</th>
        <th>Ngày thuê</th>
        <th>Hình thức thanh toán</th>
        <th>Ghi Chú</th>
        <th>Chức năng xoá</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${roomList}" var="p" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${p.name}</td>
            <td>${p.sodienthoai}</td>
            <td>${p.ngaythue}</td>
            <td>${p.phuongthuc.name}</td>
            <td>${p.ghichu}</td>
            <td>
                <button class="btn btn-danger" onclick="openDeleteModal(${p.getId()})">Xoá</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="modal fade" id="confirmModal" tabindex="-1" aria-labelledby="confirmModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmModalLabel">Xác nhận xóa sản phẩm</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Bạn có chắc chắn muốn xóa sản phẩm này không?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                <button type="button" class="btn btn-danger" id="confirmDelete">Xóa</button>
            </div>
        </div>
    </div>
</div>

<script>
    function openDeleteModal(id) {
        document.getElementById('deleteId').value = id;
        let modal;
        modal = new bootstrap.Modal(document.getElementById('confirmModal'));
        modal.show();
    }

    document.getElementById('confirmDelete').addEventListener('click', function () {
        document.getElementById('deleteForm').submit();
    });
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
 </script>
</body>
</html>



