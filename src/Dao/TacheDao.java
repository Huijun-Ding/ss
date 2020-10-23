/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BD.Query;
import static BD.Query.Query;
import static BD.Query.Select;
import static BD.Query.Update;
import static BD.Query.afferentSQL;
import static BD.Query.parameter;
import Model.Client;
import Model.Competence;
import Model.EnumEtat;
import Model.EvaluationClient;
import Model.Intervenant;
import Model.Tache;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author leonl
 */
public class TacheDao {

    public TacheDao() {
    }
    ;
    ArrayList<Tache> lsttache;
    ArrayList<Competence> lstcompetence;

    public ArrayList<Tache> tacheclient(Client client) {
        String sqltache = "select * from tache where Code_client=? "; // recherche tous les taches d'un client
        Query(); //connect
        parameter.add(client.getNumClient());
        afferentSQL(sqltache);
        this.lsttache = new ArrayList<Tache>();
        List<Object> objs = Select();
        for (int i = 0; i < objs.size(); i++) {
            Map<String, Object> rowData = (Map<String, Object>) objs.get(i);
            Tache tache = new Tache();
            tache.setDateDeb((String) rowData.get("Date_deb"));
            tache.setDateFin((String) rowData.get("Date_Fin"));
            tache.setDelais((String) rowData.get("Delais"));
            tache.setDescription((String) rowData.get("Description"));
            tache.setDomanineTache((String) rowData.get("Domaine_tache"));
            tache.setEtat(EnumEtat.valueOf((String) rowData.get("Etat_Tache")));
            tache.setNbPersonne((int) rowData.get("Nb_personne"));
            tache.setNomTache((String) rowData.get("Nom_tache"));
            tache.setNumTache((int) rowData.get("ID_tache"));
            tache.setPrix((float) rowData.get("Prix"));
            lsttache.add(tache);
        }
        return lsttache;
    }

    public ArrayList<Competence> competencetache(Tache tache) throws SQLException {
        String sqlcompetence = "select * from affecter where ID_tache=? "; 
        Query go = new Query(sqlcompetence);
        go.parameter.add(tache.getNumTache());
        go.afferentSQL(sqlcompetence);
        this.lstcompetence = new ArrayList<Competence>();
        List<Object> objs = Select(); //Chaque tâche a une liste de competence
        for (int j = 0; j < objs.size(); j++) {
            Map<String, Object> rowData = (Map<String, Object>) objs.get(j);
            Competence competence = new Competence();
            competence.setNumP((int) rowData.get("Code_competence"));
            competence.setNomP((String) rowData.get("Libelle"));
            lstcompetence.add(competence);
        }
        return lstcompetence;
    }

    public void ChangerTachEtat(Tache tache) {
        String sql = "UPDATE tache SET Etat_Tache= ? WHERE ID_tache=?";
        parameter.add(tache.getEtat());
        parameter.add(tache.getNumTache());
        Query();
        afferentSQL(sql);
    }

    public void createTache(Tache tache) throws SQLException {
        // concentrer l'ordre d'Insertion ,et et La première valeur est le code tache et il sera généré automatiquement
        String sql = "insert into tache (Nom_tache,Description,Nb_personne,Delais,Prix,Domaine_tache,Etat_Tache,Date_deb ,Date_fin, Code_client) values (?,?,?,?,?,?,?,?,?,?)";
        Query q = new Query(sql);
        //q.afferentSQL(sql);
        parameter.add(tache.getNomTache()); //Remplacez les paramètres dans l'ordre
        parameter.add(tache.getDescription());
        parameter.add(tache.getNbPersonne());
        parameter.add(tache.getDelais());
        parameter.add(tache.getPrix());
        parameter.add(tache.getDomanineTache());
        parameter.add(tache.getEtat().toString());
        parameter.add(tache.getDateDeb());
        parameter.add(tache.getDateFin());
        parameter.add(tache.getClientId());
        q.Update();

    }

    public void affecteTacheIntervenant(Intervenant intervenant, Tache tache) {
        String sql = "insert into intervenir values(?,?)";
        parameter.add(intervenant.getNumInterv());
        parameter.add(tache.getNumTache());
        Update();
    }

    public void modifierTache(Tache tache) throws SQLException {
        String sql = "UPDATE tache SET Date_deb=?,Date_Fin=?,Delais =?,Description=?,Domaine_tache=?,Nb_personne=?,Nom_tache=?,Prix=? WHERE ID_tache=?";
        Query q = new Query(sql);
        q.Query();
        q.afferentSQL(sql);
        
        parameter.add(tache.getDateDeb());
        parameter.add(tache.getDateFin());
        parameter.add(5);
        parameter.add(tache.getDescription());
        parameter.add(tache.getDomanineTache());
        parameter.add(tache.getNbPersonne());
        parameter.add(tache.getNomTache());
        parameter.add(tache.getPrix());
        int ligne = q.Update();
    }

    public void enregistrerEvalutaionCli(EvaluationClient eva) {
        String sql = "UPDATE client SET notec= ? WHERE Code_client=?";
        parameter.add(eva.getInter().getNumInterv());
        parameter.add(eva.getInter().getNoteIn());
        Update();
    }

    public void enregistreEvaluationInter(Tache tache) {

    }

}
