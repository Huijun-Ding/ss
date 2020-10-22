package Vue;

import Controler.ControlerInterface;
import Model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ClientInterface {
    private JFrame jFrame = new JFrame("Client");

    private Container c = jFrame.getContentPane();
    private JButton consulterTache = new JButton("consulter mes taches");
    private JButton creerTache = new JButton("creer une tache");
    private Client client=null;
    private ControlerInterface controler;
    private JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
    private URL resource = this.getClass().getResource("images/background2.jpg"); // 获取背景图片路径
    private ImageIcon icon = new ImageIcon("images/background2.jpg");//创建图片对象
    private Font font=new Font("Arial",Font.BOLD,36);
    private JButton btnRetour = new JButton("Return");
    public ClientInterface(){
       // this.client=cl;Client cl
        //设置窗体的位置及大小
        jFrame.setBounds(600, 200, 400, 280);
        //设置一层相当于桌布的东西
        c.setLayout(new BorderLayout());//布局管理器
        //设置按下右上角X号后关闭
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小


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
        /*标题部分--North*/

        JPanel p = new JPanel();
        JLabel titre =new JLabel("Client");

        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小

        consulterTache.setBounds(20,100,170,50);
        creerTache.setBounds(200,100,170,50);
        titre.setBounds(150,0,100,60);
        titre.setFont(font);

        btnRetour.setBounds(280, 200, 100, 25);
        btnRetour.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                Connecter cn = new Connecter();
                cn.getjFrame().setVisible(true);


            }
        });
        p.add(btnRetour);
        p.setLayout(null);
        p.add(consulterTache);
        p.add(titre);
        p.add(creerTache);
        p.add(lblBackground); // 将组件添加到面板中
        c.add(p, "Center");




        consulterTache.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转到 suivi tache
                jFrame.setVisible(false);
                ConsulterTacheC con = new ConsulterTacheC();//client
                con.setVisible(true);

            }
        });

        creerTache.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == creerTache){
                    jFrame.setVisible(false);
                    //主界面显示,如
                    CreationTache cre = new CreationTache();//client
                    cre.getjFrame().setVisible(true);
                    //不正确,则提示错误信息
                }

            }
        });

    }


}
