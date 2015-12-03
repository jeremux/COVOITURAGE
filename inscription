
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
  <head>
   <meta charset="utf-8"/>
<title>blablacar</title>
<link rel="stylesheet" href=""/>
 
  <link rel="stylesheet" href="css/style1.css">
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Pinyon+Script' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Quicksand:400,700' rel='stylesheet' type='text/css'>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/jquery.min.js"></script>
  </head>

  <body>
  
  <div class="header">
	 <div class="top-header">
		 <div class="container">
			 <div class="logo">
				 	<a href="index.html"><img src=""/></a>
			 </div>
			 <div class="top-menu">
				<ul>
					 <li class="active"><a href="acceuil.html">Acceuil</a></li>
					 <li><a class="scroll" href="index.html">Connexion</a></li>
					 <li><a class="scroll" href="annonces.html">Vos annonces</a></li>
					 <li><a class="scroll" href="reservations.html">Vos réservations</a></li>
					 <li><a class="scroll" href="profil.html">Votre profil</a></li>
					 <li><a class="scroll" href="contact.html">Contactez-nous</a></li>
				</ul>
				
			 </div>
			
		  </div>
	  </div>
	  
</div>   

    <div class="form">   
      
      <div class="tab-content">
        <div id="signup">   
         
		  <div class="tab_connexion1">
   
   <div class="tab_connexion2">
          
          <form method="post" enctype="application/x-www-form-urlencoded" action="inscription">
		  <label> Connectez-vous.</label> <br><br>
          

            
              <label>
                Nom<span class="req">*</span>
              </label>
              <input type="text"  name="nom" required autocomplete="off" value="nomTest" />
         
        </div>
<div class="tab_connexion2">
              <label>
                Prénom<span class="req">*</span>
              </label>
              <input type="text" name="prenom" required autocomplete="off" value="prenomTest"/>
        
          </div>
		
		   <div class="tab_connexion2">
		  
		 
		  
		  
            <label>
              Date de naissance<span class="req">*</span>
            </label>
            <input type="text" name="dateNaissance" required autocomplete="off"/>
       </div>

     <div class="tab_connexion2">
            <label>
              Email<span class="req">*</span>
            </label>
            <input type="email" name="email" required autocomplete="off" />
            <span class="erreur">${form.erreurs['email']}</span>
       
		  </div>
		    <div class="tab_connexion2">
		  
            <label>
              Ville<span class="req">*</span>
            </label>
            <input type="text" name="ville" required autocomplete="off" value="lill"/>   
			</div>
			<div class="tab_connexion2">
            <label>
              CP<span class="req">*</span>
            </label>
            <input type="text" name="codePostal" required autocomplete="off" value="59000"/>
          </div>
          
       <div class="tab_connexion2">
            <label>
              Mot de passe<span class="req">*</span>
            </label>
            <input type="password" name="pass" required autocomplete="off" value="test"/>
            <span class="erreur">${form.erreurs['pass']}</span>
			</div>
			<div class="tab_connexion2">
            <label>
              Confirmation<span class="req">*</span>
            </label>
            <input type="password" name="conf" required autocomplete="off" value="test"/>
            <span class="erreur">${form.erreurs['conf']}</span>
          </div>
			  <div class="tab_connexion2">
		<fieldset name="préférences">
		<label>
              Préferences<span class="req">*</span> <br><br> <br><br><br><br>
            </label>
			<div class="field-wrap">
			
	<div class="pref"><input type="checkbox" name="aimeMusique" value="true" checked>Aimez vous la musique ?</div><br>
  <div class="pref"><input type="checkbox" name="aimeDiscution" value="true" >  Aimez vous la discution ?</div><br>
 <div class="pref"> <input type="checkbox" name="aimeAnimaux" value="true" >  Aimez vous les animaux ?</div><br>
 <div class="pref"> <input type="checkbox" name="fumeur" value="true" > Etes vous fumeur ? </div><br>
</div>
</fieldset>
			
			</div>
			 <div class="tab_connexion2">
				<div class="button_class">
				
                <input type="submit" value="Valider" class="sansLabel" />
				
				</div>
				</div>
				
          </form>
		  </div>
		  </div>
	<p>${form.resultat}</p>
        </div>
        
        
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
   
    
  </body>
</html>
