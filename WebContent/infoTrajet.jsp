<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:if test="${empty sessionScope.sessionUtilisateur}">
	<jsp:forward page="/connexion"/>
</c:if>


<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Détail du trajet</title>
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
<link rel="stylesheet" type="text/css" href="css/pref.css" />
<link href="css/erreur.css" rel='stylesheet' type='text/css'/>
</head>
<body>
<div id="templatemo_wrapper">
	<jsp:include page="header.jsp"/>
	<jsp:include page="menu.jsp"/>
	
	<div id="templatemo_main">
		<jsp:include page="sidebar.jsp"/>
	
	
	<div id="content" class="float_r">
          <h1>Trajet</h1>
 			
            <div class="content_half float_l">
            
				<table>
                    <tr>
                        <td style="height:30px;width:160px">Départ:</td>
                        <td>${trajet.depart.nom}</td>
                    </tr>
                    <tr>
                        <td style="height:30px">Arrivée:</td>
                        <td>${trajet.destination.nom}</td>
                    </tr>
                    <tr>
                        <td style="height:30px">Date:</td>
                        <td>${trajet.date2}</td>
                    </tr>
                    <tr>
                        <td style="height:30px">Heure:</td>
                        <td>${trajet.heure}</td>
                    </tr>
                    <tr>
                        <td style="height:30px">Places restante:</td>
                        <td>${trajet.places}</td>
                    </tr>
                    <tr>
                        <td style="height:30px">Prix:</td>
                        <td>${trajet.prix}</td>
                    </tr>
                   
                </table>
             
              
			</div>
            <div class="cleaner h30"></div>
            <c:if test="${trajet.conducteur.getId()!=sessionScope.sessionUtilisateur.id}">
            <h4>Conducteur</h4>
            <table>
            	<tr>
                        <td style="height:30px;width:160px">Age:</td>
                        <td>${trajet.conducteur.getAge()}</td>
                </tr>
         
                <tr>
                        <td style="height:30px">Ancienneté:</td>
                        <td>${trajet.conducteur.getAnciennete()}</td>
                    </tr>
                    <tr>
                        <td style="height:30px">Demandez des précisions au conducteur:</td>
                        <td><a href="envoyerMessage?idTrajet=${trajet.getId()}&amp;idConducteur=${trajet.conducteur.getId()}"><img alt="email_ico" src="images/email.png"></a></td>
                    </tr>
                   
            </table>
            <div class="cleaner h30"></div>
            
            <h4>Préférences du conducteur</h4>
             <table>
             <tr>
             <c:if test="${trajet.conducteur.preference.aimeAnimaux==true}">
            	
                     <td style="height:30px;width:160px"><img alt="cat_img" src="images/cat-icon.png"></td>
                
                </c:if>
         		<c:if test="${trajet.conducteur.preference.aimeDiscution}">
            	
                     <td style="height:30px;width:160px">Aime bien discuter</td>
                
                </c:if>
                
               <c:if test="${trajet.conducteur.preference.aimeMusique}">
                     <td style="height:30px;width:160px"><img alt="music_img" src="images/music-note.png"/></td>
                </c:if>
                <c:if test="${!trajet.conducteur.preference.aimeMusique}">
                     <td style="height:30px;width:160px"><img class="no-music" height="48" width="48" alt="no_music_img" src="images/no-music-note.png"/></td>
                </c:if>
                
                
                <c:if test="${trajet.conducteur.preference.fumeur}">
                     <td style="height:30px;width:160px"><img alt="smoke_img" src="images/smoke.png"/></td>
                </c:if>
                <c:if test="${! trajet.conducteur.preference.fumeur}">
                     <td style="height:30px;width:160px"><img alt="noSmoke_img" src="images/no-smoke.png"/></td>
                </c:if>
              
              
              </tr>     
            </table>
        	
        	<c:if test="${voyageurs.getPassager().getId()!=-1 }">
        	
        	<c:if test="${!facadeAdmin.isReserve(trajet,sessionScope.sessionUtilisateur)}">
            	<a href="reserverTrajet?idTrajet=${trajet.getId()}&amp;idProfil=${sessionScope.sessionUtilisateur.id}" class="btn"> Reserver</a>
            </c:if>
            <c:if test="${!facadeAdmin.isPaye(trajet,sessionScope.sessionUtilisateur)}">
            	<a href="payerTrajet?idTrajet=${trajet.getId()}&amp;idProfil=${sessionScope.sessionUtilisateur.id}" class="btn">Payer</a>
            </c:if>
            
            <c:if test="${facadeAdmin.isPaye(trajet,sessionScope.sessionUtilisateur)}">
            	<p class="erreur">Le voyage est payé !</p>
            </c:if>
            </c:if>
            </c:if>
            <c:if test="${trajet.conducteur.getId()==sessionScope.sessionUtilisateur.id}">
            	<a href="supprimerTrajet?idTrajet=${trajet.getId()}&amp;idConducteur=${sessionScope.sessionUtilisateur.id}" class="btn">Supprimer</a>
            </c:if>
            </div>
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <jsp:include page="footer.jsp"/>
   
</div> <!-- END of templatemo_wrapper -->
    
	
</body>
</html>