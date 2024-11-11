<%--
  Created by IntelliJ IDEA.
  User: nhoki
  Date: 11/6/2024
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm sản phẩm mới</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            flex-direction: column;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            width: 300px;
            margin: 0 auto;
        }
        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }
        input[type="text"], input[type="number"], select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 3px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background: #5cb85c;
            border: none;
            border-radius: 3px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background: #4cae4c;
        }
    </style>
</head>
<body>
<h1>Thêm sản phẩm mới</h1>
<form method="post" action="/?action=add">
    <label for="brand">Hãng:</label>
    <select id="brand" name="brand" required>
        <c:forEach items="${brands}" var="brand">
            <option value="${brand.id}" >${brand.name}</option>
        </c:forEach>
    </select>

    <label for="model">Tên:</label>
    <input type="text" id="model" name="model" pattern="^^[A-Z][a-zA-Z0-9\s]*$" title="Không bắt đầu bằng kí tự số,không chứa kí tự đặc biệt,chữ đầu in hoa" required>

    <label for="color">Màu:</label>
    <input type="text" id="color" name="color" pattern="^^[A-Z][a-zA-Z0-9\s]*$" title="Không bắt đầu bằng kí tự số,không chứa kí tự đặc biệt,chữ đầu in hoa" required>

    <label for="price">Giá:</label>
    <input type="text" step="0.01" id="price" name="price" pattern="^\d+(\.\d{1,2})?$" title="Bắt đầu bằng số và không kết thúc bằng dấu chấm" required>

    <label for="quality">Chất lượng:</label>
    <input type="text" id="quality" name="quality" pattern="^([1-9][0-9]?|100)$" title="Chất lượng từ 1-100 và không kết thúc bằng dấu chấm" required>

    <input type="submit" value="Thêm sản phẩm">
</form>
</body>
</html>

