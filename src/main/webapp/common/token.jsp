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

<body style="background-image: url('img/pexels-photo-7978770.jpeg');">

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
		<div class="cell small-2" style="font-family: SofiaProMedium; font-size: 24pt;">Thanks for registration on
			<span style="font-family: Magic School One;">HogwartS.Online</span>
		</div>
		<div class="cell small-3" style="font-family: 'SofiaProMedium'; font-size: 18pt;">
			Please, confirm your email ${email.name} to start magic studying with HogwartS.Online
		</div>
		<form method="POST" action="${pageContext.request.contextPath}/controller?command=verify_token">
		<div class="cell">

			<div class="cell small-7">
				<label for="token" style="font-family: 'SofiaProMedium'; font-size: 18pt; padding: 0 0 20px 0;">
					Input token code:
					<input id="token" name="token" class="inputq" style="width: 50%;" required placeholder="CuteAndrei">
				</label>
			</div>
			<c:if test="${error}">
				<p class="help-text" style="font-family: SofiaProLight;" id="passwordHelpText2">${error_key}Wrong login and/or password
				</p>
			</c:if>

			<button type="submit" style="font-family: 'SofiaProMedium'; font-size: 18pt; " class="button secondary hollow newquestion">Confirm</button>

		</div>
		</form>
	</div>
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

</html>