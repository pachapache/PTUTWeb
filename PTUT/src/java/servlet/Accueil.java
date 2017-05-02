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

//Permet la redirection vers la bonne page : session active ou non
@WebServlet(name = "Accueil", urlPatterns = {"/Accueil"})
public class Accueil extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String vu_connexion = "/index.jsp";//Session non active
            String vu_connecte = "/accueilC.jsp";//Session active
            
            HttpSession session = request.getSession(false);//Recupere session
            
            try {
                String result=(String) session.getAttribute("nom");
                if (result!=null){
                request.getRequestDispatcher(vu_connecte).forward(request, response);
                }else{
                request.getRequestDispatcher(vu_connexion).forward(request, response);    
                }
            } catch (Exception e) {
                request.getRequestDispatcher(vu_connexion).forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (Exception ex) {
           Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
       }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (Exception ex) {
             Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
