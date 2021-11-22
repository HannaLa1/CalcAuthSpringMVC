<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 08.11.2021
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

<c:if test="${sessionScope.user!=null}">
    <h1 style="color: deeppink">Personal account page</h1>

    <br/>
    <a href="<c:url value="/calc"/>">Calculator</a>
    <br/>
    <br/>
    <a href="<c:url value="/logout"/>">Logout</a>
</c:if>

<c:if test="${sessionScope.user==null}">
    <h1 style="color: deeppink">Home Page</h1>

    <br/>
    <a href="<c:url value="/login"/>">LogIn</a>
    <br/>
    <br/>
    <a href="<c:url value="/registration"/>">Registration</a><br>
</c:if>

</body>
</html>
