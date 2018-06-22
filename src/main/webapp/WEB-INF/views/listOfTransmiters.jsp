<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->

    <script type="text/javascript">

        function newLocation() {
            window.location = '/deleteSpecificTransmiter/?id=' + id;
        }


    </script>

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
                <li><a href="/login">Zaloguj</a></li>
                <li><a href="/add">Dodaj Transmiter</a></li>
                <li><a href="/deleteTransmiter">Usun Transmiter</a></li>
                <li class="active"><a href="/getAll">Lista Transmiterow</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <div class="starter-template">


        <table class="table">
            <thead>
            <tr>
                <th scope="id">id</th>
                <th scope="Nazwa">Nazwa</th>
                <th scope="Cena">Cena</th>
                <th scope="Power">Power</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${transmiterList}" var="transmiter">
                <tr>
                    <td><c:out value="${transmiter.id}"/></td>
                    <td><c:out value="${transmiter.name}"/></td>
                    <td><c:out value="${transmiter.price}"/></td>
                    <td><c:out value="${transmiter.power}"/></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>