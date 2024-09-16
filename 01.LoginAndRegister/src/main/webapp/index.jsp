<%--
  Created by IntelliJ IDEA.
  User: Raj Yadav
  Date: 16-09-2024
  Time: 07:28 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Save User</h3>
<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
        out.print(msg);
    }
%>
<form action="user" method="post">
    <table>
        <tr>
            <td>UserName:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email"></td>
        </tr>

        <tr>
            <td>Phone:</td>
            <td><input type="number" name="phono"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form>
<a href="user">View Users</a>
</body>
</html>
