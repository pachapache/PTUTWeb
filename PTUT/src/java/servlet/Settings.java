package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@WebServlet(name = "Settings", urlPatterns = {"/Settings"})
public class Settings extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String vu = "/param.jsp";
            String vu_Valide = "/accueil.jsp";
          
            request.getRequestDispatcher(vu).forward(request, response);

            //Préremplir le formulaire
            try {
                DAO dao = new DAO(DAO.getDataSource());
                HttpSession session = request.getSession(false);
                int id_user = (int) session.getAttribute("id");
                try {
                    Utilisateur user = dao.findUtilisateur(id_user);
                    request.getServletContext().setAttribute("nom", user.getNom());
                    request.getServletContext().setAttribute("prenom", user.getPrenom());
                    String chek = "checked";
                    if (user.getSexe() == "Homme") {
                        request.getServletContext().setAttribute("sexe1", chek);
                    } else {
                        request.getServletContext().setAttribute("sexe2", chek);
                    }
                    request.getServletContext().setAttribute("ddn", user.getDateNaissance());
                    request.getServletContext().setAttribute("poids", user.getPoids());
                    if (user.isSportif() == true) {
                        request.getServletContext().setAttribute("sport1", chek);
                    } else {
                        request.getServletContext().setAttribute("sport2", chek);
                    }
                    request.getServletContext().setAttribute("sport", user.isSportif());

                } catch (Exception ex) {
                    Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Traiter les modifications
                if (request.getParameter("mail") != null) {
                    int poids = Integer.parseInt(request.getParameter("poids"));
                    boolean sportif = Boolean.parseBoolean(request.getParameter("sportif"));
                    String mail = request.getParameter("mail");
                    String mdp = request.getParameter("mdp");
                    try {
                        int modif = dao.editUtilisateur(poids, sportif, mail, mdp, id_user);
                        if (modif == 1) {
                        }
                    } catch (Exception ex) {
                        Logger.getLogger("JSONServlet").log(Level.SEVERE, "Action en erreur", ex);
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
                    }
                }
            } catch (NumberFormatException | SQLException ex) {
                Logger.getLogger("JSONServlet").log(Level.SEVERE, "Action en erreur", ex);
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
