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
		<div class="grid-y  align-center  text-center" style="height: 800px;">
			<div class="cell large-offset-2 small-2" style="width: 75%; font-family: Molot; font-size: 18pt;">
				Lands to the peasants, factories to the workers, Magic to the magls with
				<span style="font-family: Magic School One; font-weight: bold; font-size: 30pt;">HogwartS.Online</span>
			</div>
			<form method="POST">
				<div class="cell text-left large-offset-1 small-1">
					<label class="login-page">
						Email
						<input style="width: 85%; border-radius: 3px; padding-left: 0;" type="email" required
							placeholder="fuckingfoundation@bicthes.com" aria-describedby="loginHelpText">
					</label>
					<p class="help-text" style="font-family: SofiaProLight;" id="loginHelpText">
						Have account? <a href="#">Sing in</a>
					</p>
				</div>
				<div class="cell text-left large-offset-1 small-1">

					<div class="grid-x">
						<div class="small-4 cell">
							<label class="login-page">Name
								<input style=" border-radius: 3px;" type="text" required pattern="[A-z]+" minlength="2">
							</label>
						</div>
						<div class="small-2"></div>
						<div class="small-4 cell">
							<label class="login-page">Surname
								<input style=" border-radius: 3px;" type="text" required pattern="[A-z]+" minlength="2">
							</label>
						</div>
						<div class="small-2"></div>
					</div>

				</div>
				<div class="cell text-left large-offset-1 small-1">
					<label class="login-page">Password
						<input class="login-input" id="password" required minlength="10" type="password"
							aria-describedby="passwordHelpText">
					</label>
					<p class="help-text" style="font-family: SofiaProLight;" id="passwordHelpText">Your password must
						have at least 10 characters, a number.
					</p>
				</div>
				<div class="cell text-left large-offset-1 small-1">
					<label class="login-page" id="repeatpassword">Repeat password
						<input class="login-input" required minlength="10" type="password">
					</label>
				</div>
				<div class="cell text-left large-offset-1 small-1">
					<label class="login-page">About
						<textarea style="border-radius: 3px; width: 85%;"></textarea>
					</label>
				</div>
				<div class="cell text-left large-offset-1 small-1">
					<button class="login button success"
						style="width: 85%;color: white; margin-bottom: 60px;background-color: #4bb34b; box-shadow: -4px 4px 0 #004220;"
						type="submit">Register</button>
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
<script>
	
</script>

</html>