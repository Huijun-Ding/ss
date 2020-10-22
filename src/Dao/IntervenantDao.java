/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BD.Query;
import static BD.Query.Select;
import Model.Client;
import Model.Intervenant;
import java.util.List;
import java.util.Map;

/**
 *
 * @author leonl
 */
public class IntervenantDao {
     //Laisser le client se connecter et renvoyer le client connecté
    public Intervenant login(String email,String mdp){
            String sqlinter = "select * from intervenant where Email_Inter=? and Password=? "; //Trouvez la ligne correspondantes en fonction du email et du mot de passe saisis
            Intervenant interres = null;
            Query go = new Query();
            go.parameter.add(email); 
            go.parameter.add(mdp);
            System.out.println(go.parameter);   
            go.afferentSQL(sqlinter);
            List<Object>objs=Select();
          
            //Ensemble de résultats
            Map<String,Object> rowData =(Map<String,Object>)objs.get(0);//Prendre la première ligne
            
            if(rowData.get("Password").equals(mdp) && rowData.get("Email_Inter").equals(email))
            {  
                interres=new Intervenant();
                interres.setCarteBancaireIn((String) rowData.get("Numero_carte_Bancaire"));
                interres.setCodePostalIn((String) rowData.get("Code_Postal"));
                interres.setEmail(email);
                interres.setNoteIn((float) rowData.get("NoteIn")); //
                interres.setNumInterv((int) rowData.get("Code_Intervevant"));
                interres.setPassword(mdp);
                interres.setRurInterv((String) rowData.get("Nom_Rue_Inter"));
                interres.setNumRue((int) rowData.get("Num_Rue_Inter")); 

                interres.setTelInterv((String) rowData.get("Telephone_Inter"));
                interres.setVilleInterv((String) rowData.get("Ville_Inter"));  
                System.out.println(" connexion réussie! welcome intervenant");
                return  interres;
              }
            else {
        System.out.println(" La connexion de intervenant a échoué");
            return null;}
        }
    
}
