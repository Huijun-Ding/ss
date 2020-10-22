package Model;
import java.util.Date;
import Model.Client;
import Model.Tache;

public class Paiement {

    private int numP;
    private String dateP;
    private float montantP;
    private Tache tache;

    public Paiement(int num, String date, float montant, Tache t) {
        this.numP = num;
        this.dateP = date;
        this.montantP = montant;
        this.tache = t;
    }
    
    public Tache getTache() {
        return this.tache;
    }

    public int getNumP() {
        return numP;
    }

    public String getDateP() {
        return dateP;
    }

    public float getMontantP() {
        return montantP;
    }
}

