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
   			<h1>${titre}</h1>
        	<table style="width:680px">
                   	  	<tr bgcolor="#ddd">
                        	<th width="180" align="left">Depart</th> 
                       	  	<th width="180" align="left">Arrivée</th> 
                       	  	
                            <th width="360" align="left">Date</th>  
                        	<th width="50" align="right"> </th> 
                        	<th width="120" align="right"> </th> 
                      	</tr>
						<c:forEach items="${mesAnnonces}" var="trajet">
						<tr>
								<td>${trajet.getDepart().getNom()}</td>
								<td>${trajet.getDestination().getNom()}</td>
								<td>${trajet.getDate2()}</td>
					
					
								<td><a href="infoTrajet?id=${trajet.getId()}">Détails</a></td>
                            	<td><a href="supprimerTrajet?idTrajet=${trajet.getId()}&idConducteur=${sessionScope.sessionUtilisateur.id}">Supprimer</a></td>
							</tr>	
						</c:forEach>
						<c:forEach items="${mesReservations}" var="trajet">
						<tr>
								<td>${trajet.getDepart().getNom()}</td>
								<td>${trajet.getDestination().getNom()}</td>
								<td>${trajet.getDate2()}</td>
					
					
								<td><a href="#">Annuler</a></td>
                            	<td><a href="#">Payer</a></td>
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