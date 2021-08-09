<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/foundation.css" />
    <link rel="stylesheet" type="text/css" href="css/styles.css" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined" rel="stylesheet">
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
            <li class="menu-text"><a href="?lang=en"><img class="img-flag" src="img/4x3/gb.svg"></a></li>
            <li class="menu-text"><a href="?lang=ru"><img class="img-flag" src="img/4x3/ru.svg"></a></li>
            <li class="menu-text"><a href="?lang=by"><img class="img-flag" src="img/4x3/by.svg"></a></li>
        </ul>
    </div>
</div>

<div class="grid-container" style="height: 100px;"></div>

<div class="grid-container"
     style="background-color: white; border-radius: 6px ; width: 50%; box-shadow: inset 0 0 30px;">
    <div class="grid-y  align-center  text-center" style="height: 700px;">
        <form method="POST">
            <div class="cell small-1"></div>
            <div class="cell introduction small-1">
                Your result is 234/23443
            </div>
            <div class="cell small-4"
                 style="font-family: 'SofiaProLight'; font-size: 16pt; text-align: left; padding: 0 10%; cursor:default;">
                Lorem
                ipsum dolor sit, amet
                consectetur adipisicing elit. Laboriosam quam delectus eos vitae quisquam maiores, sint perspiciatis
                maxime. Incidunt deleniti ad natus voluptatum architecto porro neque dicta itaque molestias
                eveniet?Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus voluptas, modi eos animi
                quaerat alias soluta voluptatibus odio esse, totam sed, fugiat blanditiis accusantium doloremque.
                Soluta
                velit deleniti consequuntur quasi!
            </div>
            <div class="cell introduction small-1">
                Rating
                <input type="hidden" id="mark" name="mark" value="0">
                <div class="rating-mini">
						<span class="active material-icons-outlined">
							star
						</span>
                    <span class="active material-icons-outlined">
							grade
						</span>
                    <span class="active material-icons-outlined">
							grade
						</span>
                    <span class="active material-icons-outlined">
							grade
						</span>
                    <span class="active material-icons-outlined">
							grade
						</span>
                </div>
            </div>
            <div class="cell introduction small-1">
                Write your review about our course:
            </div>

            <div class="cell grid-x align-center text-center"><textarea cols="60" style="width: 90%;"
                                                                        rows="7"></textarea></div>

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
            <div class="cell small-4 telegram">Telegram <a href="#"><img src="img/telegram_icon.svg"
                                                                         width="25px"></a> </div>
            <div class="cell small-4 rights ">All rights reserved.</div>
            <div class="cell small-4">Have a question? You can phone +375 29 784 1845.</div>
        </div>
    </div>
</footer>
<script>
    window.onload = function () {
        let stars = document.getElementsByClassName('active')
        for (let i = 0; i < stars.length; i++) {
            let element = stars.item(i);
            if (element instanceof HTMLSpanElement) {
                element.onclick = selectStar
            }
        }
    }
    function selectStar(event) {
        if (event instanceof Event) {
            let star = event.srcElement
            let stars = document.getElementsByClassName('active')
            let hiddenInput = document.getElementById('mark')
            j = 0
            isMeet = false
            for (let i = 0; i < stars.length; i++) {
                if (star != stars[i] && !isMeet) {
                    j++
                }
                if (star == stars[i]) {
                    isMeet = true
                }
                if (i <= j) {
                    stars[i].innerText = "star"
                } else {
                    stars[i].innerHTML = "grade"
                }
            }
            if (hiddenInput instanceof HTMLInputElement) {
                hiddenInput.value = j + 1
            }
        }
    }
</script>
</body>

</html>