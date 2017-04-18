package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

public class DAO {

    private final DataSource myDataSource;

    public DAO(DataSource dataSource) {
        this.myDataSource = dataSource;
    }


    public Boolean login(String id, String mdp) throws Exception {
        if (null == id) {
            throw new Exception("id is null");
        }
        if (null == id) {
            throw new Exception("mdp is null");
        }
        String login = null;
        boolean result = false;
        String sql = "SELECT MDP FROM individu WHERE ADRESSE_MAIL = ?";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    login = rs.getString("MDP");
                }
            }
        }
        if (login.equals(mdp)) {
            result = true;
        }
        return result;
    }
    
    public void inscription(String nom, String prenom, String sexe, int age, int poids, 
            boolean sportif, String mail, String mdp) throws Exception { 
        // Ajouter un individu à la base de données
    }
    
    public void editIndividu(String nom, String prenom, String sexe, int age, int poids, 
            boolean sportif, String mail, String mdp) throws Exception { 
        // Modifie les paramètres d'un individu dans la base de données
    }
    
    public ArrayList<Donnee> statQuotidien(int idIndiv){
        return null;
        //List de statistique quoitidien
    }
    

}
