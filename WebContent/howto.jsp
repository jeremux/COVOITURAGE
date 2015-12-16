<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html> 
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Comment ça marche</title>
<meta name="keywords" content="" />
<meta name="description" content="" />

<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="css/erreur.css" rel='stylesheet' type='text/css'/>
<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

</head>

<body>

<div id="templatemo_wrapper">
	<jsp:include page="header.jsp"/>
	<jsp:include page="menu.jsp"/>
	
    
    
    
   
    
    <div id="templatemo_main">
    <jsp:include page="sidebar.jsp"/>
        <div id="content" class="float_r">
    
    <h1>Comment ça marche...</h1>
	<h2>   <img src="images/search.jpg" alt="search" height="22" width="42"/> 
	 1. Recherchez votre trajet</h2>
	 
	 
	 <p> A partir de votre ville de départ, choissisez un de nos conducteurs. n'hésitez pas à envoyer des messages au conduceturs si vous avez des questions
	</p>
	
	<h2>   <img src="images/reserver.jpg" alt="reserver" height="22" width="42"/> 2. R?servez et payez en ligne</h2>
	 <p>Vous réservez votre place en ligne et recevez un Code de Réservation. Votre conducteur est prévenu immédiatement de votre réservation par mail et SMS. Ensuite, appelez le conducteur pour régler les derniers détails du voyage de vive voix.</p>
	<h2>    <img src="images/voyage.jpg" alt="voyage" height="22" width="42"/> 3. Voyagez </h2>
	
        <p> Rendez-vous au lieu de départ, bien à l'heure. Donnez votre Code de Réservation au conducteur au cours du voyage, cela lui permettra de récupérer votre participation au trajet par la suite. Bonne route !<p>
             
			 <h2>    <img src="images/avis.jpg" alt="avis" height="22" width="42"/> 4. Donnez votre avis sur le conducteur  </h2>
    <p> vous pouvez donner votre avis sur les conducteurs, vous pouvez même les noter pour que les nouveaux puissent choisir les bons conducteurs et que les mauvais soient éliminés </p>
	</div> <!-- END div float_r -->
	
	
     <div class="cleaner">  </div>
    </div> <!-- END of templatemo_main -->
    
    <jsp:include page="footer.jsp"/>
</div> <!-- END of templatemo_wrapper -->
</body>
</html>