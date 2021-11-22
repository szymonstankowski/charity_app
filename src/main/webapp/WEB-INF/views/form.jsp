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
    <jsp:include page="header.jsp"/>


    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Oddaj rzeczy, których już nie chcesz<br/>
                <span class="uppercase">potrzebującym</span>
            </h1>

            <div class="slogan--steps">
                <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
                <ul class="slogan--steps-boxes">
                    <li>
                        <div><em>1</em><span>Wybierz rzeczy</span></div>
                    </li>
                    <li>
                        <div><em>2</em><span>Spakuj je w worki</span></div>
                    </li>
                    <li>
                        <div><em>3</em><span>Wybierz fundację</span></div>
                    </li>
                    <li>
                        <div><em>4</em><span>Zamów kuriera</span></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>


    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <sec:authorize access="isAuthenticated()">       <!-- STEP 1: class .active is switching steps -->
        <form:form method="post" action="/adddonation" modelAttribute="donation">
        <div data-step="1" class="active">

            <h3>Zaznacz co chcesz oddać:</h3>

            <form:checkboxes path="categories"
                             items="${categories}"
            />


            <div class="form-group form-group--buttons">
                <button type="button" class="btn next-step">Dalej</button>
            </div>
        </div>

        <!-- STEP 2 -->
        <div data-step="2">
            <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

            <div class="form-group form-group--inline">
                <label>
                    Liczba 60l worków:
                    <form:input id="quantity" type="number" name="bags" path="quantity" step="1" min="1"/>

                </label>
            </div>

            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <button type="button" class="btn next-step">Dalej</button>
            </div>
        </div>

        <!-- STEP 4 -->
        <div data-step="3">
            <h3>Wybierz organizacje, której chcesz pomóc:</h3>

            <form:select id="institutionName" path="institution" items="${institutions}"/>

            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <button type="button" class="btn next-step">Dalej</button>
            </div>
        </div>

        <!-- STEP 5 -->
        <div data-step="4">
            <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

            <div class="form-section form-section--columns">
                <div class="form-section--column">
                    <h4>Adres odbioru</h4>
                    <div class="form-group form-group--inline">
                        <label> Ulica <form:input id="street" type="text" path="street"
                                                  name="address"/> </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label> Miasto <form:input id="city" type="text" path="city" name="city"/> </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label>Kod pocztowy <form:input id="zipCode" type="text" path="zipCode"
                                                        name="zipCode"/></label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label>
                            Numer telefonu <input id="phoneNumber" type="phone" name="phone"/>
                        </label>
                    </div>
                </div>

                <div class="form-section--column">
                    <h4>Termin odbioru</h4>
                    <div class="form-group form-group--inline">
                        <label> Data <form:input id="pickUpDate" type="date" path="pickUpDate"/> </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label> Godzina <form:input id="pickUpTime" type="time" path="pickUpTime"
                                                    name="pickUpTime"/> </label>
                    </div>

                    <div class="form-group form-group--inline">
                        <label>
                            Uwagi dla kuriera
                            <form:textarea id="additionalInfo" path="pickUpComment" rows="5"
                                           name="additionalInfo"/>
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <button type="button" class="btn next-step">Dalej</button>
            </div>
        </div>


        <!-- STEP 6 -->
        <div data-step="5">
            <h3>Podsumowanie Twojej darowizny</h3>

            <div class="summary">
                <div class="form-section">
                    <h4>Oddajesz:</h4>
                    <ul>
                        <li>
                            <span class="icon icon-bag"></span>
                            <span class="summary--text" id="quantity-result"></span>
                        </li>

                        <li>
                            <span class="icon icon-hand"></span>
                            <span class="summary--text" id="institutionName-result"></span
                            >
                        </li>
                    </ul>
                </div>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru:</h4>
                        <ul>
                            <li id="street-result"></li>
                            <li id="city-result"></li>
                            <li id="zipCode-result"></li>
                            <li id="phoneNumber-result"></li>
                        </ul>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru:</h4>
                        <ul>
                            <li id="pickUpDate-result"></li>
                            <li id="pickUpTime-result"></li>
                            <li id="additionalInfo-result"></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <button type="submit" class="btn">Potwierdzam</button>
            </div>


        </div>
    </div>
    </form:form>
    </sec:authorize>

</section>

<script src="<c:url value="resources/js/app.js"/>"></script>

</body>
</html>