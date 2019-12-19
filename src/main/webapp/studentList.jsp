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
    <title>Overzicht Medewerkers</title>
</head>
<body>

<!-- Navigation -->
<%@ include file="components/navigation.jspf" %>

<!-- Page Content -->


<main role="main" class="container">
    <article>
        <div class="starter-template">
            <h1>Overzicht Medewerkers</h1>
        </div>
        <div style="text-align: center">
            <c:choose>
                <c:when test="${students == null || students == []}">
                    <p>U hebt momenteel geen medewerkers. Voeg er enkele toe.</p>
                </c:when>
                <c:otherwise>
                    <table class="table">
                        <tr>
                            <th scope="col">Username</th>
                            <th scope="col">name</th>
                            <th scope="col">Achternaam</th>
                            <th scope="col">Role</th>
                        </tr>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <th><c:out value="${student.getUserName()}"></c:out></th>
                                <th><c:out value="${student.getFirstName()}"></c:out></th>
                                <th><c:out value="${student.getLastName()}"></c:out></th>
                                <th><c:out value="${student.getRole()}"></c:out></th>
                            </tr>
                        </c:forEach>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </article>
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
</body>
</html>