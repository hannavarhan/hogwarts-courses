<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/foundation.css" />
	<link rel="stylesheet" type="text/css" href="css/styles.css" />
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
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

<div class="grid-container">
	<div class="whiteback align-center grid-x" style="border-radius: 10px 10px 0px 0px;">

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
</div>
<div class="grid-container">
	<div class="whiteback grid-x">
		<div style="background-color: transparent;" class="small-2"></div>
		<div class="small-8">
			<div class="grid-x align-middle align-center">
					<c:forEach var="course" items="${course_list}" begin="0" end="3">
				<div class="grid-y">
					<div class="small-1">
						<hr style="width: 85%;">
					</div>
					<div class="grid-x align-center-middle" style="height: 100px;">
						<div class="small-1"></div>
						<div class="cell small-2"><img src="img/potion.png" width="72"></div>
						<div class="cell small-6">
							<div class="grid-y grid-margin-y " style="height: 150px;">
									<div class="cell small-4 coursename">${course.name}</div>
									<div class="cell shrink addinf">${course.description}</div>
							</div>
						</div>
						<div class="cell small-1"></div>
						<div class="cell small-2">
							<div class="grid-y grid-margin-y" style="height: 150px;">
								<div class="cell rating-text align-center small-1">Rating:</div>
								<div class="cell small-1">
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
								<div class="cell"><a class="button fuck" href="#">Sign up</a></div>
							</div>
						</div>
					</div>
					<div class="small-1">
						<hr style="width: 85%;">
					</div>
				</div>
					</c:forEach>

			</div>
		</div>
		<div style="background-color: transparent;" class="small-2"></div>
	</div>
</div>


<footer>

	<div style="background-color: white; width: 100%; max-width: 100%;" class="grid-container">
		<hr>
		<div class="grid-x grid-margin-x">
			<div class="cell text-center copyright">@2021 Artuhanau&Co.</div>
		</div>
		<hr>
		<div class="grid-x align-center text-center grid-margin-x">
				<div class="cell small-4 telegram">Telegram <a href="https://t.me/hogwarts_notifications"><img src="img/telegram_icon.svg"
																		 width="25px"></a> </div>
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
		if (slideIndex > slides.length) { slideIndex = 1 }
		slides[slideIndex - 1].style.display = "block";
		setTimeout(showSlides, 2000);
	}

</script>
</body>

</html>