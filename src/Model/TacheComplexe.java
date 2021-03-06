package Model;
import Model.Tache;
import java.util.ArrayList;
import java.util.Scanner;

public class TacheComplexe extends Tache {
       private ArrayList<Tache> listTaches;  // une tache complexe est composée par plusieurs taches(simple ou massive)
       
    public TacheComplexe(String nomTache, String description, int nbPersonne, float prix, String domanineTache, EnumEtat etat, String dateDeb, String dateFin, Client c) {
        super(nomTache, description, nbPersonne,  prix, domanineTache, etat, dateDeb, dateFin, c);
        listTaches = new ArrayList();
    }
    
    public void addTache(Tache ts) {
        this.listTaches.add(ts);
    }

    public void newTache(){
        System.out.println("saisissez un nouvelle tache");
        Scanner nomtache = new Scanner (System.in); 
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

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNbPersonne(int nbPersonne) {
        this.nbPersonne = nbPersonne;
    }

    public void setDelais(String delais) {
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

    public void setEtat(EnumEtat etat) {
        this.etat = etat;
    }

    public void setDateDeb(String dateDeb) {
        this.dateDeb = dateDeb;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public ArrayList<Tache> getListTaches() {
        return listTaches;
    }
}
