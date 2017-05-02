package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


// Permet la redirection en cas de connexion
@WebServlet(name = "Inscription", urlPatterns = {"/Inscription"})
public class Inscription extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        String vu_connecte = "/accueilC.jsp";
        String vu_connexion = "/inscription.jsp";
        HttpSession session = request.getSession(false);

        try {
            String result = (String) session.getAttribute("nom");
            if (result != null) {
                request.getRequestDispatcher(vu_connecte).forward(request, response);
            } else {
                request.getRequestDispatcher(vu_connexion).forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher(vu_connexion).forward(request, response);
        }
    }


    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
