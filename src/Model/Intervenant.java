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
    private ArrayList<Tache> listTaches;
    private ArrayList<RecuPaiement> Recus;
    private ArrayList<Competence> mesCompetences;

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
}

