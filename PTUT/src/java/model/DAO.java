package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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

    //Permet de confirmer la connexion
    //renvoi TRUE si mail et mot de passe dans la base de données
    //renvoi FALSE sinon
    public boolean login(String id, String mdp) throws Exception {
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
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    //Ajoute un utilisateur à la base de données
    public int inscription(String nom, String prenom, String sexe, java.sql.Date date, int poids,
            boolean sportif, String mail, String mdp) throws Exception {
        int result = 0;
        String sql = "INSERT INTO utilisateur VALUES (null,?,?,?,?,?,?,?,?)";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, sexe);
            stmt.setDate(4, date);
            stmt.setInt(5, poids);
            stmt.setBoolean(6, sportif);
            stmt.setString(7, mail);
            stmt.setString(8, mdp);
            result = stmt.executeUpdate();
        }
        System.out.println(result);
        return result;
    }

    //Récupère id à partir de l'adresse mail de l'individu
    public int idByMail(String mail) throws Exception {
        int result = 0;
        String sql = "SELECT id_utilisateur FROM utilisateur WHERE adresse_mail = ?  ";
        PreparedStatement stmt = null;
        try {
            Connection connection = myDataSource.getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, mail);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    result = rs.getInt("ID_UTILISATEUR");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    //Trouve un utilisateur à partir de son identifiant 
    public Utilisateur findUtilisateur(int id) throws Exception {
        Utilisateur result = null;
        String sql = "SELECT * FROM utilisateur WHERE id_utilisateur = ?  ";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id_user = rs.getInt("ID_UTILISATEUR");
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String sexe = rs.getString("SEXE");
                    Date ddn = rs.getDate("DATE");
                    int poids = rs.getInt("POIDS");
                    boolean sport = rs.getBoolean("SPORTIF");
                    String mail = rs.getString("ADRESSE_MAIL");
                    String mdp = rs.getString("MDP");
                    result = new Utilisateur(id_user, nom, prenom, sexe, ddn, poids, sport, mail, mdp);
                }
            }
        }
        return result;
    }

    public int editUtilisateur(int poids, boolean sportif, String mail, String mdp, int id) throws Exception {
        int result = 0;
        String sql = "UPDATE utilisateur SET poids = ?, sportif = ?, adresse_mail = ?, mdp = ? WHERE id_utilisateur=?";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, poids);
            stmt.setBoolean(2, sportif);
            stmt.setString(3, mail);
            stmt.setString(4, mdp);
            stmt.setInt(5, id);
            result = stmt.executeUpdate();
        }
        return result;
    }

    public ArrayList<Donnee> statQuotidien(int idIndiv) {
        return null;
        //List de statistique quoitidien
    }

}
