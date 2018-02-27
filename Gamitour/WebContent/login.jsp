<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assets/css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link
	href="https://fonts.googleapis.com/css?family=Oswald|Ubuntu|Neucha"
	rel="stylesheet">
<title>Página de login</title>
</head>
<body id="todoLogin">

	<form id="loginForm" method="post" action="BuscarAdmin.do">

		<p id="loginTitle">Login</p>

		<input name="email" type="text" class="input" placeholder="E-mail" />

		<input name="password" type="password" class="input"
			placeholder="Password" /> 
			
		<input type="submit" class="loginbutton"
			value="ENTRAR" />
	</form>

</body>
</html>