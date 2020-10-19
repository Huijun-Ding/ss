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
public class Particulier extends Client{
    protected String nomPart;
    protected String  prenomPart;
    protected String civilité;

    public Particulier(String nomPart, String prenomPart, String civilité, int numClient, String telClient, String rurClient, String villeClient, String codePostalC, String carteBancaire, String noteC, String password) {
        super(numClient, telClient, rurClient, villeClient, codePostalC, carteBancaire, noteC, password);
        this.nomPart = nomPart;
        this.prenomPart = prenomPart;
        this.civilité = civilité;
    }

    public String getNomPart() {
        return nomPart;
    }

    public String getPrenomPart() {
        return prenomPart;
    }

    public String getCivilité() {
        return civilité;
    }

    public void setNomPart(String nomPart) {
        this.nomPart = nomPart;
    }

    public void setPrenomPart(String prenomPart) {
        this.prenomPart = prenomPart;
    }

    public void setCivilité(String civilité) {
        this.civilité = civilité;
    }
    
}
