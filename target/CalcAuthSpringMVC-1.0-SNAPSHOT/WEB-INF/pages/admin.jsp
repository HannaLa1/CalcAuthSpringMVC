<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 15.11.2021
  Time: 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Admin Page</title>

    <style>
        table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            font-size: 14px;
            border-collapse: collapse;
            text-align: center;
            margin-right: 200px;
        }

        th, td:first-child {
            background: #fca5cb;
            color: white;
            padding: 5px 20px;
        }
        th, td {
            border-style: solid;
            border-width: 0 1px 1px 0;
            border-color: white;
        }
        td {
            border-color: whitesmoke;
        }
        th:first-child, td:first-child {
            text-align: left;
        }
    </style>
</head>
<body>
    <table align="right">
        <tr>
            <th>Id</th>
            <th>Login</th>
            <th>Password</th>
            <th>Username</th>
            <th>Role</th>
            <th colspan="3">Action</th>
        </tr>

        <c:forEach var="user" items="${sessionScope.userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.userName}</td>
                <td>${user.role}</td>
                <td><a href="<c:url value="/deleteUser/${user.id}"/>">delete</a></td>
                <td><a href="<c:url value="/history/${user.id}"/>">history</a></td>
                <td><a href="<c:url value="/update/${user.id}"/>">update</a></td>
            </tr>
        </c:forEach>
    </table>

    <h1 style="color: deeppink">ADMIN PAGE</h1>
    <h2>List of Users:</h2>
    <br>
    <br>
    <br>

    <a href="<c:url value="/"/>">RETURN TO PERSONAL ACCOUNT PAGE</a>
</body>
</html>
