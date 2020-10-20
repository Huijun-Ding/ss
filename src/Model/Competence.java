package Model;

public class Competence {
    protected String nomP;

    public Competence(String nomP, String dateP, float montantP) {
        this.nomP = nomP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }
}

