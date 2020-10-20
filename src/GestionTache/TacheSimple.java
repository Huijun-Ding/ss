/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionTache;

/**
 *
 * @author Mathi
 */
public class TacheSimple extends Tache {

    public TacheSimple(String nomTache, String description, int nbPersonne, float prix, String domanineTache, String etat, String dateDeb, String dateFin) {
        super(nomTache, description, nbPersonne, prix, domanineTache, etat, dateDeb, dateFin);
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
    
}
