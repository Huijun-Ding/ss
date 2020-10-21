package Model;
import java.util.ArrayList;

public class Intervenant {
    protected int numInterv; 
    protected String telInterv; 
    protected String rurInterv;
    protected String villeInterv;
    protected String codePostalIn;
    protected String carteBancaireIn; 
    protected float noteIn;
    //待分配的任务？
    private ArrayList<Tache> listTachesRecevoir;
    protected String email;
    protected String password;
    private ArrayList<Tache> listTaches;
    private ArrayList<RecuPaiement> Recus;
    private ArrayList<Competence> mesCompetences;
    
    
    public void etreAffecte(Tache t){
        this.listTachesRecevoir.add(t);
    }
    
     public void supprimerAffecte(Tache t){
        this.listTachesRecevoir.remove(t);
    }
    
    public boolean accepterTache(Tache t){
        this.listTaches.add(t);
        this.listTachesRecevoir.remove(t);
        return true;
    }
    public boolean  refuserTache(Tache t){
        this.listTachesRecevoir.remove(t);
        return false;
    }

    public Intervenant(int numInterv, String telInterv, String rurInterv, String villeInterv, String codePostalIn, String carteBancaireIn, float noteIn, String email, String password, ArrayList<Tache> listTaches, ArrayList<RecuPaiement> Recus, ArrayList<Competence> mesCompetences) {
        this.numInterv = numInterv;
        this.telInterv = telInterv;
        this.rurInterv = rurInterv;
        this.villeInterv = villeInterv;
        this.codePostalIn = codePostalIn;
        this.carteBancaireIn = carteBancaireIn;
        this.noteIn = noteIn;
        this.email = email;
      
        this.listTaches = listTaches;
        this.Recus = Recus;
        this.mesCompetences = mesCompetences;
    }

    public Intervenant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

  
    
    public ArrayList<Competence> getMesCompetences() {
        return this.mesCompetences;
    }

    public String getEmail() {
        return email;
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
        this.Recus.add(rp);
    } 


    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    }
    
    



