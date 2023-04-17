/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.dahamada.chezbio.controller;


import com.ralphchg.portaildepartementinformatique.model.entities.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UtilisateurService;

/**
 *
 * @author dahamada
 */
public class AdministrationController extends HttpServlet {

    private List<Utilisateur> listeUtilisateurs;
    Utilisateur utilisateur = null;
    boolean retour = false;
    UtilisateurService utilisateurService = new UtilisateurService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nom = request.getParameter("nom");
        String nomRole = request.getParameter("role");
        String typeRole = request.getParameter("typeRole");
        String operation = request.getParameter("operation");
      String id = request.getParameter("id");
      
        request.setAttribute("roles", utilisateurService.afficherLesLesRoles());
        if (nom != null && !nom.equals("")) {
            utilisateur = utilisateurService.chercherUtilisateurParNom(nom);
            request.setAttribute("utilisateur", utilisateur);
            String listeRoles = " Profile de " + nom;
            request.setAttribute("listeRoles", listeRoles);
           // request.setAttribute("listeUtilisateurs", listeUtilisateurs);
            request.getRequestDispatcher("administration.jsp").forward(request, response);
        } else if (nomRole != null && !nomRole.equals("")) {
            System.out.println(" nomRole : " + nomRole);
             String listeRoles = " Role " + nomRole;
            request.setAttribute("listeRoles", listeRoles);
            utilisateur = utilisateurService.chercherUtilisateurParNomRole(nomRole);
            System.out.println("utilisateur nom : " + utilisateur.getNom());
            request.setAttribute("utilisateur", utilisateur);
            // request.setAttribute("listeUtilisateurs", listeUtilisateurs);
            request.getRequestDispatcher("administration.jsp").forward(request, response);
        } else if (typeRole != null && !typeRole.equals("")) {
            listeUtilisateurs = utilisateurService.trierUtilisateursParRole(typeRole);
            String listeRoles = "Liste des " +typeRole +"s";
           request.setAttribute("listeRoles", listeRoles);
            request.setAttribute("listeUtilisateurs", listeUtilisateurs);
            request.getRequestDispatcher("administration.jsp").forward(request, response);

        }else if(operation!=null){
              if(operation.equals("supprimer")){
               String message = "l'utilisateur dont l'id est " + id + " a été supprimé";
                int userId = Integer.parseInt(id);
  System.out.println("operation: " + operation);
 System.out.println("userId: " + userId);
                   retour = utilisateurService.supprimerUnUtilisateur(userId);
                  System.out.println("retour : " + retour);
                 if(retour){
                     System.out.println("suppression: ");
                request.setAttribute("message", message);
                      listeUtilisateurs = utilisateurService.afficherLesUtilisateurs();
            request.setAttribute("listeUtilisateurs", listeUtilisateurs);
            request.getRequestDispatcher("administration.jsp").forward(request, response);
               }

              }else{
               System.out.println("modification: ");
                  int userId = Integer.parseInt(id);
                 utilisateur = utilisateurService.chercherUtilisateurParID(userId);
                request.setAttribute("utilisateur", utilisateur);
                   request.getRequestDispatcher("modification.jsp").forward(request, response);
                 }
         }
         else {
            listeUtilisateurs = utilisateurService.afficherLesUtilisateurs();
            request.setAttribute("listeUtilisateurs", listeUtilisateurs);
            request.getRequestDispatcher("administration.jsp").forward(request, response);

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
