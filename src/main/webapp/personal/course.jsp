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
            <li class="menu-text" style="color: white;">cuteAndrei24</li>
            <li class="menu-text"><a href="#" class="button">Log out</a></li>
            <li class="menu-text"><a href="?lang=en"><img class="img-flag" src="img/4x3/gb.svg"></a></li>
            <li class="menu-text"><a href="?lang=ru"><img class="img-flag" src="img/4x3/ru.svg"></a></li>
            <li class="menu-text"><a href="?lang=by"><img class="img-flag" src="img/4x3/by.svg"></a></li>
        </ul>
    </div>
</div>


<div class="grid-container" style="height: 100px;"></div>

<div class="grid-container grid-x"
     style="background-color: white; border-radius: 6px ; box-shadow: inset 0 0 30px; padding: 50px 0;">

    <div class="cell small-3"><img style="padding: 20px;" src="img/potion.png"></div>
    <div class="cell small-9">
        <div class="grid-y" style="height: 300px;">
            <div class="cell coursename small-2">Course name</div>
            <div class="cell rating-mini small-2 rating-text" style="padding: 0%;"> Rating:
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
                <button class="button success " disabled
                        style="font-size: 18px;
                    font-family: 'CurcumRegular';margin-left: 50%; background-color: #04AA6D; color: white; padding: 15px;">Start
                    course</button>
            </div>
            <div class="coursename cell small-1" style="font-size: 16pt;" style="padding-bottom: 15px;">Difficulty:
                Hard</div>
            <div class="cell small-1"></div>
            <div class="coursename cell small-1">Description</div>
            <div class="cell small-1"></div>
            <div class="addinf cell small-3" style="padding-right: 50px;">Lorem ipsum dolor sit, amet consectetur
                adipisicing
                elit. Repellendus, quia architecto eum consequuntur ex pariatur dolores, porro perspiciatis tenetur
                voluptas magni labore minima esse ducimus quam! Consectetur eius nemo voluptatem!
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Sapiente porro deleniti ut. Dolore sequi ad
                impedit corrupti eos inventore maxime ipsam facere, voluptatum deserunt suscipit numquam vero, error
                reiciendis at?
            </div>
        </div>

    </div>
    <div class="grid-x" style="width: 100%;">
        <div class="cell small-9"></div>
        <div class="cell small-2">
        </div>
    </div>
    <div class="cell small-12 introduction">Comments: ${Comments.count}<button
            onclick="hideElementsByClass('comments')" type="button"
            class="button newquestion hollow secondary">Hide</button></div>
    <div style="margin: 15px 0;" class="cell small-12 comments grid-x">
        <div class="cell small-3 grid-y" style="text-align: end; padding-right: 20px;">
            <div class="cell">cuteAndrei24</div>
            <div class="cell rating-mini small-2 rating-text" style="padding: 0%;text-align: end; ">
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
        <div class="cell comment small-8">Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita fuga
            sapiente
            eius nam nisi, nihil similique error eum, at voluptates iure commodi ea iusto recusandae ratione quia
            labore accusamus. Nemo?</div>
    </div>
    <div style="margin: 15px 0;" class="cell small-12 comments grid-x">
        <div class="cell small-3  grid-y" style="text-align: end; padding-right: 20px;">
            <div class="cell">cuteAndrei24</div>
            <div class="cell rating-mini small-2 rating-text" style="padding: 0%;text-align: end; ">
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
        <div class="cell comment small-8">Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita fuga
            sapiente
            eius nam nisi, nihil similique error eum, at voluptates iure commodi ea iusto recusandae ratione quia
            labore accusamus. Nemo?</div>
    </div>
    <div style="margin: 15px 0;" class="cell small-12 comments grid-x">
        <div class="cell small-3 grid-y" style="text-align: end; padding-right: 20px;">
            <div class="cell">cuteAndrei24</div>
            <div class="cell rating-mini small-2 rating-text" style="padding: 0%;text-align: end; ">
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
        <div class="cell comment small-8">Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita fuga
            sapiente Lorem ipsum dolor sit amet consectetur, adipisicing elit. Unde quasi laboriosam illum, optio
            sunt modi iusto molestiae, assumenda totam possimus atque! Ducimus ut amet aut, autem qui ad voluptatum
            possimus?
            eius nam nisi, nihil similique error eum, at voluptates iure commodi ea iusto recusandae ratione quia
            labore accusamus. Nemo?</div>
    </div>
    <div style="margin: 15px 0;" class="cell small-12 comments grid-x">
        <div class="cell small-3 grid-y" style="text-align: end; padding-right: 20px;">
            <div class="cell">cuteAndrei24</div>
            <div class="cell rating-mini small-2 rating-text" style="padding: 0%;text-align: end; ">
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
        <div class="cell comment small-8">Lorem ipsum dolor sit amet consectetur adipisicing elit. Expedita fuga
            sapiente Lorem ipsum, dolor sit amet consectetur adipisicing elit. Cumque delectus ducimus aperiam sunt
            fugit doloremque commodi, placeat, provident, deleniti consequatur possimus nostrum dolores ipsam
            tempore laudantium aliquam ut ex nam!
            eius nam nisi, nihil similique error eum, at voluptates iure commodi ea iusto recusandae ratione quia
            labore accusamus. Nemo?</div>
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
    function hideElementsByClass(name) {
        let collections = document.getElementsByClassName(name);
        i = 0
        while (collections.item(i) != null) {
            if (collections.item(i).classList.contains("hidden")) {
                collections.item(i).classList.remove("hidden")
            } else {
                collections.item(i).classList.add("hidden")
            }
            i++;
        }
    }
</script>
</body>

</html>