package servlet;

import java.io.IOException;
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

//Permet de traiter l'inscription d'un individu
@WebServlet(name = "traitementInscription", urlPatterns = {"/traitementInscription"})
public class traitementInscription extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Recupère les informations entrées par l'individu
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
        
        String vu_connValide = "/connexion.jsp";//Problème dans l'inscription
        String vu_connInvalide = "/inscription.jsp";//Inscription valide

        if (mails.equals(vMails) && mdp.equals(vMdp)) {//Verification de l'identité des valeurs entrées
            try {
                DAO dao = new DAO(DAO.getDataSource());
                int imple = dao.inscription(nom, prenom, sexe, date, poids, sportif, mails, mdp);
                if (imple != 1) {
                    request.getRequestDispatcher(vu_connInvalide).forward(request, response);
                } else {
                    String message = "<script> $(document).ready(function () {\n $(\"#pbConnexion\").hide();})</script>";
                    //Enleve le message d'erreur de connexion
                    request.getServletContext().setAttribute("error", message);
                    request.getRequestDispatcher(vu_connValide).forward(request, response);
                }
            } catch (Exception ex) {
                Logger.getLogger("JSONServlet").log(Level.SEVERE, "Action en erreur", ex);
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
            }
        } else {
            request.getRequestDispatcher(vu_connInvalide).forward(request, response);
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
    }

}