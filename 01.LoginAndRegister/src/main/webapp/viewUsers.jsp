<%--
  Created by IntelliJ IDEA.
  User: Raj Yadav
  Date: 16-09-2024
  Time: 12:43 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">Add New User</a>
<table border="1">
    <thead>
    <tr>
        <td>S.No</td>
        <td>Name</td>
        <td>Email</td>
        <td>PhoneNo</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user" varStatus="index">
        <tr>
            <td>${index.count}</td>
            <td>${user.userName}</td>
            <td>${user.userEmail}</td>
            <td>${user.userPhono}</td>
            <td>
                <a href="#">EDIT</a>&nbsp
                <a href="#">DELETE</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>