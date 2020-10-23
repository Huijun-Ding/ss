package Vue;

import Controler.ControlerInterface;
import Model.Intervenant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

public class IntervInscription extends JFrame {
    private JLabel lblBackground = new JLabel();
    private URL resource = this.getClass().getResource("images/background2.jpg");
    private ImageIcon icon = new ImageIcon("images/background2.jpg");

    private Font font=new Font("Arial",Font.BOLD,36);
    private JLabel titre = new JLabel("Connexion");

    private ControlerInterface controler;
    //声明组件
    private JFrame jFrame;
    private JPanel p;
    private JLabel lbCBI, lbNameI, lbNumI, lbTelI, lbEmailI, lbCompetenceI, lbRueI, lbVilleI, lbCPI, lblPwdI, lbRePwdI, lbIMsgI;

    //声明文本框
    private JTextField txtNameI, txtNumI, txtTelI, txtEmailI, txtRueI, txtVilleI, txtCPI, txtCBI;
    //声明两个密码框
    private JPasswordField txtPwdI, txtRePwdI;
    //声明一个文本域

    private JButton btnRegI, btnCancelI,btnRetour;


    String[] listData = new String[]{"Java", "Php", "C++", "Python"};

    // 创建一个下拉列表框
    final JComboBox<String> comboBox = new JComboBox<String>(listData);

    public IntervInscription() {

        super("IntervInscription");
        //创建面板，面板布局为NULL
        p = new JPanel(null);
        ControlerInterface controler = new ControlerInterface();
        lblBackground.setIcon(icon);
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小
        jFrame=this;

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("选中: " + comboBox.getSelectedIndex() + " = " + comboBox.getSelectedItem());
                }
            }
        });


        comboBox.setSelectedIndex(2);

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

        lbIMsgI = new JLabel();

        lbIMsgI.setForeground(Color.RED);

        txtNameI = new JTextField(20);
        txtNumI = new JTextField(30);
        txtCBI = new JTextField(30);
        txtTelI = new JTextField(20);
        txtEmailI = new JTextField(20);
        txtRueI = new JTextField(20);
        txtVilleI = new JTextField(20);
        txtCPI = new JTextField(20);

        txtPwdI = new JPasswordField(20);
        txtRePwdI = new JPasswordField(20);

        txtPwdI.setEchoChar('*');
        txtRePwdI.setEchoChar('*');
        btnRegI = new JButton("OK");
        btnCancelI = new JButton("Reset");
        btnRetour = new JButton("Return");
        btnRegI.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                lbIMsgI.setText("");

                String strName = txtNameI.getText();
                System.out.println(strName);
                if (strName == null || strName.equals("")) {

                    lbIMsgI.setText("username is empty");
                    return;
                }

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


                if (!strRePwd.equals(strPwd)) {

                    lbIMsgI.setText("确认密码跟密码不同");
                    return;
                }

                String email = txtEmailI.getText();
                String nom = txtNameI.getText();
                String prenom = txtNumI.getText();
                String tel = txtTelI.getText();
                String rue = txtRueI.getText();
                String ville = txtVilleI.getText();
                String cp = txtCPI.getText();
                String cb = txtCBI.getText();
                String mdp = strPwd;
                System.out.println(strPwd);
                System.out.println("m emal"+email);
                System.out.println("m tel"+tel);
                Intervenant in = new Intervenant();
                in.setEmail(email);
                in.setNomInterv(nom);
                in.setPrenomInterv(prenom);
                in.setTelInterv(tel);
                in.setRueInterv(rue);
                in.setVilleInterv(ville);
                in.setCodePostalIn(cp);
                in.setCarteBancaireIn(cb);
                in.setMotdepasseI(mdp);

                controler.putIntervInBD(in);
                lbIMsgI.setText("Successful");

            }
        });


        btnCancelI.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

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


                lbIMsgI.setText("");

            }
        });

        btnRetour.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                Connecter cn = new Connecter();
                cn.getjFrame().setVisible(true);

                lbIMsgI.setText("");

            }
        });
        lbNameI.setBounds(80, 30, 120, 25);
        txtNameI.setBounds(210, 30, 120, 25);
        lbNumI.setBounds(80, 60, 120, 25);
        txtNumI.setBounds(210, 60, 120, 25);
        lbTelI.setBounds(80, 90, 120, 25);
        txtTelI.setBounds(210, 90, 120, 25);
        lbEmailI.setBounds(80, 120, 120, 25);
        txtEmailI.setBounds(210, 120, 120, 25);
        lbRueI.setBounds(80, 150, 120, 25);
        txtRueI.setBounds(210, 150, 120, 25);
        lbVilleI.setBounds(80, 180, 120, 25);
        txtVilleI.setBounds(210, 180, 120, 25);
        lbCPI.setBounds(80, 210, 120, 25);
        txtCPI.setBounds(210, 210, 120, 25);
        lblPwdI.setBounds(80, 240, 120, 25);
        txtPwdI.setBounds(210, 240, 120, 25);
        lbRePwdI.setBounds(80, 270, 120, 25);
        txtRePwdI.setBounds(210, 270, 120, 25);
        lbCompetenceI.setBounds(80, 300, 120, 25);
        lbIMsgI.setBounds(60, 185, 180, 25);
        btnRegI.setBounds(60, 380, 100, 25);
        btnCancelI.setBounds(170, 380, 100, 25);
        btnRetour.setBounds(280, 380, 100, 25);
        comboBox.setBounds(210,300,120,25);
        lbCBI.setBounds(80,330,120,25);
        txtCBI.setBounds(210,330,120,25);



        p.add(comboBox);



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
        p.add(btnRetour);
        p.add(lbCBI);
        p.add(txtCBI);
        p.add(lblBackground);



        this.add(p);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);//setLocation(200, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(p);
        this.setVisible(true);
    }
}
