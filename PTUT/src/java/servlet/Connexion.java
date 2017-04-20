package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;

@WebServlet(name = "Connexion", urlPatterns = {"/Connexion"})
public class Connexion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String mails = request.getParameter("identifiant");
            String mdp = request.getParameter("motDePasse");
            String vu_connValide = "/page_accueil.jsp";
            String vu_connInvalide = "/page_connexion.html";
            
            try {
                DAO dao = new DAO(DAO.getDataSource());
                boolean connexion = dao.login(mails, mdp);
                
                if(connexion ==true){
                    request.getRequestDispatcher(vu_connValide).forward(request, response);
                }else{
                    request.getRequestDispatcher(vu_connInvalide).forward(request, response);
                }

            } catch (Exception ex) {
                Logger.getLogger("Servlet Connexion").log(Level.SEVERE, "Action en erreur", ex);
                request.setAttribute("message", ex.getMessage());
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
