
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
public class Entreprise extends Client{
    protected String raisonSocial;
    protected String noSiret;
    protected String nomCorrespondant;
    protected String  prenomCorrespondant;
    protected String domaine;

    public Entreprise(String raisonSocial, String noSiret, String nomCorrespondant, String prenomCorrespondant, String domaine, int numClient, String telClient, String rurClient, String villeClient, String codePostalC, String carteBancaire, String noteC) {
        super(numClient, telClient, rurClient, villeClient, codePostalC, carteBancaire, noteC);
        this.raisonSocial = raisonSocial;
        this.noSiret = noSiret;
        this.nomCorrespondant = nomCorrespondant;
        this.prenomCorrespondant = prenomCorrespondant;
        this.domaine = domaine;
    }
    
}

