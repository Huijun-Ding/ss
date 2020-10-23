package Vue;


import Controler.ControlerInterface;
import Model.Client;
import Model.Entreprise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


public class EntrepriseInscription extends JFrame {
    private ControlerInterface controler;
    private JFrame jFrame;
    private JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
    private URL resource = this.getClass().getResource("images/background2.jpg"); // 获取背景图片路径
    private ImageIcon icon = new ImageIcon("images/background2.jpg");//创建图片对象
    //声明组件
    private JPanel p;
    private JLabel lbNameC,lbNumC,lbTelC,lbEmailC,lbRueC,lbVilleC,lbCPC, lblPwdC, lbRePwdC, lbCB, lbIMsgC;

    //声明文本框
    private JTextField txtNameC,txtNumC,txtTelC,txtEmailC,txtRueC,txtVilleC,txtCPC,txtCB;
    //声明两个密码框
    private JPasswordField txtPwdC, txtRePwdC;

    private JButton btnRegC, btnCancelC,btnRetour;

    public EntrepriseInscription() {

        super("Inscription-Client");
        //创建面板，面板布局为NULL
        p = new JPanel(null);
        jFrame=this;
        //实例化5个标签
        lbNameC = new JLabel("RaisonSocial");
        lbNumC = new JLabel("NoSiret");
        lbTelC=new JLabel("Tele");
        lbEmailC=new JLabel("Email");
        lbRueC=new JLabel("Rue");
        lbVilleC=new JLabel("Ville");
        lbCPC=new JLabel("CodePostal");
        lblPwdC = new JLabel("password");
        lbRePwdC = new JLabel("check password");
        lbCB = new JLabel("Carde Bancaire");
        //显示信息的标签
        lbIMsgC = new JLabel();
        //设置标签的文字是红色
        lbIMsgC.setForeground(Color.RED);
        //创建一个长度为20 的文本框
        txtNameC = new JTextField(20);
        txtNumC = new JTextField(30);
        txtTelC = new JTextField(20);
        txtEmailC = new JTextField(20);
        txtRueC = new JTextField(20);
        txtVilleC = new JTextField(20);
        txtCPC = new JTextField(20);
        txtCB = new JTextField(20);
        //创建两个密码框长度为20
        txtPwdC = new JPasswordField(20);
        txtRePwdC = new JPasswordField(20);
        //设置密码框显示的字符为*
        txtPwdC.setEchoChar('*');
        txtRePwdC.setEchoChar('*');
        //创建两个按钮
        btnRegC = new JButton("OK");
        btnCancelC = new JButton("Reset");
        btnRetour = new JButton("Return");

        btnRegC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Définissez l'étiquette d'information pour qu'elle soit vide, effacez les informations historiques d'origine
                lbIMsgC.setText("");
                String siret=txtNumC.getText();
                int numc=Integer.parseInt(siret);
                //Obtenez le nom d'utilisateur saisi par l'utilisateur
                String strName = txtNameC.getText();
                if (strName == null || strName.equals("")) {

                    lbIMsgC.setText("username is empty");
                    return;
                }
                //Obtenez un nom d'utilisateur et un mot de passe
                String strPwd = new String(txtPwdC.getPassword());
                if (strPwd == null || strPwd.equals("")) {

                    lbIMsgC.setText("password is empty");
                    return;
                }
                String strRePwd = new String(txtRePwdC.getPassword());
                if (strRePwd == null || strRePwd.equals("")) {

                    lbIMsgC.setText("password is empty");
                    return;
                }

                //Déterminez si le mot de passe de confirmation est le même que le mot de passe
                if (!strRePwd.equals(strPwd)) {

                    lbIMsgC.setText("password is false");
                    return;
                }


                //email
                String email = new String(txtEmailC.getText());
                if (email == null || email.equals("")) {

                    lbIMsgC.setText("email is empty");
                    return;
                }

                //tel
                String tele = new String(txtTelC.getText());
                if (tele == null || tele.equals("")) {

                    lbIMsgC.setText("tele is empty");
                    return;
                }

                //rue
                String rue = new String(txtRueC.getText());
                if (rue == null || rue.equals("")) {

                    lbIMsgC.setText("rue is empty");
                    return;
                }



                String num = new String(txtNumC.getText());
                if (num == null || num.equals("")) {

                    lbIMsgC.setText("number is empty");
                    return;
                }
                String cb=txtCB.getText();
                String ville=txtVilleC.getText();
                String cp=txtCPC.getText();
                String domaine="java";
                String pre="Celine";
                String nom="Wang";


                Entreprise en =new Entreprise(strName, siret, nom, pre, domaine, tele, rue, ville, cp,cb,email,0f);
                controler.putEntrepInBD(en);
                lbIMsgC.setText("Successful");

            }
        });
        btnRetour.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                Connecter cn = new Connecter();
                cn.getjFrame().setVisible(true);


            }
        });

        //Gestion des événements du bouton d'annulation
        btnCancelC.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //清空所有文本信息
                txtNameC.setText("");
                txtNumC.setText("");
                txtTelC.setText("");
                txtEmailC.setText("");
                txtRueC.setText("");
                txtVilleC.setText("");
                txtCPC.setText("");
                txtPwdC.setText("");
                txtRePwdC.setText("");
                txtCB.setText("");

                lbIMsgC.setText("");

            }
        });
        lbNameC.setBounds(80, 30, 120, 25);
        txtNameC.setBounds(205, 30, 120, 25);
        lbNumC.setBounds(80, 60, 120, 25);
        txtNumC.setBounds(205, 60, 120, 25);
        lbTelC.setBounds(80, 90, 120, 25);
        txtTelC.setBounds(205, 90, 120, 25);
        lbEmailC.setBounds(80, 120, 120, 25);
        txtEmailC.setBounds(205, 120, 120, 25);
        lbRueC.setBounds(80, 150, 120, 25);
        txtRueC.setBounds(205, 150, 120, 25);
        lbVilleC.setBounds(80, 180, 120, 25);
        txtVilleC.setBounds(205, 180, 120, 25);
        lbCPC.setBounds(80, 210, 120, 25);
        txtCPC.setBounds(205, 210, 120, 25);
        lbCB.setBounds(80, 240, 120, 25);
        txtCB.setBounds(205, 240, 120, 25);
        lblPwdC.setBounds(80, 270, 120, 25);
        txtPwdC.setBounds(205, 270, 120, 25);
        lbRePwdC.setBounds(80, 300, 120, 25);
        txtRePwdC.setBounds(205, 300, 120, 25);
        lbIMsgC.setBounds(80, 185, 180, 25);
        btnRegC.setBounds(30, 380, 100, 25);
        btnCancelC.setBounds(170, 380, 100, 25);
        btnRetour.setBounds(310, 380, 100, 25);

        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小


        //Ajouter tous les composants
        p.add(lbNameC);
        p.add(txtNameC);
        p.add(lbNumC);
        p.add(txtNumC);
        p.add(lbTelC);
        p.add(txtTelC);
        p.add(lbEmailC);
        p.add(txtEmailC);
        p.add(lbRueC);
        p.add(txtRueC);
        p.add(lbVilleC);
        p.add(txtVilleC);
        p.add(lbCPC);
        p.add(txtCPC);
        p.add(txtPwdC);
        p.add(lblPwdC);
        p.add(txtRePwdC);
        p.add(lbRePwdC);
        p.add(txtCB);
        p.add(lbCB);
        p.add(lbIMsgC);
        p.add(btnRegC);
        p.add(btnCancelC);
        p.add(btnRetour);
        p.add(lblBackground);

        this.add(p);
        this.setSize(500, 450);
        this.setLocation(200, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public JFrame getjFrame() {
        return jFrame;
    }
}
