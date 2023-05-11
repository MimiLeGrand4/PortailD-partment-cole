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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.UtilisateurService;

/**
 *
 * @author dahamada
 */
public class ConnexionControlleur extends HttpServlet {
private List<Utilisateur> listeUtilisateurs;
 Utilisateur utilisateur = null;
UtilisateurService  service = new UtilisateurService();
 public void init() throws ServletException{
  listeUtilisateurs =  service.afficherLesUtilisateurs();
}

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
  boolean connexion = false;
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        System.out.println("email " + email);
        String password = request.getParameter("password");
        String sauvegarde = request.getParameter("sauvegarde");
     utilisateur = service.verifierEmailMotDePasse(email, password);

  
         
                if (utilisateur != null) {
                 
                        connexion = true;
                        HttpSession session = request.getSession(true);
                        session.setAttribute("nom", utilisateur.getNom());
                        session.setAttribute("prenom", utilisateur.getPrenom());

                        if (sauvegarde != null) {
                            if (sauvegarde.equals("yes")) {
                                Cookie monCookie = new Cookie("email", email);
                                Cookie passwordCookie = new Cookie("password", password);
                                System.out.println("ajouter des cookies");
                                passwordCookie.setMaxAge(60 * 60);
                                monCookie.setMaxAge(60 * 60);
                                response.addCookie(monCookie);
                                response.addCookie(passwordCookie);
                            }
                        }
                        request.getRequestDispatcher("index.jsp").forward(request, response);

                    

                }

            
      

        if (!connexion) {
         ///   out.println("<center><b><font color=red>" + "L'email ou mot de passe invalide" + "</font><b></center>");
            request.setAttribute("invalide", "L'email ou mot de passe est invalide");
            request.getRequestDispatcher("connexion.jsp").include(request, response);
           
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
