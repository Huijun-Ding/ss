/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BD.Query;
import static BD.Query.Select;
import Model.Client;
import Model.Competence;
import Model.Tache;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 92930
 */
public class TacheclientDao {
        ArrayList<Tache> lsttache;
        ArrayList<Competence> lstcompetence;
         public ArrayList<Tache> tacheclient(Client client){
                 String sqltache = "select * from tache where Code_client=? "; //Tout le tache d'un client
                 Query go = new Query(); //connect
                 this.lsttache = new ArrayList<Tache>();
                 go.parameter.add(client.getNumClient());
                 go.afferentSQL(sqltache);
                 List<Object> objs=Select();
                 
                   for(int i=0;i<objs.size();i++){
                   Map<String,Object> rowData =(Map<String,Object>)objs.get(i);
                   Tache tache =new Tache();
                  tache.setDateDeb((String) rowData.get("Date_deb"));
                  tache.setDateFin((String) rowData.get("Date_Fin"));
                  tache.setDelais((int) rowData.get("Delais"));
                  tache.setDescription((String) rowData.get("Description"));
                  tache.setDomanineTache((String) rowData.get("Domaine_tache"));
                  tache.setEtat((String) rowData.get("Etat_Tache"));
                  tache.setNbPersonne((int) rowData.get("Nb_personne"));
                  tache.setNomTache((String) rowData.get("Nom_tache"));
                  tache.setNumTache((int) rowData.get("ID_tache"));
                  tache.setPrix((float) rowData.get("Prix"));
                  lsttache.add(tache);
                    }
                 return lsttache;}
         
                   public ArrayList<Competence> competencetache(){
                   String sqlcompetence ="select * from affecter where ID_tache=? "; //
                    
                   Query go = new Query();
                           for (int i=0;i<lsttache.size();i++){
                                this.lstcompetence = new ArrayList<Competence>();
                                  go.parameter.add(lsttache.get(i).getNumTache());
                                  go.afferentSQL(sqlcompetence);
                                   List<Object> objs=Select(); //Chaque tâche a une liste de competence
                                   for(int j=0;j<objs.size();j++){
                                       Map<String,Object> rowData =(Map<String,Object>)objs.get(j);
                                         Competence competence =new Competence();        
                                         if (lstcompetence.contains(competence)==false)
                                         {lstcompetence.add(competence);}
                           } 
                          }
                           return lstcompetence;
                         }
}