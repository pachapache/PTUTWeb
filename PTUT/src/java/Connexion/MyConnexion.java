/*
 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnexion {

Connection conn;
String url = "jdbc:mysql://localhost:3306/ptut_freq_res";
String pwd="root";
String login="root";


public MyConnexion() {

}

public void connecteToi(){
    
    System.out.println("Iz ok");
    try {
        System.out.println("La Taupe est dans la taupiniere");
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver O.K.");
    } 
    catch (ClassNotFoundException ex) {
    System.out.println(ex.toString());
    }
    try{
    conn = DriverManager.getConnection(url, login, pwd);
        System.out.println("Connexion effective !");
        conn.close();
    }
    catch (SQLException ex) {
    System.out.println(ex.toString());
    }
}
}