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
    <title>Welkom op ons ticketing system!</title>
</head>
<body>


<!-- Navigation -->
<%@ include file="components/navigation.jspf" %>

<!-- Page Content -->


<main role="main" class="container">
    <article>
        <c:if test = "${worker.getRole()=='ADMIN'}">
            <h1>${worker.getRole()}!</h1>
        </c:if>
        <c:if test = "${worker.getRole()=='JOBSTUDENT' || worker.getRole()=='EXPERT'}">
            <h1>${worker.getRole()} , u zit in loket ${worker.getLoket()}!</h1>
        </c:if>

        <c:if test = "${worker.getRole()!='ADMIN' || worker.getRole()!='JOBSTUDENT' || worker.getRole()!='EXPERT'}">
            <h1>Welkom op ons ticketing system!</h1>
        </c:if>
        <c:choose>
            <c:when test="${worker.getRole()=='EXPERT'}">
            </c:when>
            <c:otherwise>
                <p class="lead">U bent op de startpagina.</p>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${worker.getRole()=='EXPERT' || worker.getRole()=='ADMIN'}">
            </c:when>
            <c:otherwise>
                <p>Klik op de knoppen om naar het wachtscherm of naar het inschrijvingsformulier te gaan.</p>
            </c:otherwise>
        </c:choose>
        <p>
<c:if test = "${worker.getRole()=='ADMIN'}">
            <p><a href="Controller?command=ShowAdministration" class="button">Toon medewerkers</a></p>
</c:if>
    <c:choose>
    <c:when test="${worker.getRole()=='EXPERT' || worker.getRole()=='ADMIN'}">
    </c:when>
    <c:otherwise>
        <p><a href="Controller?command=Queue" class="button">Wachtscherm</a></p>
        </c:otherwise>
        </c:choose>
            <c:choose>
                <c:when test="${worker.getRole()=='EXPERT'}">
                </c:when>
                <c:otherwise>
                    <p><a href="Controller?command=Form" class="button">Inschrijvingsformulier</a></p>
                </c:otherwise>
            </c:choose>
        </p>
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
