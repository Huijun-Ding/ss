package Model;

public class Competence {
    protected String nomP;
    protected int numP;
    public Competence(String nomP,int numP, String dateP, float montantP) {
        this.nomP = nomP;
        this.numP=numP;
    }

    public Competence() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public int getNumP() {
        return numP;
    }

    public void setNumP(int numP) {
        this.numP = numP;
    }
    
    
    
}

