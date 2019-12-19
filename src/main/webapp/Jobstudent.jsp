<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <jsp:include page="./components/stylesheets.jsp">
        <jsp:param name="" value=""/>
    </jsp:include>
    <title>Behandel Student (Jobstudent)</title>
    <script>
        function pauze() {
            document.getElementById('pauzeKnop').style.display = 'none';
            document.getElementById('studentInfo').style.display = 'none';
        }

        function next() {
            document.getElementById('pauzeKnop').style.display = 'block';
            document.getElementById('studentInfo').style.display = 'block';    //Als je de studentInfo wil terug tonen, toont die niks, die doet dat dus automatisch?
        }
    </script>
</head>
<body>

<!-- Navigation -->
<%@ include file="components/navigation.jspf" %>

<!-- Page Content -->

<main role="main" class="container">
<article>
    <div class="starter-template">
        <h1> Behandel student</h1>
        <div>
            <div id="studentInfo">
                <p><c:out value="${assignedUser.firstName} ${assignedUser.lastName}"></c:out></p>
                <p><c:out value="${assignedUser.userId}"></c:out></p>
            </div>
        </div>
        <jsp:include page="userButtons.jsp">
            <jsp:param name="" value=""/>
        </jsp:include>
        <%--<c:if test="${!markedAsComplex}">
            <form action="Controller?command=ToComplex&userid=${assignedUser.userId}" method="post">
                <input type="button" value="Markeer als complex">
            </form>
        </c:if>--%>
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
