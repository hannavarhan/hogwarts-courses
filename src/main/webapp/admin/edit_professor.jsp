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
     style="background-color: white; border-radius: 6px ; width: 50%; box-shadow: inset 0 0 30px;">
   <div class="grid-y  align-center  text-center" style="height: 800px; margin: 10px 0;">
      <form method="POST" action="${pageContext.request.contextPath}/controller?command=edit_professor">
         <input hidden name="professor_id" id="professor_id" value="${professor.entityId}"/>
         <input hidden name="professor_old_login" id="professor_old_login" value="${professor.login}"/>
         <div class="cell text-left large-offset-1 small-1">
            <div class="grid-x">
               <div class="small-4 cell">
                  <label class="login-page">
                     Teacher email
                     <input style="border-radius: 3px; padding-left: 0;" type="text" required value="${professor.email}" id="email" name="email"
                            aria-describedby="loginHelpText">
                  </label>
               </div>
               <div class="small-2"></div>
               <div class="small-4 cell">
                  <label class="login-page">Login
                     <input style=" border-radius: 3px;" type="text" required id="login" name="login" value="${professor.login}" pattern="[A-z]+([A-z]|[0-9])*">
                  </label>
               </div>
               <div class="small-2"></div>
            </div>
         </div>
         <div class="cell text-left large-offset-1 small-1">

            <div class="grid-x">
               <div class="small-4 cell">
                  <label class="login-page">Teacher firstname:
                     <input style=" border-radius: 3px;" type="text" required id="user_name" name="user_name" value="${professor.name}" pattern="([A-z]|[А-я])+" minlength="2">
                  </label>
               </div>
               <div class="small-2"></div>
               <div class="small-4 cell">
                  <label class="login-page">Teacher lastname:
                     <input style=" border-radius: 3px;" type="text" required id="user_surname" name="user_surname" value="${professor.surname}" pattern="([A-z]|[А-я])+" minlength="2">
                  </label>
               </div>
               <div class="small-2"></div>
            </div>

         </div>
         <div class="cell text-left large-offset-1 small-1">
            <div class="grid-x">
               <div class="small-10 cell">
                  <label class="login-page">Password
                     <input class="login-input" id="password" required minlength="10" type="password" name="password"
                            value="${professor.password}" aria-describedby="passwordHelpText">
                  </label>
                  <p class="help-text" style="font-family: SofiaProLight;" id="passwordHelpText">Your password
                     must
                     have at least 10 characters, a number.
                  </p>
               </div>
               <div class="small-2"></div>
            </div>
         </div>
         <div class="cell text-left large-offset-1 small-1">
            <div class="grid-x">
               <div class="small-10 cell">
                  <label class="login-page">Repeat password
                     <input class="login-input" id="repeat_password" required minlength="10" type="password" name="repeat_password"
                            value="${professor.password}">
                  </label>
               </div>
               <div class="small-2"></div>
            </div>
         </div>
         <div class="cell text-left large-offset-1 small-1">
            <div class="grid-x">
               <div class="small-10 cell">
                  <label class="login-page">About
                     <textarea id="about" name="about" style="border-radius: 3px;">${professor.about}</textarea>
                  </label>
               </div>
               <div class="small-2"></div>
            </div>
         </div>
         <div class="cell text-left large-offset-1 small-1">
            <div class="grid-x">
               <div class="small-10 cell">
                  <button class="login button success"
                          style="width: 100%;color: white; margin-bottom: 60px;background-color: #4bb34b; box-shadow: -4px 4px 0 #004220;"
                          type="submit">Register</button>
               </div>
               <div class="small-2"></div>
            </div>
         </div>
         <div class="cell small-1"></div>
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
                                                                      width="25px"></a> </div>
         <div class="cell small-4 rights ">All rights reserved.</div>
         <div class="cell small-4">Have a question? You can phone +375 29 784 1845.</div>
      </div>
   </div>
</footer>
</body>

<script type="text/javascript">
   function checkPassword() {
      var password = document.getElementById("password");
      var repeatPassword = document.getElementById("repeat_password")
      if (password.value != repeatPassword.value) {
         repeatPassword.setCustomValidity("Passwords must be equals!")
      } else {
         repeatPassword.setCustomValidity("")
      }
   }
   window.onload = function () {
      document.getElementById("repeat_password").addEventListener('change', checkPassword, false)
   }

</script>

</html>