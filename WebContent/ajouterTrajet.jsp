<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nouveau trajet</title>
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />
<link href="css/erreur.css" rel='stylesheet' type='text/css'/>
</head>
<body>

<div id="templatemo_wrapper">
	<jsp:include page="header.jsp"/>
	<jsp:include page="menu.jsp"/> 
    
    <c:if test="${!empty sessionScope.sessionUtilisateur}">
    <div id="templatemo_main">
   		<jsp:include page="sidebar.jsp"/>
        <div id="content" class="float_r">
   			<h1>Nouveau Trajet</h1>
   			<form method="post" enctype="application/x-www-form-urlencoded" action="publication">
				<p>Depart : <span class="erreur">${form.erreurs['villeDepart']}</span></p>
				<select name="villeDepart">
					<c:forEach items="${lesVilles }" var="ville">
						<option value="${ville.codePostal}">${ville.nom}</option>
					</c:forEach>
				</select>
				
				<p>Arrivee : <span class="erreur">${form.erreurs['villeArrivee']}</span></p>
				<select name="villeArrivee">
					<c:forEach items="${lesVilles }" var="ville">
						<option value="${ville.codePostal}">${ville.nom}</option>
					</c:forEach>
				</select>
				
				<p>Date : <span class="erreur">${form.erreurs['date']}</span></p>
				<input type="date" name="date" required/>
				
				<p>Heure :</p> 
				<input type="time" name="heure" value="01:26" required/><br/>
				
				<p>Nombre de place :</p>
				<input type="number" name="places" value="4" min=1 step="1" required/>
				
				<p>Prix :</p>
				<input type="number" step="0.01" name="prix" min=0 value="1.26" required/> <br/>
				<div class="cleaner h30"></div>
				<p><button type="submit" value="Submit">Ajouter</button></p>
			</form>
        </div> 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
	</c:if>
    
    <jsp:include page="footer.jsp"/>
   
</div> <!-- END of templatemo_wrapper -->

</body>
</html>