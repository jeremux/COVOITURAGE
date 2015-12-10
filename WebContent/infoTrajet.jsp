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
<link rel="stylesheet" type="text/css" href="css/pref.css" />
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
                        <td height="30" width="160">Départ:</td>
                        <td>${trajet.depart.nom}</td>
                    </tr>
                    <tr>
                        <td height="30">Arrivée:</td>
                        <td>${trajet.destination.nom}</td>
                    </tr>
                    <tr>
                        <td height="30">Date:</td>
                        <td>${trajet.date2}</td>
                    </tr>
                    <tr>
                        <td height="30">Heure:</td>
                        <td>${trajet.heure}</td>
                    </tr>
                    <tr>
                        <td height="30">Places restante:</td>
                        <td>${trajet.places}</td>
                    </tr>
                    <tr>
                        <td height="30">Prix:</td>
                        <td>${trajet.prix}</td>
                    </tr>
                   
                </table>
             
              
			</div>
            <div class="cleaner h30"></div>
            <c:if test="${trajet.conducteur.getId()!=sessionScope.sessionUtilisateur.id}">
            <h4>Conducteur</h4>
            <table>
            	<tr>
                        <td height="30" width="160">Age:</td>
                        <td>${trajet.conducteur.getAge()}</td>
                </tr>
         
                <tr>
                        <td height="30">Ancienneté:</td>
                        <td>${trajet.conducteur.getAnciennete()}</td>
                    </tr>
                    <tr>
                        <td height="30">Demandez des précisions au conducteur:</td>
                        <td><a href="envoyerMessage?idTrajet=${trajet.getId()}&idConducteur=${trajet.conducteur.getId()}"><img alt="email_ico" src="images/email.png"></a></td>
                    </tr>
                   
            </table>
            <div class="cleaner h30"></div>
            
            <h4>Préférences du conducteur</h4>
             <table>
             <tr>
             <c:if test="${trajet.conducteur.preference.aimeAnimaux==true}">
            	
                     <td height="30" width="160"><img alt="cat_img" src="images/cat-icon.png"></td>
                
                </c:if>
         		<c:if test="${trajet.conducteur.preference.aimeDiscution}">
            	
                     <td height="30" width="160">Aime bien discuter</td>
                
                </c:if>
                
               <c:if test="${trajet.conducteur.preference.aimeMusique}">
                     <td height="30" width="160"><img alt="music_img" src="images/music-note.png"/></td>
                </c:if>
                <c:if test="${!trajet.conducteur.preference.aimeMusique}">
                     <td height="30" width="160"><img class="no-music" height="48px" width="48px" alt="no_music_img" src="images/no-music-note.png"/></td>
                </c:if>
                
                
                <c:if test="${trajet.conducteur.preference.fumeur}">
                     <td height="30" width="160"><img alt="smoke_img" src="images/smoke.png"/></td>
                </c:if>
                <c:if test="${! trajet.conducteur.preference.fumeur}">
                     <td height="30" width="160"><img alt="noSmoke_img" src="images/no-smoke.png"/></td>
                </c:if>
              
              
              </tr>     
            </table>
        	
            <button type="submit">Reserver !</button>
            </c:if>
            
            <c:if test="${trajet.conducteur.getId()==sessionScope.sessionUtilisateur.id}">
            	<a href="supprimerTrajet?idTrajet=${trajet.getId()}&idConducteur=${sessionScope.sessionUtilisateur.id}"><button class="delete" style="cursor:pointer">Supprimer</button></a>
            </c:if>
            </div>
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <jsp:include page="footer.jsp"/>
   
</div> <!-- END of templatemo_wrapper -->
    
	
</body>
</html>