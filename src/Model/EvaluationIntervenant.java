package Model;

public class EvaluationIntervenant {
    private int nbEtoileQualite;
    private int nbEtoileDelai;
    private String commentaire;

    public EvaluationIntervenant( int nbEtoileQualite, int nbEtoileDelai, String commentaire) {

        this.nbEtoileQualite = nbEtoileQualite;
        this.nbEtoileDelai = nbEtoileDelai;
        this.commentaire = commentaire;
    }

    public int getNbEtoileQualite() {
        return nbEtoileQualite;
    }

    public int getNbEtoileDelai() {
        return nbEtoileDelai;
    }

    public String getCommentaire() {
        return commentaire;
    }
}
