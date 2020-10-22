package Model;

import Model.Tache;

public class TacheSimple extends Tache {

    public TacheSimple(String nomTache, String description, int nbPersonne, float prix, String domanineTache, EnumEtat etat, String dateDeb, String dateFin, Client c) {
        super(nomTache, description, nbPersonne, prix, domanineTache, etat, dateDeb, dateFin, c);
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

