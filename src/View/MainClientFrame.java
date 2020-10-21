/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author leonl
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainClientFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClientFrame frame = new MainClientFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainClientFrame() {
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		
		
		setTitle("Mon espace");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
                
                /**
                 *Menu classement:
                 * Mon profil
                 * Mes tâches 
                 *          création d'une tâche 
                 *          historiques 
                 * Log out
                 
                 **/
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
                //menue mon profil
		JMenu profil = new JMenu("Mon profil");
		profil.setIcon(new ImageIcon(MainClientFrame.class.getResource("/images/base.png")));
		menuBar.add(profil);
                
                //menue mes tâches 
		JMenu taches = new JMenu("Mes Tâches");
		//menu.setIcon(new ImageIcon(MainClientFrame.class.getResource("/images/base.png")));
		menuBar.add(taches);

                JMenu exit = new JMenu("Log out");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//µ¯³öÍË³öÈ·ÈÏÌáÊ¾¿ò
				int res=JOptionPane.showConfirmDialog(null, "È·¶¨ÒªÍË³öÂð£¿");
				//È·¶¨ÍË³ö
				if(res==JOptionPane.OK_OPTION){
					dispose();
				} 
				//·ñÔò¼ÌÐøÁôÔÚ¸Ã½çÃæ
			}
		});
		//exit.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit.png")));
		menuBar.add(exit);
		
                
                
                JMenu mnNewMenu = new JMenu("Creation une tache");
		//mnNewMenu.setIcon(new ImageIcon(MainClientFrame.class.getResource("/images/bookTypeManager.png")));
		taches.add(mnNewMenu);
                
                
		//Histroriques taches 
		JMenuItem menuItem = new JMenuItem("Historiques mes tache");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreationTacheView creantionTacheView=new CreationTacheView();
//				creantionTacheView.setVisible(true);
//				table.add(creantionTacheView);
			}
		});
                
//		menuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add.png")));
		taches.add(menuItem);
                
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
