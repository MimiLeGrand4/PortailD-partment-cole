<%-- 
    Document   : connexion.jsp
    Created on : 22-Mar-2023, 10:59:27 PM
    Author     : Vince
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Se connecter</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
<script
	src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
        <link rel="stylesheet" href="css/style.css"> 
   
    </head>

    <body>

               <header>
            <div class="banniere">
                <img id="logo" src="images/logo.png" alt="logo" />
                <h1>Département des Techniques de l'Informatique</h1>

            </div>
      <div>
          <nav class="navbarDep1">
  <div id="navid">
    <a href="index.jsp" class="Nav">Accueil</a>
    <a href="espaceEP.jsp" class="Nav">Espace EP</a>
    <a href="tutorat.jsp" class="Nav">Aide et tutorat</a>
        <a href="inscription.jsp" class="Nav">Inscription</a>
    <a href="connexion.jsp" class="Nav">Connexion</a>
  </div>
</nav>

            </div>
        </header>
        
        
    <div class="container">
    <div class="row" >
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h2 class="text-center login-title">Connecter </h2>
            <div class="account-wall">
                <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                    alt="">
        
                 
                <form class="form-signin" action="login" method="get">
                <input type="email" class="form-control" name="email" placeholder="Email" required autofocus>
                </br>
                <input type="password" class="form-control" name="password" placeholder="Password" required>
                </br>
                <button class="btn btn-lg btn-primary btn-block btn-inscr" type="submit">
                   Sign in</button>
                <label class="checkbox pull-left">
                    <input type="checkbox" name="sauvegarde" value="yes">
                    Se souvenir </br>
                </label>
                </form>
            </div></br> </br> </br>

        </div>
    </div>
</div>
            <footer>

                </div>    <jsp:include page="pied.jsp"/>
           </div>
    
</footer> 
    </body>

</html>
