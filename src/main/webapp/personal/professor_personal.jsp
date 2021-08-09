<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/foundation.css" />
    <link rel="stylesheet" type="text/css" href="css/styles.css" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title></title>
</head>

<body style="background-image: url('img/pexels-photo-7978770.jpeg');">

<div class="top-bar">
    <div class="top-bar-left">
        <ul class="dropdown menu" data-dropdown-menu>
            <li class="menu-text"><a href="#" class="logo">HogwartS.Online</a></li>
        </ul>
    </div>
    <div class="top-bar-right ">
        <ul class="dropdown middle align-middle menu" data-dropdown-menu>
            <li class="menu-text" style="color: white;">cuteAndrei24</li>
            <li class="menu-text"><a href="#" class="button">Log out</a></li>
            <li class="menu-text"><a onclick="setLang('en')" href="#"><img class="img-flag"
                                                                           src="img/4x3/gb.svg"></a></li>
            <li class="menu-text"><a onclick="setLang('ru')" href="#"><img class="img-flag"
                                                                           src="img/4x3/ru.svg"></a></li>
            <li class="menu-text"><a onclick="setLang('by')" href="#"><img class="img-flag"
                                                                           src="img/4x3/by.svg"></a></li>
        </ul>
    </div>
</div>

<div class="grid-container" style="height: 100px;"></div>

<div class="grid-container grid-x"
     style="background-color: white; border-radius: 6px ; box-shadow: inset 0 0 30px; padding: 40px 0;">

    <div class="cell small-3">

        <table class="text-center usertable" style="border-radius: 3px; margin: 0 40px;">
            <thead>
            <tr>
                <th colspan="2" class="text-center">User:${username}</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td colspan="2"><img src="img/avatar.png"> </td>
            </tr>
            <tr>
                <td>User rating</td>
                <td>5.0</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>Hanna</td>
            </tr>
            <tr>
                <td>Surname</td>
                <td>Hanna</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>hanna@gmail.com</td>
            </tr>

            </tbody>
        </table>
    </div>
    <div class="small-1"></div>
    <div class="cell small-7">
        <table class="text-center usertable" style="border-radius: 3px;">
            <thead>
            <tr>
                <th class="text-center">Coursename
                </th>
                <th class="text-center">Delete</th>
                <th class="text-center">Open</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Hanna</td>
                <td><button class="hollow alert button edit" href="#">Delete</button></td>
                <td><button class="hollow button edit" href="#">Open</button></td>
            </tr>
            <tr>
                <td>Hanna</td>
                <td>Vorgan</td>
                <td><button class="hollow button edit" href="#">Edit</button></td>
            </tr>
            <tr>
                <td>Hanna</td>
                <td>Vorgan</td>
                <td><button class="hollow button edit" href="#">Edit</button></td>
            </tr>
            <tr>
                <td>Hanna</td>
                <td>Vorgan</td>
                <td><button class="hollow button edit" href="#">Edit</button></td>

            </tr>
            <tr>
                <td>Hanna</td>
                <td>Vorgan</td>
                <td><button class="hollow button edit" href="#">Edit</button></td>
            </tr>
            <tr>
                <td>Hanna</td>
                <td>Vorgan</td>
                <td><button class="hollow button edit" href="#">Edit</button></td>
            </tr>
            <tr>
                <td>Hanna</td>
                <td>Vorgan</td>
                <td><button class="hollow button edit" href="#">Edit</button></td>
            </tr>
            <tr>
                <td>Hanna</td>
                <td>Vorgan</td>
                <td><button class="hollow button edit" href="#">Edit</button></td>
            </tr>
            </tbody>
        </table>

        <div class="cell small-1"></div>
        <div class="cell small-12" style="height: 25px;"></div>
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
            <div class="cell small-4 telegram">Telegram <a href="#"><img src="img/telegram_icon.svg"
                                                                         width="25px"></a> </div>
            <div class="cell small-4 rights ">All rights reserved.</div>
            <div class="cell small-4">Have a question? You can phone +375 29 784 1845.</div>
        </div>
    </div>
</footer>
<script type="text/javascript">
    function setLang(code) {
        let url = new URL(window.location.href)
        url.searchParams.set("lang", code)
        window.location.href = url.href
    }
</script>
</body>

</html>