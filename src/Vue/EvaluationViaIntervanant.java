package Vue;

import javax.swing.*;
import java.awt.*;

public class EvaluationViaIntervanant {

    private JFrame jFrame = new JFrame("Evaluation Via Intervenant");
    private Container c = jFrame.getContentPane();
    private JLabel lbIndicateur = new JLabel("Indicateur");
    private JLabel lbEvaluation = new JLabel("Evaluation");
    private JLabel lbI1 = new JLabel("<html><body><p >correspondance entre la tache telle que decrite et<br/> la tache effectivement realisee</p></body></html> ");
    private JLabel lbI2 = new JLabel("rentabilite de la tache");
    private JLabel lbI3 = new JLabel("qualite d'echange entre client");
    private JLabel lbcomm = new JLabel("Commentaire");
    private JTextField lbCommentaire = new JTextField(10);
    // 创建两个单选按钮
    private JRadioButton radioBtn101 = new JRadioButton("1");
    private JRadioButton radioBtn102 = new JRadioButton("2");
    private JRadioButton radioBtn103 = new JRadioButton("3");
    private JRadioButton radioBtn104 = new JRadioButton("4");
    private JRadioButton radioBtn105 = new JRadioButton("5");

    private JRadioButton radioBtn201 = new JRadioButton("1");
    private JRadioButton radioBtn202 = new JRadioButton("2");
    private JRadioButton radioBtn203 = new JRadioButton("3");
    private JRadioButton radioBtn204 = new JRadioButton("4");
    private JRadioButton radioBtn205 = new JRadioButton("5");

    private JRadioButton radioBtn301 = new JRadioButton("1");
    private JRadioButton radioBtn302 = new JRadioButton("2");
    private JRadioButton radioBtn303 = new JRadioButton("3");
    private JRadioButton radioBtn304 = new JRadioButton("4");
    private JRadioButton radioBtn305 = new JRadioButton("5");

    private JButton okbtn = new JButton("Ok");
    private JButton cancelbtn = new JButton("cancel");

    public EvaluationViaIntervanant() {
        jFrame.setBounds(600, 200, 800, 500);
        c.setLayout(new BorderLayout());//布局管理器
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        jFrame.setVisible(true);
    }

    public void init() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("Evaluation Interface Intervenant"));
        c.add(titlePanel, "North");

        ButtonGroup btnGroup1 = new ButtonGroup();
        btnGroup1.add(radioBtn101);
        btnGroup1.add(radioBtn102);
        btnGroup1.add(radioBtn103);
        btnGroup1.add(radioBtn104);
        btnGroup1.add(radioBtn105);
        // 设置第一个单选按钮选中
        // radioBtn101.setSelected(true);

        ButtonGroup btnGroup2 = new ButtonGroup();
        btnGroup2.add(radioBtn201);
        btnGroup2.add(radioBtn202);
        btnGroup2.add(radioBtn203);
        btnGroup2.add(radioBtn204);
        btnGroup2.add(radioBtn205);
        // 设置第一个单选按钮选中
       // radioBtn201.setSelected(true);

        ButtonGroup btnGroup3 = new ButtonGroup();
        btnGroup3.add(radioBtn301);
        btnGroup3.add(radioBtn302);
        btnGroup3.add(radioBtn303);
        btnGroup3.add(radioBtn304);
        btnGroup3.add(radioBtn305);
        // 设置第一个单选按钮选中
       // radioBtn301.setSelected(true);

        /*输入部分--Center*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        lbIndicateur.setBounds(100, 50, 100, 20);
        lbI1.setBounds(100, 90, 350, 40);
        lbI2.setBounds(100, 150, 350, 20);
        lbI3.setBounds(100, 190, 350, 20);
        lbEvaluation.setBounds(500, 50, 100, 20);
        lbcomm.setBounds(100, 250, 100, 20);
        lbCommentaire.setBounds(100, 280, 600, 100);
        radioBtn101.setBounds(500,110,40,20);
        radioBtn102.setBounds(540,110,40,20);
        radioBtn103.setBounds(580,110,40,20);
        radioBtn104.setBounds(620,110,40,20);
        radioBtn105.setBounds(660,110,40,20);
        radioBtn201.setBounds(500,150,40,20);
        radioBtn202.setBounds(540,150,40,20);
        radioBtn203.setBounds(580,150,40,20);
        radioBtn204.setBounds(620,150,40,20);
        radioBtn205.setBounds(660,150,40,20);
        radioBtn301.setBounds(500,190,40,20);
        radioBtn302.setBounds(540,190,40,20);
        radioBtn303.setBounds(580,190,40,20);
        radioBtn304.setBounds(620,190,40,20);
        radioBtn305.setBounds(660,190,40,20);

        fieldPanel.add(lbIndicateur);
        fieldPanel.add(lbI1);
        fieldPanel.add(lbI2);
        fieldPanel.add(lbI3);
        fieldPanel.add(lbEvaluation);
        fieldPanel.add(lbcomm);
        fieldPanel.add(lbCommentaire);
        fieldPanel.add(radioBtn101);
        fieldPanel.add(radioBtn102);
        fieldPanel.add(radioBtn103);
        fieldPanel.add(radioBtn104);
        fieldPanel.add(radioBtn105);
        fieldPanel.add(radioBtn201);
        fieldPanel.add(radioBtn202);
        fieldPanel.add(radioBtn203);
        fieldPanel.add(radioBtn204);
        fieldPanel.add(radioBtn205);
        fieldPanel.add(radioBtn301);
        fieldPanel.add(radioBtn302);
        fieldPanel.add(radioBtn303);
        fieldPanel.add(radioBtn304);
        fieldPanel.add(radioBtn305);


        c.add(fieldPanel, "Center");

        /*按钮部分--South*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(okbtn);
        buttonPanel.add(cancelbtn);
        c.add(buttonPanel, "South");
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
