<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>testing JSP</title>
</head>
<body>
	<h2>Hello Ben, this is a internal page for testing jetty
		webserver.</h2>

	<c:forEach var="contact" items="${showdetail}">
		<li>ID: ${contact.id} Name: ${contact.name} AddressId:
			${contact.addressId}</li>
	</c:forEach>


</body>
</html>