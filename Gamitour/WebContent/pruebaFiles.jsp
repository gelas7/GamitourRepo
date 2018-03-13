<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Prueba subir archivo</h1>
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file" multiple/>
		<input type="submit">
	</form>
</body>
</html>