<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="page-header">
    <h1>Choose picks</h1>
</div>
<!--
    If the user is anonymous (not logged in), show the registration form.
-->
<sec:authorize access="isAuthenticated()">
    <div class="panel panel-default">
        <div class="panel-body">
            <!--
                Ensure that when the form is submitted, a POST request is send to url
                '/user/register'.
            -->
            <form:form action="${pageContext.request.contextPath}/pick/save" commandName="pick" method="POST" enctype="utf8" role="form">
                <!-- Add CSRF token to the request. -->
                <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

                <!--
                If the user is using social sign in, add the signInProvider
                as a hidden field.
                -->

                <div class="row">
                    <div id="form-group-pick1" >
                        <label class="control-label" for="pick-pick1">SuperPick: </label>
                        <!--
                            Add the firstName field to the form and ensure
                            that validation errors are shown.
                        -->
                        <form:select id="pick-pick1" path="pick1" >
                            <c:forEach var="player" items="${playersInMatch}">
                                <option value = "${player.playerId}">${player.fullName}</option>
                            </c:forEach>
                        </form:select>


                    </div>
                </div>
                <div class="row">
                    <div id="form-group-pick2" >
                        <label class="control-label" for="pick-pick2">Pick 2: </label>
                        <!--
                            Add the firstName field to the form and ensure
                            that validation errors are shown.
                        -->
                        <form:select id="pick-pick2" path="pick2" >
                            <c:forEach var="player" items="${playersInMatch}">
                                <option value = "${player.playerId}">${player.fullName}</option>
                            </c:forEach>
                        </form:select>


                    </div>
                </div>
                <div class="row">
                    <div id="form-group-pick3" >
                        <label class="control-label" for="pick-pick3">Pick 3: </label>
                        <!--
                            Add the firstName field to the form and ensure
                            that validation errors are shown.
                        -->
                        <form:select id="pick-pick3" path="pick3" >
                            <c:forEach var="player" items="${playersInMatch}">
                                <option value = "${player.playerId}">${player.fullName}</option>
                            </c:forEach>
                        </form:select>


                    </div>
                </div>
                <div class="row">
                    <div id="form-group-pick4" class="form-group col-lg-4">
                        <label class="control-label" for="pick-pick4">Pick 4: </label>
                        <!--
                            Add the firstName field to the form and ensure
                            that validation errors are shown.
                        -->
                        <form:select id="pick-pick4" path="pick4" >
                            <c:forEach var="player" items="${playersInMatch}">
                                <option value = "${player.playerId}">${player.fullName}</option>
                            </c:forEach>
                        </form:select>


                    </div>
                </div>
                <div class="row">
                    <div id="form-group-pick5" class="form-group col-lg-4">
                        <label class="control-label" for="pick-pick5">Pick 5: </label>
                        <!--
                            Add the firstName field to the form and ensure
                            that validation errors are shown.
                        -->
                        <form:select id="pick-pick5" path="pick5" >
                            <c:forEach var="player" items="${playersInMatch}">
                                <option value = "${player.playerId}">${player.fullName}</option>
                            </c:forEach>
                        </form:select>


                    </div>
                </div>
                <div class="row">
                    <div id="form-group-pick6" class="form-group col-lg-4">
                        <label class="control-label" for="pick-pick6">Pick 6: </label>
                        <!--
                            Add the firstName field to the form and ensure
                            that validation errors are shown.
                        -->
                        <form:select id="pick-pick6" path="pick6" >
                            <c:forEach var="player" items="${playersInMatch}">
                                <option value = "${player.playerId}">${player.fullName}</option>
                            </c:forEach>
                        </form:select>


                    </div>
                </div>

                <div class="row">
                    <div id="form-group-team" class="form-group col-lg-4">
                        <label class="control-label" for="pick-pick6">I am a  </label>
                        <!--
                            Add the firstName field to the form and ensure
                            that validation errors are shown.
                        -->
                        <form:select id="pick-team" path="team" >

                                <option value ="CHUTIYA" >CHUTIYA</option>
                                <option value ="MADARCHOD" >MADARCHODS</option>
                            </form:select>
                        </div>


                    </div>
                </div>

                <!-- Add the submit button to the form. -->
                <button type="submit" class="btn btn-default">"label.user.registration.submit.button"</button>
            </form:form>
        </div>
    </div>
</sec:authorize>
<!--
    If the user is authenticated, show a help message instead
    of registration form.
-->
<sec:authorize access="isAnonymous()">
    <p>Login karle Gaandu</p>
</sec:authorize>
</body>
</html>