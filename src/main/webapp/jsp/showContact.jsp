<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${contact.name}</title>
</head>
<body>
	<form action="contacts" method="post">
		<input type="hidden" name="id" value="${contact.id}">
		<ul>
			<li>Name: <input type="text" name="name" value="${contact.name}"></li>
			<li>Street: <input type="text" name="street" value="${address.street}"></li>
			<li>City: <input type="text" name="city" value="${address.city}"></li>
			<li>State: <input type="text" name="state" value="${address.state}"></li>
			<li>ZipCode: <input type="text" name="zip" value="${address.zip}"></li>
		</ul>
		<input type="submit" name="edit" value="edit">
	</form>
	<form action="contacts" method="get">
		<input type="submit" name="show" value="Back to List">
	</form>
</body>
</html>