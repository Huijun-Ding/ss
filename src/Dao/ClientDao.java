/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import static BD.Query.Query;
import static BD.Query.Select;
import static BD.Query.Update;
import static BD.Query.afferentSQL;
import static BD.Query.parameter;
import Model.Client;
import Model.Entreprise;
import Model.Particulier;
import java.util.List;
import java.util.Map;

/**
 *
 * @author leonl
 */

/*Nous avons testé avec succès la connexion  et l'inscription des utilisateurs,
consulter des taches des utilisateurs et la création de nouvelles tâches,
ces méthodes peuvent réaliser l'interaction entre l’interfase et la base de données.
Par contres les autres ne sont pas encore réalisées. Mais chaque méthode impliquant SQL peut réussir à réaliser l'interaction avec la BD,
seulement l'interaction avec l'interaction n'a pas encore été réalisée.
Et l'interface peut foncitionner entièrement indépendamment en fonction de chaque instance dans "main".*/
public class ClientDao {
        public ClientDao(){};
     public Client login(String email) {

        String sqlclient = "select * from client where EmailC=?";
        Client clientres = null;
        Query();
        parameter.add(email);//Remplacez les paramètres donc le "?"
        afferentSQL(sqlclient);
        List<Object> objs = Select();//Ensemble de résultats

        if(objs.size()==0){
            System.out.println("suibian ");
            return null;
        }
        //Ensemble de résultats
        Map<String, Object> rowData = (Map<String, Object>) objs.get(0);//tirer le premier ligne parceque y a qu'un
       
            clientres = new Client();
            clientres.setCarteBancaire((String) rowData.get("NumCarteBancaire")); //Obtenir toutes les informations
            clientres.setCodePostalC((String) rowData.get("CodePostal"));
            clientres.setEmail(email);
            clientres.setNoteC((float) rowData.get("NoteC"));
            clientres.setNumClient((int) rowData.get("Code_client"));
            clientres.setPassword((String) rowData.get("Password"));
            clientres.setRurClient((String)rowData.get("NomRue"));
            clientres.setTelClient((String) rowData.get("TelC"));
            clientres.setVilleClient((String) rowData.get("VilleC"));
            System.out.println(clientres);
            //System.out.println(" connexion réussie! welcome client");
            System.out.println("mima"+clientres.getMotdepasseC());
            return clientres;
       
    }
     
      public void addEntreprise(Entreprise entreprise){
        String sql="insert into client values(null,'E',null,null,?,?,?,?,?,?,?,null,?,?,?,?,?)";// Inserer la position correspondante
        Query();
        afferentSQL(sql);
        parameter.add(entreprise.getTelClient());
        parameter.add(entreprise.getEmail());
        //parameter.add(entreprise.getNumRue());
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
     public void addParticulier(Particulier particulier){                                         
        String sql="insert into client values(null,'P',?,?,?,?,0,?,?,?,?,?,null,null,null,null,null,?,0)";
        Query();
        afferentSQL(sql);
        
        parameter.add(particulier.getNomPart());
        parameter.add(particulier.getPrenomPart());
        parameter.add(particulier.getTelClient());
        parameter.add(particulier.getEmail());
        parameter.add(particulier.getRurClient());
        parameter.add(particulier.getVilleClient());
        parameter.add(particulier.getCodePostalC());
        parameter.add(particulier.getCarteBancaire());
        parameter.add(particulier.getCivilité());
        parameter.add(particulier.getMotdepasseC());
        int ligne=Update();
        if(ligne>=1){
            System.out.println("succcess");
        };  
    }
     

}
