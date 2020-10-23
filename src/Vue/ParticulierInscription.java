package Vue;

import Controler.ControlerInterface;
import Model.Particulier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ParticulierInscription extends JFrame {
    private ControlerInterface controler;
    private String civilite;
    private JFrame jFrame;
    private JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
    private URL resource = this.getClass().getResource("images/background2.jpg"); // 获取背景图片路径
    private ImageIcon icon = new ImageIcon("images/background2.jpg");//创建图片对象


    //声明组件
    private JPanel p;
    private JLabel lbNameC, lbNumC, lbTelC, lbEmailC, lbRueC, lbVilleC, lbCPC, lblPwdC, lbRePwdC, lbCB, lbIMsgC;

    //声明文本框
    private JTextField txtNameC, txtNumC, txtTelC, txtEmailC, txtRueC, txtVilleC, txtCPC, txtCB;
    //声明两个密码框
    private JPasswordField txtPwdC, txtRePwdC;

    private JButton btnRegC, btnCancelC,btnRetour;

    private JRadioButton radioBtn1 = new JRadioButton("Madame");
    private JRadioButton radioBtn2 = new JRadioButton("Monsieur");

    public ParticulierInscription() {

        super("Inscription-Client");
        //创建面板，面板布局为NULL
        p = new JPanel(null);
        jFrame=this;
        //实例化5个标签
        lbNameC = new JLabel("Prenom");
        lbNumC = new JLabel("Nom");
        lbTelC = new JLabel("Tele");
        lbEmailC = new JLabel("Email");
        lbRueC = new JLabel("Rue");
        lbVilleC = new JLabel("Ville");
        lbCPC = new JLabel("CodePostal");
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
        ButtonGroup btnGroup1 = new ButtonGroup();
        btnGroup1.add(radioBtn1);
        btnGroup1.add(radioBtn2);

        radioBtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "Madame":
                        civilite = "Madame";
                        break;
                    case "Monsieur":
                        civilite = "Monsieur";
                        break;
                }
            }
        });

        radioBtn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "Madame":
                        civilite = "Madame";
                        break;
                    case "Monsieur":
                        civilite = "Monsieur";
                        break;
                }
            }
        });


        btnRegC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Définissez l'étiquette d'information pour qu'elle soit vide, effacez les informations historiques d'origine
                lbIMsgC.setText("");
                String nom = txtNumC.getText();
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


                //获取用户nom
                String num = new String(txtNumC.getText());
                if (num == null || num.equals("")) {

                    lbIMsgC.setText("number is empty");
                    return;
                }
                String cb = txtCB.getText();
                String ville = txtVilleC.getText();
                String cp = txtCPC.getText();


                Particulier pa = new Particulier(0, tele, rue, ville, cp, cb, 0f,  nom, strName,  civilite);
                    controler.putPartiInBD(pa);
                lbIMsgC.setText("Successful");

            }
        });
        btnRetour.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                Connecter cn = new Connecter();
                cn.getjFrame().setVisible(true);
                //设置信息标签为空
                //lbIMsgI.setText("");

            }
        });

        //Gestion des événements du bouton d'annulation
        btnCancelC.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Effacer tous les messages texte
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
                //Définir l'étiquette d'information sur vide
                lbIMsgC.setText("");

            }
        });
        lbNameC.setBounds(60, 30, 120, 25);
        txtNameC.setBounds(185, 30, 120, 25);
        lbNumC.setBounds(60, 60, 120, 25);
        txtNumC.setBounds(185, 60, 120, 25);
        radioBtn1.setBounds(70, 90, 80, 20);
        radioBtn2.setBounds(210, 90, 80, 20);
        lbTelC.setBounds(60, 120, 120, 25);
        txtTelC.setBounds(185, 120, 120, 25);
        lbEmailC.setBounds(60, 150, 120, 25);
        txtEmailC.setBounds(185, 150, 120, 25);
        lbRueC.setBounds(60, 180, 120, 25);
        txtRueC.setBounds(185, 180, 120, 25);
        lbVilleC.setBounds(60, 210, 120, 25);
        txtVilleC.setBounds(185, 210, 120, 25);
        lbCPC.setBounds(60, 240, 120, 25);
        txtCPC.setBounds(185, 240, 120, 25);
        lbCB.setBounds(60, 270, 120, 25);
        txtCB.setBounds(185, 270, 120, 25);
        lblPwdC.setBounds(60, 300, 120, 25);
        txtPwdC.setBounds(185, 300, 120, 25);
        lbRePwdC.setBounds(60, 330, 120, 25);
        txtRePwdC.setBounds(185, 330, 120, 25);
        lbIMsgC.setBounds(90, 185, 180, 25);
        btnRegC.setBounds(30, 380, 100, 25);
        btnCancelC.setBounds(170, 380, 100, 25);
        btnRetour.setBounds(310, 380, 100, 25);

        lblBackground.setIcon(icon); // Définit l'icône à afficher par le composant d'étiquette
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // Définit la position d'affichage et la taille du composant

        //添加所有组件
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
        p.add(radioBtn1);
        p.add(radioBtn2);
        p.add(lblBackground); // ajoute le composant au panneau

        this.add(p);
        this.setSize(450, 450);
        this.setLocation(200, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JFrame getjFrame() {
        return jFrame;
    }
}

