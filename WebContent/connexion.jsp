<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html> 
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Station Shop - Checkout Page</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<!-- templatemo 352 station shop -->
<!-- 
Station Shop Template 
http://www.templatemo.com/preview/templatemo_352_station_shop 
-->
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="css/erreur.css" rel='stylesheet' type='text/css'/>
<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

</head>

<body>

<div id="templatemo_wrapper">
	<jsp:include page="header.jsp"/>
	<jsp:include page="menu.jsp"/>
    
    <form method="post" enctype="application/x-www-form-urlencoded" action="connexion">
    <div id="templatemo_main_form">
   	
        <div id="content2">
        	<h2>Connexion</h2>
            <h5><strong>DETAILS DU PROFIL</strong></h5>
            <div >
                Login<span class="req">*</span>
              	<input type="text"  name="login" required autocomplete="off" />
                Mot de passe<span class="req">*</span>
              	<input type="password" name="motdepasse" required autocomplete="off"/>
              	
            
            </div>
            
           
            
            <div class="cleaner h50"></div>
            
        <div class="cleaner"></div>
        <input type="submit" value="Connexion" class="sansLabel" />				
		<c:if test="${!empty form.erreurs}">
                		<p class="erreur"> S'inscrire <a class="erreur erreur_lien" href="inscription">ici</a></p>
                </c:if>
                
                <br/><span class="erreur"> ${form.erreurs['login']}</span>
                <br/><span class="erreur">${form.erreurs['motdepasse']}</span>
                <p class="${empty form.erreurs ? 'success' : 'erreur'}">${form.resultat}</p>
                
                
                <%-- Vérification de la présence d'un objet utilisateur en session --%>
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%> 
                    <p class="success">Vous êtes connecté(e) avec le login : ${sessionScope.sessionUtilisateur.pseudo}</p> 
                </c:if>
    </div> <!-- END of templatemo_main -->
    </div>
    </form>
    <jsp:include page="footer.jsp"/>
    
</div> <!-- END of templatemo_wrapper -->

</body>
</html>