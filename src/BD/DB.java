/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author mamad
 */
public class DB {
    
    private String BDD;
    private String url;
    private String user;
    private String passwd;

    public DB(String BDD, String url, String user, String passwd) {
        this.BDD = BDD;
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }
    
    public void connexion(){
        
        String urlbdd = this.url+this.BDD;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(urlbdd, user, passwd);
            System.out.println("Connecté avec succès !");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Erreur");
            System.exit(0);
        }
        
    }
    
}
