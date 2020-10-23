package Model;

import java.util.ArrayList;

public class Entreprise extends Client{
    protected String raisonSocial;
    protected String noSiret;
    protected String nomCorrespondant;
    protected String  prenomCorrespondant;
    protected String domaine;
    public Entreprise(){}
    public Entreprise(String raisonSocial, String noSiret, String nomCorrespondant, String prenomCorrespondant, String domaine, String telClient,  String rurClient, String villeClient, String codePostalC, String carteBancaire, String email, float noteC) {
        super(telClient,rurClient, villeClient, codePostalC, carteBancaire, email, noteC);
        this.raisonSocial = raisonSocial;
        this.noSiret = noSiret;
        this.nomCorrespondant = nomCorrespondant;
        this.prenomCorrespondant = prenomCorrespondant;
        this.domaine = domaine;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotdepasseC(String motdepasseC) {
        this.motdepasseC = motdepasseC;
    }




    public String getEmail() {
        return email;
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

    public void setTaches(ArrayList<Tache> taches) {
        this.taches = taches;
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

    public ArrayList<Tache> getTaches() {
        return taches;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public String getNoSiret() {
        return noSiret;
    }

    public String getNomCorrespondant() {
        return nomCorrespondant;
    }

    public String getPrenomCorrespondant() {
        return prenomCorrespondant;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public void setNoSiret(String noSiret) {
        this.noSiret = noSiret;
    }

    public void setNomCorrespondant(String nomCorrespondant) {
        this.nomCorrespondant = nomCorrespondant;
    }

    public void setPrenomCorrespondant(String prenomCorrespondant) {
        this.prenomCorrespondant = prenomCorrespondant;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
    
}
