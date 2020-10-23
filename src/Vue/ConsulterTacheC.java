package Vue;

import Model.Client;
import Model.Tache;
import Model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ConsulterTacheC extends JFrame implements ListSelectionListener {
    private JPanel p;
    private JFrame jFrame;
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
    private JButton btnRetour = new JButton("Return");
    private JButton btnPayer = new JButton("Payer");
    private JButton btnValider = new JButton("Valider");
    private JButton btnEvaluer = new JButton("Evaluer");
    private JButton btnModifier = new JButton("Modifier");
    private JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
    private URL resource = this.getClass().getResource("images/background2.jpg"); // 获取背景图片路径
    private ImageIcon icon = new ImageIcon("images/background2.jpg");//创建图片对象

    private Client client = new Client(1, "0645857455", "rue du 11 Novembre", "Toulouse", "31300", "548725100XXXX", 0f);
    private Tache t1 = new Tache("Affectation", "affecter des taches", 1, 200f, "Comptable", EnumEtat.FINALISEE_INTER, "05/05/2020", "01/12/2020");
    private Tache t2 = new Tache("Realisation", "realiser des taches", 3, 2000f, "Java", EnumEtat.ACCEPTEE, "05/05/2021", "01/12/2021");
    // private Tache t = new Tache("t1", "ed", 1, 1f, "j", EnumEtat.EN_COURS, "1", "2");
    private Tache[] choix = new Tache[2];
    //int[] ns = new int[5];
    private String[] nomChoix = new String[2];

    JLabel etiquette = new JLabel("                   ");

    public ConsulterTacheC() {//Client c
        super("Consulter mes taches");
        //this.client=c;
        p = new JPanel(null);
        jFrame = this;


        client.addTache(t1);
        client.addTache(t2);
        addChoix();
        liste = new JList(nomChoix);
        liste.addListSelectionListener(this);
        liste.setBounds(0, 0, 200, 600);
        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小
        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小
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

        btnRetour.setBounds(650, 500, 80, 50);
        btnRetour.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                ClientInterface cn = new ClientInterface();
                cn.getjFrame().setVisible(true);

            }
        });
        p.add(btnRetour);
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

        p.add(lblBackground); // 将组件添加到面板中
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
                    choix[courrent].setEtat(EnumEtat.PAYEE);

                }
            }
        });

        btnValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnValider) {
                    choix[courrent].setEtat(EnumEtat.VALIDEE_CLIENT);
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
       // etiquette.setText((String) liste.getSelectedValue());
        //Par rapport au nom dans choix, si les mêmes mots sont les mêmes, les informations de la tâche seront affichées à d'autres endroits

        for (int i = 0; i < nomChoix.length; i++) {
            if (liste.getSelectedValue() == choix[i].getNomTache()) {
                courrent = i;
                etatTac.setText(choix[i].getEtat().toString());
                nomTa.setText(choix[i].getNomTache());
                int nb = choix[i].getNbPersonne();
                String s = "" + nb;// transformer int en String
                nbpTa.setText(s);
                dateDT.setText(choix[i].getDateDeb());
                dateFT.setText(choix[i].getDateFin());
                Descri.setText(choix[i].getDescription());
                switch (choix[i].getEtat()) {
                    case VALIDEE_CLIENT:
                        btnEvaluer.setVisible(true);
                        btnValider.setVisible(false);
                        btnPayer.setVisible(false);
                        //btnEvaluer.setContentAreaFilled(true);
                        break;
                    case FINALISEE_INTER:
                        btnEvaluer.setVisible(false);
                        btnValider.setVisible(true);
                        btnPayer.setVisible(false);
                        //btnValider.setContentAreaFilled(true);
                        break;
                    case ACCEPTEE:
                        btnEvaluer.setVisible(false);
                        btnValider.setVisible(false);
                        btnPayer.setVisible(true);
                        //btnPayer.setContentAreaFilled(true);
                        break;
                }
            } /*else {
                etatTac.setText("...");
                nomTa.setText("...");
                nbpTa.setText("...");
                dateDT.setText("...");
                dateFT.setText("...");
                Descri.setText("...");
            }*/
        }


    }

    public void addChoix() {
        for (int i = 0; i < client.getTaches().size(); i++) {
            this.choix[i] = client.getTaches().get(i);
            System.out.println(choix[0].getNomTache());
            this.nomChoix[i] = client.getTaches().get(i).getNomTache();
        }
    }


}

