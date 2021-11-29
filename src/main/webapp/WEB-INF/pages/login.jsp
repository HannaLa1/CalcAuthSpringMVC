<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 06.10.2021
  Time: 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1 align="center">Authorization Page:</h1>

    <a href="<c:url value="/"/>">BACK</a><br>

    <form action="<c:url value="/login"/>" name="user" method="post">
        <table style="background-color: pink; margin-left: 500px; margin-top: 50px">
            <tr>
                <td>
                    <h3 style="color: palevioletred;">${successMessage}</h3>
                </td>
                <td></td>
            </tr>

            <tr>
                <td>
                    <h3 style="color: palevioletred;">LOGIN...</h3>
                </td>
                <td></td>
            </tr>

            <tr>
                <td>Login: </td>
                <td><input type="text" name="login" required></td>
            </tr>

            <tr>
                <td>Password: </td>
                <td><input type="password" name="password" required></td>
            </tr>

            <tr>
                <td><input type="submit" name="submit" value="logIn"></td>
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