<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dabroal
  Date: 16/07/15
  Time: 6:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Satta Live ScoreCard</title>
    <style>


        table {
            width: 100%;
        }

        th {
            height: 50px;
        }
        .MADARCHOD {
            background-color: #CCFFFF;
            color: black;
        }
        .CHUTIYA{
            background-color: #FFFFCC;
            color: black;
        }
    </style>
</head>
<body>
<table>

        <c:forEach items="${liveSattaScore.userWisePerformance}" var="entry">
           <tr class="${entry.value.sattaTeam}"> <td>${entry.key.firstName}: </td>    <td>${entry.value.satteriScore}</td> <td><b>${entry.value.superPlayer.fullName} : ${entry.value.superPlayer.score} </b></td> <c:forEach items="${entry.value.playerScores}" var="playerScore"><td>${playerScore.fullName}: ${playerScore.score}  </td></c:forEach></tr>
        </c:forEach>


</table>

<a href="Ashes2015/pick/save">Make your own picks</a>


<table>
<c:forEach items="${liveSattaScore.teamScores}" var="entry"><tr class="${entry.value}"><td>${entry.key}</td><td>${entry.value}</td></tr></c:forEach>
</table>


</body>
</html>
