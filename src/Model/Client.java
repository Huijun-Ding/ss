package Model;

import java.util.ArrayList;

public class Client {

    protected int numClient;
    protected String telClient;
    protected int numRue;
    protected String rurClient;
    protected String villeClient;
    protected String codePostalC;
    protected String carteBancaire;
<<<<<<< HEAD
    protected String email;
=======
    protected String motdepasseC;
>>>>>>> 1bcc73d81e7c073bcb711c2625db79c988d8d318
    protected float noteC;
    protected ArrayList<Tache> taches = new ArrayList<Tache>();
    public Client(){};
    public Client(int numClient, String telClient, int numRue, String rurClient, String villeClient, String codePostalC, String carteBancaire, String email, float noteC) {
        this.numClient = numClient;
        this.telClient = telClient;
        this.numRue = numRue;
        this.rurClient = rurClient;
        this.villeClient = villeClient;
        this.codePostalC = codePostalC;
        this.carteBancaire = carteBancaire;
        this.email = email;
        this.noteC = noteC;
    }

   
    public String getEmail() {
        return email;
    }

    public ArrayList<Tache> getTaches() {
        return taches;
    }

    public int getNumClient() {
        return numClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public String getRurClient() {
        return rurClient;
    }

    public String getVilleClient() {
        return villeClient;
    }

    public String getCodePostalC() {
        return codePostalC;
    }


    public String getCarteBancaire() {
        return carteBancaire;
    }

    public float getNoteC() {
        return noteC;
    }

    public void setNumClient(int numClient) {
        this.numClient = numClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public void setRurClient(String rurClient) {
        this.rurClient = rurClient;
    }

    public void setVilleClient(String villeClient) {
        this.villeClient = villeClient;
    }

    public void setCodePostalC(String codePostalC) {
        this.codePostalC = codePostalC;
    }

    public void setCarteBancaire(String carteBancaire) {
        this.carteBancaire = carteBancaire;
    }

    public void setNoteC(float noteC) {
        this.noteC = noteC;
    }

    // annuler une tâche s'il la tâche n'est pas encore distribué
    public void annuler(Tache tache) {
        if (tache.getEtat() == EnumEtat.EN_COURS) {
            tache.setEtat(EnumEtat.ANNULEE);
        }
    }

    //validation tache
    public void valider(Tache tache) {
        if (tache.getEtat() == EnumEtat.FINALISEE_INTER) {
            tache.setEtat(EnumEtat.VALIDEE_CLIENT);
        }
    }

    public ArrayList<Object> getListNomTaches() {
        ArrayList<Object> historiques = new ArrayList();
        for (Tache tache : this.taches) {
            if (tache instanceof TacheSimple) {
                TacheSimple tacheSimple = (TacheSimple) tache;
                historiques.add(tacheSimple.getNomTache());
            }
            if (tache instanceof TacheMassive) {
                TacheMassive tacheMassive = (TacheMassive) tache;
                historiques.add(tacheMassive.getNomTache());

            }
            if (tache instanceof TacheComplexe) {
                TacheComplexe tacheComplexe = (TacheComplexe) tache;
                ArrayList<String> nomSousTache = new ArrayList();
                nomSousTache.add(tacheComplexe.getNomTache());
                for (Tache ta : tacheComplexe.getListTaches()) {
                    if (ta instanceof TacheSimple) {
                        TacheSimple tacheSimple = (TacheSimple) ta;
                        nomSousTache.add(tacheSimple.getNomTache());
                    }
                    if (tache instanceof TacheMassive) {
                        TacheMassive tacheMassive = (TacheMassive) tache;
                        historiques.add(tacheMassive.getNomTache());

                    }
                }
                historiques.add(tacheComplexe.getNomTache());
            }
        }
        return historiques;
    }
  
    public void consulterTache(String nomTache) {

    }

<<<<<<< HEAD
    
    public void addTache(Tache tache){
        this.taches.add(tache);
        
    }

    public void setEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPassword(String mdp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

=======
    public String getMotdepasseC() {
        return motdepasseC;
    }

    public void setMotdepasseC(String motdepasseC) {
        this.motdepasseC = motdepasseC;
    }

    public ArrayList<Tache> getTaches() {
        return taches;
    }
>>>>>>> 1bcc73d81e7c073bcb711c2625db79c988d8d318
}
