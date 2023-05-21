<%-- 
    Document   : listeEtudiant
    Created on : 22-Mar-2023, 11:00:51 PM
    Author     : Vince
--%>
<%@page import="com.ralphchg.portaildepartementinformatique.model.entities.Utilisateur"%>
<%@page import="java.util.ArrayList"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Afficher Etudiant</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">


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
<nav class="navbarDep">
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
        


  


        
        
        <div class="menuClass">
  <p class="menu-label">Menu</p>
</div>
<div class="sidebar">
      <ul>
    <li><a href="#">Recherche</a></li>
    <hr>
        <li><a href="#">Projets des étudiants</a></li>
    <hr>
    <li><a href="#">Documents des professeurs</a></li>
    <hr>
    <li><a href="listeEtudiant.jsp">Liste des étudiants</a></li>
    <hr>
    <li><a href="#">Liste des profs</a></li>
  </ul>
</div>
        
        
                <h2></h2>
        <c:choose>
          
            <c:when test= "${not empty requestScope.listeRoles}">
                 <h2>${requestScope.listeRoles}</h2> 
            </c:when>
            <c:otherwise>
                <h2>Liste des utilisateurs</h2>
            </c:otherwise>
        </c:choose>


     

        <table style="width:79%">
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Mot de passe</th>


            </tr>
            <c:choose>
                
                <c:when test= "${not empty requestScope.utilisateur}">
                    <tr>
                        <td>${utilisateur.id}  </td>

                        <td>${utilisateur.nom} </td>
                        <td>${utilisateur.prenom}   </td>
                        <td> ${utilisateur.password}  </td>
                    </tr>
                </c:when>
                <c:otherwise>
                <c:forEach var="user" items="${requestScope.listeUtilisateurs}" >
                        <tr>
                            <td>${user.id}  </td>

                            <td>${user.nom} </td>
                            <td>${user.prenom}   </td>
                            <td> ${user.password}  </td>


                        </tr>

                    </c:forEach>
                </c:otherwise>
            </c:choose>

        </table>


    </body>
</html>


