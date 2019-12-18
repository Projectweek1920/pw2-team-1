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

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="/static/css/style.css" rel="stylesheet">
    <title>Overzicht Medewerkers</title>
</head>
<body>

<!-- Navigation -->
<%@ include file="components/navigation.jspf" %>

<!-- Page Content -->


<main role="main" class="container">

    <div class="starter-template">
        <h1>Overzicht Medewerkers</h1>

    </div>
    <c:choose>
        <c:when test="${students == null || students == []}">
            <p>U hebt momenteel geen medewerkers. Voeg er enkele toe.</p>
        </c:when>
        <c:otherwise>
            <table class="table">
                <caption>Medewerkers</caption>
                <thead>
                <tr>
                    <th scope="col">#</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <th><c:out value="${student.toShowString()}"></c:out>
                            <c:if test = "${worker.getRole()=='ADMIN'}">
                                <form method="post" action="Controller?command=ChangeRole" novalidate>
                                    <input type="radio" name="role" value="JOBSTUDENT" id="jobstudent">
                                    <label for="jobstudent">Jobstudent</label>
                                    <input type="radio" name="role" value="EXPERT" id="expert">
                                    <label for="expert">Expert</label>
                                    <input type="radio" name="role" value="ADMIN" id="admin">
                                    <label for="admin">Admin</label>
                                    <p><label for="worker"></label><input type="hidden" id="worker" name="worker" value="<c:out value="${student.userName}"></c:out>"></p>
                                    <input type="submit" value="save">
                                </form>
                            </c:if>
                        </th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>



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