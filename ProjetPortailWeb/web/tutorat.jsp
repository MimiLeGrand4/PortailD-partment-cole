<%-- 
    Document   : tutorat
    Created on : 22-Mar-2023, 11:05:21 PM
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
        <title>Aide et Tutorat</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet"  href="css/style.css" media="screen and (min-width: 481px)"/>
        <link rel="stylesheet"   href="css/style.css" media="screen and (max-width: 480px)"/>
        <style>


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
    <body>
        <div class="container">
      <h2 class="mt-5">Vous cherché de l'aide?</h2>
      <form>
        <div class="form-group">
          <label for="cours">Choisir un cours en difficulté :</label>
          <select class="form-control" id="cours" name="cours">
            <option value="reseau">Réseautique</option>
            <option value="programmation">Programmation</option>
          </select>
        </div>
        <div class="form-group">
          <label for="description">Description de la difficulté :</label>
          <textarea class="form-control" id="description" name="description"></textarea>
        </div>
        <div class="form-group">
          <label for="type-rencontre">Choisir le type de rencontre :</label>
          <select class="form-control" id="type-rencontre" name="type-rencontre">
            <option value="en-ligne">En ligne</option>
            <option value="en-presentiel">En présentiel</option>
          </select>
        </div>
        <div class="form-group">
          <label for="disponibilites">Indiquer vos disponibilités pour un rendez-vous :</label>
          <input type="datetime-local" class="form-control" id="disponibilites" name="disponibilites">
        </div>
        <div class="form-group">
          <label for="cherche-tuteur">Chercher un tuteur :</label>
          <input type="text" class="form-control" id="cherche-tuteur" name="cherche-tuteur">
        </div>
        <div class="form-group">
          <label for="tuteurs-disponibles">Tuteurs disponibles :</label>
          <select class="form-control" id="tuteurs-disponibles" name="tuteurs-disponibles">
            <option value="tuteur1">Alex</option>
            <option value="tuteur2">Justin</option>
            <option value="tuteur3">Micheal</option>
          </select>
        </div>
        <button type="submit" class="btn btn-primary">Envoyer la demande</button>
      </form>
      <hr class="mt-5">
      <h2 class="mt-5">Vous voulez devenir un étudiant tuteur?</h2>
      <form>
        <div class="form-group">
          <label for="cours-aider">Choisir un cours à aider :</label>
          <select class="form-control" id="cours-aider" name="cours-aider">
            <option value="reseau">Réseautique</option>
            <option value="programmation">Programmation</option>
          </select>
        </div>
        <div
                class="form-group">
      <label for="type-rencontre-aider">Choisir le type de rencontre :</label>
      <select class="form-control" id="type-rencontre-aider" name="type-rencontre-aider">
        <option value="en-ligne">En ligne</option>
        <option value="en-presentiel">En présentiel</option>
      </select>
    </div>
    <div class="form-group">
      <label for="disponibilites-aider">Indiquer vos disponibilités pour un rendez-vous :</label>
      <input type="datetime-local" class="form-control" id="disponibilites-aider" name="disponibilites-aider">
    </div>
    <button type="submit" class="btn btn-primary">S'inscrire</button>
  </form>
        </div>
        
        <footer class="footer">

           </div>    <jsp:include page="pied.jsp"/>
           </div>
    
        </footer>  
        

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>