<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
                <tr class="grid-item">
                    <th class="table-cell">${name}</th>
                </tr>
            </c:forEach>
            <%--<th class="grid-item">4</th>
            <th class="grid-item">5</th>--%>
        </div>
    </div>
    <div class="section">
        <h2 style="margin-right: -1px">In behandeling</h2>
        <div id="In behandeling" class="grid-container">
            <c:forEach var="name" items="${ready}">
                <tr class="grid-item">
                    <th class="table-cell">${name}</th>
                </tr>
            </c:forEach>
            <%--<th class="grid-item">2</th>
            <th class="grid-item">1</th>--%>
        </div>
    </div>
</main>
</body>
<script src="./js/synchron.js"></script>
</html>
