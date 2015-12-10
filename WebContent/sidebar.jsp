<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div id="sidebar" class="float_l">
        	 
           
           			
                    	
                    	<c:if test="${!empty sessionScope.sessionUtilisateur}">
                    	<div class="sidebar_box"><span class="bottom"></span>
            	<h3>Categories</h3>
<div class="content">
		<ul class="sidebar_list">
                    <li class="first"><a href="editProfil?id=${sessionScope.sessionUtilisateur.id}">Mon profil</a></li>
                        <li><a>Messagerie</a>
                        	<ul>
                        	<li><a href="messageEnvoyes?id=${sessionScope.sessionUtilisateur.id}">Messages envoyés</a></li>
                        	<li><a href="messageRecus?id=${sessionScope.sessionUtilisateur.id}">Messages reçus</a></li>
                        </ul>
                        </li>
                        <li><a href="publication?conducteur=${sessionScope.sessionUtilisateur.id}">Proposer un trajet</a></li>
                        <li><a href="mesAnnonces?id=${sessionScope.sessionUtilisateur.id}">Vos annonces</a></li>
                        <li class="last"><a href="mesReservations?id=${sessionScope.sessionUtilisateur.id}">Vos reservations</a></li>
                        </ul>
                        </div>
                      
                        </div>
                        
                </c:if>
                
                   
             
            <div class="sidebar_box"><span class="bottom"></span>
            	<h3>Les moins chers !</h3>   
                <div class="content"> 
                <c:forEach items="${applicationScope['meilleursPrix']}" var="trajet">
                	<div class="bs_box">
                    	<img src="images/Car.png" alt="image_${trajet.destination.nom}" />
                        <h4>
                        	<c:if test="${!empty sessionScope.sessionUtilisateur}">
                        		<a href="infoTrajet?id=${trajet.id}">${trajet.destination.nom}</a>
                        	</c:if>
                        	<c:if test="${empty sessionScope.sessionUtilisateur}">
                        		<a href="#">${trajet.destination.nom}</a>
                        	</c:if>
                        </h4>
                        <p class="price">${trajet.prix} &euro;</p>
                        <div class="cleaner"></div>
                    </div>
                </c:forEach>
                
                	
                </div>
            </div>
        </div>