<!DOCTYPE html>
<%@ page session="true" %>
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

    <style>
        body {
            background: #eee url(http://subtlepatterns.com/patterns/sativa.png);
        }

        html, body {
            position: relative;
            height: 100%;
        }

        .login-container {
            position: relative;
            width: 300px;
            margin: 80px auto;
            padding: 20px 40px 40px;
            text-align: center;
            background: #fff;
            border: 1px solid #ccc;
        }

        #output {
            position: absolute;
            width: 300px;
            top: -75px;
            left: 0;
            color: #fff;
        }

        #output.alert-success {
            background: rgb(25, 204, 25);
        }

        #output.alert-danger {
            background: rgb(228, 105, 105);
        }

        .login-container::before, .login-container::after {
            content: "";
            position: absolute;
            width: 100%;
            height: 100%;
            top: 3.5px;
            left: 0;
            background: #fff;
            z-index: -1;
            -webkit-transform: rotateZ(4deg);
            -moz-transform: rotateZ(4deg);
            -ms-transform: rotateZ(4deg);
            border: 1px solid #ccc;

        }

        .login-container::after {
            top: 5px;
            z-index: -2;
            -webkit-transform: rotateZ(-2deg);
            -moz-transform: rotateZ(-2deg);
            -ms-transform: rotateZ(-2deg);

        }

        .avatar {
            width: 100px;
            height: 100px;
            margin: 10px auto 30px;
            border-radius: 100%;
            border: 2px solid #aaa;
            background-size: cover;
        }

        .form-box input {
            width: 100%;
            padding: 10px;
            text-align: center;
            height: 40px;
            border: 1px solid #ccc;;
            background: #fafafa;
            transition: 0.2s ease-in-out;

        }

        .form-box input:focus {
            outline: 0;
            background: #eee;
        }

        .form-box input[type="text"] {
            border-radius: 5px 5px 0 0;
            text-transform: lowercase;
        }

        .form-box input[type="password"] {
            border-radius: 0 0 5px 5px;
            border-top: 0;
        }

        .form-box button.login {
            margin-top: 15px;
            padding: 10px 20px;
        }

        .animated {
            -webkit-animation-duration: 1s;
            animation-duration: 1s;
            -webkit-animation-fill-mode: both;
            animation-fill-mode: both;
        }

        @-webkit-keyframes fadeInUp {
            0% {
                opacity: 0;
                -webkit-transform: translateY(20px);
                transform: translateY(20px);
            }

            100% {
                opacity: 1;
                -webkit-transform: translateY(0);
                transform: translateY(0);
            }
        }

        @keyframes fadeInUp {
            0% {
                opacity: 0;
                -webkit-transform: translateY(20px);
                -ms-transform: translateY(20px);
                transform: translateY(20px);
            }

            100% {
                opacity: 1;
                -webkit-transform: translateY(0);
                -ms-transform: translateY(0);
                transform: translateY(0);
            }
        }

        .fadeInUp {
            -webkit-animation-name: fadeInUp;
            animation-name: fadeInUp;
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
                        <li><a href="/add">Dodaj Transmiter</a></li>
                        <li><a href="/deleteTransmiter">Usun Transmiter</a></li>
                        <li><a href="/getAll">Lista Transmiterow</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="active"><a href="/login">Zaloguj</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>


<div class="container">


    <div class="login-container">
        <div class="avatar"></div>
        <div class="form-box">
            <form method="post">
                <input type="text" name="name"/>
                <input type="password" name="password"/>
                <button class="btn btn-info btn-block login" type="submit">Zaloguj</button>
            </form>
        </div>
    </div>

</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>

