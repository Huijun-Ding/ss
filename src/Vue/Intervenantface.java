
package Vue;

        import Controler.ControlerInterface;
        import Model.Client;
        import Model.Intervenant;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.net.URL;

public class Intervenantface {
    private JFrame jFrame = new JFrame("Connexion");
    private Container c = jFrame.getContentPane();
    private JButton consulterTache = new JButton("consulter mes taches");
    private JButton recommande = new JButton("mes taches recommandees");
    private Intervenant intervenant=null;
    private ControlerInterface controler;
    private JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
    private URL resource = this.getClass().getResource("images/background2.jpg"); // 获取背景图片路径
    private ImageIcon icon = new ImageIcon("images/background2.jpg");//创建图片对象
    private Font font=new Font("Arial",Font.BOLD,36);
    public Intervenantface(){
        // this.Intervenant=cl;Intervenant cl
        //设置窗体的位置及大小
        jFrame.setBounds(600, 200, 500, 280);
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
        JLabel titre =new JLabel("Intervenant");



        consulterTache.setBounds(20,100,200,50);
        recommande.setBounds(250,100,200,50);
        titre.setBounds(150,0,200,60);
        titre.setFont(font);


        p.setLayout(null);
        p.add(consulterTache);
        p.add(titre);
        p.add(recommande);
        p.add(lblBackground); // 将组件添加到面板中
        c.add(p, "Center");




        consulterTache.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转到 suivi tache
                jFrame.setVisible(false);
                ConsulterTacheI con = new ConsulterTacheI();//client
                con.setVisible(true);

            }
        });

        recommande.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == recommande){
                    jFrame.setVisible(false);
                    //主界面显示,如
                    RecommanderTache re = new RecommanderTache();//intervenant
                    re.getjFrame().setVisible(true);
                    //不正确,则提示错误信息
                }

            }
        });

    }


}

