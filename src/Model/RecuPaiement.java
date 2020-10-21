package Model;

public class RecuPaiement {
    protected String nomRP;
    protected String dateRP;
    protected float montantRP;
    private Tache tache;
    
    public RecuPaiement(String nom, String day, float montant, Tache t) {
        this.nomRP = nom;
        this.dateRP = day;
        this.montantRP = montant;
        this.tache = t;
    }
    
    public Tache getTache() {
        return this.tache;
    }
}

