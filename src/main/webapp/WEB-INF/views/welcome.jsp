<!DOCTYPE html>
<%@ page session="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
    <c:url value="" var="jstlCss"/>
    <link href="${jstlCss}" rel="stylesheet"/>


    <style>
        body {
            background: #eee url(http://subtlepatterns.com/patterns/sativa.png);
        }

        html, body {
            position: relative;
            height: 100%;
        }
    </style>

</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/hello">Home</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <c:choose>
                    <c:when test="${sessionScope.size() > 0}">
                        <li><a href="/logout">Wyloguj</a></li>
                        <li class="active"><a href="/add">Dodaj Transmiter</a></li>
                        <li><a href="/deleteTransmiter">Usun Transmiter</a></li>
                        <li><a href="/getAll">Lista Transmiterow</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/login">Zaloguj</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <div class="starter-template">
        <h1>Spring Boot Web JSP Example</h1>
        <h2>Strina startowa, witaj! <c:out value="${sessionScope.name}"/></h2>
    </div>



</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>