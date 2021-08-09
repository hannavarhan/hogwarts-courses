<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<body>

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

<div class="grid-container" style="padding: 30px 0;">
    <form method="POST">
        <div class="grid-x align-center text-center">
            <div>
                <div class="cell small-12 introduction">
                    Name <button class="button newquestion hollow secondary" type="button"
                                 onclick="hideElement('name')" id="hideIntro">Hide</button>
                    <button class="button newquestion hollow secondary" type="submit">Save course</button>
                    <hr>
                </div>
                <input name="name" id="name" type="text" required>
                <div class="cell small-12 introduction">
                    Description <button class="button newquestion hollow secondary" type="button"
                                        onclick="hideElement('description')" id="hideIntro">Hide</button>
                    <hr>
                </div>
                <textarea name="description" id="description" cols="80" rows="7"></textarea>
                <div class="cell small-12 introduction">Difficulty:<select name="difficulty">
                    <option value="HARD">Hard</option>
                    <option value="MEDIUM">Medium</option>
                    <option value="EASY">Easy</option>
                </select></div>
                <div class="introduction cell small-12">Image: <input class="inputq" style="width: 100%;" type="file" id="profile_pic"
                                                                      name="profile_pic" accept=".jpg, .jpeg, .png">
                    <div class="cell small-12 introduction">
                        Introduction <button class="button newquestion hollow secondary" type="button"
                                             onclick="hideElement('intro')" id="hideIntro">Hide</button>
                        <hr>
                    </div>
                    <textarea name="introduction" id="intro" cols="80" rows="7"></textarea>
                    <div class="cell small-12 introduction">
                        Theory <button class="button newquestion hollow secondary" type="button"
                                       onclick="addTheoryBlock()">Add</button>
                        <button class="button newquestion hollow secondary" type="button"
                                onclick="hideElement('theoryHide')">Hide</button>
                    </div>
                    <div id="theoryHide">
                        <div class="cell small-12" id="theories"></div>
                    </div>
                    <div class="cell small-12 introduction">
                        Questions <button onclick="addNewQuestion()" type="button"
                                          class="button newquestion hollow secondary">Add</button>
                        <button onclick="hideElement('questionHide')" type="button"
                                class="button newquestion hollow secondary">Hide</button>
                    </div>
                </div>
                <div id="questionHide">
                    <div class="cell small-12" id="questions"></div>
                </div>
                <div class="cell small-12 introduction">
                    Conclusion <button class="button newquestion hollow secondary" type="button"
                                       onclick="hideElement('conclusion')">Hide</button>
                    <hr>

                </div>
                <div>
                    <textarea name="conclusion" id="conclusion" cols="80" rows="7"></textarea>
                </div>
            </div>
    </form>
</div>

<footer>

    <div style="background-color: white; width: 100%; max-width: 100%;" class="grid-container">
        <hr>
        <div class="grid-x grid-margin-x">
            <div class="cell text-center copyright">@2021 Artuhanau&Co.</div>
        </div>
        <hr style="width: 250%;">
        <div class="grid-x align-center text-center grid-margin-x">
            <div class="cell small-4 telegram">Telegram <a href="#"><img src="img/telegram_icon.svg"
                                                                         width="25px"></a> </div>
            <div class="cell small-4 rights ">All rights reserved.</div>
            <div class="cell small-4">Have a question? You can phone +375 29 784 1845.</div>
        </div>
    </div>
</footer>
</body>
<script>
    function hideElement(name) {
        let introClassList = document.getElementById(name).classList;
        if (introClassList.contains("hidden")) {
            introClassList.remove("hidden")
        } else {
            introClassList.add("hidden")
        }
    }
    function addNewQuestion() {
        let questionId = document.getElementsByClassName('question').length;
        let questionsDiv = document.getElementById("questions")
        questionsDiv.insertAdjacentHTML('afterend', '<textarea class="questtext" id="question' + questionId + '" name="introduction" id="intro" cols="80" rows="2"></textarea>  <div class="cell question small-6">Count questions: <input id="input' + questionId + '" class="inputq" onchange="addVariants(this)" type="numeric" pattern="[1-6]{1}"></div> <div class="cell small-6"></div>')
    }
    function addVariants(input) {
        if (input instanceof HTMLInputElement && input.validity.valid == true) {
            let divs = document.getElementsByClassName('div' + input.id)
            while (divs != null && divs.item(0) != null) {
                divs.item(0).remove()
            }
            for (i = 0; i < input.value; i++) {
                input.insertAdjacentHTML('afterend', '<div class="question align-middle cell small-12 grid-x div' + input.id + '"><div class="cell small-3">Answer</div><div class="cell small-6"><input class="answer" required name="answer' + input.id + '" type="text"></div><div class="cell small-3"><input name="rightanswer' + input.id + '" type="checkbox"></div></div>')
            }
        }
    }
    function addTheoryBlock() {
        let index = document.getElementsByClassName('theorytext').length;
        document.getElementById('theories').insertAdjacentHTML('afterend', '<textarea class="theorytext" id="theory' + index + '"></textarea>')
    }
</script>

</html>