package Vue;

import Controler.ControlerInterface;
import Model.Intervenant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class IntervInscription extends JFrame {

    private ControlerInterface controler;
    //声明组件
    private JPanel p;
    private JLabel lbCBI,lbNameI, lbNumI, lbTelI, lbEmailI, lbCompetenceI, lbRueI, lbVilleI, lbCPI, lblPwdI, lbRePwdI, lbIMsgI;

    //声明文本框
    private JTextField txtNameI, txtNumI, txtTelI, txtEmailI, txtRueI, txtVilleI, txtCPI,txtCBI;
    //声明两个密码框
    private JPasswordField txtPwdI, txtRePwdI;
    //声明一个文本域

    private JButton btnRegI, btnCancelI;


    String[] listData = new String[]{"Java", "Php", "C++", "Python"};

    // 创建一个下拉列表框
    final JComboBox<String> comboBox = new JComboBox<String>(listData);

    public IntervInscription() {

        super("IntervInscription");
        //创建面板，面板布局为NULL
        p = new JPanel(null);

        // 添加条目选中状态改变的监听器
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("选中: " + comboBox.getSelectedIndex() + " = " + comboBox.getSelectedItem());
                }
            }
        });

        // 设置默认选中的条目
        comboBox.setSelectedIndex(2);
        //实例化5个标签
        lbNameI = new JLabel("Nom");
        lbCBI = new JLabel("Carde Bancaire");
        lbNumI = new JLabel("Prenom");
        lbTelI = new JLabel("Tele");
        lbEmailI = new JLabel("Email");
        lbRueI = new JLabel("Rue");
        lbVilleI = new JLabel("Ville");
        lbCPI = new JLabel("CodePostal");
        lblPwdI = new JLabel("password");
        lbRePwdI = new JLabel("check password");
        lbCompetenceI = new JLabel("competence");
        //显示信息的标签
        lbIMsgI = new JLabel();
        //设置标签的文字是红色
        lbIMsgI.setForeground(Color.RED);
        //创建一个长度为20 的文本框
        txtNameI = new JTextField(20);
        txtNumI = new JTextField(30);
        txtCBI = new JTextField(30);
        txtTelI = new JTextField(20);
        txtEmailI = new JTextField(20);
        txtRueI = new JTextField(20);
        txtVilleI = new JTextField(20);
        txtCPI = new JTextField(20);
        //创建两个密码框长度为20
        txtPwdI = new JPasswordField(20);
        txtRePwdI = new JPasswordField(20);
        //设置密码框显示的字符为*
        txtPwdI.setEchoChar('*');
        txtRePwdI.setEchoChar('*');
        //创建一个文本域  20,2

        //创建两个按钮
        btnRegI = new JButton("OK");
        btnCancelI = new JButton("Reset");
        btnRegI.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //设置信息标签为空 清楚原来的历史信息
                lbIMsgI.setText("");
                //获取用户输入的用户名
                String strName = txtNameI.getText();
                if (strName == null || strName.equals("")) {

                    lbIMsgI.setText("username is empty");
                    return;
                }
                //获取用户名密码
                String strPwd = new String(txtPwdI.getPassword());
                if (strPwd == null || strPwd.equals("")) {

                    lbIMsgI.setText("password is empty");
                    return;
                }
                String strRePwd = new String(txtRePwdI.getPassword());
                if (strRePwd == null || strRePwd.equals("")) {

                    lbIMsgI.setText("确认密码不能为空");
                    return;
                }

                //判断确认密码是否跟密码相同
                if (!strRePwd.equals(strPwd)) {

                    lbIMsgI.setText("确认密码跟密码不同");
                    return;
                }
                String tel=txtTelI.getText();
                String rue=txtRueI.getText();
                String ville=txtVilleI.getText();
                String cp=txtCPI.getText();
                String cb=txtCBI.getText();



                Intervenant in =new Intervenant(0, tel, rue,ville,cp, cb, 0) ;
               controler.putIntervInBD(in);
                lbIMsgI.setText("Successful");

            }
        });

        //取消按钮的事件处理
        btnCancelI.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //清空所有文本信息
                txtNameI.setText("");
                txtNumI.setText("");
                txtTelI.setText("");
                txtEmailI.setText("");
                txtRueI.setText("");
                txtVilleI.setText("");
                txtCPI.setText("");
                txtPwdI.setText("");
                txtRePwdI.setText("");
                txtCBI.setText("");

                //设置信息标签为空
                lbIMsgI.setText("");

            }
        });
        lbNameI.setBounds(30, 30, 120, 25);
        txtNameI.setBounds(160, 30, 120, 25);
        lbNumI.setBounds(30, 60, 120, 25);
        txtNumI.setBounds(160, 60, 120, 25);
        lbTelI.setBounds(30, 90, 120, 25);
        txtTelI.setBounds(160, 90, 120, 25);
        lbEmailI.setBounds(30, 120, 120, 25);
        txtEmailI.setBounds(160, 120, 120, 25);
        lbRueI.setBounds(30, 150, 120, 25);
        txtRueI.setBounds(160, 150, 120, 25);
        lbVilleI.setBounds(30, 180, 120, 25);
        txtVilleI.setBounds(160, 180, 120, 25);
        lbCPI.setBounds(30, 210, 120, 25);
        txtCPI.setBounds(160, 210, 120, 25);
        lblPwdI.setBounds(30, 240, 120, 25);
        txtPwdI.setBounds(160, 240, 120, 25);
        lbRePwdI.setBounds(30, 270, 120, 25);
        txtRePwdI.setBounds(160, 270, 120, 25);
        lbCompetenceI.setBounds(30, 300, 120, 25);
        lbIMsgI.setBounds(60, 185, 180, 25);
        btnRegI.setBounds(60, 380, 100, 25);
        btnCancelI.setBounds(170, 380, 100, 25);
        comboBox.setBounds(160,300,120,25);
        lbCBI.setBounds(30,330,120,25);
        txtCBI.setBounds(160,330,120,25);




        // 添加到内容面板
        p.add(comboBox);


        //添加所有组件
        p.add(lbNameI);
        p.add(txtNameI);
        p.add(lbNumI);
        p.add(txtNumI);
        p.add(lbTelI);
        p.add(txtTelI);
        p.add(lbEmailI);
        p.add(txtEmailI);
        p.add(lbRueI);
        p.add(txtRueI);
        p.add(lbVilleI);
        p.add(txtVilleI);
        p.add(lbCPI);
        p.add(txtCPI);
        p.add(txtPwdI);
        p.add(lblPwdI);
        p.add(txtRePwdI);
        p.add(lbRePwdI);
        p.add(lbCompetenceI);
        p.add(lbIMsgI);
        p.add(btnRegI);
        p.add(btnCancelI);
        p.add(lbCBI);
        p.add(txtCBI);



        this.add(p);
        this.setSize(350, 500);
        this.setLocationRelativeTo(null);//setLocation(200, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(p);
        this.setVisible(true);
    }
}
