package Model;

import Model.Competence;
import Model.Client;
import Model.Intervenant;
import java.util.ArrayList;

public class Tache {
    protected String nomTache;
    protected String description;
    protected int nbPersonne;
    protected int delais; // nombre de jours
    protected int numTache;
    protected float prix;
    protected String domanineTache;
    protected EnumEtat etat;
    protected String dateDeb;
    protected String dateFin;
    protected ClientEvaluation clientEvaluation;
    private Client client;
    private Paiement paiement;  
    private ArrayList<RecuPaiement> listRecus;
    private ArrayList<Competence> competences;
    
    public Tache(String nomTache, String description, int nbPersonne,  float prix, String domanineTache, EnumEtat etat, String dateDeb, String dateFin) {
        this.nomTache = nomTache;
        this.description = description;
        this.nbPersonne = nbPersonne;
        this.prix = prix;
        this.domanineTache = domanineTache;
        this.etat = etat;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
    }
   
    public ArrayList<Competence> getCompetences() {
        return this.competences;
    }
    
    class ClientEvaluation{
        private int nbEtoileQualite;
        private int nbEtoileDelai;
        private String commentaire;

        public ClientEvaluation(int nbEtoileQualite, int nbEtoileDelai, String commentaire) {
            this.nbEtoileQualite = nbEtoileQualite;
            this.nbEtoileDelai = nbEtoileDelai;
            this.commentaire = commentaire;
        }

        public int getNbEtoileQualite() {
            return nbEtoileQualite;
        }

        public int getNbEtoileDelai() {
            return nbEtoileDelai;
        }

        public String getCommentaire() {
            return commentaire;
        }

        public void setNbEtoileQualite(int nbEtoileQualite) {
            this.nbEtoileQualite = nbEtoileQualite;
        }

        public void setNbEtoileDelai(int nbEtoileDelai) {
            this.nbEtoileDelai = nbEtoileDelai;
        }

        public void setCommentaire(String commentaire) {
            this.commentaire = commentaire;
        }
        
    }

    public String getNomTache() {
        return nomTache;
    }
    
    public Client getClient() {
        return this.client;
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

    public ClientEvaluation getClientEvaluation() {
        return clientEvaluation;
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

    public void setEtat(EnumEtat etat) {
        this.etat = etat;
    }

    public void setDateDeb(String dateDeb) {
        this.dateDeb = dateDeb;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
    
    //evaluation tache
    public void clientEvaluer(int nbEtoileQualite, int nbEtoileDelai, String commentaire){
       this.clientEvaluation=new ClientEvaluation(nbEtoileQualite,nbEtoileDelai,commentaire);
       float originNote = this.client.getNoteC();
       int note=(nbEtoileQualite+nbEtoileDelai)/2;
       if(commentaire.matches(".*bien.*")
               ||commentaire.matches(".*bravo.*")){
           note++;
       }
       this.client.setNoteC(note+originNote);
    }

    public void setPaiement(Paiement p) {
        this.paiement = p;
    }

    public void setRecuPaiement(RecuPaiement rp) {
        if (this.etat == EnumEtat.VALIDEE_CLIENT) {
            this.listRecus.add(rp);
        }  
    }   

    public void ajouterCompetence(Competence c){
        this.competences.add(c);
    }
    
    public boolean terminerTache(Tache t) {
        if (t.getEtat() == EnumEtat.VALIDEE_CLIENT) {
            return true;
        }
        return false;
    }
}

