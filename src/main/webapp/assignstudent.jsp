<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Header -->
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <jsp:include page="./components/stylesheets.jsp">
        <jsp:param name="" value=""/>
    </jsp:include>
    <title>Administratieve medewerkers toevoegen</title>
</head>
<body>

<!-- Navigation -->
<%@ include file="components/navigation.jspf" %>

<!-- Page Content -->


<main role="main" class="container">

    <div class="starter-template">
        <h1>Nieuwe administratieve medewerker</h1>
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
                <label for="userName">StudentenNummer:</label>
                <input type="text" value="<c:out value="${userNamePV}"></c:out>" name="userName" id="userName">
            </p>
            <p>
                <label for="firstName">Voornaam:</label>
                <input type="text" value="<c:out value="${firstNamePV}"></c:out>" name="firstName" id="firstName">
            </p>
            <p>
                <label for="lastName">Achternaam:</label>
                <input type="text" value="<c:out value="${lastNamePV}"></c:out>" name="lastName" id="lastName">
            </p>
            <p>
                <label for="email">Email:</label>
                <input type="text" value="<c:out value="${emailPV}"></c:out>" name="email" id="email">
            </p>
            <p>
                <input type="radio" value="JOBSTUDENT" name="worker" id="jobStudent" ${jobstudentPV}>
                <label for="jobStudent">JobStudent</label>
                <input type="radio" value="EXPERT" name="worker" id="expert" ${expertPV}>
                <label for="expert">Expert</label>
                <input type="radio" value="ADMIN" name="worker" id="admin" ${adminPV}>
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
