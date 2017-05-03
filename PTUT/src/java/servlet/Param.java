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

//Permet la redirection vers la page de paramètres en cas de connexion
@WebServlet(name = "Param", urlPatterns = {"/Param"})
public class Param extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String vu_nonC = "/index.jsp"; //Session inactive
        String vu = "/param.jsp"; //Session active

        HttpSession session = request.getSession(false);
        try {
            String result = (String) session.getAttribute("nom");
            //Coche les informations relatives au sexe et au sport
            if (result != null) {
                if (session.getAttribute("sexe") == "Homme") {
                    request.getServletContext().setAttribute("sexe1", "checked");
                } else {
                    request.getServletContext().setAttribute("sexe2", "checked");
                }
                if ((boolean) session.getAttribute("sportif") == true) {
                    System.out.println(session.getAttribute("sportif"));
                    request.getServletContext().setAttribute("sport1", "checked");
                } else {
                    request.getServletContext().setAttribute("sport2", "checked");
                }
                request.getRequestDispatcher(vu).forward(request, response);
            } else {
                request.getRequestDispatcher(vu_nonC).forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(Param.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher(vu_nonC).forward(request, response);
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