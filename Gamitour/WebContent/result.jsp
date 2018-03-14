<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos de la subida</title>
<script type="text/javascript">
    self.close();
</script>
</head>
<body>
	<div id="result">
		<h3>${requestScope["message"]}</h3>
		<br>
	</div>
	Nombre del fichero : ${requestScope["name"]}
	<br> Tamaño del fichero : ${requestScope["size"]} kb
	<br> Tipo de archivo : ${requestScope["type"]}

</body>
</html>