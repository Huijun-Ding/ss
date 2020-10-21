package Model;

public class EvaluationClient {
    private int noteContenu;
    private int noteRentabilite;
    private int noteEchange;
    private String commentaireC;
    
    public EvaluationClient(int n1, int n2, int n3, String commentaire) {
        this.commentaireC = commentaire;
        this.noteContenu = n1;
        this.noteRentabilite = n2;
        this.noteEchange = n3;
    }
}
