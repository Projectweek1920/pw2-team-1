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
    <title>Welkom op ons ticketing system!</title>
</head>
<body onload="startTime()">

<div id="txt"></div>

<!-- Navigation -->
<%@ include file="components/navigation.jspf" %>

<!-- Page Content -->


<main role="main" class="container">
    <div class="starter-template">
        <c:if test = "${worker.getRole()=='ADMIN' || worker.getRole()=='JOBSTUDENT' || worker.getRole()=='EXPERT'}">
            <h1>${worker.getRole()} , u zit in loket ${worker.getLoket()}!</h1>
        </c:if>

        <c:if test = "${worker.getRole()!='ADMIN' || worker.getRole()!='JOBSTUDENT' || worker.getRole()!='EXPERT'}">
            <h1>Welkom op ons ticketing system!</h1>
        </c:if>
        <p class="lead">U bent op de startpagina, klik <a href="Controller?command=Form">hier</a> voor het inschrijvingsformulier.</p>
        <p>Klik <a href="Controller?command=Queue">hier</a> voor het wachtscherm.</p>
        <p>
            <button><a href="Controller?command=Queue" class="button">Wachtscherm</a></button>
<c:if test = "${worker.getRole()=='ADMIN' || worker.getRole()=='EXPERT'}">
            <button><a href="Controller?command=ShowAdministration" type="button" class="button">Toon medewerkers</a></button>
</c:if>
            <button><a href="Controller?command=Form" type="button" class="button">Inschrijvingsformulier</a></button>
        </p>
    </div>

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
        if (i < 10) {
            i = "0" + i
        }
        ;  // add zero in front of numbers < 10
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
