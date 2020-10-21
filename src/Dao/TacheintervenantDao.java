/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BD.Query;
import static BD.Query.Select;
import Model.Competence;
import Model.Intervenant;
import Model.Tache;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 92930
 */
public class TacheintervenantDao {
        ArrayList<Tache> lsttacheIn;
        ArrayList<Competence> lstcompetenceIn;
        
         public ArrayList<Tache> tacheclient(Intervenant intervenant){
                 String sqltache = "select * from tache where Code_Intervevant=? "; //Tout le tache d'un client
                 Query go = new Query(); //connect
                 this.lsttacheIn = new ArrayList<Tache>();
                 go.parameter.add(intervenant.getNumInterv());
                 go.afferentSQL(sqltache);
                 List<Object> objs=Select();
                 
                   for(int i=0;i<objs.size();i++){
                   Map<String,Object> rowData =(Map<String,Object>)objs.get(i);
                   Tache tache =new Tache();
                  tache.setDateDeb((String) rowData.get("Date_deb"));//数据库里类型要改成string 现在是date
                  tache.setDateFin((String) rowData.get("Date_Fin"));//数据库里类型要改成string
                  tache.setDelais((int) rowData.get("Delais"));//数据库里是 date 要改成 int
                  tache.setDescription((String) rowData.get("Description"));
                  tache.setDomanineTache((String) rowData.get("Domaine_tache"));
                  tache.setEtat((String) rowData.get("Etat_Tache"));
                  tache.setNbPersonne((int) rowData.get("Nb_personne"));
                  tache.setNomTache((String) rowData.get("Nom_tache"));
                  tache.setNumTache((int) rowData.get("ID_tache"));
                  tache.setPrix((float) rowData.get("Prix"));
                  lsttacheIn.add(tache);
                    }
                 return lsttacheIn;}
    
         public ArrayList<Competence> competencetache(){
                   String sqlcompetence ="select * from affecter where ID_tache=? "; //还不确定commpetence 和 tache 同在的那个表的名字
                   Query go = new Query();
                           for (int i=0;i<lsttacheIn.size();i++){
                                this.lstcompetenceIn = new ArrayList<Competence>();
                                  go.parameter.add(lsttacheIn.get(i).getNumTache());
                                  go.afferentSQL(sqlcompetence);
                                   List<Object> objs=Select(); //Chaque tâche a une liste de competence
                                   for(int j=0;j<objs.size();j++){
                                       Map<String,Object> rowData =(Map<String,Object>)objs.get(j);
                                         Competence competence =new Competence();          
                                         lstcompetenceIn.add(competence);
                           } 
                          }
                           return lstcompetenceIn;
                         }
         
         
}
