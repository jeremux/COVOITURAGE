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
</head>
<body>

<div id="templatemo_wrapper">
	<jsp:include page="header.jsp"/>
	<jsp:include page="menu.jsp"/>
	
    
    
    
   
    
    <div id="templatemo_main">
   		<jsp:include page="sidebar.jsp"/>
        <div id="content" class="float_r">
   			<h1>Boite de reception</h1>
        	<table style="width:680px">
                   	  	<tr bgcolor="#ddd">
                        	<th width="180" align="left">Destinataire</th> 
                       	  	<th width="180" align="left">Objet</th> 
                       	  	
                            <th width="360" align="left">Trajet</th>  
                        	<th width="50" align="right"> </th> 
                        	<th width="120" align="right"> </th> 
                      	</tr>
						<c:forEach items="${messagesEnvoyes}" var="message">
						<tr>
								<td>${message.destinataire.getNom()}</td>
								<td>${message.objet}</td>
							
						
						
								<td>
								<c:if test="${message.getTrajet().getId()!=-1}">	
									<a href="infoTrajet?id=${message.getTrajet().getId()}">${message.getTrajet().getDepart().getNom()} -> ${message.getTrajet().getDestination().getNom()}</a>
								</c:if>	
								<c:if test="${message.getTrajet().getId()==-1}">	
									
								</c:if>	
								</td>
								<td><a href="lireMessage?id=${message.getId()}">lire</a></td>
                            	<td><a href="supprimerMessage?idMessage=${message.getId()}&idProfil=${sessionScope.sessionUtilisateur.id}">Supprimer</a></td>
							</tr>	
						</c:forEach>
                      	
            </table>
        </div> 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <jsp:include page="footer.jsp"/>
   
</div> <!-- END of templatemo_wrapper -->

</body>
</html>