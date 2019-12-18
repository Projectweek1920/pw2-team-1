<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 16/12/2019
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Auto refresh -->
    <meta http-equiv="refresh" content="5"/>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Aleo&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./static/css/style.css">
    <link rel="stylesheet" href="./static/css/reset.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wachtlijst</title>
</head>
<body>
<main class="grid-container" style="display: grid;
    grid-template-columns: 50% 50%;">
    <div class="section">
        <h2 style="margin-right: -1px">Wachtrij</h2>
        <div id="Wachtrij" class="grid-container">
            <c:forEach var="name" items="${names}">
                <div class="table-cell"><p style="font-weight: bolder"><c:out value="${name}"></c:out></p></div>
            </c:forEach>
            <%--<th class="grid-item">4</th>
            <th class="grid-item">5</th>--%>
        </div>
    </div>
    <div class="section">
        <h2 style="margin-right: -1px">In behandeling</h2>
        <div id="In behandeling" class="grid-container">
            <c:forEach var="user" items="${ready}">
                <div class="table-cell">
                    <p style="font-weight: bolder"><c:out value="${user.firstName} ${fn:substring(user.lastName,0,0)}."></c:out>> </p>
                </div>
                <div class="table-cell">
                    <p style="font-weight: bolder"><c:out value="${user.loket}"></c:out></p>
                </div>
            </c:forEach>
            <%--<th class="grid-item">2</th>
            <th class="grid-item">1</th>--%>
        </div>
    </div>
</main>
<a class="link" href="/Controller?command=Home">Terug</a>
</body>
<script src="./js/synchron.js"></script>
</html>
