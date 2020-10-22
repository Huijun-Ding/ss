/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author leonl
 */
public class EvaluationIntervenant {

    private int nbEtoileQualite;
    private int nbEtoileDelai;
    private String commentaire;

    public EvaluationIntervenant( int nbEtoileQualite, int nbEtoileDelai, String commentaire) {

        this.nbEtoileQualite = nbEtoileQualite;
        this.nbEtoileDelai = nbEtoileDelai;
        this.commentaire = commentaire;
    }
    
   
}
