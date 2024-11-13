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
    <title>Thêm Phòng Trọ Mới</title>
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
        input[type="text"], input[type="tel"], select, input[type="date"] {
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
<h1>Thêm Phòng Trọ Mới</h1>
<form method="post" action="/?action=add">
    <label for="name">Tên Người Thuê Trọ:</label>
    <input type="text" id="name" name="name" pattern="^[A-Z][a-zA-Z\s]*$" title="Chữ đầu in hoa, không chứa ký tự đặc biệt" required>

    <label for="phone">Số Điện Thoại:</label>
    <input type="tel" id="phone" name="phone" pattern="^\d{10}$" title="Số điện thoại phải đủ 10 chữ số" required>

    <label for="startDate">Ngày Bắt Đầu Thuê Trọ:</label>
    <input type="date" id="startDate" name="startDate" required>

    <label for="paymentMethod">Hình Thức Thanh Toán:</label>
    <select id="paymentMethod" name="paymentMethod" required>
        <c:forEach items="${methodList}" var="method">
            <option value="${method.id}">${method.name}</option>
        </c:forEach>
    </select>

    <label for="note">Ghi Chú:</label>
    <input type="text" id="note" name="note" pattern="^[A-Z][a-zA-Z0-9\s]*$" title="Chữ đầu in hoa, không chứa ký tự đặc biệt" required>

    <input type="submit" value="Thêm Phòng Trọ">
</form>
</body>
</html>

