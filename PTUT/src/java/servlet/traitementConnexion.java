package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO;
import model.Utilisateur;

@WebServlet(name = "traitementConnexion", urlPatterns = {"/traitementConnexion"})
public class traitementConnexion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String mails = request.getParameter("identifiant");
            String mdp = request.getParameter("motDePasse");
            String vu = "/connexion.jsp";
            String vu_Valide = "/accueilC.jsp";
            
            if(mails!=null&mdp!=null){               
                try {
                    DAO dao = new DAO(DAO.getDataSource());
                    boolean connexion = dao.login(mails, mdp);
                    if (connexion == true) {
                        HttpSession session = request.getSession(true);
                        Utilisateur user = dao.findUtilisateur(mails);
                        session.setAttribute("id",user.getId());
                        session.setAttribute("nom",user.getNom());
                        session.setAttribute("prenom", user.getPrenom());
                        session.setAttribute("sexe", user.getSexe());
                        session.setAttribute("date_naissance", user.getDateNaissance());    
                        session.setAttribute("poids", user.getPoids());
                        session.setAttribute("sportif",user.isSportif());
                        session.setAttribute("mail",user.getMail());
                        session.setAttribute("mdp",user.getMdp());
                        request.getRequestDispatcher(vu_Valide).forward(request, response);
                    } else {                      
                        String message = "<script> $(document).ready(function () {\n $(\"#pbConnexion\").show();})</script>";
                        request.getServletContext().setAttribute("error", message);
                        request.getRequestDispatcher(vu).forward(request, response);
                    }

                } catch (Exception ex) {
                    Logger.getLogger("Servlet Connexion").log(Level.SEVERE, "Action en erreur", ex);
                    request.setAttribute("message", ex.getMessage());
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
