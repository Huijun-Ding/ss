package Model;

public class Particulier extends Client {
    protected String nomPart;
    protected String  prenomPart;
    protected String civilité;

    public Particulier(int numClient, String telClient, String rurClient, String villeClient, String codePostalC, String carteBancaire, float noteC, String nomPart, String prenomPart, String civilité) {
        super(numClient, telClient, rurClient, villeClient, codePostalC, carteBancaire, noteC);
        this.nomPart = nomPart;
        this.prenomPart = prenomPart;
        this.civilité = civilité;
    }

    public String getNomPart() {
        return nomPart;
    }

    public String getPrenomPart() {
        return prenomPart;
    }

    public String getCivilité() {
        return civilité;
    }

    public void setNomPart(String nomPart) {
        this.nomPart = nomPart;
    }

    public void setPrenomPart(String prenomPart) {
        this.prenomPart = prenomPart;
    }

    public void setCivilité(String civilité) {
        this.civilité = civilité;
    }
    
}

