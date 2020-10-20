


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDonnes;

import GestionTache.Tache;
import GestionTache.TacheComplexe;
import GestionTache.TacheMassive;
import GestionTache.TacheSimple;

import java.util.ArrayList;

/**
 *
 * @author Mathi
 */
public class Client {
    protected int numClient; 
    protected String telClient; 
    protected String rurClient;
    protected String villeClient;
    protected String codePostalC;
    protected String carteBancaire; 
    protected String noteC;
    protected ArrayList<Tache> taches = new ArrayList<Tache>();


    public Client(int numClient, String telClient, String rurClient, String villeClient, String codePostalC, String carteBancaire, String noteC) {
        this.numClient = numClient;
        this.telClient = telClient;
        this.rurClient = rurClient;
        this.villeClient = villeClient;
        this.codePostalC = codePostalC;
        this.carteBancaire = carteBancaire;
        this.noteC = noteC;
    }

    public int getNumClient() {
        return numClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public String getRurClient() {
        return rurClient;
    }

    public String getVilleClient() {
        return villeClient;
    }

    public String getCodePostalC() {
        return codePostalC;
    }

    public String getCarteBancaire() {
        return carteBancaire;
    }

    public String getNoteC() {
        return noteC;
    }

    public void setNumClient(int numClient) {
        this.numClient = numClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public void setRurClient(String rurClient) {
        this.rurClient = rurClient;
    }

    public void setVilleClient(String villeClient) {
        this.villeClient = villeClient;
    }

    public void setCodePostalC(String codePostalC) {
        this.codePostalC = codePostalC;
    }

    public void setCarteBancaire(String carteBancaire) {
        this.carteBancaire = carteBancaire;
    }

    public void setNoteC(String noteC) {
        this.noteC = noteC;
    }
    public ArrayList<Object> getListNomTaches(){
        ArrayList<Object> historiques= new ArrayList();
        for(Tache tache: this.taches){
            if(tache instanceof TacheSimple){
                TacheSimple tacheSimple=(TacheSimple)tache;
                historiques.add(tacheSimple.getNomTache());
            }
            if(tache instanceof TacheComplexe){
                TacheComplexe tacheComplexe=(TacheComplexe)tache;
                historiques.add(tacheComplexe.getNomTache());
                
            }
            if(tache instanceof TacheMassive){
                TacheMassive tacheMassive=(TacheMassive)tache;
                ArrayList<String> nomSousTache= new ArrayList();
                nomSousTache.add(tacheMassive.getNomTache());
                for(Tache ta: tacheMassive.getListTaches()){
                    if(ta instanceof TacheSimple){
                        TacheSimple tacheSimple=(TacheSimple)ta;
                        nomSousTache.add(tacheSimple.getNomTache());
                    }
                    if(ta instanceof TacheComplexe){
                        TacheComplexe tacheComplexe=(TacheComplexe)ta;
                        nomSousTache.add(tacheComplexe.getNomTache());
                    }
                }
                 historiques.add(tacheMassive.getNomTache());
            }
        }
        return historiques;
    }
    
    
    public void consulterTache(String nomTache){
        
    }
}

