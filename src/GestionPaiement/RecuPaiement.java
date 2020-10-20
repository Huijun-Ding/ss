package GestionPaiement;

public class RecuPaiement {
    protected String nomRP;
    protected String dateRP;
    protected float montantRP;
    
    public RecuPaiement(String nom, String day, float montant) {
        this.nomRP = nom;
        this.dateRP = day;
        this.montantRP = montant;
    }
}

