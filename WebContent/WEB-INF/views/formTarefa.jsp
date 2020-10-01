<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="adiciona" method = 'Post'>
	Tag=<select type ="text" name="tag">
  <option value="Insper">Insper</option>
  <option value="Lazer">Lazer</option>
  <option value="Familia">Familia</option>
  <option value="Entidade">Entidade</option>
</select>
	Usuario =<input type ="text" name="usuario"/><br>
	Tarefa=<input type="text" name="tarefa"/><br>
	<input type = 'submit' value = 'Submit'>
</form>
</body>
</html>