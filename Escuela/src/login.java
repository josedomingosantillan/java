import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel login;
	private JTextField user_field;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("Control Escolar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 655);
		login = new JPanel();
		login.setBackground(new Color(255, 255, 255));
		login.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(login);
		login.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Universidad Patito");
		lblNewLabel.setBounds(218, 4, 252, 53);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		login.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(218, 67, 233, 243);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\MSI PRENDAMEX\\eclipse-workspace\\Escuela\\img\\login.png"));
		login.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setBounds(245, 327, 150, 36);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 16));
		login.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Contraseña:");
		lblNewLabel_2_1.setBounds(245, 415, 137, 32);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 18));
		login.add(lblNewLabel_2_1);
		
		user_field = new JTextField();
		user_field.setBounds(230, 373, 206, 32);
		login.add(user_field);
		user_field.setColumns(10);
		
		JButton iniciar = new JButton("Iniciar");
		iniciar.setBounds(259, 516, 141, 36);
		
		Conect_BD conectar = new Conect_BD();
		
		iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user= user_field.getText();
				String user_password= password.getText();
				
					if(conectar.login(user, user_password)) {
						menu_principal menu_prin= new menu_principal();
						menu_prin.setVisible(true);
						dispose();	
					}else {
						JOptionPane.showMessageDialog(login,"Los datos ingresados son incorrectos." ,"Error" , JOptionPane.ERROR_MESSAGE);
					}	
			}
		});
		iniciar.setFont(new Font("Arial Black", Font.BOLD, 18));
		login.add(iniciar);
		
		password = new JPasswordField();
		password.setBounds(230, 457, 206, 32);
		login.add(password);
	}
}
