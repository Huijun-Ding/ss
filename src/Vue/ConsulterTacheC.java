package Vue;

import Model.Client;
import Model.Tache;
import Model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsulterTacheC extends JFrame implements ListSelectionListener {
    private JPanel p;
    private int courrent;
    private JList liste = new JList();
    private JLabel etat = new JLabel("Etat de tache");
    private JLabel etatTac = new JLabel("...");
    private JLabel nom = new JLabel("Nom de tache");
    private JLabel nomTa = new JLabel("...");
    private JLabel nbp = new JLabel("Nombre de personne");
    private JLabel nbpTa = new JLabel("...");
    private JLabel dateD = new JLabel("Date de debut");
    private JLabel dateDT = new JLabel("...");
    private JLabel dateF = new JLabel("Date d'echeance");
    private JLabel dateFT = new JLabel("...");
    private JLabel Description = new JLabel("Description");
    private JTextArea Descri = new JTextArea(10, 30);

    private JButton btnPayer=new JButton("Payer");
    private JButton btnValider=new JButton("Valider");
    private JButton btnEvaluer=new JButton("Evaluer");
    private JButton btnModifier=new JButton("Modifier");

    private Client client;
   // private Tache t = new Tache("t1", "ed", 1, 1f, "j", EnumEtat.EN_COURS, "1", "2");

  private ArrayList<Tache> choix = new ArrayList<Tache>();
    //int[] ns = new int[5];
    private  ArrayList<String> nomChoix = new ArrayList<String>();

    JLabel etiquette = new JLabel("                   ");

    public ConsulterTacheC(Client c) {
        super("Consulter mes taches");
        this.client= new Client();
        this.client=c;
        this.choix=c.getTaches();
        p = new JPanel(null);
        addChoix();
         String[] nomChoixShu=(String[])nomChoix.toArray();
        liste = new JList( nomChoixShu);
        liste.addListSelectionListener(this);
        liste.setBounds(0, 0, 200, 600);


        nom.setBounds(250, 20, 120, 20);
        nomTa.setBounds(390, 20, 120, 20);
        etat.setBounds(650, 20, 120, 20);
        etatTac.setBounds(770, 20, 120, 20);
        dateD.setBounds(250, 100, 120, 20);
        dateDT.setBounds(390, 100, 120, 20);
        dateF.setBounds(650, 100, 120, 20);
        dateFT.setBounds(770, 100, 120, 20);
        nbp.setBounds(250, 180, 120, 20);
        nbpTa.setBounds(390, 180, 120, 20);
        Description.setBounds(250, 220, 50, 100);
        Descri.setBounds(250, 240, 600, 100);
        etiquette.setBounds(250, 400, 50, 50);
        btnEvaluer.setBounds(800, 500, 80, 50);
        btnPayer.setBounds(800, 500, 80, 50);
        btnModifier.setBounds(900, 500, 80, 50);
        btnValider.setBounds(800, 500, 80, 50);

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
        p.add(btnEvaluer);
        p.add(btnModifier);
        p.add(btnPayer);
        p.add(btnValider);

        btnPayer.setVisible(false);
        //btnPayer.setContentAreaFilled(false);

        btnEvaluer.setVisible(false);
        //btnEvaluer.setContentAreaFilled(false);

        btnValider.setVisible(false);
        //btnValider.setContentAreaFilled(false);

        this.add(p);

        pack();



        btnPayer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnPayer) {
                    choix.get(courrent).setEtat(EnumEtat.PAYEE);

                    //应该创建objet paiement 但是我没有
                }
            }
        });

        btnValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnValider) {
                    choix.get(courrent).setEtat(EnumEtat.VALIDEE_CLIENT);
                }
            }
        });

        btnEvaluer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnEvaluer) {
                    //this.setVisible(false);
                    EvaluationViaClient ec = new EvaluationViaClient();
                    ec.getjFrame().setVisible(true);
                }
            }
        });


        btnModifier.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnModifier) {
                    //this.setVisible(false);
                    System.out.println("modifier");
                    Modifier mo = new Modifier();
                    mo.getjFrame().setVisible(true);
                }
            }
        });



        this.setSize(1000, 600);
        this.setLocation(200, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void valueChanged(ListSelectionEvent evt) {
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
       // etiquette.setText((String) liste.getSelectedValue());
        //与choix中的名字相比，相同的话则在其他位置显示该任务信息
         for (int i = 0; i < nomChoix.size(); i++) {
         if (liste.getSelectedValue() == choix.get(i).getNomTache()) {
                courrent = i;
                etatTac.setText(choix.get(i).getEtat().toString());
                nomTa.setText(choix.get(i).getNomTache());
                int nb = choix.get(i).getNbPersonne();
                String s = "" + nb;// transformer int en String
                nbpTa.setText(s);
                dateDT.setText(choix.get(i).getDateDeb());
                dateFT.setText(choix.get(i).getDateFin());
                Descri.setText(choix.get(i).getDescription());
                System.out.println(choix.get(i).getNomTache());
                switch (choix.get(i).getEtat()) {
                    case VALIDEE_CLIENT:
                        btnEvaluer.setVisible(true);
                        //btnEvaluer.setContentAreaFilled(true);
                        break;
                    case FINALISEE_INTER:
                        btnValider.setVisible(true);
                        //btnValider.setContentAreaFilled(true);
                        break;
                    case ACCEPTEE:
                        btnPayer.setVisible(true);
                        //btnPayer.setContentAreaFilled(true);
                        break;
                }
            } else {
                etatTac.setText("...");
                nomTa.setText("...");
                nbpTa.setText("...");
                dateDT.setText("...");
                dateFT.setText("...");
                Descri.setText("...");
            }
        }


    }

    public void addChoix() {
        for (int i = 0; i < client.getTaches().size(); i++) {
            this.choix.add (client.getTaches().get(i));
            this.nomChoix.add( client.getTaches().get(i).getNomTache());
        }
    }


}

