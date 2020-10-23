
import BD.DB;
import Model.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /*DB db = new DB();
        db.createConn();*/

 /*DB db = new DB();
        db.createConn();*/
        // TODO code application logic here
        Intervenant i1 = new Intervenant(1, "0603047123", "6 rue des étoiles", "Toulouse", "31000", "1836458393995747", 4.00f);
        Intervenant i2 = new Intervenant(2, "0603436734", "11 rue des lois", "Toulouse", "31000", "1836458393995747", 4.26f);
        Intervenant i3 = new Intervenant(3, "0623047123", "allée Et", "Toulouse", "31000", "1836458393995747", 3.50f);
        Intervenant i4 = new Intervenant(4, "3456789457", "rue xxxx", "LYON", "31000", "1234244056789", 3.50f);

        Competence comp1 = new Competence("conception");
        Competence comp2 = new Competence("html");
        Competence comp3 = new Competence("php");
        Competence comp4 = new Competence("css");

        Client c1 = new Client("7674677267", "rue xxxx", "toulouse", "31000", "123456789056789", "gsczdddd@gmail.com", 4.26f);

        TacheComplexe t1 = new TacheComplexe("Developement site web", "xxxxxxxxxxx", 4, 4000, "IT", EnumEtat.EN_COURS, "18/10/2020", "01/01/2021", c1);
        TacheSimple t2 = new TacheSimple("Conception site web", "xxxxxxxxxxx", 1, 1000, "IT", EnumEtat.EN_COURS, "18/10/2020", "30/10/2021", c1);
        TacheMassive t3 = new TacheMassive("developpeurs", "xxxxxxxxxxx", 3, 3000, "IT", EnumEtat.EN_COURS, "18/10/2020", "01/01/2021", c1);

        Paiement p1 = new Paiement(1, "20/10/2020", 1000.00f, t2);
        Paiement p2 = new Paiement(2, "20/10/2020", 3000.00f, t3);

        RecuPaiement rp1 = new RecuPaiement("conecption", "05/11/2021", 1000, t2, i1);
        RecuPaiement rp2 = new RecuPaiement("developpeur 1", "05/01/2021", 1000, t3, i2);
        RecuPaiement rp3 = new RecuPaiement("developpeur 2", "05/01/2021", 1000, t3, i3);
        RecuPaiement rp4 = new RecuPaiement("developpeur 3", "05/01/2021", 1000, t3, i4);

        t1.addTache(t2);
        t1.addTache(t3);
        t2.ajouterCompetence(comp1);
        t3.ajouterCompetence(comp2);
        t3.ajouterCompetence(comp3);
        t3.ajouterCompetence(comp4);
        i1.addMesCompetences(comp1);
        i2.addMesCompetences(comp2);
        i2.addMesCompetences(comp3);
        i2.addMesCompetences(comp4);
        i3.addMesCompetences(comp2);
        i3.addMesCompetences(comp3);
        i3.addMesCompetences(comp4);
        i4.addMesCompetences(comp2);
        i4.addMesCompetences(comp3);
        i4.addMesCompetences(comp4);

        Affecter af2 = new Affecter(t2);
        af2.addListAllInters(i1);
        af2.addListAllInters(i2);
        af2.addListAllInters(i3);
        af2.addListAllInters(i4);
        af2.selectCandidats();
        af2.classerCandidats();
        
        System.out.println("tous les intervenants Conception: " + af2.getListAllInter());
        System.out.println("les candidats Conception: " + af2.getListCandidats());
        
        try {
            af2.affecterTache();
            //Thread.sleep(14400000); //4 heures
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Affecter af1 = new Affecter(t3);
        af1.addListAllInters(i1);
        af1.addListAllInters(i2);
        af1.addListAllInters(i3);
        af1.addListAllInters(i4);
        af1.selectCandidats();
        af1.classerCandidats();
        
        System.out.println("tous les intervenants Developpement: " + af1.getListAllInter());
        System.out.println("les candidats Developpement: " + af1.getListCandidats());  
        
        try {
            af1.affecterTache();
            //Thread.sleep(14400000); //4 heures
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Intervenant1 tache reçu: " + i1.getTacheAffectee());
        System.out.println("Intervenant2 tache reçu: " + i2.getTacheAffectee());
        System.out.println("Intervenant3 tache reçu: " + i3.getTacheAffectee());
        System.out.println("Intervenant4 tache reçu: " + i4.getTacheAffectee());             

        i1.accepterTache(t2);
        i2.accepterTache(t3);
        i3.accepterTache(t3);
        i4.accepterTache(t3);

        t2.setPaiement(p1);
        t3.setPaiement(p2);

        try {
            af1.affecterTache();
            //Thread.sleep(14400000); //4 heures
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        try {
            af2.affecterTache();
            //Thread.sleep(14400000); //4 heures
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("paiement cllient pour conception " + t2.getPaiement());
        System.out.println(t2.getEtat());
        System.out.println("paiement cllient pour developpement " + t3.getPaiement());
        System.out.println(t3.getEtat());
        
        System.out.println("liste finle Developpement " + af1.getIntervenants());
        System.out.println("liste finle Conception " + af2.getIntervenants());

        System.out.println("Intervenant1 tache: " + i1.consulterTache());
        System.out.println("Intervenant2 tache: " + i2.consulterTache());
        System.out.println("Intervenant3 tache: " + i3.consulterTache());
        System.out.println("Intervenant4 tache: " + i4.consulterTache());
        
        

    }

}
