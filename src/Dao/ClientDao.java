/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BD.Query;
import static BD.Query.Query;
import static BD.Query.Select;
import static BD.Query.afferentSQL;
import static BD.Query.parameter;
import Model.Client;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

/**
 *
 * @author leonl
 */
public class ClientDao {

 
        public Client login(String email,String mdp){
            
            String sqlclient = "select * from client where EmailC=? and Password=? ";
            Client clientres = null;
            Query go = new Query();
            go.parameter.add(email);
            go.parameter.add(mdp);
           
            go.afferentSQL(sqlclient);
            List<Object> objs=Select();
            System.out.println(objs);
            //Ensemble de résultats
            Map<String,Object> rowData =(Map<String,Object>)objs.get(0);//Prendre la première ligne
            
            if(rowData.get("Password").equals(mdp) && rowData.get("EmailC").equals(email))
            {  
                clientres=new Client();
                clientres.setCarteBancaire((String) rowData.get("NumCarteBancaire"));
                clientres.setCodePostalC((String) rowData.get("CodePostal"));
                clientres.setEmail(email);
                clientres.setNoteC((float) rowData.get("NoteC"));   
                clientres.setNumClient((int) rowData.get("Code_client"));
                clientres.setPassword(mdp);
                clientres.setRurClient((String) rowData.get("NumRue")+rowData.get("NomRue"));
                clientres.setTelClient((String) rowData.get("TelC"));
                clientres.setVilleClient((String) rowData.get("VilleC"));  
                System.out.println(" connexion réussie! welcome client");
              return clientres;
            }
            else {
        System.out.println(" La connexion de client a échoué");
            return null;}
        }
       public static void main(String[] args) {

        ClientDao clogin = new ClientDao();
        clogin.login("929302356@qq.com","049988");
        // TODO code application logic here
    }
}
