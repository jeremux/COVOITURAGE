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
   			
   			
   			<form method="post" enctype="application/x-www-form-urlencoded" action="payerTrajet?idProfil=<%= request.getParameter("idProfil") %>&amp;idTrajet=<%= request.getParameter("idTrajet")%>">
    <fieldset name="personalInfo">
      <label for="nom">Nom</label>
      <input type="text" id="nom" 
             >
    </fieldset>

    <fieldset name="cardInfo">
      <label for="cardNum" >Card Number</label>
      <input type="tel" id="cardNum" 
             placeholder="0000 0000 0000 0000">

      <label for="cardExp">Expires</label>
      <input type="tel" id="cardExp" placeholder="MM/YY">  

      <label for="cardCVC">CVC</label>
      <input type="tel" id="cardCVC" placeholder="***">
    </fieldset>
	<div class="cleaner h30"></div>
    <input type="submit" value="Payer">
  </form>
   			
   			
        </div> 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <jsp:include page="footer.jsp"/>
   
</div> <!-- END of templatemo_wrapper -->

</body>
</html>