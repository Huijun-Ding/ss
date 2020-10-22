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
import Model.Entreprise;
import Model.Entreprise;
import Model.EvaluationClient;
import Model.Intervenant;
import Model.Tache;
import java.util.List;
import java.util.Map;

/**
 *
 * @author leonl
 */
public class ClientvsBDDao {
    public void addClient(Entreprise entreprise){
        String sql="insert into client values(null,'E',null,null,?,?,?,?,?,?,?,null,?,?,?,?,?)";
        Query();
        afferentSQL(sql);
        parameter.add(entreprise.getTelClient());
        parameter.add(entreprise.getEmail());
        parameter.add(entreprise.getNumRue());
        parameter.add(entreprise.getNumClient());
        parameter.add(entreprise.getVilleClient());
        parameter.add(entreprise.getCodePostalC());
        parameter.add(entreprise.getCarteBancaire());
        parameter.add(entreprise.getRaisonSocial());
        parameter.add(entreprise.getNoSiret());
        parameter.add(entreprise.getNomCorrespondant());
        parameter.add(entreprise.getPrenomCorrespondant());
        parameter.add(entreprise.getDomaine());
        int ligne=Update();
        if(ligne>=1){
            System.out.println("succcess");
        };  
    }
    
    public void ChangerTachEtat(Tache tache){
        String sql="UPDATE tache SET Etat_Tache= ? WHERE ID_tache=?";
        parameter.add(tache.getEtat());
        parameter.add(tache.getId());
        Query();
        afferentSQL(sql);
    }
    
    public Map<String, Object> getClient(Client client){
        String sql="select * from client where Emailc=?";
        Query();
        parameter.add(client.getEmail());
        afferentSQL(sql);
        List<Object> objs=Select();
        Map<String, Object> mesInfos = (Map<String, Object>)objs.get(0);
        return mesInfos;
    }
    
    
    public void createTache(Client client, Tache tache){
        String sql="insert into tache values(?,?,?,?,?,null,?,?,?,?,?)";
        Query();
        parameter.add(client.getNumClient());
        parameter.add(tache.getDateDeb());
        parameter.add(tache.getDateFin());
        parameter.add(tache.getDelais());
        parameter.add(tache.getDescription());
        parameter.add(tache.getDomanineTache());
        parameter.add("creer");
        parameter.add(tache.getNbPersonne());
        parameter.add(tache.getNomTache());
        parameter.add(tache.getPrix());
        Update();
    }
    
    
    public void affecteTacheIntervenant( Intervenant intervenant,Tache tache){
        String sql="insert into intervenir values(?,?)";
        parameter.add(intervenant.getNumInterv());
        parameter.add(tache.getNumTache());
        Update();
    }
    
    public void modifierTache(Tache tache){
        String sql="UPDATE tache SET Date_deb=?,Date_Fin=?,Delais =?,Description=?,Domaine_tache=?,Nb_personne=?,Nom_tache=?,Prix=? WHERE ID_tache=?";
        Query();
        afferentSQL(sql);
        parameter.add(tache.getDateDeb());
        parameter.add(tache.getDateFin());
        parameter.add(tache.getDelais());
        parameter.add(tache.getDescription());
        parameter.add(tache.getDomanineTache());
        parameter.add(tache.getNbPersonne());
        parameter.add(tache.getNomTache());
         parameter.add(tache.getPrix());
        int ligne=Update();
    }

    public void enregistrerEvalutaionCli(EvaluationClient eva){
        String sql="UPDATE client SET notec= ? WHERE Code_client=?";
        parameter.add(eva.getInter().getNumInterv());
        parameter.add(eva.getInter().getNoteIn());
        Update();
    }
    
    public void enregistreEvaluationInter(Tache tache){
        
    }
    
    public static void main(String[] args){
        Entreprise c=new Entreprise("1","1","1","1","1",1,"1",2,"1","1","1","1","1", (float) 2.3);
        ClientvsBDDao bd= new ClientvsBDDao();
        bd.addClient(c);
    }
    
}