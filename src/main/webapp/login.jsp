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
    <title>Login</title>
</head>
<body onload="startTime()">

<div id="txt"></div>

<!-- Navigation -->
<%@ include file="components/navigation.jspf" %>

<!-- Page Content -->


<main role="main" class="container">

    <form action="/Controller?command=SignIn" method="POST" novalidate>
        <p>
            <label for="userName">Username:</label>
            <input type="text" value="<c:out value="Admin"></c:out>" name="userName" id="userName">
        </p>
        <p>
            <label for="password">Wachtwoord:</label>
            <input type="password" value="<c:out value=""></c:out>" name="password" id="password">
        </p>
        <p>
            <label for="loket">Loket:</label>
            <input type="loket" value="<c:out value=""></c:out>" name="loket" id="loket">
        </p>
        <p><input type="submit" value="Login" id="submit"></p>
    </form>

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
