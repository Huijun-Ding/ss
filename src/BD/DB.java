/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

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
    
     public Client(){
        try { 
        DB db = new DB("bd_dolt", "jdbc:mysql://localhost:3306/", "root", "");
        db.connexion();
        Statement st = null;
        ResultSet srs = st.executeQuery("SELECT * FROM client");
        
        while (srs.next()) {
                Client newclient = new Client();
                
                newclient.(srs.getString("name"));
                newclient.setJobtitle(srs.getString("jobtitle"));
                newclient.setFrequentflyer(srs.getInt("frequentflyer"));
                lstusers.add(newclient);
            }
        }catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}

