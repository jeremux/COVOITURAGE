<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TuturPooling</title>
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />
</head>
<body>

<div id="templatemo_wrapper">
	<jsp:include page="header.jsp"/>
	<jsp:include page="menu.jsp"/>
	
    
    
    
   
    
    <div id="templatemo_main">
   		<jsp:include page="sidebar.jsp"/>
        <div id="content" class="float_r">
        <div class="trajet">
         	<table>
<tr>
	<td>Depart</td>
	<td>Arrivee</td>
	<td>Date</td>
	<!--  <td>Heure</td>-->
	<!-- <td>Places</td>-->
<td>Prix</td>
<!-- 	<td>Conducteur</td> -->
</tr>
<c:forEach items="${lesTrajets}" var="trajet">
	<tr onclick="document.location = 'infoTrajet?id=${trajet.id}';" style="cursor:pointer">
		<td>${trajet.depart.nom}</td>
		<td>${trajet.destination.nom}</td>
		<td>${trajet.date2}</td>
<%-- 		<td>${trajet.heure}</td> --%>
<%-- 		<td>${trajet.places}</td> --%>
		<td>${trajet.prix}</td>
<%-- 		<td><a href="afficherProfil?id=${trajet.conducteur.id}">${trajet.conducteur.nom}</a></td> --%>
	</tr>	
</c:forEach>
</table>
</div>
        </div> 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <jsp:include page="footer.jsp"/>
   
</div> <!-- END of templatemo_wrapper -->

</body>
</html>