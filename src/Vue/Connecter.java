package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Connecter {
    private JFrame jFrame = new JFrame("Connexion");
    private Container c = jFrame.getContentPane();
    private JLabel lbUser = new JLabel("UserName");
    private JTextField username = new JTextField();
    private JLabel lbPass = new JLabel("Password");
    private JPasswordField password = new JPasswordField();
    private JButton okbtn = new JButton("Ok");
    private JButton cancelbtn = new JButton("Cancel");
    private JRadioButton radioBtn1 = new JRadioButton("Client");
    private JRadioButton radioBtn2 = new JRadioButton("Intervenant");
    private int identifiant=0;

    public Connecter() {
        //设置窗体的位置及大小
        jFrame.setBounds(600, 200, 400, 280);
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

    public void init() {
        /*标题部分--North*/
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("Client/Intervenant"));
        c.add(titlePanel, "North");



        /*输入部分--Center*/
        ButtonGroup btnGroup1 = new ButtonGroup();
        btnGroup1.add(radioBtn1);
        btnGroup1.add(radioBtn2);


        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        lbUser.setBounds(100, 50, 80, 20);
        lbPass.setBounds(100, 90, 80, 20);
        fieldPanel.add(lbUser);
        fieldPanel.add(lbPass);
        username.setBounds(190, 50, 120, 20);
        password.setBounds(190, 90, 120, 20);
        fieldPanel.add(username);
        fieldPanel.add(password);
        radioBtn1.setBounds(100,130,100,20);
        radioBtn2.setBounds(200,130,100,20);
        fieldPanel.add(radioBtn1);
        fieldPanel.add(radioBtn2);
        radioBtn1.setSelected(true);


        c.add(fieldPanel, "Center");

        /*按钮部分--South*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(okbtn);
        buttonPanel.add(cancelbtn);
        c.add(buttonPanel, "South");

        radioBtn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                switch (e.getActionCommand()){
                    case "Client":
                        identifiant=0;
                        break;
                    case "Intervenant":
                        identifiant=1;
                        break;
                }
            }
        });
        radioBtn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                switch (e.getActionCommand()){
                    case "Client":
                        identifiant=0;
                        break;
                    case "Intervenant":
                        identifiant=1;
                        break;
                }
            }
        });




        okbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == okbtn){
                    jFrame.setVisible(false);
                    switch (identifiant){
                        case 0:
                            ClientInterface cli = new ClientInterface();
                            cli.getjFrame().setVisible(true);
                            break;
                        case 1:
                            RecommanderTache re = new RecommanderTache();
                            re.getjFrame().setVisible(true);
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
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Client":
                identifiant=0;
                break;
            case "Intervenant":
                identifiant=1;
                break;
        }
    }



}
