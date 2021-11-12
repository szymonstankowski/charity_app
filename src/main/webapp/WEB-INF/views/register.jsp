<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="/login">Zaloguj</a></li>
            <li class="highlighted"><a href="/register">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="/about" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="/aboutUs" class="btn btn--without-border">O nas</a></li>
            <li><a href="/institutions" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="/contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>


</header>

<section class="login-page">
    <h2>Załóż konto</h2>

    <form method="post" action="/registerNewUser" modelAttribute="user"/>

    <div class="form-group">
        <input type="name" path="name" name="username" placeholder="Username"/>
    </div>
    <div class="form-group">
        <input type="email" path="email" name="email" placeholder="Email"/>
    </div>
    <div class="form-group">
        <input type="password" id="password" path="password" name="password" placeholder="Password" required/>
    </div>
    <div class="form-group">
        <input type="password" id="password2" name="password2" placeholder="Repeat password" required/>
    </div>

    <div class="form-group form-group--buttons">
        <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
        <button class="btn" type="submit">Załóż konto</button>
    </div>
    <form/>
</section>

<script src="resources/js/app.js"/>
</script>


</body>

</html>
