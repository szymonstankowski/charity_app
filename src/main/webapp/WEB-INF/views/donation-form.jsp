<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>

    <form action="form-confirmation.html" method="post">


</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="footer.jsp" %>

  <form:form method="post" action="/addDonation" modelAttribute="donation">
  Kategoria: <form:checkboxes multiple="true" path="categories" items="${categories}" itemValue="id" itemLabel="name"/>
  Instytucja: <form:select multiple="false" path="institutions" items="${institutions}" itemValue="id" itemLabel="name"/>

  Kod pocztowy: <form:input path="zipCode"/><br/>
  Ulica: <form:input path="street"/><br/>
  Miasto: <form:input path="city"/><br/>
  Ilosc: <form:input path="quantity"/><br/>
  Informacje o odbiorze: <form:textarea path="pickUpComment"/><br/>
  Data odbioru: <form:input type="date" path="pickUpDate"/><br/>
  Godzina odbioru: <form:input type="time" path="pickUpTime"/><br/>
  <input type="submit" value="Dodaj"><br/>

  </form:form>

</body>

