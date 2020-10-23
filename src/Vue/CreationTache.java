package Vue;

import Controler.ControlerInterface;
import Model.Client;
import Model.EnumEtat;
import Model.Tache;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;



public class CreationTache {
    private Client client;

    private JFrame jFrame = new JFrame("Creation de tache");
    private Container c = jFrame.getContentPane();
    private JLabel lbNomTache = new JLabel("Nom de tache");
    private JLabel lbIMsgI = new JLabel();
    private JLabel lbDateD = new JLabel("Date de debur");
    private JLabel lbDateF = new JLabel("Date d'echeance");
    private JLabel lbPrix = new JLabel("Prix");
    private JLabel lbNbP = new JLabel("Nombre de personne");
    private JLabel lbDescrip = new JLabel("Description de tache");
    private JLabel lbDomaine = new JLabel("Domaine de tache");
    private JLabel lbCompetence = new JLabel("Competence de tache");
    private JTextField tfDescription = new JTextField(10);
    private JTextField tfNomTache = new JTextField();
    private JTextField tfDateD = new JTextField();
    private JTextField tfDateF = new JTextField();
    private JTextField tfPrix = new JTextField();
    private JTextField tfNbP = new JTextField();
    private JTextField tfCompe = new JTextField();
    private JButton btnRetour = new JButton("Return");
    private ControlerInterface contoler;

    private JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
    private URL resource = this.getClass().getResource("images/background2.jpg"); // 获取背景图片路径
    private ImageIcon icon = new ImageIcon("images/background2.jpg");//创建图片对象
    private JButton okbtn = new JButton("Ok");
    private JButton sousbtn = new JButton("add Sous-tache");
    private JButton cancelbtn = new JButton("cancel");
    private JButton save = new JButton("save");
    String[] listData = new String[]{"Java", "Php", "C++", "Python"};

    final JComboBox<String> comboBox = new JComboBox<String>(listData);


    public CreationTache() {
        //this.client=cl;Client cl
        jFrame.setBounds(600, 200, 800, 500);
        c.setLayout(new BorderLayout());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        jFrame.setVisible(true);
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public void init() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("Creation de tache"));
        c.add(titlePanel, "North");


        lblBackground.setIcon(icon);
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        /*Partie d'entrée--Center*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        lbNomTache.setBounds(100, 50, 120, 20);
        lbDateD.setBounds(100, 90, 120, 20);
        lbDateF.setBounds(400, 90, 120, 20);
        lbPrix.setBounds(100, 130, 120, 20);
        lbNbP.setBounds(400, 130, 120, 20);
        lbDescrip.setBounds(100, 170, 120, 20);
        lbDomaine.setBounds(100, 270, 120, 20);
        lbCompetence.setBounds(100, 310, 150, 20);
        tfNomTache.setBounds(250, 50, 400, 20);
        tfDateD.setBounds(250, 90, 120, 20);
        tfDateF.setBounds(550, 90, 120, 20);
        tfPrix.setBounds(250, 130, 120, 20);
        tfNbP.setBounds(550, 130, 120, 20);
        tfDescription.setBounds(250, 170, 400, 60);
        tfCompe.setBounds(250, 310, 120, 20);
        comboBox.setBounds(250, 270, 120, 20);


        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Traiter uniquement l'état sélectionné
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("select: " + comboBox.getSelectedIndex() + " = " + comboBox.getSelectedItem());
                }
            }
        });

        // Définit l'élément sélectionné par défaut
        comboBox.setSelectedIndex(2);
        btnRetour.setBounds(280, 380, 100, 25);
        btnRetour.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                ClientInterface cn = new ClientInterface(client);
                cn.getjFrame().setVisible(true);

            }
        });
        fieldPanel.add(btnRetour);
        fieldPanel.add(comboBox);
        fieldPanel.add(lbNomTache);
        fieldPanel.add(lbDateD);
        fieldPanel.add(lbDateF);

        fieldPanel.add(lbPrix);
        fieldPanel.add(lbNbP);
        fieldPanel.add(lbDescrip);
        fieldPanel.add(lbDomaine);
        fieldPanel.add(lbCompetence);
        fieldPanel.add(tfNomTache);
        fieldPanel.add(tfDateD);
        fieldPanel.add(tfDateF);
        fieldPanel.add(tfPrix);
        fieldPanel.add(tfNbP);
        fieldPanel.add(tfDescription);
        fieldPanel.add(tfCompe);
        fieldPanel.add(comboBox);

        fieldPanel.add(lblBackground); // 将组件添加到面板中
        c.add(fieldPanel, "Center");


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(okbtn);
        buttonPanel.add(save);
        buttonPanel.add(cancelbtn);
        buttonPanel.add(sousbtn);
        buttonPanel.add(btnRetour);


        okbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == okbtn) {
                    String nomT = tfNomTache.getText();
                    String dateD = tfDateD.getText();
                    String dateF = tfDateF.getText();
                    String prix = tfPrix.getText();
                    float p = Float.parseFloat(prix);
                    String nbP = tfNbP.getText();
                    int nb = Integer.parseInt(nbP);
                    String descri = tfDescription.getText();
                    String competence = tfCompe.getText();
                    String domaine = (String) comboBox.getSelectedItem();
                    //enregistrer toutes les info dans BD
                    Tache t = new Tache(nomT, descri, nb, p, domaine, EnumEtat.EN_COURS, dateD, dateF);
                    t.setClientId(client.getNumClient());
                    contoler.putTacheInBD(t);

                }
            }

        });



        sousbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == sousbtn) {
                    String nomT = tfNomTache.getText();
                    String dateD = tfDateD.getText();
                    String dateF = tfDateF.getText();
                    String prix = tfPrix.getText();
                    float p = Float.parseFloat(prix);
                    String nbP = tfNbP.getText();
                    int nb = Integer.parseInt(nbP);
                    String descri = tfDescription.getText();
                    String competence = tfCompe.getText();
                    String domaine = (String) comboBox.getSelectedItem();
                    //enregistrer toutes les info dans BD
                    Tache t = new Tache(nomT, descri, nb, p, domaine, EnumEtat.EN_COURS, dateD, dateF);
                    jFrame.setVisible(false);
                    //sauter a la page suivant
                    CreationTache sousFrame = new CreationTache();//client
                    sousFrame.getjFrame().setVisible(true);

                }
            }

        });


        cancelbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //vider toutes les infos
                tfCompe.setText("");
                tfDateD.setText("");
                tfDateF.setText("");
                tfDescription.setText("");
                tfNbP.setText("");
                tfNomTache.setText("");
                tfPrix.setText("");


                //lbIMsgC.setText("");

            }
        });

        c.add(buttonPanel, "South");
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void obtenirInfo() {// obtenir toutes les infos d'utilisateur qui remplit.
        String nomT = tfNomTache.getText();
        String dateD = tfDateD.getText();
        String dateF = tfDateF.getText();
        String prix = tfPrix.getText();
        String nbP = tfNbP.getText();
        String descri = tfDescription.getText();
        String competence = tfCompe.getText();
        String domaine = (String) comboBox.getSelectedItem();
    }


}
