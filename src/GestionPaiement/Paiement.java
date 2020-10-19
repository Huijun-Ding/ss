/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionPaiement;
import java.util.Date;
/**
 *
 * @author Mathi
 */
public class Paiement {

    private int numP;
    private Date dateP;
    private float montantP;

    public Paiement() {
    }

    public Paiement(int numP, Date dateP, int montantP) {
        this.numP = numP;
        this.dateP = dateP;
        this.montantP = montantP;
    }

    public void setNumP(int numP) {
        this.numP = numP;
    }

    public void setDateP(Date dateP) {
        this.dateP = dateP;
    }

    public void setMontantP(int montantP) {
        this.montantP = montantP;
    }

    public int getNumP() {
        return numP;
    }

    public Date getDateP() {
        return dateP;
    }

    public int getMontantP() {
        return montantP;
    }


>>>>>>> 887412ffc4672885e3e6a78fae52bc9a2f98d5b1
}
