package Model;

import java.util.ArrayList;

public class Intervenant {

    protected String nomInterv;
    protected String prenomInterv;
    protected int numInterv;
    protected String email;
    protected String telInterv;
    protected String rueInterv;
    protected String villeInterv;
    protected String codePostalIn;
    protected String carteBancaireIn;
    protected String motdepasseI;
    protected float noteIn;
    private ArrayList<Tache> listTachesRecevoir;
    private ArrayList<Tache> listTaches;
    private ArrayList<RecuPaiement> recus;
    private ArrayList<Competence> mesCompetences;

    public void addMesCompetences(Competence c) {
        this.mesCompetences.add(c);
    }

    public ArrayList<Tache> getListTaches() {
        return this.listTaches;
    }

    public String getTacheAffectee() {  // retourner tous les tâches qui ont été affectées à cet intervenant
        String t = "";
        for (int i = 0; i < this.listTachesRecevoir.size(); i++) {
            t += this.listTachesRecevoir.get(i).getNomTache() + " ";
        }
        return t;
    }

    public ArrayList<Tache> getListTachesRecevoir() {
        return this.listTachesRecevoir;
    }

    public void etreAffecte(Tache t) {
        this.listTachesRecevoir.add(t);
    }

    public void supprimerAffecte(Tache t) {
        this.listTachesRecevoir.remove(t);
    }

    public boolean accepterTache(Tache t) {
        this.listTaches.add(t);
        this.listTachesRecevoir.remove(t);
        return true;
    }

    public void addTache(Tache t){  // juste pour tester l'interface
        this.listTaches.add(t);
    }
    
    public boolean refuserTache(Tache t) {
        this.listTachesRecevoir.remove(t);
        return false;
    }

    public Intervenant() {
    }

    public Intervenant(int numInterv, String telInterv, String rueInterv, String villeInterv, String codePostalIn, String carteBancaireIn, float noteIn) {

        this.numInterv = numInterv;
        this.telInterv = telInterv;
        this.rueInterv = rueInterv;
        this.villeInterv = villeInterv;
        this.codePostalIn = codePostalIn;
        this.carteBancaireIn = carteBancaireIn;
        this.noteIn = noteIn;
        listTachesRecevoir = new ArrayList();
        listTaches = new ArrayList();
        recus = new ArrayList();
        mesCompetences = new ArrayList();
    }

    public ArrayList<Competence> getMesCompetences() {
        return this.mesCompetences;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumInterv() {
        return numInterv;
    }

    public String getTelInterv() {
        return telInterv;
    }

    public String getRueInterv() {
        return rueInterv;
    }

    public String getVilleInterv() {
        return villeInterv;
    }

    public String getCodePostalIn() {
        return codePostalIn;
    }

    public String getCarteBancaireIn() {
        return carteBancaireIn;
    }

    public float getNoteIn() {
        return noteIn;
    }

    public void setNumInterv(int numInterv) {
        this.numInterv = numInterv;
    }

    public void setTelInterv(String telInterv) {
        this.telInterv = telInterv;
    }

    public void setRueInterv(String rurInterv) {
        this.rueInterv = rurInterv;
    }

    public void setVilleInterv(String villeInterv) {
        this.villeInterv = villeInterv;
    }

    public void setCodePostalIn(String codePostalIn) {
        this.codePostalIn = codePostalIn;
    }

    public void setCarteBancaireIn(String carteBancaireIn) {
        this.carteBancaireIn = carteBancaireIn;
    }

    public void setNoteIn(float noteIn) {
        this.noteIn = noteIn;
    }

    public void setRecuPaiement(RecuPaiement rp) {  // quand le client a validé la tâche, la palteforme peut payer l'intervenant
        if (rp.getTache().etat == EnumEtat.VALIDEE_CLIENT) {
            this.recus.add(rp);
        }
    }

    public void finaliser(Tache tache) {  // terminer la tâche
        tache.incrementerNbFinish();
    }

    public String consulterTache() {
        String mesTaches = "";
        for (int i = 0; i < this.listTaches.size(); i++) {
            mesTaches = mesTaches + " - " + this.listTaches.get(i).getNomTache();
        }
        return mesTaches;
    }

    public void setMotdepasseI(String motdepasseI) {
        this.motdepasseI = motdepasseI;
    }

    public String getMotdepasseI() {
        return this.motdepasseI;
    }

    public String getNomInterv() {
        return nomInterv;
    }

    public String getPrenomInterv() {
        return prenomInterv;
    }

    public String getRecuPaiement() {
        String rp = "";
        for (int i = 0; i < this.recus.size(); i++) {
            rp = rp + " - " + this.recus.get(i).getNomRP() + "  Montant: " + this.recus.get(i).getMontantRP() + "$";
        }
        return rp;
    }

    public void setNomInterv(String nomInterv) {
        this.nomInterv = nomInterv;
    }

    public void setPrenomInterv(String prenomInterv) {
        this.prenomInterv = prenomInterv;
    }
}
