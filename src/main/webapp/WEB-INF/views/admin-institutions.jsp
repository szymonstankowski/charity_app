<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <jsp:include page="admin-header.jsp"/>
</header>


<body>
<div class="stats--item">
    <ul class="help--slides-items">

        <c:forEach items="${institutions}" var="institution">

            <li>
                <div class="col">
                    <a href="/disableInstitution/${institution.id}" class="btn btn--small btn--highlighted">Disable</a><br>
                    <a href="/enableInstitution/${institution.id}" class="btn btn--small btn--highlighted">Enable</a><br>
                    <h3>
                        <div class="title">${institution.name}</div>
                        <div class="subtitle">Email: ${institution.description}</div>
                        <div class="subtitle">Active?: ${institution.active}</div>
                    </h3>
                </div>
            </li>

        </c:forEach>
    </ul>
</div>
</body>


<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
