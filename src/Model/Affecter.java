package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Affecter {
    private ArrayList<Intervenant> listAllInters;
    private ArrayList<Intervenant> listCandidats;
    private ArrayList<Intervenant> intervenants;
    private Tache tache;
    
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
        int nb = tache.getNbPersonne() * 3;
        
        
    }
 }
