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
    
    public static DataSource getDataSource() throws SQLException {
		com.mysql.jdbc.jdbc2.optional.MysqlDataSource ds = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
		ds.setDatabaseName("ptut_freq_res");
		ds.setUser("root");
		ds.setPassword("root");
		ds.setServerName("localhost");
		ds.setPortNumber(3306);
		return ds;
	}


    public boolean login(String id, String mdp) throws Exception {
        if (null == id) {
            throw new Exception("id is null");
        }
        if (null == mdp) {
            throw new Exception("mdp is null");
        }
        
        boolean result = false;
        
        PreparedStatement stmt = null;
        String sql = "SELECT MDP FROM utilisateur WHERE ADRESSE_MAIL = ?";
        try {
            Connection connection = myDataSource.getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String login = rs.getString("MDP");
                    if (login.equals(mdp)) {
                        result = true;
                    }
                }
            }      
        }catch(SQLException e){
            System.out.println(e);
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
