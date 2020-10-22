package Controler;

import Model.*;

public class ControlerInterface {
    private Client client;
    private Intervenant intervenant;


    public boolean checkPasswordC(Client c, String pass) {
        boolean same = false;
        if (c.getMotdepasseC() == pass) {
            same = true;
        }
        return same;
    }

    public boolean checkPasswordI(Intervenant i, String pass) {
        boolean same = false;
        if (i.getMotdepasseI() == pass) {
            same = true;
        }
        return same;
    }

    // retourner une instance en fonction de Email/nom
    public Client seekClient(String e) {
        Client c = null;

        return c;

    }

    public Intervenant seekIntervenant(String e) {
        Intervenant i = null;

        return i;

    }


    public void putTacheInBD(Tache t) {


    }


    public void putEntrepInBD(Entreprise en) {

    }

    public void putPartiInBD(Particulier pa) {


    }

    public void putIntervInBD(Intervenant in) {

    }

}
