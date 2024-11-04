<%--
  Created by IntelliJ IDEA.
  User: nhoki
  Date: 11/4/2024
  Time: 5:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a>Danh sách Android</a>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Hãng</th>
        <th>Tên</th>
        <th>Màu</th>
        <th>Giá</th>
        <th>Chất lượng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${AndroidList}" var="p" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${p.brand}</td>
            <td>${p.model}</td>
            <td>${p.color}</td>
            <td>${p.price}</td>
            <td>${p.quality}</td>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
