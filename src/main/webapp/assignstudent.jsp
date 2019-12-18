<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Header -->
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="/static/css/style.css" rel="stylesheet">
    <title>All users</title>
</head>
<body>

<!-- Navigation -->
<%@ include file="components/navigation.jspf" %>

<!-- Page Content -->


<main role="main" class="container">

    <div class="starter-template">
        <h1>Form page</h1>
        <c:choose>
            <c:when test="${errors==null}">
                <div>

                </div>
            </c:when>
            <c:otherwise>
                <div class="alert-danger">
                    <ul>
                        <li>${errors}</li>
                    </ul>
                </div>
            </c:otherwise>
        </c:choose>

        <form method="post" action="/Controller?command=Assignstudent" novalidate>
            <p>User information:</p>
            <p>
                <label for="userName">Username:</label>
                <input type="text" value="${fn:escapeXml(userNamePV)}" name="userName" id="userName">
            </p>
            <p>
                <label for="firstName">Voornaam:</label>
                <input type="text" value="${fn:escapeXml(firstNamePV)}" name="firstName" id="firstName">
            </p>
            <p>
                <label for="lastName">LastName:</label>
                <input type="text" value="${fn:escapeXml(lastNamePV)}" name="lastName" id="lastName">
            </p>
            <p>
                <label for="email">Email:</label>
                <input type="text" value="${fn:escapeXml(emailPV)}" name="email" id="email">
            </p>
            <p>
                <input type="radio" value="FEMALE" name="gender" id="femalegender">
                <label for="femalegender">Female</label>
                <input type="radio" value="MALE" name="gender" id="malegender">
                <label for="malegender">Male</label>
            </p>
            <p>
                <input type="radio" value="JOBSTUDENT" name="worker" id="jobStudent">
                <label for="jobStudent">JobStudent</label>
                <input type="radio" value="EXPERT" name="worker" id="expert">
                <label for="expert">Expert</label>
                <input type="radio" value="ADMIN" name="worker" id="admin">
                <label for="admin">Admin</label>
            </p>
            <p><input type="submit" value="Send" id="submit"></p>
        </form>

    </div>

</main>
<!-- Footer -->
<!-- Optional JavaScript -->
<!-- jQuery first, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>
