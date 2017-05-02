package model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.Map;
import javax.sql.DataSource;
import java.util.HashMap;

public class DAO {

    private final DataSource myDataSource;

    public DAO(DataSource dataSource) {
        this.myDataSource = dataSource;
    }

    //Permet de se connecter à la base de données
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
    //renvoi 1 si insertion dans la base de donnees
    //renvoi 0 si pas d'insertion
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

    //Trouve un utilisateur à partir de son identifiant 
    //renvoi un utilisateur
    public Utilisateur findUtilisateur(String mail) throws Exception {
        Utilisateur result = null;
        String sql = "SELECT * FROM utilisateur WHERE adresse_mail = ?  ";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setString(1, mail);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id_user = rs.getInt("ID_UTILISATEUR");
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String sexe = rs.getString("SEXE");
                    Date ddn = rs.getDate("DATE");
                    int poids = rs.getInt("POIDS");
                    boolean sport = rs.getBoolean("SPORTIF");
                    String mails = rs.getString("ADRESSE_MAIL");
                    String mdp = rs.getString("MDP");
                    result = new Utilisateur(id_user, nom, prenom, sexe, ddn, poids, sport, mails, mdp);
                }
            }
        }
        return result;
    }

    //Permet de mofifier les informations d'un utilisateur : poids, sport, mail et mdp
    //renvoi 1 si modification dans la base de donnees
    //renvoi 0 si pas de modification
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

    //Permet de recuperer la dernière données d'un individu
    public Donnee derniereDonnee(int id) throws Exception {
        Donnee result = new Donnee(0, 0, null, null, 0);
        String sql = "SELECT * FROM donnees WHERE id_utilisateur = ? ORDER BY id_donnees DESC LIMIT 1; ";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id_donnee = rs.getInt("ID_DONNEES");
                    int id_utilisateur = rs.getInt("ID_UTILISATEUR");
                    Time heure = rs.getTime("HEURE_MESURE");
                    Date date = rs.getDate("DATE_MESURE");
                    int valeur = rs.getInt("VALEUR");
                    result = new Donnee(id_donnee, id_utilisateur, heure, date, valeur);
                }
            }
        }
        return result;
    }

    //Permet de recuperer la frequence moyenne d'un individu
    public int getMoyenne(int id) throws Exception {
        int result = 0;
        String sql = "SELECT AVG(valeur) FROM donnees WHERE id_utilisateur = ? ";
        PreparedStatement stmt = null;
        try {
            Connection connection = myDataSource.getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    result = rs.getInt("AVG(valeur)");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    //Permet de recuperer la frequence ecart-type d'un individu
    public int getEcart(int id) throws Exception {
        int result = 0;
        String sql = "SELECT STD(valeur) FROM donnees WHERE id_utilisateur = ? ";
        PreparedStatement stmt = null;
        try {
            Connection connection = myDataSource.getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    result = rs.getInt("STD(valeur)");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    //Permet de recuperer la frequence minimale d'un individu
    public int getMin(int id) throws Exception {
        int result = 0;
        String sql = "SELECT MIN(valeur) FROM donnees WHERE id_utilisateur = ? ";
        PreparedStatement stmt = null;
        try {
            Connection connection = myDataSource.getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    result = rs.getInt("MIN(valeur)");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    //Permet de recuperer la frequence maximale d'un individu
    public int getMax(int id) throws Exception {
        int result = 0;
        String sql = "SELECT MAX(valeur) FROM donnees WHERE id_utilisateur = ? ";
        PreparedStatement stmt = null;
        try {
            Connection connection = myDataSource.getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    result = rs.getInt("MAX(valeur)");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    //Permet de recuperer l'historique de l'individu
    public Map<String, Double> historique(int id) throws SQLException {
        Map<String, Double> result = new HashMap<>();
        String sqlQ = "SELECT AVG(Valeur), DAYOFWEEK(DATE_MESURE) FROM ptut_freq_res.donnees WHERE (id_utilisateur = ? ) group by DAYOFWEEK(DATE_MESURE)";
        String sqlH = "SELECT AVG(Valeur), HOUR(HEURE_MESURE) FROM ptut_freq_res.donnees WHERE (id_utilisateur = ? ) group by HOUR(HEURE_MESURE)";
        String sqlM = "SELECT AVG(Valeur), MONTH(STR_TO_DATE(DATE_MESURE,'%Y-%m-%d')) FROM ptut_freq_res.donnees WHERE (YEAR(STR_TO_DATE(DATE_MESURE,'%Y-%m-%d'))=YEAR(CURRENT_DATE)) AND (id_utilisateur = ? ) group by  MONTH(STR_TO_DATE(DATE_MESURE,'%Y-%m-%d'));";
        String sqlA = "SELECT AVG(Valeur), YEAR(STR_TO_DATE(DATE_MESURE,'%Y-%m-%d')) FROM ptut_freq_res.donnees WHERE (id_utilisateur = ? ) group by  YEAR(STR_TO_DATE(DATE_MESURE,'%Y-%m-%d'));";
        PreparedStatement stmt = null;
        try {
            Connection connection = myDataSource.getConnection();
            stmt = connection.prepareStatement(sqlQ);
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int jours = (rs.getInt("DAYOFWEEK(DATE_MESURE)"));
                    double valeur = rs.getDouble("AVG(valeur)");
                    try {
                        result.put("j"+jours, valeur);
                    } catch (Exception e) {
                        result.put(null, 0.0);
                    }
                }
            }
            stmt = connection.prepareStatement(sqlH);
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int heure = (rs.getInt("HOUR(HEURE_MESURE)"));
                    double valeur = rs.getDouble("AVG(valeur)");
                    try {
                        result.put("h"+heure, valeur);
                    } catch (Exception e) {
                        result.put(null, 0.0);
                    }
                }
            }
            stmt = connection.prepareStatement(sqlM);
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int mois = (rs.getInt("MONTH(STR_TO_DATE(DATE_MESURE,'%Y-%m-%d'))"));
                    double valeur = rs.getDouble("AVG(valeur)");
                    try {
                        result.put("m"+mois, valeur);
                    } catch (Exception e) {
                        result.put(null, 0.0);
                    }
                }
            }
            stmt = connection.prepareStatement(sqlA);
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int annee = (rs.getInt("YEAR(STR_TO_DATE(DATE_MESURE,'%Y-%m-%d'))"));
                    double valeur = rs.getDouble("AVG(valeur)");
                    try {
                        result.put("a"+annee, valeur);
                    } catch (Exception e) {
                        result.put(null, 0.0);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
}
