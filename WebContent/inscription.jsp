<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
  <head>
    <meta charset="UTF-8">
    <title>Sign-Up/Login Form</title>
  
    
  </head>

  <body>

    <div class="form">
      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab"><a href="#login">Log In</a></li>
		
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
          <h1>Sign Up for Free</h1>
          
          <form method="post" enctype="application/x-www-form-urlencoded" action="inscription">
          
          <div class="top-row">
            <div class="field-wrap">
              <label>
                Nom<span class="req">*</span>
              </label>
              <input type="text"  name="nom" required autocomplete="off" value="nomTest" />
            </div>
        
            <div class="field-wrap">
              <label>
                Prénom<span class="req">*</span>
              </label>
              <input type="text" name="prenom" required autocomplete="off" value="prenomTest"/>
            </div>
          </div>
		  
		 
		  
		   <div class="field-wrap">
            <label>
              Date de naissance<span class="req">*</span>
            </label>
            <input type="date" name="dateNaissance" required autocomplete="off"/>
          </div>

          <div class="field-wrap">
            <label>
              Email<span class="req">*</span>
            </label>
            <input type="email" name="email" required autocomplete="off" />
            <span class="erreur">${form.erreurs['email']}</span>
          </div>
		  
		     <div class="field-wrap">
            <label>
              Ville<span class="req">*</span>
            </label>
            <input type="text" name="ville" required autocomplete="off" value="lill"/>
          </div>
          
           <div class="field-wrap">
            <label>
              CP<span class="req">*</span>
            </label>
            <input type="text" name="codePostal" required autocomplete="off" value="59000"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Mot de passe<span class="req">*</span>
            </label>
            <input type="password" name="pass" required autocomplete="off" value="test"/>
            <span class="erreur">${form.erreurs['pass']}</span>
          </div>
           <div class="field-wrap">
            <label>
              Confirmation<span class="req">*</span>
            </label>
            <input type="password" name="conf" required autocomplete="off" value="test"/>
            <span class="erreur">${form.erreurs['conf']}</span>
            
                <br />
          </div>
		  
	
		<div class="field-wrap">
       
			</div>
			
		<fieldset name="préférences">
			<div class="field-wrap">
			
	<input type="checkbox" name="aimeMusique" value="true" checked>Aimez vous la musique ?<br>
  <input type="checkbox" name="aimeDiscution" value="true" >Aimez vous la discution ?<br>
  <input type="checkbox" name="aimeAnimaux" value="true" >Aimez vous les animaux ?<br>
  <input type="checkbox" name="fumeur" value="true" >Etes vous fumeur ?<br>
</div>
</fieldset>
			
			
       
	 <button class="button button-block" type="submit" value="submit"> Valider</button>
	
          </form>
	<p>${form.resultat}</p>
        </div>
        
        
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
   
    
  </body>
</html>