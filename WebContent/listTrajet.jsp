<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
	<th>Depart</th>
	<th>Arrivee</th>
	<th>Date</th>
	<th>Heure</th>
	<th>Places</th>
	<th>Prix</th>
	<th>Conducteur</th>
</tr>
<c:forEach items="${lesTrajets}" var="trajet">
	<tr>
		<td>${trajet.depart.nom}</td>
		<td>${trajet.destination.nom}</td>
		<td>${trajet.date}</td>
		<td>${trajet.heure}</td>
		<td>${trajet.places}</td>
		<td>${trajet.prix}</td>
		<td><a href="afficherProfil?id=${trajet.conducteur.id}">${trajet.conducteur.nom}</a></td>
	</tr>	
</c:forEach>
</table>
</body>
</html>