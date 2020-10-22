package Vue;

import Model.Client;
import Model.Tache;
import Model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ConsulterTacheC extends JFrame implements ListSelectionListener {
    private JPanel p;
    private JList liste = new JList();
    private JLabel etat = new JLabel("Etat de tache");
    private JLabel etatTac;
    private JLabel nom = new JLabel("Nom de tache");
    private JLabel nomTa ;
    private JLabel nbp = new JLabel("Nombre de personne");
    private JLabel nbpTa ;
    private JLabel dateD = new JLabel("Date de debut");
    private JLabel dateDT ;
    private JLabel dateF = new JLabel("Date d'echeance");
    private JLabel dateFT ;
    private JLabel Description = new JLabel("Description");
    private JTextArea Descri=new JTextArea(10, 30);
    private Client client;
    private Tache t=new Tache("t1","ed",1,1f,"j",EnumEtat.EN_COURS,"1","2");
    private Tache choix[] = {};
    private String nomChoix[] = {"java"};

    JLabel etiquette = new JLabel("                   ");
    public ConsulterTacheC() {//Client c
        super("Consulter mes taches");
        //this.client=c;
        p = new JPanel(null);
        //addChoix();

        liste = new JList(nomChoix);
        liste.addListSelectionListener(this);
        liste.setBounds(0,0,200,600);


        nom.setBounds(250,20,120,20);
        nomTa.setBounds(390,20,120,20);
        etat.setBounds(650,20,120,20);
        etatTac.setBounds(770,20,120,20);
        dateD.setBounds(250,100,120,20);
        dateDT.setBounds(390,100,120,20);
        dateF.setBounds(650,100,120,20);
        dateFT.setBounds(770,100,120,20);
        nbp.setBounds(250,180,120,20);
        nbpTa.setBounds(390,180,120,20);
        Description.setBounds(250,220,50,100);
        Descri.setBounds(250,240,600,100);
        etiquette.setBounds(250,400,50,50);

        p.add(liste);
        p.add(nomTa);
        p.add(etatTac);
        p.add(dateDT);
        p.add(dateFT);
        p.add(Descri);
        p.add(nbpTa);
        p.add(etat);
        p.add(nom);
        p.add(dateD);
        p.add(dateF);
        p.add(nbp);
        p.add(Description);
        p.add(etiquette);

        this.add(p);




        pack();


        this.setSize(1000, 600);
        this.setLocation(200, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void valueChanged(ListSelectionEvent evt) {
        etiquette.setText((String) liste.getSelectedValue());
        //与choix中的名字相比，相同的话则在其他位置显示该任务信息
        //给其他的加 人或者任务
        for (int i = 0; i < nomChoix.length; i++) {
            if (nomChoix[i]==choix[i].getNomTache()) {
                JLabel etatTac = new JLabel(choix[i].getEtat().toString());
                JLabel nomTa = new JLabel(choix[i].getNomTache());
                int nb=choix[i].getNbPersonne();
                String s=""+nb;// transformer int en String
                JLabel nbpTa = new JLabel(s);
                JLabel dateDT = new JLabel(choix[i].getDateDeb());
                JLabel dateFT = new JLabel(choix[i].getDateFin());
                Descri.setText(choix[i].getDescription());
            }
            else{
                 JLabel etatTac = new JLabel("...");
                 JLabel nomTa = new JLabel("...");
                 JLabel nbpTa = new JLabel("...");
                 JLabel dateDT = new JLabel("...");
                 JLabel dateFT = new JLabel("...");
                 JTextArea Descri=new JTextArea(10, 30);
            }
        }


    }
    public void addChoix(){
        for (int i = 0; i <client.getTaches().size() ; i++) {
            this.choix[i]=client.getTaches().get(i);
            this.nomChoix[i]=client.getTaches().get(i).getNomTache();
        }
    }




}

