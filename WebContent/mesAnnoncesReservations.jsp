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
<title>Mes ${titre}</title>
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />
<link href="css/erreur.css" rel='stylesheet' type='text/css'/>
</head>
<body>

<div id="templatemo_wrapper">
	<jsp:include page="header.jsp"/>
	<jsp:include page="menu.jsp"/>
	
    
    
    
   
    
    <div id="templatemo_main">
   		<jsp:include page="sidebar.jsp"/>
        <div id="content" class="float_r">
   			<h1>${titre}</h1>
        	<table style="width:680px">
                   	  	<tr style="background-color:#ddd">
                        	<th style="width:180px;align:left" >Depart</th> 
                       	  	<th style="width:180px;align:left">Arrivée</th> 
                       	  	
                            <th style="width:360px;align:left" >Date</th>  
                        	<th style="width:50px;align:right" > </th> 
                        	<th style="width:120px;align:right" > </th> 
                        	<th style="width:120px;align:left" >Détails</th>
                      	</tr>
						<c:forEach items="${mesAnnonces}" var="trajet">
						<tr>
								<td>${trajet.getDepart().getNom()}</td>
								<td>${trajet.getDestination().getNom()}</td>
								<td>${trajet.getDate2()}</td>
					
					
								<td><a href="infoTrajet?id=${trajet.getId()}">Détails</a></td>
                            	<td><a href="supprimerTrajet?idTrajet=${trajet.getId()}&amp;idConducteur=${sessionScope.sessionUtilisateur.id}">Supprimer</a></td>
                            	<td><a href="infoTrajet?id=${trajet.getId()}">${trajet.getDepart().getNom()} -> ${trajet.getDestination().getNom()}</a></td>
							</tr>	
						</c:forEach>
						<c:forEach items="${mesReservations}" var="trajet">
						<tr>
								<td>${trajet.getDepart().getNom()}</td>
								<td>${trajet.getDestination().getNom()}</td>
								<td>${trajet.getDate2()}</td>
					
								<c:if test="${!facadeAdmin.isPaye(trajet,sessionScope.sessionUtilisateur)}">
								<td><a href="annulerReservation?idPassager=${sessionScope.sessionUtilisateur.getId()}&amp;idTrajet=${trajet.getId()}">Annuler</a></td>
                            	<td><a href="payerTrajet?idProfil=${sessionScope.sessionUtilisateur.getId()}&amp;idTrajet=${trajet.getId()}">Payer</a></td>
                            	</c:if>
                            	<c:if test="${facadeAdmin.isPaye(trajet,sessionScope.sessionUtilisateur)}">
								<td colspan="2"><span class="success">Paiement effectué</span></td>
                            	</c:if>
                            	<td><a href="infoTrajet?id=${trajet.getId()}">${trajet.getDepart().getNom()} -> ${trajet.getDestination().getNom()}</a></td>
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