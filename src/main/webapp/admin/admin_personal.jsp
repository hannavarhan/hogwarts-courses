<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/foundation.css" />
    <link rel="stylesheet" type="text/css" href="../css/styles.css" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
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
        style="background-color: white; border-radius: 6px ; width: 85%; box-shadow: inset 0 0 30px;">
        <div class="grid-x">
            <div class="cell small-12 text-center" style="font-family: SofiaProMedium; padding: 30px 0; font-size: 24pt;"> Hello, Admin!!
            </div>
            <div class="cell small-1"></div>
            <div class="cell small-10">
                <table class="text-center" style="border-radius: 3px;">
                    <thead>
                        <tr>
                            <th class="text-center">Firstname</th>
                            <th class="text-center">Lastname</th>
                            <th class="text-center">Edit</th>
                            <th class="text-center">Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="professor" items="${professor_list}" begin="0" end="3">
                        <tr>
                            <%--<p hidden id="professor_id">${professor.entityId}</p>--%>
                            <td>${professor.name}</td>
                            <td>${professor.surname}</td>
                            <c:url value="/controller?command=go_to_edit_professor_page" var="edit_professor"/>
                            <td><form><input hidden name="professor_id" id="professor_to_edit_id" value="${professor.entityId}"/>
                                <button class="hollow button edit" formaction="${pageContext.request.contextPath}/controller?command=go_to_edit_professor_page"
                                        formmethod="post">Edit</button></form></td>
                            <td><form><input hidden name="professor_id" id="professor_id" value="${professor.entityId}"/>
                                <button class="hollow button alert" formaction="${pageContext.request.contextPath}/controller?command=delete_professor"
                            formmethod="post">Delete</button></form></td>
                        </tr>
                    </c:forEach>
                        <tr>
                            <c:url value="/controller?command=go_to_register_professor_page" var="register_professor"/>
                            <td class="text-center" colspan="4"><button class="hollow button success"><a href="${register_professor}">Add new teacher</a></button></td>
                        </tr>
                    </tbody>
                </table>
            </div>
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
                <div class="cell small-4 telegram">Telegram <a href="#"><img src="../img/telegram_icon.svg"
                            width="25px"></a> </div>
                <div class="cell small-4 rights ">All rights reserved.</div>
                <div class="cell small-4">Have a question? You can phone +375 29 784 1845.</div>
            </div>
        </div>
    </footer>
</body>

</html>