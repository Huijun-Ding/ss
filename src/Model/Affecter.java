package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Affecter {
    private ArrayList<Intervenant> listAllInters;
    private ArrayList<Intervenant> listCandidats;
    private ArrayList<Intervenant> intervenants;
    private Tache tache;
    private ArrayList<Intervenant> listAttende ;
    private int nb = tache.getNbPersonne();
    private int nbAccept=0;
   
    
    public void addListAllInters(Intervenant a) {
        this.listAllInters.add(a);
    }
    
    public void selectCandidats() {
        for (Intervenant i: this.listAllInters) {
            if (i.getMesCompetences().equals(tache.getCompetences()) && (i.getNoteIn()<= getNoteClient())) {
                this.listCandidats.add(i);                   
            }  
        }
    }
    
    public float getNoteClient() {
        return tache.getClient().getNoteC();
    }
    
    public void classerCandidats() {
        int length = listCandidats.size();

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (listCandidats.get(j).getNoteIn() > listCandidats.get(j+1).getNoteIn()) {
                    Collections.swap(listCandidats, j, j+1);
                }
            }
        }
    }

    public void affecterTache() {

        if (nbAccept<nb){ 
            for(int i=0;i<nb-nbAccept;i++){  
        listCandidats.get(i).etreAffecte(tache);  // informer l'intervenant qu,'il a tache a recevoir
        listCandidats.remove(listCandidats.get(i));
        listAttende.add(listCandidats.get(i));
        }
            //加时间条件
            for(int i=0;i<listAttende.size();i++){
                if (listCandidats.get(i).accepterTache(tache)){
                    intervenants.add(listCandidats.get(i));
                    nbAccept++;}
            }
            
        }
       
              
    }
    public void supprimerTache(){
        if (nbAccept==nb){  // si le nombre de personne qui accepte la tache est egal au  nbPersonne
        for(int i=0;i<listAttende.size();i++){
            listAttende.get(i).supprimerAffecte(tache);
        }
        }
    }

 }