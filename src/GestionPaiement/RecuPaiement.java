
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionPaiement;

import GestionDonnes.Intervenant;
import GestionTache.Tache;

/**
 *
 * @author Mathi
 */
public class RecuPaiement {
    protected String nomRP;
    protected String dateRP;
    protected float montantRP;
    private Intervenant intervenant;
    private Tache tache;
    
    public RecuPaiement(String nom, String day, float montant) {
        this.nomRP = nom;
        this.dateRP = day;
        this.montantRP = montant;
    }
}

