package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO;
import model.Donnee;

@WebServlet(name = "Frequence", urlPatterns = {"/Frequence"})
public class Frequence extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String vu_nonC = "/index.jsp";
            String vu = "/freq.jsp";
            HttpSession session = request.getSession(false);
            
            try {
                String result=(String) session.getAttribute("nom");
                if (result!=null){
                    DAO dao = new DAO(DAO.getDataSource());
                    Donnee donnee = dao.derniereDonnee((int) session.getAttribute("id"));  
                    int test = donnee.getValeur();                           
                    if(test==0){
                        request.setAttribute("valeur","XX");
                        request.setAttribute("date","Vous n'avez pas de valeurs enregistrées");
                        request.setAttribute("heure","Vous n'avez pas de valeurs enregistrées");
                    }else{
                    request.setAttribute("valeur",donnee.getValeur());
                    request.setAttribute("date",donnee.getDate());
                    request.setAttribute("heure",donnee.getHeure());
                    }
                    request.getRequestDispatcher(vu).forward(request, response);                    
                }else{
                request.getRequestDispatcher(vu_nonC).forward(request, response);    
                }
            } catch (Exception e) {
                request.getRequestDispatcher(vu_nonC).forward(request, response);
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
    }// </editor-fold>

}
