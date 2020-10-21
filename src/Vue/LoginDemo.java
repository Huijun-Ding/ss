package Vue;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  LoginDemo extends JFrame {

    //声明组件
    private JPanel p;
    private JLabel lbNameC,lbNumC,lbTelC,lbEmailC,lbRueC,lbVilleC,lbCPC, lblPwdC, lbRePwdC, lbAddressC, lbIMsgC;

    //声明文本框
    private JTextField txtNameC,txtNumC,txtTelC,txtEmailC,txtRueC,txtVilleC,txtCPC;
    //声明两个密码框
    private JPasswordField txtPwdC, txtRePwdC;
    //声明一个文本域
    private JTextArea txtAddressC;
    private JButton btnRegC, btnCancelC;

    public LoginDemo() {

        super("Inscription-Client");
        //创建面板，面板布局为NULL
        p = new JPanel(null);
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
        lbAddressC = new JLabel("addresse");
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
        //创建两个密码框长度为20
        txtPwdC = new JPasswordField(20);
        txtRePwdC = new JPasswordField(20);
        //设置密码框显示的字符为*
        txtPwdC.setEchoChar('*');
        txtRePwdC.setEchoChar('*');
        //创建一个文本域  20,2
        txtAddressC = new JTextArea(20, 2);
        //创建两个按钮
        btnRegC = new JButton("OK");
        btnCancelC = new JButton("Reset");
        btnRegC.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //设置信息标签为空 清楚原来的历史信息
                lbIMsgC.setText("");
                //获取用户输入的用户名
                String strName = txtNameC.getText();
                if (strName == null || strName.equals("")) {

                    lbIMsgC.setText("username is empty");
                    return;
                }
                //获取用户名密码
                String strPwd = new String(txtPwdC.getPassword());
                if (strPwd == null || strPwd.equals("")) {

                    lbIMsgC.setText("password is empty");
                    return;
                }
                String strRePwd = new String(txtRePwdC.getPassword());
                if (strRePwd == null || strRePwd.equals("")) {

                    lbIMsgC.setText("确认密码不能为空");
                    return;
                }

                //判断确认密码是否跟密码相同
                if (!strRePwd.equals(strPwd)) {

                    lbIMsgC.setText("确认密码跟密码不同");
                    return;
                }


                //获取用户地址
                String strAddress = new String(txtAddressC.getText());
                if (strAddress == null || strAddress.equals("")) {

                    lbIMsgC.setText("地址不能为空");
                    return;
                }
                lbIMsgC.setText("Successful");

            }
        });

        //取消按钮的事件处理
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
                txtAddressC.setText("");
                //设置信息标签为空
                lbIMsgC.setText("");

            }
        });
        lbNameC.setBounds(30, 30, 60, 25);
        txtNameC.setBounds(95, 30, 120, 25);
        lbNumC.setBounds(30, 60, 60, 25);
        txtNumC.setBounds(95, 60, 120, 25);
        lbTelC.setBounds(30, 90, 60, 25);
        txtTelC.setBounds(95, 90, 120, 25);
        lbEmailC.setBounds(30, 120, 60, 25);
        txtEmailC.setBounds(95, 120, 120, 25);
        lbRueC.setBounds(30, 150, 60, 25);
        txtRueC.setBounds(95, 150, 120, 25);
        lbVilleC.setBounds(30, 180, 60, 25);
        txtVilleC.setBounds(95, 180, 120, 25);
        lbCPC.setBounds(30, 210, 60, 25);
        txtCPC.setBounds(95, 210, 120, 25);
        lblPwdC.setBounds(30, 240, 60, 25);
        txtPwdC.setBounds(95, 240, 120, 25);
        lbRePwdC.setBounds(30, 270, 60, 25);
        txtRePwdC.setBounds(95, 270, 120, 25);
        lbAddressC.setBounds(30, 300, 60, 25);
        txtAddressC.setBounds(95, 300, 120, 25);
        lbIMsgC.setBounds(60, 185, 180, 25);
        btnRegC.setBounds(60, 350, 100, 25);
        btnCancelC.setBounds(170, 350, 100, 25);

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
        p.add(txtAddressC);
        p.add(lbAddressC);
        p.add(lbIMsgC);
        p.add(btnRegC);
        p.add(btnCancelC);

        this.add(p);
        this.setSize(350, 450);
        this.setLocation(200, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
