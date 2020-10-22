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
           
            String sqlclient = "select * from client where EmailC=? and Password=? ";  //Trouvez la ligne correspondantes en fonction du email et du mot de passe saisis
            Client clientres = null;    //La valeur de retour initiale est vide    
            Query go = new Query(); //  L connexion de bd
            
            go.parameter.add(email); // Mettre  e-mail et le mot de passe respectivement dans la position du point d'interrogation de sql                                       
            go.parameter.add(mdp); 
           
            go.afferentSQL(sqlclient);    //Préparer SQL          
            List<Object> objs=Select(); ////Ensemble de résultats
            Map<String,Object> rowData =(Map<String,Object>)objs.get(0);//Prendre la première ligne
            
            if(rowData.get("Password").equals(mdp) && rowData.get("EmailC").equals(email)) //S'il y a une couple d'entrées dans la base de données, la connexion est réussie
            {  
                clientres=new Client(); //Instancier  le client
                clientres.setCarteBancaire((String) rowData.get("NumCarteBancaire")); //Obtenir des informations sur la base de données
                clientres.setCodePostalC((String) rowData.get("CodePostal"));
                clientres.setEmail(email);
                clientres.setNoteC((float) rowData.get("NoteC"));   
                clientres.setNumClient((int) rowData.get("Code_client"));
                clientres.setPassword(mdp);
                clientres.setRurClient((String) rowData.get("NomRue"));
                clientres.setNumRue((int) rowData.get("NumRue")); 
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
