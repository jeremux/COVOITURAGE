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
    
    <form method="post" enctype="application/x-www-form-urlencoded" action="editProfil?id=<%= request.getParameter("id")%>">    
    <div id="templatemo_main_form">
   	
        <div id="content2">
        	<h2>Modification du profil</h2>
            <h5><strong>DETAILS DU PROFIL</strong></h5>
            <div class="content_half float_l checkout">
                        
            	
                Email <span class="erreur">${form.erreurs['email']}</span>
            	<input type="email" name="email" autocomplete="off" value="${sessionScope.sessionUtilisateur.email}" style="width:300px;"/><br/>
            
               	
           	 	Ville
            	<input type="text" name="ville" autocomplete="off" value="${sessionScope.sessionUtilisateur.getVille().getNom()}" style="width:300px;"/>
            	
            	 
            	CP<span class="req">*</span>
            	<input type="text" name="codePostal" autocomplete="off" value="${sessionScope.sessionUtilisateur.getVille().getCodePostal()}" style="width:300px;"/>
            	
            	Ancien mot de passe <span class="erreur">${form.erreurs['oldPass']}</span>
            	<input type="password" name="oldPass"  autocomplete="off"  style="width:300px;"/>
            
           
            	Nouveau mot de passe<span class="erreur">${form.erreurs['pass']}</span>
            	<input type="password" name="pass" autocomplete="off"  style="width:300px;"/>
            
            
            	Confirmation<span class="erreur">${form.erreurs['conf']}</span>
            	<input type="password" name="conf" autocomplete="off" style="width:300px;"/><br/>
            
            </div>
            
            <div class="content_half float_r checkout">
            <h2>Préférences</h2>
                
                <span>Aimez vous la musique ?</span>
               
                <c:if test="${sessionScope.sessionUtilisateur.getPreference().isAimeMusique()}">
                	<input type="checkbox" name="aimeMusique" value="true" checked > <br/>
                </c:if>
                 <c:if test="${!sessionScope.sessionUtilisateur.getPreference().isAimeMusique()}">
                	<input type="checkbox" name="aimeMusique" value="true"> <br/>
                </c:if>
                
                Aimez vous la discussion ?
                <c:if test="${sessionScope.sessionUtilisateur.getPreference().isAimeDiscution()}">
                <input type="checkbox" name="aimeDiscution" value="true" checked >  <br/>
                </c:if>
                <c:if test="${!sessionScope.sessionUtilisateur.getPreference().isAimeDiscution()}">
                <input type="checkbox" name="aimeDiscution" value="true">  <br/>
                </c:if>
                
                
                Aimez vous les animaux ?
                <c:if test="${sessionScope.sessionUtilisateur.getPreference().isAimeAnimaux()}">
               <input type="checkbox" name="aimeAnimaux" value="true" checked>  <br/>
                </c:if>
                <c:if test="${!sessionScope.sessionUtilisateur.getPreference().isAimeAnimaux()}">
               <input type="checkbox" name="aimeAnimaux" value="true">  <br/>
                </c:if>
                
              	
              	
              	Etes vous fumeur ?
              	<c:if test="${sessionScope.sessionUtilisateur.getPreference().isFumeur()}">                    
                <input type="checkbox" name="fumeur" value="true" checked> <br/> 
                </c:if>
                <c:if test="${!sessionScope.sessionUtilisateur.getPreference().isFumeur()}">                    
                <input type="checkbox" name="fumeur" value="true"> <br/> 
                </c:if>
            </div>
            
            <div class="cleaner h50"></div>
            
        <div class="cleaner"></div>
        <input type="submit" value="Modifier" class="sansLabel" />				
		<p>${form.resultat}</p>
    </div> <!-- END of templatemo_main -->
    </div>
    </form>
    <jsp:include page="footer.jsp"/>
    
</div> <!-- END of templatemo_wrapper -->

</body>
</html>