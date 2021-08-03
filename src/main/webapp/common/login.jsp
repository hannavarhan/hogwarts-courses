<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/foundation.css"/>
    <link rel="stylesheet" type="text/css" href="../css/styles.css"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
            <li class="menu-text"><a href="?lang=en"><img class="img-flag" src="../img/4x3/gb.svg"></a></li>
            <li class="menu-text"><a href="?lang=ru"><img class="img-flag" src="../img/4x3/ru.svg"></a></li>
            <li class="menu-text"><a href="?lang=by"><img class="img-flag" src="../img/4x3/by.svg"></a></li>
        </ul>
    </div>
</div>

<div class="grid-container" style="height: 100px;"></div>

<div class="grid-container"
     style="background-color: white; border-radius: 6px ; width: 50%; box-shadow: inset 0 0 30px;">
    <div class="grid-y  align-center  text-center" style="height: 450px;">
        <div class="cell small-1"></div>
        <div class="cell small-2" style="font-family: SofiaProMedium; font-size: 24pt;">Welcome to <span
                style="font-family: Magic School One;">HogwartS.Online</span></div>
        <c:url value="/controller?command=login" var="var"/>
        <form actin="${var} method="POST"/>
        <div class="cell text-left large-offset-1 small-3">
            <label class="login-page">
                Email
                <input style="width: 85%; border-radius: 3px; padding-left: 0;" type="email" id="login" name="login"
                       placeholder="fuckingfoundation@bicthes.com" aria-describedby="loginHelpText">
            </label>
            <c:url value="/controller?command=go_to_register_page" var="login"/>
            <p class="help-text" style="font-family: SofiaProLight;" id="loginHelpText">
                Don't have account? <a href="${register}">Register</a>
            </p>
        </div>
        <div class="cell text-left large-offset-1 small-3">
            <label class="login-page">Password
                <input class="login-input" type="password" id="password"  name="password"aria-describedby="passwordHelpText">
            </label>
            <p class="help-text" style="font-family: SofiaProLight;" id="passwordHelpText">Your password must
                have at least 10 characters, a number.
            </p>
        </div>
        <c:if test="${error}">
            <p class="help-text" style="font-family: SofiaProLight;" id="passwordHelpText2">${error_key}Wrong login and/or password
            </p>
        </c:if>
        <c:if test="${email_not_confirmed}">
            <p class="help-text" style="font-family: SofiaProLight;" id="passwordHelpText3">${error_key}
            </p>
        </c:if>
        <div class="cell text-left large-offset-1 small-1">
            <button class="login button success"
                    style="width: 85%;color: white; margin-bottom: 60px;background-color: #4bb34b; box-shadow: -4px 4px 0 #004220;"
                    type="submit">Login
            </button>
        </div>
        <div class="cell small-2"></div>
        </form>
    </div>
</div>
<div class="grid-container" style="height: 150px;"></div>

<footer>

    <div style="background-color: white; width: 100%; max-width: 100%;" class="grid-container">
        <hr>
        <div class="grid-x grid-margin-x">
            <div class="cell text-center copyright">@2021 Artuhanau&Co.</div>
        </div>
        <hr>
        <div class="grid-x align-center text-center grid-margin-x">
            <div class="cell small-4 telegram">Telegram <a href="#"><img src="../img/telegram_icon.svg"
                                                                         width="25px"></a></div>
            <div class="cell small-4 rights ">All rights reserved.</div>
            <div class="cell small-4">Have a question? You can phone +375 29 784 1845.</div>
        </div>
    </div>
</footer>
</body>

</html>