<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 03.11.2021
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Calculator Page</title>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">--%>

    <style>
        table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            font-size: 14px;
            border-collapse: collapse;
            text-align: center;
            margin-right: 80px;
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
            <th>User Id</th>
            <th>Operation Id</th>
            <th>Number 1</th>
            <th>Operation</th>
            <th>Number 2</th>
            <th>Result</th>
            <th>Action</th>
        </tr>

        <c:forEach var="operation" items="${operationList}">
            <tr>
                <td>${sessionScope.user.id}</td>
                <td>${operation.id}</td>
                <td>${operation.num1}</td>
                <td>${operation.typeOfOperation}</td>
                <td>${operation.num2}</td>
                <td>${operation.result}</td>
                <td><a href="<c:url value="/delete/${operation.id}"/>">delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <h1 style="color: deeppink">Authorization done successfully!!!</h1>
    <h3 style="color: deeppink">Welcome, ${sessionScope.user.userName}!</h3>
    <br/>

    <h2>Calculator Page</h2>

    <form action="<c:url value="/calc"/>" method="post">
        <p><input type="number" name="num1" placeholder="value 1..." required></p>
        <p><input type="number" name="num2" placeholder="value 2..." required/></p>
        <br/>
        <p>Number of operations: </p>
        <input type="submit" name="submit" value="+"/>
        <input type="submit" name="submit" value="-"/>
        <input type="submit" name="submit" value="*"/>
        <input type="submit" name="submit" value="/"/>
        <br/>
        <h2>The result of operation is: ${result}</h2>
        <h2>USER ID: ${sessionScope.user.id}</h2>
    </form>

    <br/>
    <a href="<c:url value="/"/>">RETURN TO PERSONAL ACCOUNT PAGE</a>

<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>--%>
</body>
</html>
