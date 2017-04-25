package servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.Utilisateur;

@WebServlet(name = "Inscription", urlPatterns = {"/Inscription"})
public class Inscription extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String sexe = request.getParameter("sexe");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(request.getParameter("ddn"));
            java.sql.Date date = new java.sql.Date(date1.getTime());                     
            int poids = Integer.parseInt(request.getParameter("poids"));
            boolean sportif = Boolean.parseBoolean(request.getParameter("sportif"));
            String mails = request.getParameter("mail");
            String vMails = request.getParameter("confirmMail");
            String mdp = request.getParameter("mdp");
            String vMdp = request.getParameter("confirmMdp");
            String vu_connValide = "/page_accueil.jsp";
            String vu_connInvalide = "/page_inscription.jsp";               
                
            try {
                DAO dao = new DAO(DAO.getDataSource());
                int imple = dao.inscription(nom, prenom, sexe, date, poids, sportif, mails, mdp);
                
                if(imple != 1){
                    request.getRequestDispatcher(vu_connInvalide).forward(request, response);
                }else{
                    request.getRequestDispatcher(vu_connValide).forward(request, response);
                }
            } catch (Exception ex) {
		Logger.getLogger("JSONServlet").log(Level.SEVERE, "Action en erreur", ex);
		response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
            }
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
