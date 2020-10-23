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
    private JLabel lblBackground = new JLabel();
    private URL resource = this.getClass().getResource("images/background2.jpg"); // obtenir le path de l'image
    private ImageIcon icon = new ImageIcon("images/background2.jpg");//creer un objet d'image
    private Font font=new Font("Arial",Font.BOLD,36);
    private JButton btnRetour = new JButton("Return");
    public ClientInterface(){
       // this.client=cl;Client cl

        jFrame.setBounds(600, 200, 400, 280);

        c.setLayout(new BorderLayout());//gestion de mise en page
        //terminer la programmation
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lblBackground.setIcon(icon); // les icone vont afficher
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());


        jFrame.setLocationRelativeTo(null);
        //initialiser-complir la frame
        init();
        //visibilite de la frame
        jFrame.setVisible(true);
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public void init() {


        JPanel p = new JPanel();
        JLabel titre =new JLabel("Client");

        lblBackground.setIcon(icon); // l'image a affecher
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

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
        p.add(lblBackground); // ajouter les composantes
        c.add(p, "Center");




        consulterTache.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //sauter au sconsuler mes taches
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

                    CreationTache cre = new CreationTache();//client
                    cre.getjFrame().setVisible(true);

                }

            }
        });

    }


}
