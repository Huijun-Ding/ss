package Model;

public class Competence {
    protected int numP;
    protected String nomP;

    public Competence(String nomP, String dateP, float montantP) {
        this.nomP = nomP;
    }

    public Competence() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNumP() {
        return numP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public void setNumP(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

