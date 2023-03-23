<%-- 
    Document   : inscription
    Created on : 22-Mar-2023, 11:05:07 PM
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
        <meta charset="utf-8" />
        <title>Formulaire d inscription</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

        <script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script
        src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
        <link rel="stylesheet" href="css/style.css">  
        <style>
    em.error{
        color:red;
    }
    input.error{
        border:1px solid red;
    }
</style>
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
        <div>

<div class="d-flex justify-content-center">
    <div class="panel panel-default mx-auto">
            <div class="panel-body">
                <h2>Inscription</h2>
                <form id="signupForm" method="get" class="form-horizontal"
                      action="">


                    <div class="form-group">
                        <label  class="col-sm-4 control-label" for="sex"> Sex : </label>
                        <div class="col-sm-4 col-sm-offset-0">
                            <label class="radio-inline" for="gender_male"> <input type="radio"
                                                                                  id="gender_male" value="m" name="sex">Male
                            </label> <label  class="radio-inline" for="gender_female"> <input type="radio"
                                                                                              id="gender_female" value="f" name="sex">Female
                            </label>

                        </div>
                    </div>            
                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="prenom">Prenom:</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="prenom"
                                   name="prenom" placeholder="prenom" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="nom">Nom:</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="nom"
                                   name="nom" placeholder="nom" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="email">Email :</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="email"
                                   name="email" placeholder="Email" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="password">Mot de passe :</label>
                        <div class="col-sm-5">
                            <input type="password" class="form-control" id="password"
                                   name="password" placeholder="Password" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="confirm_password">Confirmation du mot de passe</label>
                        <div class="col-sm-5">
                            <input type="password" class="form-control"
                                   id="confirm_password1" name="confirm_password"
                                   placeholder="Confirm password" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-4 control-label" for="programme">Choix du role : </label>
                        <div class="col-sm-5">      
                            <select class="custom-select" name="programme" title = "Choisissez un role" required>


                                <option value=""></option>
                                <option value="administrateur">Administrateur</option>
                                <option value="visiteur">Visiteur</option>
                                <option value="étudiant">Étudiant</option>
                                <option value="professeur">Professeur</option>
                             

                            </select>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-sm-9 col-sm-offset-4">

                                  <input type="submit"  class="btn btn-primary btn-lg btn-inscr" 
                                         value="Inscription"  id="submit" />

                        </div>
                    </div>
                </form>
            </div>
        </div>
                </div>
        </div>
        <footer>

           </div>    <jsp:include page="pied.jsp"/>
           </div>
    
        </footer>  

        <script src="js/formValidation.js"></script>

    </body>
</html>
