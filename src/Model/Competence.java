package Model;

public class Competence {
    protected String nomC;

    public Competence(String nom) {
        this.nomC = nom;
    }

    public String getNomP() {
        return nomC;
    }

    public void setNomP(String nomP) {
        this.nomC = nomP;
    }
}

