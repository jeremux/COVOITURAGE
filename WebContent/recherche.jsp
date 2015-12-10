<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />
<link href="css/erreur.css" rel='stylesheet' type='text/css'/>
</head>
<body>

<div id="templatemo_wrapper">
	<jsp:include page="header.jsp"/>
	<jsp:include page="menu.jsp"/>
	
    
    
    
   
    
    <div id="templatemo_main">
   		<jsp:include page="sidebar.jsp"/>
        <div id="content" class="float_r">
        
   			<h1>Recherchez un trajet !</h1>
   			
   			<form method="post" enctype="application/x-www-form-urlencoded" action="recherche">
				
				<p>Départ : </p>
				<select name="villeDepart">
					<c:forEach items="${lesVilles }" var="ville">
						<option value="${ville.codePostal}">${ville.nom}</option>
					</c:forEach>
					<option selected>--------</option>
				</select>
				
				<p>Arrivee : </p>
				<select name="villeArrivee">
					<c:forEach items="${lesVilles }" var="ville">
						<option value="${ville.codePostal}">${ville.nom}</option>
					</c:forEach>
					<option selected>--------</option>
				</select>
				
				
				<p>Date : </p>
				<input type="date" name="date"/>
				<div class="cleaner h30"></div>
				<p><button type="submit" value="Submit">Rechercher</button></p>
				
				<div class="cleaner h10"></div>
				<c:if test="${taille==0}">
					<p class="erreur">Aucun résultat...</p>
				</c:if>
			</form>
   		
        </div> 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <jsp:include page="footer.jsp"/>
   
</div> <!-- END of templatemo_wrapper -->

</body>
</html>