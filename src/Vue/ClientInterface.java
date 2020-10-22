package Vue;

import Controler.ControlerInterface;
import Model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientInterface {
    private JFrame jFrame = new JFrame("Connexion");
    private Container c = jFrame.getContentPane();
    private JButton consulterTache = new JButton("consulter mes taches");
    private JButton creerTache = new JButton("creer une tache");
    private Client client=null;
    private ControlerInterface controler;

    public ClientInterface(Client cl){
        this.client=cl;
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

    public JFrame getjFrame() {
        return jFrame;
    }

    public void init() {
        /*标题部分--North*/
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("Client"));
        c.add(titlePanel, "North");



        /*按钮部分--South*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(consulterTache);
        buttonPanel.add(creerTache);
        c.add(buttonPanel, "South");


        consulterTache.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转到 suivi tache
                jFrame.setVisible(false);
                ConsulterTacheC con = new ConsulterTacheC(client);
                con.getjFrame().setVisible(true);

            }
        });

        creerTache.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == creerTache){
                    jFrame.setVisible(false);
                    //主界面显示,如
                    CreationTache cre = new CreationTache(client);
                    cre.getjFrame().setVisible(true);
                    //不正确,则提示错误信息
                }

            }
        });

    }


}
