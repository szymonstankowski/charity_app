<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="container container--70">
    <sec:authorize access="isAuthenticated()">
        <h3><p>Zalogowany jako: <sec:authentication property="principal.username"/></p>
            <p>Posiada role: <sec:authentication property="authorities"/></p></h3>
        <a href="/donation" class="btn btn--without-border active">Oddaj dary</a>
        <a href="/userdonations" class="btn btn--without-border active">Moje donacje</a>
    </sec:authorize>

    <ul class="nav--actions">
        <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
        <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        <li>
            <form action="/logout" method="post">
                <input type="submit" value="Wyloguj">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </li>
    </ul>

    <ul>
        <li><a href="/" class="btn btn--without-border active">Start</a></li>
        <li><a href="/about" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="/aboutUs" class="btn btn--without-border">O nas</a></li>
        <li><a href="/institutions" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <li><a href="/contact" class="btn btn--without-border">Kontakt</a></li>
    </ul>

<%--        <sec:authorize access="isAnonymous()">--%>
<%--            <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>--%>
<%--            <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>--%>
<%--        </sec:authorize>--%>
</nav>