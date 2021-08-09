<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/foundation.css"/>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined" rel="stylesheet">
    <title></title>
</head>

<body style="background-image: url('../img/pexels-photo-7978770.jpeg');">

<div class="top-bar">
    <div class="top-bar-left">
        <ul class="dropdown menu" data-dropdown-menu>
            <li class="menu-text"><a href="#" class="logo">HogwartS.Online</a></li>
        </ul>
    </div>
    <div class="top-bar-right ">
        <ul class="dropdown middle align-middle menu" data-dropdown-menu>
            <c:url value="/controller?command=go_to_login_page" var="login"/>
            <li class="menu-text"><a href="${login}" class="button">Login</a></li>
            <c:url value="/controller?command=go_to_register_page" var="register"/>
            <li class="menu-text"><a href="${register}" class="button">Register</a></li>
            <li class="menu-text"><a href="?lang=en"><img class="img-flag" src="img/4x3/gb.svg"></a></li>
            <li class="menu-text"><a href="?lang=ru"><img class="img-flag" src="img/4x3/ru.svg"></a></li>
            <li class="menu-text"><a href="?lang=by"><img class="img-flag" src="img/4x3/by.svg"></a></li>
        </ul>
    </div>
</div>

<div class="grid-container" style="height: 100px;"></div>

<div class="grid-container whiteback align-center grid-x" style="border-radius: 10px 10px 0px 0px;">

    <div style="padding-top: 10px;" class="cell align-center"></div>
    <div class="slideshow-container">
        <div class="slide fade">
            <img src="../img/WIZARD SCHOOL.svg" style="width: 900px; height: 240px;" class="slide-img">
            <div class="text">Best teachers</div>
        </div>
        <div class="slide fade">
            <img src="../img/telegram_icon.svg" class="slide-img">
            <div class="text">Caption Two</div>
        </div>
        <div class="slide fade">
            <img src="img/potion.png" class="slide-img">
            <div class="text">Caption Three</div>
        </div>
    </div>
</div>
</div>
<c:forEach var="course" items="${course_list}" begin="0" end="10">
    <div class="grid-container grid-x whiteback ">
        <div class="cell small-12">
            <hr>
        </div>
        <div class="cell small-3"></div>
        <div class="cell small-1">
            <img src="../img/potion.png" width="100"></div>
        <div class="cell small-4">
            <div class="introduction">${course.name}</div>
            <div class="addinf">${course.description}</div>
        </div>
        <div class="cell small-4">
            <div class="rating-text">Rating:</div>
            <div class="rating-mini stars-${course.rating}"></div>
            <div class="cell"><a class="button fuck" href="#">Sign up</a></div>
        </div>
    </div>
</c:forEach>
<div class="grid-container grid-x whiteback ">
    <div class="cell small-12">
        <hr>
    </div>
    <div class="cell small-3"></div>
    <div class="cell small-1"><img src="img/potion.png" width="100"></div>
    <div class="cell small-4">
        <div class="introduction">Курс по зельеварению</div>
        <div class="addinf">Ой, девочки вам не поздоровится... побольше текста надо, а то слишком мало больше</div>
    </div>
    <div class="cell small-4">
        <div class="rating-text">Rating:</div>
        <div class="rating-mini stars-4">
        </div>
        <div class="cell"><a class="button fuck" href="#">Sign up</a></div>
    </div>
</div>
<!--При последнем элементе на странице style="padding-bottom: 20px; border-radius: 0px 0px 10px 10px"-->
<div class="grid-container grid-x whiteback " style="padding-bottom: 40px; border-radius: 0px 0px 10px 10px ;">
    <div class="cell small-12">
        <hr>
    </div>
    <div class="cell small-3"></div>
    <div class="cell small-1"><img src="img/potion.png" width="100"></div>
    <div class="cell small-4">
        <div class="introduction">Курс по зельеварению</div>
        <div class="addinf">Ой, девочки вам не поздоровится... побольше текста надо, а то слишком мало больше</div>
    </div>
    <div class="cell small-4">
        <div class="rating-text">Rating:</div>
        <div class="rating-mini stars-2"></div>
        <div class="cell"><a class="button fuck" href="#">Sign up</a></div>

    </div>

</div>

<div class="grid-container" style="height: 100px;"></div>
<footer>

    <div style="background-color: white; width: 100%; max-width: 100%;" class="grid-container">
        <hr>
        <div class="grid-x grid-margin-x">
            <div class="cell text-center copyright">@2021 Artuhanau&Co.</div>
        </div>
        <hr>
        <div class="grid-x align-center text-center grid-margin-x">
            <div class="cell small-4 telegram">Telegram <a href="https://t.me/hogwarts_notifications"><img
                    src="img/telegram_icon.svg"
                    width="25px"></a></div>
            <div class="cell small-4 rights ">All rights reserved.</div>
            <div class="cell small-4">Have a question? You can phone +375 29 784 1845.</div>
        </div>
    </div>
</footer>
<script>
    var slideIndex = 0;
    showSlides();

    function showSlides() {
        var i;
        var slides = $('.slide')
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        slideIndex++;
        if (slideIndex > slides.length) {
            slideIndex = 1
        }
        slides[slideIndex - 1].style.display = "block";
        setTimeout(showSlides, 2000);
    }

    var maxRating = 5;
    window.onload = function () {
        let ratings = document.getElementsByClassName('rating-mini')
        for (let i = 0; i < ratings.length; i++) {
            let count = getCountStars(ratings[i].classList)
            insertHtml(ratings[i], maxRating - count, '<span class="active material-icons-outlined">grade</span>')
            insertHtml(ratings[i], count, '<span class="active material-icons-outlined">star</span>')
        }
    }

    function getCountStars(classList) {
        if (classList instanceof DOMTokenList) {
            for (let i = 0; i < classList.length; i++) {
                if (/stars-.*/.test(classList[i])) {
                    return Number(classList[i].toString()[classList[i].length - 1])
                }
            }
        }
    }

    function insertHtml(element, count, html) {
        if (element instanceof HTMLElement) {
            for (let i = 0; i < count; i++) {
                element.insertAdjacentHTML('afterbegin', html)
            }
        }
    }

</script>
</body>

</html>