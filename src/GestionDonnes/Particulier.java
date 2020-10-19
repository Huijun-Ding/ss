
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
public class Particulier extends Client {
    protected String nomPart;
    protected String  prenomPart;
    protected String civilité;

    public Particulier(String nomPart, String prenomPart, String civilité, int numClient, String telClient, String rurClient, String villeClient, String codePostalC, String carteBancaire, String noteC) {
        super(numClient, telClient, rurClient, villeClient, codePostalC, carteBancaire, noteC);
        this.nomPart = nomPart;
        this.prenomPart = prenomPart;
        this.civilité = civilité;
    }
    
}

