<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Contact</title>
</head>
<body>
	<h1>Add Contact</h1>
	<form action="contacts" method="post">
	<input type="hidden" name="add">
	<ul>
		<li>name: <input type="text" name="name"></li>
		<li>street: <input type="text" name="street"></li>
		<li>city: <input type="text" name="city"></li>
		<li>state: <input type="text" name="state"></li>
		<li>zip: <input type="text" name="zip"></li>
	</ul>
	
	<input type="submit" value="add">
	<input type="submit" value="edit">
	</form>
	<a href="contacts?show">back to contact list</a>
</body>
</html>