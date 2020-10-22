package Vue;

import Controler.ControlerInterface;
import Model.Intervenant;
import Model.Tache;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecommanderTache {
    private ControlerInterface controler;
    private Intervenant intervenant;
    private Tache tache=null;

    private JFrame jFrame = new JFrame("Recommande");
    private Container c = jFrame.getContentPane();
    private JLabel lbNom = new JLabel("Nom de Tache");
    private JLabel lbNomTache=new JLabel("...");
    private JLabel lbEc = new JLabel("Echeance");
    private JLabel lbEcheance =new JLabel("...");
    private JLabel lbComp = new JLabel("Competence");
    private JLabel lbCompetence =new JLabel("...");
    private JLabel lbPri = new JLabel("Prix");
    private JLabel lbPrix=new JLabel("...");
    private JLabel lbDescri = new JLabel("Description de tache :");
   private JTextArea lbDescription = new JTextArea(10, 10);
    private JLabel lbDateD = new JLabel("Date Debut");
    private JLabel lbDateDebut=new JLabel("...") ;
    private JButton okbtn = new JButton("Ok");
    private JButton cancelbtn = new JButton("Refuse");


    public RecommanderTache() {
        //this.intervenant=in;Intervenant in
        jFrame.setBounds(600, 200, 600, 500);
        c.setLayout(new BorderLayout());//布局管理器
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        jFrame.setVisible(true);
        if(intervenant.getListTachesRecevoir()!=null){
            tache=intervenant.getListTachesRecevoir().get(0);
        }else{tache=null;}

    }
    public JFrame getjFrame() {
        return jFrame;
    }

    public void init() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("Mes taches Recoomandees"));
        c.add(titlePanel, "North");

        if(tache!=null){
            lbNomTache = new JLabel(tache.getNomTache());
            lbEcheance = new JLabel(tache.getDateFin());
            lbCompetence = new JLabel(tache.getCompetences().get(0).getNomP());//problem
            String s=Float.toString(tache.getPrix());
            lbPrix = new JLabel(s);
            lbDateDebut = new JLabel(tache.getDateDeb());

        }else{
            lbNomTache.setText("...");
            lbEcheance .setText("...");
            lbCompetence .setText("...");
            lbPrix .setText("...");
            lbDateDebut.setText("...");
        }



        /*输入部分--Center*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        lbNom.setBounds(100, 50, 100, 20);
        lbNomTache.setBounds(215, 50, 100, 20);
        lbDateD.setBounds(330, 50, 100, 20);
        lbDateDebut.setBounds(445, 50, 100, 20);
        lbEc.setBounds(330, 90, 100, 20);
        lbEcheance.setBounds(445, 90, 100, 20);
        lbComp.setBounds(330, 130, 100, 20);
        lbCompetence.setBounds(445, 130, 100, 20);
        lbPri.setBounds(330, 170, 80, 20);
        lbPrix.setBounds(445, 170, 80, 20);
        lbDescri.setBounds(100, 90, 130, 20);
        lbDescription.setBounds(100,120,150,180);
        fieldPanel.add(lbNomTache);
        fieldPanel.add(lbNom);
        fieldPanel.add(lbDateD);
        fieldPanel.add(lbDateDebut);
        fieldPanel.add(lbEcheance);
        fieldPanel.add(lbEc);
        fieldPanel.add(lbComp);
        fieldPanel.add(lbCompetence);
        fieldPanel.add(lbPrix);
        fieldPanel.add(lbPri);
        fieldPanel.add(lbDescri);
        fieldPanel.add(lbDescription);

        c.add(fieldPanel, "Center");

        /*按钮部分--South*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(okbtn);
        buttonPanel.add(cancelbtn);
        c.add(buttonPanel, "South");




        okbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == okbtn) {
                    intervenant.accepterTache(tache);

                }
            }
        });


        cancelbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cancelbtn) {
                    intervenant.refuserTache(tache);

                }
            }
        });


        jFrame.setLocationRelativeTo(null);
    }
}

