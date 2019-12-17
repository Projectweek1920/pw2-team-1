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

    <script>
        function showHideVooropleiding() {
            if(document.getElementById('graduaat').checked || document.getElementById('postgraduaat').checked){
                document.getElementById('vooropleiding').style.display='none';
            }
                else{
                document.getElementById('vooropleiding').style.display='block';
            }
            
        }
    </script>
    s
</head>
<body onload="startTime()">

<div id="txt"></div>

<!-- Navigation -->
<%@ include file="components/navigation.jspf" %>

<!-- Page Content -->


<main role="main" class="container">

    <div class="starter-template">
        <h1>Form page</h1>

        <form method="post" action="/Controller?command=Enrol">
            <p>User information:</p>
            <p>
                <label for="firstName">Voornaam:</label>
                <input type="text" value="" name="firstName" id="firstName" required>
            </p>
            <p>
                <label for="lastName">LastName:</label>
                <input type="text" value="" name="lastName" id="lastName" required>
            </p>
            <p>
                <label for="email">Email:</label>
                <input type="text" value="" name="email" id="email" required>
            </p>
            <p>
                <input type="radio" value="FEMALE" name="gender" id="femalegender" required>
                <label for="femalegender">Female</label>
                <input type="radio" value="MALE" name="gender" id="malegender">
                <label for="malegender">Male</label>
            </p>




            <p>Welke opleiding?</p>
            <p>

<<<<<<< HEAD
                <input type="radio" value="graduaat" name="vraag1" id="graduaat" onclick="showHideVooropleiding()">
=======
                <input type="radio" value="graduaat" name="vraag1" id="graduaat" required>
>>>>>>> 7b2317369dd97df167996e4343890800b8f59181
                <label for="graduaat">Bachelor graduaat</label>
                <input type="radio" value="postgraduaat" name="vraag1" id="postgraduaat" onclick="showHideVooropleiding()">
                <label for="postgraduaat">Banaba postgraduaat</label>
                <input type="radio" value="andere" name="vraag1" id="andere" onclick="showHideVooropleiding()">
                <label for="andere">Andere</label>
            </p>

<<<<<<< HEAD
            <fieldset id="vooropleiding">
            <legend>Welke vooropleiding?</legend>

                <input type="radio" value="middelbaar" name="vraag2" id="middelbaar" checked>
=======
            <p>Welke vooropleiding?</p>
            <p>
                <input type="radio" value="middelbaar" name="vraag2" id="middelbaar" required>
>>>>>>> 7b2317369dd97df167996e4343890800b8f59181
                <label for="middelbaar">Middelbaar</label>
                <input type="radio" value="bachelor" name="vraag2" id="bachelor">
                <label for="bachelor">Bachelor/graduaat</label>
                <input type="radio" value="andere" name="vraag2" id="andere1">
                <label for="andere1">Andere</label>

            </fieldset>

            <p>Taal?</p>
            <p>
                <input type="radio" value="NL" name="vraag3" id="NL" required>
                <label for="NL">Nederlands/Vlaams</label>
                <input type="radio" value="andere" name="vraag3" id="andere2">
                <label for="andere2">Andere</label>
            </p>
            <p><input type="submit" value="Send" id="submit"></p>
        </form>

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
