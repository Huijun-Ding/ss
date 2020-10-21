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
    public Intervenant login(String email,String mdp){
            
            String sqlinter = "select * from intervenant where Email_Inter=? and Password=? "; //需要新建一个password 在 intervenant里
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
                interres.setNoteIn((float) rowData.get("NoteIn")); //需要新加一个attribut NoteIn float   
                interres.setNumInterv((int) rowData.get("Code_Intervevant"));
                interres.setPassword(mdp);
                interres.setRurInterv((String) rowData.get("Num_Rue_Inter")+rowData.get("Nom_Rue_Inter")); //不确定这么对不对 不对的话可以删掉一个numrue
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
