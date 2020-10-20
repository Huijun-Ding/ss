
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
    private Intervenant I;

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

    public float getMontantP() {
        return montantP;
    }


}

