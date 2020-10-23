package Model;

public class RecuPaiement {  // plateforme paye le client
    protected String nomRP;
    protected String dateRP;
    protected float montantRP;
    private Tache tache;
    private Intervenant intervenant;
    
    public RecuPaiement(String nom, String day, float montant, Tache t, Intervenant i) {
        this.nomRP = nom;
        this.dateRP = day;
        this.montantRP = montant;
        this.tache = t;
        this.intervenant= i;
    }
    
    public String getNomRP() {
        return this.nomRP;
    }    
    
    public float getMontantRP() {
        return this.montantRP;
    }     
    
    public Tache getTache() {
        return this.tache;
    }
    
    public Intervenant getIntervenant() {
        return this.intervenant;
    }
}

