package Vue;

import Controler.ControlerInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Connecter {
    private JFrame jFrame = new JFrame("Connexion");
    private Container c = jFrame.getContentPane();
    private JLabel lbIMsgI = new JLabel();
    private JLabel lbUser = new JLabel("User Email");
    private JTextField username = new JTextField();
    private JLabel lbPass = new JLabel("Password");
    private JLabel logo = new JLabel(new ImageIcon("images/logo.png"));

    private JPasswordField password = new JPasswordField();
    private JButton okbtn = new JButton("Ok");
    private JButton cancelbtn = new JButton("Cancel");
    private JButton inscription = new JButton("Inscription");
    private JRadioButton radioBtn1 = new JRadioButton("Entreprise");
    private JRadioButton radioBtn2 = new JRadioButton("Intervenant");
    private JRadioButton radioBtn3 = new JRadioButton("Particulier");
    private int identifiant = 0;
    private ControlerInterface contoler=new ControlerInterface();
    private JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
    private URL resource = this.getClass().getResource("images/background2.jpg"); // 获取背景图片路径
    private ImageIcon icon = new ImageIcon("images/background2.jpg");//创建图片对象
    private Font font=new Font("Arial",Font.BOLD,36);
    private JLabel titre = new JLabel("Connexion");
    public Connecter() {
        //设置窗体的位置及大小


        titre.setFont(font);
        titre.setBounds(410,20,200,40);
        jFrame.setBounds(600, 200, 1000, 550);
        //设置一层相当于桌布的东西
        c.setLayout(new BorderLayout());//布局管理器
        //设置按下右上角X号后关闭
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setLocationRelativeTo(null);
        //初始化--往窗体里放其他控件
        init();
        //设置窗体可见
        jFrame.setVisible(true);
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public void init() {

        /*输入部分--Center*/
        ButtonGroup btnGroup1 = new ButtonGroup();
        btnGroup1.add(radioBtn1);
        btnGroup1.add(radioBtn3);
        btnGroup1.add(radioBtn2);

        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        lbUser.setBounds(360, 130, 80, 20);
        lbPass.setBounds(360, 170, 80, 20);
        fieldPanel.add(lbUser);
        fieldPanel.add(lbPass);
        fieldPanel.add(titre);

        okbtn.setBounds(360,280,100,20);
        cancelbtn.setBounds(460,280,100,20);
        inscription.setBounds(560,280,100,20);


        logo.setBounds(0,0,220,100);
        fieldPanel.add(logo);


        fieldPanel.add(okbtn);
        fieldPanel.add(cancelbtn);
        fieldPanel.add(inscription);

        username.setBounds(460, 130, 200, 20);
        password.setBounds(460, 170, 200, 20);
        fieldPanel.add(username);
        fieldPanel.add(password);
        radioBtn1.setBounds(360, 210, 100, 20);
        radioBtn2.setBounds(460, 210, 100, 20);
        radioBtn3.setBounds(560, 210, 100, 20);
        fieldPanel.add(radioBtn1);
        fieldPanel.add(radioBtn2);
        fieldPanel.add(radioBtn3);
        radioBtn1.setSelected(true);
        fieldPanel.add(lblBackground); // 将组件添加到面板中

        //设置标签的文字是红色
        lbIMsgI.setForeground(Color.RED);
        lbIMsgI.setBounds(500, 185, 180, 25);
        fieldPanel.add(lbIMsgI);

        c.add(fieldPanel, "Center");

        /*按钮部分--South*/
        /*JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(okbtn);
        buttonPanel.add(cancelbtn);
        buttonPanel.add(inscription);
        c.add(buttonPanel, "South");*/

        radioBtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "Entreprise":
                        identifiant = 0;
                        break;
                    case "Intervenant":
                        identifiant = 1;
                        break;
                    case "Particulier":
                        identifiant = 2;
                        break;
                }
            }
        });
        radioBtn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "Client":
                        identifiant = 0;
                        break;
                    case "Intervenant":
                        identifiant = 1;
                        break;
                    case "Particulier":
                        identifiant = 2;
                        break;
                }
            }
        });
        radioBtn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "Client":
                        identifiant = 0;
                        break;
                    case "Intervenant":
                        identifiant = 1;
                        break;
                    case "Particulier":
                        identifiant = 2;
                        break;
                }
            }
        });


        okbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == okbtn) {


                    String strPwd = new String(password.getPassword());
                    String strE = new String(username.getText());

                    switch (identifiant) {
                        case 0:

                           /* if (contoler.checkPasswordC(contoler.seekClient(strE), strPwd)) {*/
                                jFrame.setVisible(false);
                                ClientInterface cli = new ClientInterface();//contoler.seekClient(strE)
                                cli.getjFrame().setVisible(true);
                           /* } else {
                                lbIMsgI.setText("password is wrong");
                            }*/

                            break;
                        case 1:
                           /* if (contoler.checkPasswordI(contoler.seekIntervenant(strE), strPwd)) {*/
                                jFrame.setVisible(false);
                                RecommanderTache re = new RecommanderTache();//contoler.seekIntervenant(strE)
                                re.getjFrame().setVisible(true);
                           /* } else {
                                lbIMsgI.setText("password is wrong");
                            }*/

                            break;
                        case 2:
                            /*if (contoler.checkPasswordC(contoler.seekClient(strE), strPwd)) {*/
                                jFrame.setVisible(false);
                                ClientInterface pa = new ClientInterface();//contoler.seekClient(strE)
                                pa.getjFrame().setVisible(true);
                       /*     } else {
                                lbIMsgI.setText("password is wrong");
                            }*/

                            break;
                    }

                }
            }
        });

        cancelbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //清空所有文本信息
                username.setText("");
                password.setText("");

                //设置信息标签为空
                //lbIMsgC.setText("");

            }
        });

        inscription.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == inscription) {
                    switch (identifiant) {
                        case 0:
                            jFrame.setVisible(false);
                            EntrepriseInscription cli = new EntrepriseInscription();
                            cli.setVisible(true);
                            break;
                        case 1:
                            jFrame.setVisible(false);
                            IntervInscription i = new IntervInscription();
                            i.setVisible(true);
                            break;
                        case 2:
                            jFrame.setVisible(false);
                            ParticulierInscription p = new ParticulierInscription();
                            p.setVisible(true);

                            break;
                    }
                }
            }
        });


    }


}
