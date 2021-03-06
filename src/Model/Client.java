package Model;

import java.util.ArrayList;

public class Client {

    protected int numClient;
    protected String telClient;
    protected String rurClient;
    protected String villeClient;
    protected String codePostalC;
    protected String carteBancaire;
    protected String email;
    protected String motdepasseC;

    protected float noteC;
    protected ArrayList<Tache> taches = new ArrayList<Tache>();
    public Client(){};
    public Client( String telClient, String rurClient, String villeClient, String codePostalC, String carteBancaire, String email, float noteC) {
        this.telClient = telClient;
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

    public ArrayList<Object> getListNomTaches() {   // consulation d'historique de tâche
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
    
    public void addTache(Tache tache){
        this.taches.add(tache);
    }

    public void setEmail(String email) {
       this.email=email;
    }

    public void setPassword(String mdp) {
        this.motdepasseC=mdp;
    }

    public String getMotdepasseC() {
        return motdepasseC;
    }
}
