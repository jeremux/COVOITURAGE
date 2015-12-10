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
    
    <form method="post" enctype="application/x-www-form-urlencoded" action="inscription">
    <div id="templatemo_main_form">
   	
        <div id="content2">
        	<h2>Inscription</h2>
            <h5><strong>DETAILS DU PROFIL</strong></h5>
            <div class="content_half float_l checkout">
                
                Nom<span class="req">*</span>
              	<input type="text"  name="nom" required autocomplete="off" value="nomTest" style="width:300px;" />
              	
              	
                Prénom<span class="req">*</span>
              	<input type="text" name="prenom" required autocomplete="off" value="prenomTest" style="width:300px;"/>
              	
              	
              	Date de naissance<span class="req">*</span>
            	<input type="date" name="dateNaissance" required autocomplete="off" style="width:300px;"/>
            	
            	
                Email<span class="req">* </span><span class="erreur">${form.erreurs['email']}</span>
            	<input type="email" name="email" autocomplete="off" style="width:300px;"/><br/>
            	
            	
            	Login<span class="req">* </span><span class="erreur">${form.erreurs['login']}</span>
            	<input type="text" name="login" required autocomplete="off" style="width:300px;"/><br/>
            	
            	
           	 	Ville<span class="req">* </span>
            	<input type="text" name="ville" required autocomplete="off" value="lill" style="width:300px;"/>
            	
            	 
            	CP<span class="req">*</span>
            	<input type="text" name="codePostal" required autocomplete="off" value="59000" style="width:300px;"/>
            	
            	
            	Mot de passe<span class="req">* </span><span class="erreur">${form.erreurs['pass']}</span>
            	<input type="password" name="pass" required autocomplete="off" value="test" style="width:300px;"/>
            
            
            	Confirmation<span class="req">* </span><span class="erreur">${form.erreurs['conf']}</span>
            	<input type="password" name="conf" required autocomplete="off" value="test" style="width:300px;"/><br/>
            
            </div>
            
            <div class="content_half float_r checkout">
            <h2>Préférences</h2>
                
                <span>Aimez vous la musique ?</span>
                <input type="checkbox" name="aimeMusique" value="true" checked > <br/>
                
                
                Aimez vous la discussion ?
                <input type="checkbox" name="aimeDiscution" value="true" >  <br/>
                
                
                Aimez vous les animaux ?
                <input type="checkbox" name="aimeAnimaux" value="true" >  <br/>
              	
              	
              	Etes vous fumeur ?                    
                <input type="checkbox" name="fumeur" value="true" > <br/> 
            </div>
            
            <div class="cleaner h50"></div>
            
        <div class="cleaner"></div>
        <input type="submit" value="Valider" class="sansLabel" />				
		<p>${form.resultat}</p>
    </div> <!-- END of templatemo_main -->
    </div>
    </form>
    <jsp:include page="footer.jsp"/>
    
</div> <!-- END of templatemo_wrapper -->

</body>
</html>