<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Pragma" content="nocache">
<title>Send an e-mail</title>

<style>
body, div, h1, form, fieldset, input, textarea {
	margin: 0;
	padding: 0;
	border: 0;
	outline: none;
}

html {
	height: 100%;
}

body {
	background: #7b9cd1;
	font-family: sans-serif;
}

#contact {
	width: 600px;
	margin: 60px auto;
	padding: 60px 30px;
	background: #c9d0de;
	border: 1px solid #e1e1e1;
	-moz-box-shadow: 0px 0px 8px #444;
	-webkit-box-shadow: 0px 0px 8px #444;
}

h1 {
	font-size: 35px;
	color: #445668;
	text-transform: uppercase;
	text-align: center;
	margin: 0 0 35px 0;
	text-shadow: 0px 1px 0px #f2f2f2;
}

label {
	float: left;
	clear: left;
	margin: 11px 20px 0 0;
	width: 95px;
	text-align: right;
	font-size: 16px;
	color: #445668;
	text-transform: uppercase;
	text-shadow: 0px 1px 0px #f2f2f2;
}

input {
	width: 260px;
	height: 35px;
	padding: 5px 20px 0px 20px;
	margin: 0 0 20px 0;
	background: #d7e0ed;
	border-radius: 5px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-box-shadow: 0px 1px 0px #f2f2f2;
	-webkit-box-shadow: 0px 1px 0px #f2f2f2;
	font-family: sans-serif;
	font-size: 16px;
}

textarea {
	width: 260px;
	height: 170px;
	padding: 12px 20px 0px 20px;
	margin: 0 0 20px 0;
	background: #d7e0ed;
	border-radius: 5px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-box-shadow: 0px 1px 0px #f2f2f2;
	-webkit-box-shadow: 0px 1px 0px #f2f2f2;
	font-family: sans-serif;
	font-size: 16px;
	color: black;
}

input[type=submit] {
	width: 185px;
	height: 52px;
	float: right;
	padding: 10px 15px;
	margin: 0 15px 0 0;
	-moz-box-shadow: 0px 0px 5px #999;
	-webkit-box-shadow: 0px 0px 5px #999;
	border: 1px solid #556f8c;
	background: -moz-linear-gradient(top, #718DA9 0%,  #c9d0de 100%);

	cursor: pointer;
}
</style>
</head>
<body>


	<form action="EmailSendingServlet" method="post">
		<table border="0" width="33%" align="center">
			<caption>
				<h2 style="color: white;">Tu opinion nos importa</h2>
				<p style="color: white;">Haznos saber cualquier fallo o
					dificultad en el programa</p>
			</caption>

			<input type="text" name="recipient" size="50"
				value="adelbustom@yahoo.com" hidden />
			<tr>
				<td style="color: white;">Tu nombre</td>
				<td><input type="text" name="subject" size="50" /></td>
			</tr>
			<tr>
				<td style="color: white;">Tu Comentario</td>
				<td><textarea rows="10" cols="39" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Enviar" /></td>
			</tr>
		</table>

	</form>
</body>
</html>