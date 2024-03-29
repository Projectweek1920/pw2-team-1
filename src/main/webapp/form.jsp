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
    <title>New enrolment</title>

    <script>
        function showHideVooropleiding() {
            if (document.getElementById('graduaat').checked || document.getElementById('postgraduaat').checked) {
                document.getElementById('vooropleiding').style.display = 'none';
            } else {
                document.getElementById('vooropleiding').style.display = 'block';
            }

        }
    </script>
</head>
<body onload="startTime()">


<!-- Navigation -->
<%@ include file="components/navigation.jspf" %>

<!-- Page Content -->


<main role="main" class="container">
    <article>
        <div class="starter-template">
            <p id="done" style="display: ${submitted eq 'block' ? 'block' : 'none'}">Your information has been
                submitted.</p>
            <h1>New enrolment</h1>

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

            <form method="post" action="/Controller?command=Enrol">
                <p>Please input your information.</p>
                <p>
                    <label for="firstName">First Name:</label>
                    <input type="text" value="<c:out value="${firstNamePV}"></c:out>" name="firstName" id="firstName">
                </p>
                <p>
                    <label for="lastName">Last Name:</label>
                    <input type="text" value="<c:out value="${lastNamePV}"></c:out>" name="lastName" id="lastName">
                </p>
                <p>
                    <label for="email">Email:</label>
                    <input type="text" value="<c:out value="${emailPV}"></c:out>" name="email" id="email">
                </p>

                <h2 style="margin: 10px; font-size: 125%">What will you be studying?</h2>
                <ul class="radio-menu-item">
                <li><input type="radio" value="graduaat" name="vraag1" id="graduaat"
                           onclick="showHideVooropleiding()" ${graduaatPV}>
                    <label for="graduaat">Bachelor or graduate</label></li>
                <li><input type="radio" value="postgraduaat" name="vraag1" id="postgraduaat"
                           onclick="showHideVooropleiding()" ${postgraduaatPV}>
                    <label for="postgraduaat">Banaba or post-graduate</label></li>
                <li><input type="radio" value="andereOPO" name="vraag1" id="andere"
                           onclick="showHideVooropleiding()" ${andereOPOPV}>
                    <label for="andere">Other</label></li>
                </ul>

                <fieldset id="vooropleiding">
                    <h2 style="margin: 10px; font-size: 125%"><legend>What is your previous education?</legend></h2>
                    <ul class="radio-menu-item">
                        <li><input type="radio" value="middelbaar" name="vraag2" id="middelbaar" ${middelbaarPV}>
                        <label for="middelbaar">High School</label></li>
                        <li><input type="radio" value="bachelor" name="vraag2" id="bachelor" ${bachelorPV}>
                        <label for="bachelor">Bachelor or graduate</label></li>
                        <li><input type="radio" value="andereVOPO" name="vraag2" id="andere1" ${andereOPOPV}>
                        <label for="andere1">Other</label></li>
                    </ul>
                </fieldset>

                <h2 style="margin: 10px; font-size: 125%">Language of degree?</h2>
                <ul class="radio-menu-item">
                    <li> <input type="radio" value="NL" name="vraag3" id="NL" ${NLPV}>
                    <label for="NL">Dutch</label></li>
                    <li> <input type="radio" value="andereT" name="vraag3" id="andere2" ${andereTPV}>
                    <label for="andere2">Other</label></li>
                </ul>
                <h2 style="margin: 10px; font-size: 125%">Extra questions?</h2>
                <ul class="radio-menu-item">
                    <li><input type="radio" value="YES" name="vraag4" id="YES" ${YESPV}>
                    <label for="YES">Yes</label></li>
                    <li><input type="radio" value="NO" name="vraag4" id="NO" ${NOPV}>
                    <label for="NO">No</label></li>
                </ul>
                <p><input type="submit" value="Send" id="submit" style="margin-top: 10px"></p>
            </form>

        </div>
    </article>
</main>
<!-- Footer -->
<!-- Optional JavaScript -->
<!-- jQuery first, then Bootstrap JS -->
<script>
    function clearForm() {
        document.getElementById("myForm").reset();
    }
</script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
</body>
</html>
