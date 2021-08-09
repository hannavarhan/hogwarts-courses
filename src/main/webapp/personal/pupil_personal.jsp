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
            <ul class="dropdown middle align-middle menu" data-dropdown-menu>
                <li class="menu-text" style="color: white;">cuteAndrei24</li>
                <li class="menu-text"><a href="#" class="button">Log out</a></li>
                <li class="menu-text"><a onclick="setLang('en')" href="#"><img class="img-flag"
                                                                               src="../img/4x3/gb.svg"></a></li>
                <li class="menu-text"><a onclick="setLang('ru')" href="#"><img class="img-flag"
                                                                               src="../img/4x3/ru.svg"></a></li>
                <li class="menu-text"><a onclick="setLang('by')" href="#"><img class="img-flag"
                                                                               src="../img/4x3/by.svg"></a></li>
            </ul>
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
                <th colspan="2" class="text-center">User:${sessionScope.user.login}</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td colspan="2"><img src="../img/avatar.png"></td>
            </tr>
            <tr>
                <td>User rating</td>
                <td>${sessionScope.user.rating}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${sessionScope.user.name}</td>
            </tr>
            <tr>
                <td>Surname</td>
                <td>${sessionScope.user.surname}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${sessionScope.user.email}</td>
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
                    <select onchange="showCourses(this)">
                        <!--В зависимости от параметра ставь selected в option с данным названием-->
                        <c:choose>
                            <c:when test="${active_course_list}">
                                <option selected value="unfinished">Unfinished</option>
                                <option value="unpatched">Unpatched</option>
                                <option value="finished">Finished</option>
                            </c:when>
                            <c:when test="${finished_course_list}">
                                <option value="unfinished">Unfinished</option>
                                <option value="unpatched">Unpatched</option>
                                <option selected value="finished">Finished</option>
                            </c:when>
                            <c:when test="${all_course_list}">
                                <option value="unfinished">Unfinished</option>
                                <option selected value="unpatched">Unpatched</option>
                                <option value="finished">Finished</option>
                            </c:when>
                        </c:choose>
                    </select>
                </th>
                <th class="text-center">Open</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="course" items="${course_list}" begin="0" end="3">
            <tr>
                <td>${course.name}</td>
                <c:choose>
                    <c:when test="${active_course_list}">
                        <td>
                            <form>
                                <input hidden name="course_id" id="course_to_study_id"
                                       value="${course.entityId}"/>
                                <button class="hollow button edit"
                                        formaction="${pageContext.request.contextPath}/controller?command=go_to_study_course_page"
                                        formmethod="post">Study
                                </button>
                            </form>
                        </td>
                    </c:when>
                    <c:when test="${finished_course_list}">
                        <td>
                            <form>
                                <input hidden name="course_id" id="finished_course_id"
                                       value="${course.entityId}"/>
                                <button class="hollow button edit"
                                        formaction="${pageContext.request.contextPath}/controller?command=go_to_course_page"
                                        formmethod="post">Open
                                </button>
                            </form>
                        </td>
                    </c:when>
                    <c:when test="${all_course_list}">
                        <td>
                            <form>
                                <input hidden name="course_id" id="course_id"
                                       value="${course.entityId}"/>
                                <button class="hollow button edit"
                                        formaction="${pageContext.request.contextPath}/controller?command=go_to_course_page"
                                        formmethod="post">Open
                                </button>
                            </form>
                        </td>
                    </c:when>
                </c:choose>
            </tr>
            </c:forEach>
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
            <div class="cell small-4 telegram">Telegram <a href="#"><img src="../img/telegram_icon.svg"
                                                                         width="25px"></a></div>
            <div class="cell small-4 rights ">All rights reserved.</div>
            <div class="cell small-4">Have a question? You can phone +375 29 784 1845.</div>
        </div>
    </div>
</footer>
<script type="text/javascript">
    function showCourses(select) {
        if (select instanceof HTMLSelectElement) {
            let url = new URL(window.location.href)
            url.searchParams.set("course", select.value)
            window.location.href = url.href
        }
    }

    function setLang(code) {
        let url = new URL(window.location.href)
        url.searchParams.set("lang", code)
        window.location.href = url.href
    }
</script>
</body>

</html>