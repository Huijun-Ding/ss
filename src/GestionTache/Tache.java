
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionTache;

import GestionPaiement.*;
import GestionDonnes.*;
import java.util.ArrayList;

/**
 *
 * @author Mathi
 */
public class Tache {
    protected String nomTache;
    protected String description;
    protected int nbPersonne;
    protected int delais; // nombre de jours
    protected int numTache;
    protected float prix;
    protected String domanineTache;
    protected String etat;
    protected String dateDeb;
    protected String dateFin;
    private Client client;
    private ArrayList<Intervenant> listInters;
    private ArrayList<RecuPaiement> listRecus;
    private ArrayList<Paiement> listPaiements;
   

    public Tache(String nomTache, String description, int nbPersonne,  float prix, String domanineTache, String etat, String dateDeb, String dateFin) {
        this.nomTache = nomTache;
        this.description = description;
        this.nbPersonne = nbPersonne;
        this.prix = prix;
        this.domanineTache = domanineTache;
        this.etat = etat;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
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

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNbPersonne(int nbPersonne) {
        this.nbPersonne = nbPersonne;
    }

    public void setDelais(int delais) {
        this.delais = delais;
    }

    public void setNumTache(int numTache) {
        this.numTache = numTache;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setDomanineTache(String domanineTache) {
        this.domanineTache = domanineTache;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setDateDeb(String dateDeb) {
        this.dateDeb = dateDeb;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
  
   
          
}

