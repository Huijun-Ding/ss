package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluationViaClient {

    private String saveValue1=null;
    private String saveValue2=null;
    private JFrame jFrame = new JFrame("Evaluation Via Client");
    private Container c = jFrame.getContentPane();
    private JLabel lbIndicateur = new JLabel("Indicateur");
    private JLabel lbEvaluation = new JLabel("Evaluation");
    private JLabel lbI1 = new JLabel("qualite de la realisation");
    private JLabel lbI2 = new JLabel("delais du tavail");
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


    private JButton okbtn = new JButton("Ok");
    private JButton cancelbtn = new JButton("cancel");
    private RadioButtonListener1 radioButtonListener1=new RadioButtonListener1();
    private RadioButtonListener2 radioButtonListener2=new RadioButtonListener2();

    public EvaluationViaClient() {
        jFrame.setBounds(600, 200, 800, 500);
        c.setLayout(new BorderLayout());//布局管理器
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        jFrame.setVisible(true);
    }

    public void init() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("Evaluation Interface Client"));
        c.add(titlePanel, "North");

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

        /*输入部分--Center*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        lbIndicateur.setBounds(100, 50, 100, 20);
        lbI1.setBounds(100, 90, 350, 40);
        lbI2.setBounds(100, 150, 350, 20);
        lbEvaluation.setBounds(500, 50, 100, 20);
        lbcomm.setBounds(100, 250, 100, 20);
        lbCommentaire.setBounds(100, 280, 600, 100);
        radioBtn101.setBounds(500,90,40,20);
        radioBtn102.setBounds(540,90,40,20);
        radioBtn103.setBounds(580,90,40,20);
        radioBtn104.setBounds(620,90,40,20);
        radioBtn105.setBounds(660,90,40,20);
        radioBtn201.setBounds(500,150,40,20);
        radioBtn202.setBounds(540,150,40,20);
        radioBtn203.setBounds(580,150,40,20);
        radioBtn204.setBounds(620,150,40,20);
        radioBtn205.setBounds(660,150,40,20);


        fieldPanel.add(lbIndicateur);
        fieldPanel.add(lbI1);
        fieldPanel.add(lbI2);

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
                String note1 =saveValue1;
                String note2 =saveValue2;
                String commentaire=lbCommentaire.getText();

                //实例化一个evaluation 并存到BD中


            }
        });





        cancelbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //清空所有文本信息
                lbCommentaire.setText("");

            }
        });

        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public class RadioButtonListener1 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            JRadioButton temp=(JRadioButton)arg0.getSource();
            if(temp.isSelected()){
                saveValue1=temp.getText();
            }
        }

    }
    public class RadioButtonListener2 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            JRadioButton temp=(JRadioButton)arg0.getSource();
            if(temp.isSelected()){
                saveValue2=temp.getText();
            }
        }

    }
}
