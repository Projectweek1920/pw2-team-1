<%--
  Created by IntelliJ IDEA.
  User: Familie Skovdal
  Date: 19/12/2019
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Submitted</title>
</head>
<body>
    <h1>Your information has been submitted. Please wait in the lounge.</h1>
    <h1>Click on the button below if the next page doesn't load within 5 seconds</h1>
    <script>
        setTimeout(function(){
            window.location.href = "Controller?command=Form";
        }, 4500);
    </script>
    <form method="post" action="Controller?command=Form">
        <button type="submit">Back to form!</button>
    </form>
</body>
</html>
