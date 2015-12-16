<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html> 
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Contact</title>
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
    
    <h1>Nous contacter</h1>
          <div class="content_half float_l">
            <h4>Envoyez nous un message...</h4>
                <div id="contact_form">
                   <form method="post" name="contact" action="envoyerMessage">
                        
                        <c:if test="${!empty sessionScope.sessionUtilisateur}">
                        
                        	<label for="author">Nom:</label> <input type="text" id="author" name="author" value="${sessionScope.sessionUtilisateur.nom}" class="required input_field" />
                        	<div class="cleaner h10"></div>
                        
                        	<label for="email">Email:</label> <input type="text" id="email" name="email" class="validate-email required input_field" value="${sessionScope.sessionUtilisateur.email}"/>
                        	<div class="cleaner h10"></div>
                        </c:if>
                        
                         <c:if test="${empty sessionScope.sessionUtilisateur}">
                        
                        	<label for="author">Nom:</label> <input type="text" id="author" name="author" class="required input_field" />
                        	<div class="cleaner h10"></div>
                        
                        	<label for="email">Email:</label> <input type="text" id="email" name="email" class="validate-email required input_field" />
                        	<div class="cleaner h10"></div>
                        </c:if>
                        
						<label for="subject">Objet:</label> <input type="text" name="subject" id="subject" class="input_field" />

						<div class="cleaner h10"></div>
        
                        <label for="text">Message:</label> <textarea id="text" name="text" rows="1" cols="1" class="required"></textarea>
                        <div class="cleaner h10"></div>
                        
                        <input type="submit" value="Envoyer" id="submit" name="submit" class="submit_btn float_l" />
						<input type="reset" value="Reset" id="reset" name="reset" class="submit_btn float_r" />
                        
            	</form>
                </div>
            </div>
        <div class="content_half float_r">
          <h4>Adresse</h4>
          <h6><strong>Location</strong></h6>
Université de Lille 1<br/>
Cité Scientifique, 59650 Villeneuve-d'Ascq<br />
<br />
<strong>Tel:</strong> 0123456789<br />
<strong>Email:</strong> <a href="mailto:info@yoursite.com">admin@tuturpooling.com</a><br />
<div class="cleaner h20"></div>
           
        </div>
        
        <div class="cleaner h40"></div>
             
        <iframe width="680" height="340"  src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2531.9133648029233!2d3.1412267226513317!3d50.61014735107693!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47c2d64d7432cc3b%3A0x975b789ee1f01e43!2sUniversit%C3%A9+de+Lille+1!5e0!3m2!1sfr!2sfr!4v1449438964943" style="border:0" ></iframe>
    </div> <!-- END div float_r -->
     <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <jsp:include page="footer.jsp"/>
</div> <!-- END of templatemo_wrapper -->
</body>
</html>