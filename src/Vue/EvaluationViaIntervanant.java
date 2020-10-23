package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.net.URL;
import java.util.ArrayList;

public class EvaluationViaIntervanant {

    private JFrame jFrame = new JFrame("Evaluation Via Intervenant");
    private Container c = jFrame.getContentPane();
    private String saveValue1 = null;
    private String saveValue2 = null;
    private String saveValue3 = null;
    private JLabel lbIndicateur = new JLabel("Indicateur");
    private JLabel lbEvaluation = new JLabel("Evaluation");
    private JLabel lbI1 = new JLabel("<html><body><p >correspondance entre la tache telle que decrite et<br/> la tache effectivement realisee</p></body></html> ");
    private JLabel lbI2 = new JLabel("rentabilite de la tache");
    private JLabel lbI3 = new JLabel("qualite d'echange entre client");
    private JLabel lbcomm = new JLabel("Commentaire");
    private JButton btnRetour = new JButton("Return");

    private JLabel lblBackground = new JLabel();
    private URL resource = this.getClass().getResource("images/background2.jpg");
    private ImageIcon icon = new ImageIcon("images/background2.jpg");
    private JTextField lbCommentaire = new JTextField(10);
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

    private RadioButtonListener1 radioButtonListener1 = new RadioButtonListener1();
    private RadioButtonListener2 radioButtonListener2 = new RadioButtonListener2();
    private RadioButtonListener3 radioButtonListener3 = new RadioButtonListener3();

    private JButton okbtn = new JButton("Ok");
    private JButton cancelbtn = new JButton("cancel");

    public EvaluationViaIntervanant() {
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
        titlePanel.add(new JLabel("Evaluation Interface Intervenant"));
        c.add(titlePanel, "North");

        lblBackground.setIcon(icon); 
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); 
        ButtonGroup btnGroup1 = new ButtonGroup();
        btnGroup1.add(radioBtn101);
        btnGroup1.add(radioBtn102);
        btnGroup1.add(radioBtn103);
        btnGroup1.add(radioBtn104);
        btnGroup1.add(radioBtn105);

        radioBtn101.addActionListener(radioButtonListener1);
        radioBtn102.addActionListener(radioButtonListener1);
        radioBtn103.addActionListener(radioButtonListener1);
        radioBtn104.addActionListener(radioButtonListener1);
        radioBtn105.addActionListener(radioButtonListener1);
        // radioBtn101.setSelected(true);

        ButtonGroup btnGroup2 = new ButtonGroup();
        btnGroup2.add(radioBtn201);
        btnGroup2.add(radioBtn202);
        btnGroup2.add(radioBtn203);
        btnGroup2.add(radioBtn204);
        btnGroup2.add(radioBtn205);


        radioBtn201.addActionListener(radioButtonListener2);
        radioBtn202.addActionListener(radioButtonListener2);
        radioBtn203.addActionListener(radioButtonListener2);
        radioBtn204.addActionListener(radioButtonListener2);
        radioBtn205.addActionListener(radioButtonListener2);
        // radioBtn201.setSelected(true);

        ButtonGroup btnGroup3 = new ButtonGroup();
        btnGroup3.add(radioBtn301);
        btnGroup3.add(radioBtn302);
        btnGroup3.add(radioBtn303);
        btnGroup3.add(radioBtn304);
        btnGroup3.add(radioBtn305);

        radioBtn301.addActionListener(radioButtonListener3);
        radioBtn302.addActionListener(radioButtonListener3);
        radioBtn303.addActionListener(radioButtonListener3);
        radioBtn304.addActionListener(radioButtonListener3);
        radioBtn305.addActionListener(radioButtonListener3);
        // radioBtn301.setSelected(true);

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        lbIndicateur.setBounds(100, 50, 100, 20);
        lbI1.setBounds(100, 90, 350, 40);
        lbI2.setBounds(100, 150, 350, 20);
        lbI3.setBounds(100, 190, 350, 20);
        lbEvaluation.setBounds(500, 50, 100, 20);
        lbcomm.setBounds(100, 250, 100, 20);
        lbCommentaire.setBounds(100, 280, 600, 100);
        radioBtn101.setBounds(500, 110, 40, 20);
        radioBtn102.setBounds(540, 110, 40, 20);
        radioBtn103.setBounds(580, 110, 40, 20);
        radioBtn104.setBounds(620, 110, 40, 20);
        radioBtn105.setBounds(660, 110, 40, 20);
        radioBtn201.setBounds(500, 150, 40, 20);
        radioBtn202.setBounds(540, 150, 40, 20);
        radioBtn203.setBounds(580, 150, 40, 20);
        radioBtn204.setBounds(620, 150, 40, 20);
        radioBtn205.setBounds(660, 150, 40, 20);
        radioBtn301.setBounds(500, 190, 40, 20);
        radioBtn302.setBounds(540, 190, 40, 20);
        radioBtn303.setBounds(580, 190, 40, 20);
        radioBtn304.setBounds(620, 190, 40, 20);
        radioBtn305.setBounds(660, 190, 40, 20);

        btnRetour.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                ConsulterTacheI cn = new ConsulterTacheI();
                cn.setVisible(true);

            }
        });

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
        fieldPanel.add(lblBackground);

        c.add(fieldPanel, "Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(okbtn);
        buttonPanel.add(cancelbtn);
        buttonPanel.add(btnRetour);
        c.add(buttonPanel, "South");

        okbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String note1 = saveValue1;
                String note2 = saveValue2;
                String note3 = saveValue3;
                String commentaire = lbCommentaire.getText();
            }
        });


        cancelbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lbCommentaire.setText("");

            }
        });


        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public class RadioButtonListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            JRadioButton temp = (JRadioButton) arg0.getSource();
            if (temp.isSelected()) {
                saveValue1 = temp.getText();
            }
        }

    }

    public class RadioButtonListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            JRadioButton temp = (JRadioButton) arg0.getSource();
            if (temp.isSelected()) {
                saveValue2 = temp.getText();
            }
        }

    }

    public class RadioButtonListener3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            JRadioButton temp = (JRadioButton) arg0.getSource();
            if (temp.isSelected()) {
                saveValue3 = temp.getText();
            }
        }

    }
}