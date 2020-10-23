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
import Model.Competence;
import Model.Intervenant;
import java.util.List;
import java.util.Map;

/**
 *
 * @author leonl
 */
public class IntervenantDao {
public IntervenantDao(){};
    public Intervenant login(String email) {
        String sqlinter = "select * from intervenant where Email_Inter=?"; //Trouvez la ligne correspondantes en fonction du email et du mot de passe saisis
        Intervenant interres = null;
        Query();
        parameter.add(email);
        afferentSQL(sqlinter);
        List<Object> objs = Select();
        System.out.println(objs.get(0));
       if(objs.size()==0){
            System.out.println(" La connexion de intervenant a échoué");
            return null;
        }
        //Ensemble de résultats
        Map<String, Object> rowData = (Map<String, Object>) objs.get(0);//Prendre la première ligne

       
            interres = new Intervenant();
            interres.setCarteBancaireIn((String) rowData.get("Numero_carte_Bancaire"));
            interres.setCodePostalIn((String) rowData.get("Code_Postal"));
            interres.setEmail(email);
            interres.setNoteIn((float) rowData.get("NoteIn")); //
            interres.setNumInterv((int) rowData.get("Code_Intervevant"));
            interres.setMotdepasseI((String) rowData.get("Password"));
            interres.setRueInterv((String) rowData.get("Nom_Rue_Inter"));
            //interres.setNumRue((int) rowData.get("Num_Rue_Inter")); 
            interres.setTelInterv((String) rowData.get("Telephone_Inter"));
            interres.setVilleInterv((String) rowData.get("Ville_Inter"));
            System.out.println(" connexion réussie! welcome intervenant");
            return interres;
 
            
  
    }
        
    public void addIntervenant(Intervenant intervenant){
        String sql="insert into intervenant values(null,?,?,?,?,0,?,?,?,?,?,?)";
        Query();
        afferentSQL(sql);
        parameter.add(intervenant.getNomInterv());
        parameter.add(intervenant.getPrenomInterv());
        parameter.add(intervenant.getTelInterv());
        parameter.add(intervenant.getEmail());
        parameter.add(intervenant.getRueInterv());
        parameter.add(intervenant.getVilleInterv());
        parameter.add(intervenant.getCodePostalIn());
        parameter.add(intervenant.getCarteBancaireIn());
        parameter.add(intervenant.getMotdepasseI());
        parameter.add(intervenant.getNoteIn());
        int ligne=Update();
        if(ligne>=1){
            System.out.println("succcess");
        };  
        
        for(Competence comp: intervenant.getMesCompetences()){
            String newsql="insert into avoir values(?,?)";
            parameter.add(intervenant.getNumInterv());
            parameter.add(comp.getNumP());
            Query();
            afferentSQL(newsql);
        }

    }
    
//      public static void main(String[] args) {
//          IntervenantDao inDao=new IntervenantDao();
//          Intervenant in= new Intervenant();
//        in.setEmail("hello");
//        in.setNomInterv("j");
//        in.setPrenomInterv("j");
//        in.setTelInterv("h");
//        in.setRueInterv("j");
//        in.setVilleInterv("heu");
//        in.setCodePostalIn("hju");
//        in.setCarteBancaireIn("hjj");
//        in.setMotdepasseI("cccc");
//        inDao.addIntervenant(in);
//      }

}
