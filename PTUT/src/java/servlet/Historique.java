package servlet;

import com.google.gson.Gson;
import java.io.FileWriter;
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

//Permet d'afficher l'historique de l'utilisateur dans le cas ou ce dernier est connecté
@WebServlet(name = "Historique", urlPatterns = {"/Historique"})
public class Historique extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String vu_nonC = "/index.jsp"; //Session inactive
        String vu = "/historique.jsp"; //Session active
        HttpSession session = request.getSession(false);

        // Rempli un document JSON relatif aux données de l'utilisateur
        try {
            DAO dao = new DAO(DAO.getDataSource());
            try (FileWriter out = new FileWriter("C:\\Users\\Pauline\\Documents\\GitHub\\PTUTWeb\\PTUT\\web\\Output.json")) {
                Gson gson = new Gson();
                String gsonData = gson.toJson(dao.historique((int) session.getAttribute("id")));
                out.write(gsonData);
                int moyenne = dao.getMoyenne((int) session.getAttribute("id"));
                //Rempli la moyenne, l'écart type, la valeur minimale et maximale
                if (moyenne == 0) {
                    request.getServletContext().setAttribute("moyenne", "<b> pas de valeurs pour le moment </b>");
                } else {
                    request.getServletContext().setAttribute("moyenne", moyenne);
                }
                int ecart = dao.getEcart((int) session.getAttribute("id"));
                if (ecart == 0) {
                    request.getServletContext().setAttribute("ecart", "<b> pas de valeurs pour le moment </b>");
                } else {
                    request.getServletContext().setAttribute("ecart", ecart);
                }
                int min = dao.getMin((int) session.getAttribute("id"));
                if (min == 0) {
                    request.getServletContext().setAttribute("min", "<b> pas de valeurs pour le moment </b>");
                } else {
                    request.getServletContext().setAttribute("min", min);
                }
                int max = dao.getMax((int) session.getAttribute("id"));
                if (max == 0) {
                    request.getServletContext().setAttribute("max", "<b> pas de valeurs pour le moment </b>");
                } else {
                    request.getServletContext().setAttribute("max", max);
                }
            } catch (Exception ex) {
                Logger.getLogger("JSONServlet").log(Level.SEVERE, "Action en erreur", ex);
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
            }
        } catch (Exception ex) {
            Logger.getLogger("Servlet Connexion").log(Level.SEVERE, "Action en erreur", ex);
            request.setAttribute("message", ex.getMessage());
        }

        try {
            String result = (String) session.getAttribute("nom");
            if (result != null) {
                request.getRequestDispatcher(vu).forward(request, response);
            } else {
                request.getRequestDispatcher(vu_nonC).forward(request, response);
            }
        } catch (Exception e) {
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