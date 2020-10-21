package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//每次打开新建任务 先去数据库检测是否有记录

public class CreationTache {

    private JFrame jFrame = new JFrame("Evaluation Via Client");
    private Container c = jFrame.getContentPane();
    private JLabel lbNomTache = new JLabel("Nom de tache");
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

    private JButton okbtn = new JButton("Ok");
    private JButton sousbtn = new JButton("add Sous-tache");
    private JButton cancelbtn = new JButton("cancel");
    private JButton save = new JButton("save");
    String[] listData = new String[]{"Java", "Php", "C++", "Python"};

    final JComboBox<String> comboBox = new JComboBox<String>(listData);


    public CreationTache() {
        jFrame.setBounds(600, 200, 800, 500);
        c.setLayout(new BorderLayout());//布局管理器
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


        /*输入部分--Center*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        lbNomTache.setBounds(100, 50, 120, 20);
        lbDateD.setBounds(100, 90, 120, 20);
        lbDateF.setBounds(400, 90, 120, 20);
        lbPrix.setBounds(100, 130, 120, 20);
        lbNbP.setBounds(400, 130, 120, 20);
        lbDescrip.setBounds(100, 170, 120, 20);
        lbDomaine.setBounds(100,210,120,20);
        lbCompetence.setBounds(100,250,150,20);
        tfNomTache.setBounds(250,50,400,20);
        tfDateD.setBounds(250,90,120,20);
        tfDateF.setBounds(550,90,120,20);
        tfPrix.setBounds(250,130,120,20);
        tfNbP.setBounds(550,130,120,20);
        tfDescription.setBounds(250,170,120,20);
        tfCompe.setBounds(250,250,120,20);
        comboBox.setBounds(250,210,120,20);


        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("select: " + comboBox.getSelectedIndex() + " = " + comboBox.getSelectedItem());
                }
            }
        });

        // 设置默认选中的条目
        comboBox.setSelectedIndex(2);

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


        c.add(fieldPanel, "Center");

        /*按钮部分--South*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(okbtn);
        buttonPanel.add(save);
        buttonPanel.add(cancelbtn);
        buttonPanel.add(sousbtn);

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //enregistrer toutes les info dans BD

            }

        });



        sousbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == sousbtn){
                    //判断登录名或者密码是否正确
                    //如果正确则跳转
                    jFrame.setVisible(false);
                    //主界面显示,如
                    CreationTache sousFrame = new CreationTache();
                    sousFrame.getjFrame().setVisible(true);
                    //不正确,则提示错误信息
                }
            }

        });


        cancelbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //清空所有文本信息
                tfCompe.setText("");
                tfDateD.setText("");
                tfDateF.setText("");
                tfDescription.setText("");
                tfNbP.setText("");
                tfNomTache.setText("");
                tfPrix.setText("");

                //设置信息标签为空
                //lbIMsgC.setText("");

            }
        });

        c.add(buttonPanel, "South");
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}
