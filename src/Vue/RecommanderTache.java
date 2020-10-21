package Vue;

import javax.swing.*;
import java.awt.*;

public class RecommanderTache {

    private JFrame jFrame = new JFrame("Creation de Tache");
    private Container c = jFrame.getContentPane();
    private JLabel lbNom = new JLabel("Nom de Tache");
    private JLabel lbNomTache = new JLabel("...");
    private JLabel lbEc = new JLabel("Echeance");
    private JLabel lbEcheance = new JLabel("...");
    private JLabel lbComp = new JLabel("Competence");
    private JLabel lbCompetence = new JLabel("...");
    private JLabel lbPri = new JLabel("Prix");
    private JLabel lbPrix = new JLabel("...");
    private JLabel lbDescri = new JLabel("Description de tache :");
  //  private JLabel lbDescription = new JLabel("...");
   private JTextArea lbDescription = new JTextArea(10, 10);
    private JLabel lbDateD = new JLabel("Date Debut");
    private JLabel lbDateDebut = new JLabel("...");
    private JButton okbtn = new JButton("Ok");
    private JButton cancelbtn = new JButton("Refuse");

    public RecommanderTache() {
        jFrame.setBounds(600, 200, 600, 500);
        c.setLayout(new BorderLayout());//布局管理器
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        jFrame.setVisible(true);
    }

    public void init() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("Mes taches Recoomandees"));
        c.add(titlePanel, "North");

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

        jFrame.setLocationRelativeTo(null);
    }
}

