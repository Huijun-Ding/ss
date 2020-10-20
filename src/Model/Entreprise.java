package Model;

public class Entreprise extends Client{
    protected String raisonSocial;
    protected String noSiret;
    protected String nomCorrespondant;
    protected String  prenomCorrespondant;
    protected String domaine;

    public Entreprise(String raisonSocial, String noSiret, String nomCorrespondant, String prenomCorrespondant, String domaine, int numClient, String telClient, String rurClient, String villeClient, String codePostalC, String carteBancaire, float noteC, String email, String password) {
        super(numClient, telClient, rurClient, villeClient, codePostalC, carteBancaire, noteC, email, password);
        this.raisonSocial = raisonSocial;
        this.noSiret = noSiret;
        this.nomCorrespondant = nomCorrespondant;
        this.prenomCorrespondant = prenomCorrespondant;
        this.domaine = domaine;
    }

   

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public String getNoSiret() {
        return noSiret;
    }

    public String getNomCorrespondant() {
        return nomCorrespondant;
    }

    public String getPrenomCorrespondant() {
        return prenomCorrespondant;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public void setNoSiret(String noSiret) {
        this.noSiret = noSiret;
    }

    public void setNomCorrespondant(String nomCorrespondant) {
        this.nomCorrespondant = nomCorrespondant;
    }

    public void setPrenomCorrespondant(String prenomCorrespondant) {
        this.prenomCorrespondant = prenomCorrespondant;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
    
}
