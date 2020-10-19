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
public class Competence {
  protected String nomP;
    protected String dateP;
    protected float montantP;

    public Competence(String nomP, String dateP, float montantP) {
        this.nomP = nomP;
        this.dateP = dateP;
        this.montantP = montantP;
    }

    public String getNomP() {
        return nomP;
    }

    public String getDateP() {
        return dateP;
    }

    public float getMontantP() {
        return montantP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public void setDateP(String dateP) {
        this.dateP = dateP;
    }

    public void setMontantP(float montantP) {
        this.montantP = montantP;
    }
    
}
