package Model;

import Model.Tache;

public class TacheSimple extends Tache {
    
    Intervenant intervenant;

    public TacheSimple(String nomTache, String description, int nbPersonne, float prix, String domanineTache, String etat, String dateDeb, String dateFin) {
        super(nomTache, description, nbPersonne, prix, domanineTache, etat, dateDeb, dateFin);
    }

    public Intervenant getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }
    
    
    public String getNomTache() {
        return nomTache;
    }

    public String getDescription() {
        return description;
    }

    public int getNbPersonne() {
        return nbPersonne;
    }

    public int getDelais() {
        return delais;
    }

    public int getNumTache() {
        return numTache;
    }

    public float getPrix() {
        return prix;
    }

    public String getDomanineTache() {
        return domanineTache;
    }

    public String getEtat() {
        return etat;
    }

    public String getDateDeb() {
        return dateDeb;
    }

   public String getDateFin() {
       return dateFin;
    }
   
    public float evaluerIntervenant(int nbEtoileQualite, int nbEtoileDelai, String commentaire){
        float note=(nbEtoileQualite+nbEtoileDelai)/2;
        return note;
    }
    
    
}

