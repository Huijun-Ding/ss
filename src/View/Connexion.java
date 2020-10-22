package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Dao.BDvdClientDao;
import Model.Client;
import BD.DB;

public class Connexion extends JFrame {

	private JPanel contentPane;
	private JTextField usernameText;
	private JPasswordField passwordText;
	private JButton loginBtn;
	private JButton resetBtn;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion();
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
	public Connexion() {
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		//setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images/logo.png")));
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("ËÎÌå", Font.BOLD, 22));
		//lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/logo.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D :");
		//lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/userName.png")));
		
		usernameText = new JTextField();
		usernameText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801 :");
		//lblNewLabel_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/password.png")));
		
		passwordText = new JPasswordField();
		
		//Ìí¼ÓµÇÂ½°´Å¥
		loginBtn = new JButton("\u767B\u5F55");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		//loginBtn.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/login.png")));
		
		//Ìí¼ÓÖØÖÃ°´Å¥
		resetBtn = new JButton("\u91CD\u7F6E");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		
		//resetBtn.setIcon(new ImageIcon(Connexion.class.getResource("/images/reset.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(106)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(usernameText, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGap(16)
									.addComponent(loginBtn)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(resetBtn)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(105, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginBtn)
						.addComponent(resetBtn))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		//ÉèÖÃ´°¿Ú¾ÓÖÐ
		this.setLocationRelativeTo(null);
	}
	/**
	 * µÇÂ¼ÊÂ¼þ´¦Àí
	 * @param evt
	 */
	private void loginActionPerformed(ActionEvent evt) {
		//´ÓÊäÈë¿ò»ñÈ¡ÓÃ»§Ãû
		String username=usernameText.getText().trim();
		//´ÓÊäÈë¿ò»ñÈ¡ÃÜÂë
		String password=passwordText.getText().trim();
		//ÓÃ»§Ãû²»ÄÜÎª¿Õ»ò¿Õ×Ö·û´®,·ñÔò½áÊøÊÂ¼þ´¦Àí
		if(username==null || "".equals(username)){
			JOptionPane.showMessageDialog(null, "ÓÃ»§Ãû²»ÄÜÎª¿Õ");
			return;
		}
		//ÓÃ»§Ãû²»ÄÜÎª¿Õ»ò¿Õ×Ö·û´®·ñÔò½áÊøÊÂ¼þ´¦Àí
		if(password==null || "".equals(password)){
			JOptionPane.showMessageDialog(null, "ÃÜÂë²»ÄÜÎª¿Õ");
			return;
		}
			}
	/**
	 * ÖØÖÃÊÂ¼þ´¦Àí
	 * @param evt
	 */
	private void resetActionPerformed(ActionEvent evt) {
		usernameText.setText("");
		passwordText.setText("");
	}
}
