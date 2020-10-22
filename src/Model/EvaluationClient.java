package Model;

public class EvaluationClient {
    private int noteContenu;
    private int noteRentabilite;
    private int noteEchange;
    private String commentaireC;
    private Tache tache;
    private Intervenant inter;
    
    public EvaluationClient(int n1, int n2, int n3, String commentaire, Tache t, Intervenant i) {
        this.commentaireC = commentaire;
        this.noteContenu = n1;
        this.noteRentabilite = n2;
        this.noteEchange = n3;
        this.tache = t;
        this.inter = i;
    }

    public Intervenant getInter() {
        return inter;
    }
    
    
    
    public void calculerNoteC() {
        float note = (this.noteContenu + this.noteEchange + this.noteRentabilite)/3;
        this.tache.getClient().setNoteC(note);
    }
}
