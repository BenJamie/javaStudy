<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Address and Contact</title>
</head>
<body>
	<h2>Address</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Street</th>
			<th>City</th>
			<th>State</th>
			<th>Zip</th>
		</tr>
	<c:forEach var="address" items="${addresses}">
		<tr>
			<td>${address.id}</td>
			<td>${address.street}</td>
			<td>${address.city}</td>
			<td>${address.state}</td>
			<td>${address.zip}</td>
		</tr>
	</c:forEach>	
	</table>
	<!-- //TODO get contact display function work. -->
	<h2>Contacts</h2>
	<form method="get">
		<ul>
			<c:forEach var="contact" items="${contacts}">
				<li>ID: ${contact.id}</li>
				<li>Name: ${contact.name}</li>
				<li>AddressID: ${contact.addressId}</li>
			</c:forEach>
		</ul>
		<br><br>
		<input type="submit" value="Submit">
	</form>

</body>
</html>