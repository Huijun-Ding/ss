package Model;

import Model.Tache;

public class TacheSimple extends Tache {
    
//    private Intervenant intervenant;

    public TacheSimple(String nomTache, String description, int nbPersonne, float prix, String domanineTache, EnumEtat etat, String dateDeb, String dateFin, Client c) {
        super(nomTache, description, nbPersonne, prix, domanineTache, etat, dateDeb, dateFin, c);
    }

//    public Intervenant getIntervenant() {
//        return intervenant;
//    }
//
//    public void setIntervenant(Intervenant intervenant) {
//        this.intervenant = intervenant;
//    }
    
    
    public String getNomTache() {
        return nomTache;
    }

    public String getDescription() {
        return description;
    }

    public int getNbPersonne() {
        return nbPersonne;
    }

    public String getDelais() {
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

    public EnumEtat getEtat() {
        return etat;
    }

    public String getDateDeb() {
        return dateDeb;
    }

   public String getDateFin() {
       return dateFin;
    }
   
    
    
    
}

