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
    <title>About</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
<header>
 <jsp:include page="header.jsp"/>
</header>

<section class="stats">
    <div class="container container--85">
        <div class="stats--item">
            <em>${donations}</em>

            <h3>Oddanych worków</h3>


            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                tempora!</p>
        </div>

        <div class="stats--item">
            <em>${itemsSum}</em>
            <h3>Przekazanych darów</h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                quam.</p>
        </div>

    </div>
</section>

<section class="steps">
    <h2>Wystarczą 4 proste kroki</h2>

    <div class="steps--container">
        <div class="steps--item">
            <img src="<c:url value="resources/images/icon-hands.png"/>"/>

            <h3>Wybierz rzeczy</h3>
            <p>ubrania, zabawki, sprzęt i inne</p>
        </div>
        <div class="steps--item">
            <img src="<c:url value="resources/images/icon-arrow.png"/>"/>
            <h3>Spakuj je</h3>
            <p>skorzystaj z worków na śmieci</p>
        </div>
        <div class="steps--item">
            <img src="<c:url value="resources/images/icon-glasses.png"/>"/>
            <h3>Zdecyduj komu chcesz pomóc</h3>
            <p>wybierz zaufane miejsce</p>
        </div>
        <div class="steps--item">
            <img src="<c:url value="resources/images/icon-courier.png"/>"/>
            <h3>Zamów kuriera</h3>
            <p>kurier przyjedzie w dogodnym terminie</p>
        </div>
    </div>

    <a href="/register" class="btn btn--large">Załóż konto</a>
</section>
    <h2>Komu pomagamy?</h2>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
            Możesz sprawdzić czym się zajmują.</p>


        <ul class="help--slides-items">
            <c:forEach items="${institutions}" var ="user" step="2" varStatus="loopStatus">
                <li>
                    <div class="col">
                        <div class="title">Fundacja "${user.name}"</div>
                        <div class="subtitle">Cel i misja: "${user.description}"</div>
                    </div>

                    <div class="col">
                        <div class="title">Fundacja "${institutions[loopStatus.index+1].name}"</div>
                        <div class="subtitle">Cel i misja: "${institutions[loopStatus.index+1].description}"</div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>

</section>
<footer>
    <jsp:include page="footer.jsp"/>
</footer>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
