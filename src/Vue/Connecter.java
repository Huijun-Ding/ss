package Vue;

import javax.swing.*;
import java.awt.*;

public class Connecter {
    private JFrame jFrame = new JFrame("Connexion");
    private Container c = jFrame.getContentPane();
    private JLabel lbUser = new JLabel("UserName");
    private JTextField username = new JTextField();
    private JLabel lbPass = new JLabel("Password");
    private JPasswordField password = new JPasswordField();
    private JButton okbtn = new JButton("Ok");
    private JButton cancelbtn = new JButton("Cancel");

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
        c.add(fieldPanel, "Center");

        /*按钮部分--South*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(okbtn);
        buttonPanel.add(cancelbtn);
        c.add(buttonPanel, "South");
    }
}
