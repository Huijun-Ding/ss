
package GestionPaiement;
import java.util.Date;
import GestionDonnes.Client;
import GestionTache.Tache;
/**
 *
 * @author Mathi
 */
public class Paiement {
    private int numP;
    private Date dateP;
    private float montantP;
    private Client client;
    private Tache tache;

    public Paiement(int numP, Date dateP, int montantP) {
        this.numP = numP;
        this.dateP = dateP;
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

