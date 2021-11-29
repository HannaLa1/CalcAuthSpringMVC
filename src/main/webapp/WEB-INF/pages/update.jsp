<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 17.11.2021
  Time: 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Page</title>
</head>
<body>
<h2 align="center">Change User password page:</h2>

<a href="<c:url value="/admin"/>">RETURN TO ADMIN PAGE</a><br>

<form action="<c:url value="/update/${id}"/>" method="post">
    <table style="background-color: pink; margin-left: 500px; margin-top: 50px">
        <tr>
            <td>
                <h3 style="color: palevioletred;">CHANGE...</h3>
            </td>
            <td></td>
        </tr>

        <tr>
            <td>Password: </td>
            <td><input type="password" name="password" value="${sessionScope.user.password}" required></td>
        </tr>

        <tr>
            <td><input type="submit" name="submit" value="Submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
