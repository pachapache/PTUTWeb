package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Permet la redirection en cas de connexion
@WebServlet(name = "Connexion", urlPatterns = {"/Connexion"})
public class Connexion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");

        String vu_connecte = "/accueilC.jsp";//Session active
        String vu_connexion = "/connexion.jsp";//Session non active

        HttpSession session = request.getSession(false);//Recupere session

        try {
            String result = (String) session.getAttribute("nom");
            if (result != null) {
                request.getRequestDispatcher(vu_connecte).forward(request, response);
            } else {
                String message = "<script> $(document).ready(function () {\n $(\"#pbConnexion\").hide();})</script>";
                //Enleve le message d'erreur de connexion
                request.getServletContext().setAttribute("error", message);
                request.getRequestDispatcher(vu_connexion).forward(request, response);
            }
        } catch (Exception e) {
            String message = "<script> $(document).ready(function () {\n $(\"#pbConnexion\").hide();})</script>";
            //Enleve le message d'erreur de connexion
            request.getServletContext().setAttribute("error", message);
            request.getRequestDispatcher(vu_connexion).forward(request, response);
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
    }

}