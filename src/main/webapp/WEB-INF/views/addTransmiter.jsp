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
                <li class="active"><a href="/add">Dodaj Transmiter</a></li>
                <li><a href="/deleteTransmiter">Usun Transmiter</a></li>
                <li><a href="/getAll">Lista Transmiterow</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <h2>Dodaj transmiter</h2>
    <form action="/addSuccess" method="post">
        <div class="form-group">
            <label for="name">Nazwa:</label>
            <input type="text" class="form-control" id="name" placeholder="Podaj nazwe" name="name">
        </div>
        <div class="form-group">
            <label for="price">Cena:</label>
            <input type="text" class="form-control" id="price" placeholder="Podaj cene" name="price">
        </div>
        <div class="form-group">
            <label for="power">Moc:</label>
            <input type="text" class="form-control" id="power" placeholder="Podaj moc" name="power">
        </div>
        <button type="submit" class="btn btn-default">Dodaj</button>
    </form>
</div>


<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
