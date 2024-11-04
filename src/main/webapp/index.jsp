<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.example.demo5.Iphone" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

</h1>
<br/>
<a href="">Danh sách Iphone </a>
<br>

<a href="/?action=AndroidList">Danh sách Android</a>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Hãng</th>
        <th>Tên</th>
        <th>Màu</th>
        <th>Giá</th>
        <th>Chất lượng</th>
        <th>Vùng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${IphoneList}" var="p" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${p.brand}</td>
            <td>${p.model}</td>
            <td>${p.color}</td>
            <td>${p.price}</td>
            <td>${p.quality}</td>
            <td>${p.nation}</td>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>