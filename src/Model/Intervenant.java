package Model;
import java.util.ArrayList;

public class Intervenant {
    protected String nomInterv; 
    protected String prenomInterv;
    protected int numInterv; 
    protected String email;
    protected String telInterv; 
    protected String rurInterv;
    protected String villeInterv;
    protected String codePostalIn;
    protected String carteBancaireIn; 
    protected String motdepasseI;
    protected boolean reponse=false;
    protected float noteIn;
    private ArrayList<Tache> listTachesRecevoir;
    private ArrayList<Tache> listTaches;
    private ArrayList<RecuPaiement> Recus;
    private ArrayList<Competence> mesCompetences;

    public ArrayList<Tache> getListTachesRecevoir() {
        return listTachesRecevoir;
    }

    public void etreAffecte(Tache t){
        this.listTachesRecevoir.add(t);
    }
    
     public void supprimerAffecte(Tache t){
        this.listTachesRecevoir.remove(t);
    }
    
    public void accepterTache(Tache t){
        this.listTaches.add(t);
        this.listTachesRecevoir.remove(t);
        this.reponse= true;
    }
    public void  refuserTache(Tache t){
        this.listTachesRecevoir.remove(t);
        this.reponse= false;
    }
    public boolean getReponse(){
        return this.reponse;
    }
    public Intervenant(){}
    public Intervenant(int numInterv, String telInterv, String rurInterv, String villeInterv, String codePostalIn, String carteBancaireIn, float noteIn) {

        this.numInterv = numInterv;
        this.telInterv = telInterv;
        this.rurInterv = rurInterv;
        this.villeInterv = villeInterv;
        this.codePostalIn = codePostalIn;
        this.carteBancaireIn = carteBancaireIn;
        this.noteIn = noteIn;
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

    public String getRurInterv() {
        return rurInterv;
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

    public void setRurInterv(String rurInterv) {
        this.rurInterv = rurInterv;
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
    
    public void setRecuPaiement(RecuPaiement rp) {
        if (rp.getTache().etat == EnumEtat.VALIDEE_CLIENT) {
            this.Recus.add(rp);
        }
    } 
    
    public void finaliser(Tache tache) {
        if (tache.getEtat() == EnumEtat.PAYEE) {
            tache.setEtat(EnumEtat.FINALISEE_INTER);
        }
    }
    
    public String consulterTache() {
        String mesTaches = "";
        for (int i=0; i<this.listTaches.size(); i++) {
            mesTaches = mesTaches + " - " + this.listTaches.get(i);
        }
        return mesTaches;
    }

    public void setMotdepasseI(String motdepasseI) {
        this.motdepasseI = motdepasseI;
    }
    public String getMotdepasseI(){
        return this.motdepasseI;
    }

    public String getNomInterv() {
        return nomInterv;
    }

    public String getPrenomInterv() {
        return prenomInterv;
    }
    
}