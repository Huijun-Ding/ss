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
    private JFrame jFrame = new JFrame("Intervenant");
    private Container c = jFrame.getContentPane();
    private JButton consulterTache = new JButton("consulter mes taches");
    private JButton recommande = new JButton("mes taches recommandees");
    private Intervenant intervenant;
    private ControlerInterface controler;
    private JLabel lblBackground = new JLabel(); 
    private URL resource = this.getClass().getResource("images/background2.jpg"); 
    private ImageIcon icon = new ImageIcon("images/background2.jpg");
    private Font font=new Font("Arial",Font.BOLD,36);
    private JButton btnRetour = new JButton("Return");
    public Intervenantface(Intervenant in){
        this.intervenant=in;        
        controler = new ControlerInterface();
        jFrame.setBounds(600, 200, 500, 280);
        c.setLayout(new BorderLayout());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lblBackground.setIcon(icon); 
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());


        jFrame.setLocationRelativeTo(null);

        init();

        jFrame.setVisible(true);
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public void init() {

        JPanel p = new JPanel();
        JLabel titre =new JLabel("Intervenant");

        consulterTache.setBounds(20,100,200,50);
        recommande.setBounds(250,100,200,50);
        titre.setBounds(150,0,200,60);
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
        p.add(recommande);
        p.add(lblBackground); 
        c.add(p, "Center");

        consulterTache.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
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
                    RecommanderTache re = new RecommanderTache();//intervenant
                    re.getjFrame().setVisible(true);
                }

            }
        });

    }


}