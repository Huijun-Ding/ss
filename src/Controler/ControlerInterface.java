package Controler;

import Model.Client;
import Model.Intervenant;

public class ControlerInterface {
    private Client client;
    private Intervenant intervenant;



    public boolean checkPasswordC(String pass){
        boolean same=false;
        if (client.getMotdepasseC()==pass){
            same=true;
        }
        return same;
    }

    public boolean checkPasswordI(String pass){
        boolean same=false;
        if (intervenant.getMotdepasseI()==pass){
            same=true;
        }
        return same;
    }
}
