
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDonnes;

/**
 *
 * @author Mathi
 */
public class Client {
    protected int numClient; 
    protected String telClient; 
    protected String rurClient;
    protected String villeClient;
    protected String codePostalC;
    protected String carteBancaire; 
    protected String noteC;
    protected String password;
    
    public Client(int numClient, String telClient, String rurClient, String villeClient, String codePostalC, String carteBancaire, String noteC,String password) {
        this.numClient = numClient;
        this.telClient = telClient;
        this.rurClient = rurClient;
        this.villeClient = villeClient;
        this.codePostalC = codePostalC;
        this.carteBancaire = carteBancaire;
        this.noteC = noteC;
        this.password=password;
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

    public String getNoteC() {
        return noteC;
    }

    public String getPassword() {
        return password;
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

    public void setNoteC(String noteC) {
        this.noteC = noteC;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
