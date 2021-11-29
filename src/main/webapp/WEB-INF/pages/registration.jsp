<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 06.10.2021
  Time: 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1 align="center">Authorization Page:</h1>
<h2 align="center" style="color: deeppink">${msg}</h2>
<h2 align="center" style="color: deeppink">${mess}</h2>

<a href="<c:url value="/"/>">BACK</a><br>

<form action="<c:url value="/registration"/>" name="user" method="post">
    <table style="background-color: pink; margin-left: 500px; margin-top: 50px">
        <tr>
            <td>
                <h3 style="color: palevioletred;">REGISTRATION FORM...</h3>
            </td>
            <td></td>
        </tr>

        <tr>
            <td>Login: </td>
            <td><input type="text" name="login" value="${sessionScope.user.login}" required></td>
        </tr>

        <tr>
            <td>Password: </td>
            <td><input type="password" name="password" value="${sessionScope.user.password}" required></td>
        </tr>

        <tr>
            <td>UserName: </td>
            <td><input type="text" name="userName" value="${sessionScope.user.userName}" required></td>
        </tr>

        <tr>
            <td><input type="submit" name="submit" value="registr"></td>
        </tr>
    </table>

    <p><spring:hasBindErrors name="user">
    <h2>Error caused!</h2>
        <c:forEach var="error" items="${errors.allErrors}">
            <b><spring:message message="${error}"/></b>
            <br/>
            <br/>
        </c:forEach>
    </spring:hasBindErrors></p>
</form>
</body>
</html>
