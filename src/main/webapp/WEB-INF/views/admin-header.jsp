<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="container container--70">
    <sec:authorize access="isAuthenticated()">
        <h3><p>Zalogowany jako: <sec:authentication property="principal.username"/></p>
            <p>Posiada role: <sec:authentication property="authorities"/></p></h3>

    </sec:authorize>

    <ul class="nav--actions">

        <li>
            <form action="/logout" method="post">
                <input type="submit" value="Wyloguj">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </li>
    </ul>

    <ul>
        <li><a href="/admin" class="btn btn--without-border active">Start</a></li>
        <li><a href="/users" class="btn btn--without-border">Uzytkownicy</a></li>
        <li><a href="/adminInstitutions" class="btn btn--without-border">Institucje</a></li>
        <li><a href="/addNewInstitution" class="btn btn--without-border">Dodaj institucje</a></li>
    </ul>
</nav>