
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
    protected ClientEvaluation clientEvaluation;
   
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

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setDateDeb(String dateDeb) {
        this.dateDeb = dateDeb;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
  
    // annuler une tâche s'il la tâche n'est pas encore distribué
   public void annuler(){
       if(this.etat=="en cours"){
           this.etat="anuler";
       }
   }
   
   //validation tache
    public void valider(){
       if(this.etat=="termine"){
           this.etat="valide";
       }
   }
    
    //evaluation tache
    public void clientEvaluer(int nbEtoileQualite, int nbEtoileDelai, String commentaire){
       this.clientEvaluation=new ClientEvaluation(nbEtoileQualite,nbEtoileDelai,commentaire);
    }
    
   
    
}

