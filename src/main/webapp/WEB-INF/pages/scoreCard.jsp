<%--
  Created by IntelliJ IDEA.
  User: dabroal
  Date: 09/07/15
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ScoreCard</title>
</head>
<body>
<table>
    <tr>
    <td>Player</td>   <td>score</td>
    </tr>
    <c:forEach var="entry" items="${fantasyScoreCard.playerScores}">
    <tr>
        <td>${entry.value.fullName}</td> <td>${entry.value.score}</td>
    </tr>
    </c:forEach>
</table>
<h3>Chutiyas</h3>
<table>
    <tr>
        <td>Chutiya</td><td>Points</td>
    </tr>
    <c:forEach var="chutiya" items="${chutiyas}">
        <tr>
            <td>${chutiya.name}</td><td>${chutiya.userScore}</td>
        </tr>
    </c:forEach>
</table>

<h3>Madarchod</h3>
<table>
    <tr>
        <td>Madarchod</td><td>Points</td>
    </tr>
    <c:forEach var="madarchod" items="${madarchods}">
        <tr>
            <td>${madarchod.name}</td><td>${madarchod.userScore}</td>
        </tr>
    </c:forEach>
</table>


<div class="facebook">
<script>
    window.fbAsyncInit = function() {
        FB.init({
            appId      : '1506386686291384',
            xfbml      : true,
            version    : 'v2.4'
        });
    };

    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
</script>

<div
        class="fb-like"
        data-share="true"
        data-width="450"
        data-show-faces="true">
</div>

</div>


</body>
</html>
