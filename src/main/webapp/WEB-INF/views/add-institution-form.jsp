<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Donation form</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>

<header>
    <jsp:include page="admin-header.jsp"/>
</header>


<sec:authorize access="isAuthenticated()">
    <form:form method="post" action="/addNewInstitution" modelAttribute="institution">


        <h2>Dodaj instytucje</h2><br>

        <h1><br><br><br><br><br>
            <label>
                Nazwa:<br>
                <form:input type="text" path="name" name="name"/>
            </label><br><br>
            <label>
                Opis:<br>
                <form:textarea type="text" path="description" name="name" rows="5"/>
            </label><br>


            <div class="form-group form-group--buttons">
                <br>
                <button type="submit" class="btn">Dodaj</button>
            </div>
        </h1>


    </form:form>
</sec:authorize>


<script src="<c:url value="resources/js/app.js"/>"></script>

</body>
</html>