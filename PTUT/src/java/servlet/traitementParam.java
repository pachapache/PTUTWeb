package servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO;

//Permet de traiter la modification des informations de l'utilisateur
@WebServlet(name = "traitementParam", urlPatterns = {"/traitementParam"})
public class traitementParam extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);
        String vu_Valide = "/accueilC.jsp";//Problèmes dans les valeurs entrées
        String vu_Invalide = "/param.jsp";//Modifications prisent en compte

        //Traiter les modifications
        if (request.getParameter("ancienMail").equals(session.getAttribute("mail")) & request.getParameter("ancienMdp").equals(session.getAttribute("mdp"))
                & request.getParameter("mail").equals(request.getParameter("newMail")) & request.getParameter("mdp").equals(request.getParameter("newMdp"))) {
            int poids = Integer.parseInt(request.getParameter("poids"));
            boolean sportif = Boolean.parseBoolean(request.getParameter("sportif"));
            String mail = request.getParameter("mail");
            String mdp = request.getParameter("mdp");
            try {
                DAO dao = new DAO(DAO.getDataSource());
                int modif = dao.editUtilisateur(poids, sportif, mail, mdp, (int) session.getAttribute("id"));
                if (modif == 1) {
                    request.getRequestDispatcher(vu_Valide).forward(request, response);
                    session.setAttribute("poids", poids);
                    session.setAttribute("sportif", sportif);
                    session.setAttribute("mail", mail);
                    session.setAttribute("mdp", mdp);
                } else {
                    request.getRequestDispatcher(vu_Invalide).forward(request, response);
                }
            } catch (Exception ex) {
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