<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Header -->
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="./components/stylesheets.jsp">
        <jsp:param name="" value=""/>
    </jsp:include>
    <title>Administratie</title>
</head>
<body>

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
<article style="text-align: center">
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
            <p><c:out value="${assignedUser.firstName} ${assignedUser.lastName}"></c:out></p>
            <p><c:out value="${assignedUser.userId}"></c:out></p>
        </div>
    </div>
    <div style="margin: auto">
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
