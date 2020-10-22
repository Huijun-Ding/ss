package Model;

public class EvaluationClient {
    private int noteContenu;
    private int noteRentabilite;
    private int noteEchange;
    private String commentaireC;
    private Tache tache;
    private Intervenant inter;
    
    // création d'une évaluation de client pour une Tache, cette évaluation est composée par 3 critères et un commentaire
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
        // selon les notes des 3 critères et le note actuel de client, nous allons calculer une note final de client pour cette tache
        float note = ((this.noteContenu + this.noteEchange + this.noteRentabilite)/3 + this.tache.getClient().getNoteC())/2;
        this.tache.getClient().setNoteC(note);
    }
}
