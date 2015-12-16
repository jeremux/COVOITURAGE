<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty sessionScope.sessionUtilisateur}">
	<jsp:forward page="/connexion"/>
</c:if>

<!DOCTYPE html> 
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Détail message</title>
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
    
    <h5> ${message.getObjet()}</h5>
    <h6>De: ${message.getExpediteur().getNom()}</h6>
    <c:if test="${message.getTrajet().getId()!=-1 }">
    <h6>Trajet: ${message.getTrajet().getDepart().getNom() }-->${message.getTrajet().getDestination().getNom()}</h6>
    </c:if>
    
    <p>${message.getContenu()}</p>
    <c:if test="${message.getTrajet().getId()!=-1 }">
    <c:if test="${message.getExpediteur().getId()!=sessionScope.sessionUtilisateur.id}">
                <div id="contact_form">
                   <form method="post" name="contact" action="envoyerMessage?idConducteur=${message.getExpediteur().getId()}&amp;idTrajet=${message.getTrajet().getId()}&amp;idMessage=${message.getId()}">
                        
						<div class="cleaner h10"></div>
        
                        <label for="text">Message:</label> <textarea id="text" name="contenu" rows="1" cols="1" class="required"></textarea>
                        <div class="cleaner h10"></div>
                        <span class="erreur">${erreur}</span>
                        <input type="submit" value="Répondre" id="submit" name="submit" class="submit_btn float_l" />
						<input type="reset" value="Reset" id="reset" name="reset" class="submit_btn float_r" />
                        
            	</form>
            	
                </div>
                </c:if>
                </c:if>
                <div class="cleaner h20"></div> 
        <div class="cleaner h40"></div>
             
       
    </div> <!-- END div float_r -->
     <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <jsp:include page="footer.jsp"/>
</div> <!-- END of templatemo_wrapper -->
</body>
</html>