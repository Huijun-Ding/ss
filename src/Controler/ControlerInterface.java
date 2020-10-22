package Controler;

import Dao.ClientDao;
import Dao.IntervenantDao;
import Dao.TacheDao;
import Model.Client;
import Model.Entreprise;
import Model.Intervenant;
import Model.Intervenant;
import Model.Particulier;
import Model.Tache;

public class ControlerInterface {
    private Intervenant intervenant;
    private ClientDao clientDao;
    private IntervenantDao intervDao;
    private TacheDao tacheDao;

    public ControlerInterface() {
        this.clientDao = new ClientDao();
        this.intervDao = new IntervenantDao();
        this.tacheDao = new TacheDao();
    }
    public void oup(){
        System.out.println("3");
    }
    

    public boolean checkPasswordC(Client c, String pass) {
        boolean same = false;
         System.out.println(same);
        if (c.getMotdepasseC().equals(pass)) {
            same = true;
        }
        return same;
    }

    public boolean checkPasswordI(Intervenant i, String pass) {
        boolean same = false;
        if (i.getMotdepasseI().equals(pass)) {
            same = true;
        }
        System.out.println(same);
        return same;
    }

    // retourner une instance en fonction de Email/nom
    public Client seekClient(String e) {
        System.out.println("hello");
        System.out.println(clientDao.login(e).getEmail());
        return clientDao.login(e);
    }

    public Intervenant seekIntervenant(String e) {
        System.out.println("hello");
        System.out.println(intervDao.login(e).getEmail());
        return intervDao.login(e);
    }

    public void putTacheInBD(Tache t) {
        tacheDao.createTache(t);
    }

    public void putEntrepInBD(Entreprise en) {
    }

    public void putPartiInBD(Particulier pa) {
        clientDao.addParticulier(pa);
    }

    public void putIntervInBD(Intervenant in) {
        intervDao.addIntervenant(intervenant);
    }

}
