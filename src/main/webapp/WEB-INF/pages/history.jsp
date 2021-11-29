<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 15.11.2021
  Time: 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>History Page</title>

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
    <h2 style="color: deeppink">List of operations</h2><br>

    <a href="<c:url value="/admin"/>">RETURN TO ADMIN PAGE</a>
    <br><br>

    <table>
        <tr>
            <th>Operation Id</th>
            <th>User Id</th>
            <th>Number 1</th>
            <th>Operation</th>
            <th>Number 2</th>
            <th>Result</th>
        </tr>

        <c:forEach var="operation" items="${operations}">
            <tr>
                <td>${operation.id}</td>
                <td>${operation.userId}</td>
                <td>${operation.num1}</td>
                <td>${operation.typeOfOperation}</td>
                <td>${operation.num2}</td>
                <td>${operation.result}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
