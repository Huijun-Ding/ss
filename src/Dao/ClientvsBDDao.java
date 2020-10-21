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
    
    public void clientChangerTachEtat(Client client,Tache tache){
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
Code_client (MUL, int)
Colonne
Date_deb (date)
Colonne
Date_Fin (date)
Colonne
Delais (date)
Colonne
Description (varchar)
Colonne
Domaine_tache (varchar)
Colonne
Etat_Tache (varchar)
Colonne
ID_tache (PRI, int)
Colonne
Nb_personne (int)
Colonne
Nom_tache (varchar)
Colonne
Prix (float)
        String sql="insert into tache values(null,'E',null,null,?,?,?,?,?,?,?,null,?,?,?,?,?)";
         
    }
    
    
    public static void main(String[] args){
        Entreprise c=new Entreprise("1","1","1","1","1",1,"1",2,"1","1","1","1","1", (float) 2.3);
        ClientvsBDDao bd= new ClientvsBDDao();
        bd.addClient(c);
    }
    
}
