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
public class Particulier {
    protected String nomPart;
    protected String  prenomPart;
    protected String civilité;

    public Particulier(String nomPart, String prenomPart, String civilité) {
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
