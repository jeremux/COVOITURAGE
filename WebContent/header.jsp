<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="templatemo_header">
     	
     	<c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%> 
                    <div id="header_right"><a href="editProfil?id=${sessionScope.sessionUtilisateur.id}">${sessionScope.sessionUtilisateur.pseudo}</a> | <a href="deconnexion">Se déconnecter</a></div>
                </c:if>
                <c:if test="${empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%> 
                    <div id="header_right"><a href="inscription">Inscription</a> | <a href="connexion">Connexion</a></div>
                </c:if>
        
        
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->