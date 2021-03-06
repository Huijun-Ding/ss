package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Affecter {

    private ArrayList<Intervenant> listAllInters; // Tous les intervenants
    private ArrayList<Intervenant> listCandidats; // les intervenant qui ont correponds les critères de rechercher, peuvent potentiellement être affecté cette tâche
    private ArrayList<Intervenant> intervenants;  // les intervenant qui accepte cette tâche
    private ArrayList<Intervenant> listAttende;   // liste d'intervenants qu'on a envoyer une affectation mais pas encore reçu la réponse
    private Tache tache;
    private int nb; // nombre de personne nécissaire pour réaliser cette tâche
    private int nbAccept = 0;  // nombre de personne acceptent cette tâche

    public Affecter(Tache t) {
        listAllInters = new ArrayList();
        listCandidats = new ArrayList();
        intervenants = new ArrayList();
        listAttende = new ArrayList();
        this.tache = t;
        this.nb = this.tache.getNbPersonne();
    }

    // créer une liste qui contien tous les intervenants dans notre BD
    public void addListAllInters(Intervenant a) {
        this.listAllInters.add(a);
    }

    // pou chacun des intervenants, si il proccède des compétences qui nécissite par ce tâche, et ce intervenant a unr note inférieur ou équal le client qui déposé ce tâche
    // nous allons l'ajouter dans liste des candidats
    public void selectCandidats() {
        for (Intervenant i : this.listAllInters) {
            if (i.getMesCompetences().equals(tache.getCompetences()) && (i.getNoteIn() <= getNoteClient())) {
                this.listCandidats.add(i);
            }
        }
    }

    // retourner la note de client qui a déposé cette tâche
    public float getNoteClient() {
        return this.tache.getClient().getNoteC();
    }

    // pour tous les candidats potenciels, nous allons les clsser par leur note de l'order décroissante
    public void classerCandidats() {
        int length = listCandidats.size();

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (listCandidats.get(j).getNoteIn() < listCandidats.get(j + 1).getNoteIn()) {
                    Collections.swap(listCandidats, j, j + 1);
                }
            }
        }
    }

    // affectation de cette tâche à des intervenants dans la liste de candidats
    public void affecterTache() {
        // compter le nombre d'intervenant trouvés
        for (int i = 0; i < this.listAttende.size(); i++) { // pour tous les intervenants dans liste d'attente (de réponse)
            if (listAttende.get(i).getListTaches().contains(tache)) { // si il accepte
                intervenants.add(listAttende.get(i)); // ajouter ce intervenant dans la liste finale
                nbAccept += 1; 
            }
        }
        
        // si cette tâche a trouvée tous les intervenants, modifier son état en ACCEPTEE
        if (nb == nbAccept) {
            this.tache.setEtat(EnumEtat.ACCEPTEE);
        }
        
        // pour le nombre des intervenants qu'on a pas encore trouvés
        for (int i = 0; i < nb - nbAccept; i++) {
            // envoyer une affectation à un intervenant qui est dans la liste des candidats par l'ordre croissante
            listCandidats.get(i).etreAffecte(tache);  // ajouter cette tâche dans listTachesRecevoir de ce intervenant
            listAttende.add(listCandidats.get(i)); //mais l'ajouter dans liste d'attente                        
        }

        for (int i = 0; i < nb - nbAccept; i++) {
            listCandidats.remove(listCandidats.get(0)); // supprimer cet intervenant de la liste des candidats                       
        }
    }

    public void supprimerTache() {
        if (nbAccept == nb) {  // une fois tous les intervenants sont trouvés, il aura plus de affectation en cours
            for (int i = 0; i < listAttende.size(); i++) {
                listAttende.get(i).supprimerAffecte(tache); // enlever l'affectation au'on avait envoyés
            }
        }
    }

    public String getListCandidats() {
        String t = "";
        for (int i=0; i<this.listCandidats.size(); i++) {
            t += this.listCandidats.get(i).getNumInterv() + " ";
        }
        return t;
    }

    public String getListAllInter() {
        String t = "";
        for (int i=0; i<this.listAllInters.size(); i++) {
            t += this.listAllInters.get(i).getNumInterv() + " ";
        }
        return t;
    }

    public String getIntervenants() {
        String t = "";
        for (int i=0; i<this.intervenants.size(); i++) {
            t += this.intervenants.get(i).getNumInterv() + " ";
        }
        return t;        
    }
}