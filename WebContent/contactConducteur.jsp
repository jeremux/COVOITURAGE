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
	
    
    
    
   
    
    <div id="templatemo_main">
    <jsp:include page="sidebar.jsp"/>
        <div id="content" class="float_r">
    
    <h1>Demande d'informations</h1>
                <div id="contact_form">
                   <form method="post" name="contact" action="envoyerMessage?idConducteur=<%= request.getParameter("idConducteur") %>&idTrajet=<%= request.getParameter("idTrajet")%>">
                        
						<label for="subject">Objet:</label> <input type="text" name="objet" id="subject" class="input_field" />

						<div class="cleaner h10"></div>
        
                        <label for="text">Message:</label> <textarea id="text" name="contenu" rows="0" cols="0" class="required"></textarea>
                        <div class="cleaner h10"></div>
                        <span class="erreur">${erreur}</span>
                        <input type="submit" value="Envoyer" id="submit" name="submit" class="submit_btn float_l" />
						<input type="reset" value="Reset" id="reset" name="reset" class="submit_btn float_r" />
                        
            	</form>
            	
                </div>
                <div class="cleaner h20"></div>
                <p><a href="infoTrajet?id=<%=request.getParameter("idTrajet")%>">Revenir aux informations du trajet</a></p> 
        <div class="cleaner h40"></div>
             
       
    </div> <!-- END div float_r -->
     <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <jsp:include page="footer.jsp"/>
</div> <!-- END of templatemo_wrapper -->
</body>
</html>