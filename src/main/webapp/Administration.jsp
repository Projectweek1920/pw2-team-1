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
    <title>All users</title>
</head>
<body onload="startTime()">

<div id="txt"></div>
<script>
    function pauze() {
        document.getElementById('pauzeKnop').style.display='none';
        document.getElementById('studentInfo').style.display='none';
    }

    function next() {
        document.getElementById('pauzeKnop').style.display='block';
        document.getElementById('studentInfo').style.display='block';
    }
</script>

<!-- Navigation -->
<%@ include file="components/navigation.jspf" %>

<!-- Page Content -->


<main role="main" class="container">

    <div class="starter-template">
        <h1>Behandel student (Expert)</h1>

    </div>
    <div>
        <form action="/Controller?command=PickNext" method="POST">
            <label for="simpel">Student:</label>
            <input type="submit" value="SIMPEL" name="student" id="simpel">
            <label for="moeilijk">Student:</label>
            <input type="submit" value="MOEILIJK" name="student" id="moeilijk">
            <button type="button" id="pauzeKnop" onclick="pauze()">Pauze</button>
        </form>
        <div id="studentInfo">
            <p><c:out value="${JobStudent.firstName} ${JobStudent.lastName}"></c:out></p>
            <p><c:out value="${JobStudent.userId}"></c:out></p>
        </div>
    </div>
    <c:choose>
        <c:when test="${users == null || users == []}">
            <p>Er zijn nog geen tickets aangemaakt.</p>
        </c:when>
        <c:otherwise>
            <table class="table">
                <caption>Studentenlijst</caption>
                <thead>
                <tr>
                    <th scope="col">Volgnummer</th>
                    <th scope="col">Voornaam</th>
                    <th scope="col">Achternaam</th>
                    <th scope="col">Email</th>
                    <th scope="col">Complexiteit</th>
                    <th scope="col">Tijd van inschrijven</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <th><c:out value="${user.userId}"></c:out> </th>
                        <th><c:out value="${user.getFirstNamee()}"></c:out> </th>
                        <th><c:out value="${user.getLastNamee()}"></c:out></th>
                        <th><c:out value="${user.getEmaile()}"></c:out> </th>
                        <th><c:out value="${user.isDifficult()}"></c:out> </th>
                        <th><c:out value="${user.tijdVanInschrijving}"></c:out> </th>
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
<script>
    function startTime() {
        var today = new Date();
        var h = today.getHours();
        var m = today.getMinutes();
        var s = today.getSeconds();
        m = checkTime(m);
        s = checkTime(s);
        document.getElementById('txt').innerHTML =
            h + ":" + m + ":" + s;
        var t = setTimeout(startTime, 500);
    }
    function checkTime(i) {
        if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
        return i;
    }
</script>
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
