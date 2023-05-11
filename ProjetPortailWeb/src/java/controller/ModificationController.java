/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

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
public class ModificationController extends HttpServlet {

    private List<Utilisateur> listeUtilisateurs;
    UtilisateurService utilisateurService = new UtilisateurService();
    Utilisateur utilisateur = null;
    boolean retour = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");
        String status = request.getParameter("status");
        String id = request.getParameter("id");
        boolean tuteur = Boolean.valueOf(status);

        String password = request.getParameter("password");
        int userId = Integer.parseInt(id);
        utilisateur = utilisateurService.chercherUtilisateurParID(userId);

        utilisateur.setEmail(email);
        utilisateur.setPassword(password);
        utilisateur.setTuteur(tuteur);
        retour = utilisateurService.modifierUnUtilisateur(utilisateur);
        if (retour) {
            String message = "l'utilisateur  " + utilisateur.getNom() + " " + utilisateur.getPrenom() + " a été mis à jour avec success ";
            listeUtilisateurs = utilisateurService.afficherLesUtilisateurs();
            request.setAttribute("message", message);
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
