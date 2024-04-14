import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class insert_usuarios extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField ape_p;
	private JTextField ape_m;
	private JTextField username;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insert_usuarios frame = new insert_usuarios();
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
	public insert_usuarios() {
		setTitle("Control Escolar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Universidad Patito");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(202, 10, 272, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblAgregarUsuarios = new JLabel("Agregar usuario");
		lblAgregarUsuarios.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblAgregarUsuarios.setBounds(202, 66, 272, 46);
		contentPane.add(lblAgregarUsuarios);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(43, 293, 128, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(43, 151, 128, 38);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellido Materno:");
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(452, 151, 196, 38);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Contraseña:");
		lblNewLabel_1_3.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(203, 293, 128, 38);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Departamento:");
		lblNewLabel_1_4.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(452, 293, 166, 38);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Apellido Paterno:");
		lblNewLabel_1_5.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(202, 151, 185, 38);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Sexo:");
		lblNewLabel_1_6.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_6.setBounds(43, 420, 128, 38);
		contentPane.add(lblNewLabel_1_6);
		
		name = new JTextField();
		name.setFont(new Font("Arial Black", Font.BOLD, 16));
		name.setBounds(43, 199, 128, 56);
		contentPane.add(name);
		name.setColumns(10);
		
		ape_p = new JTextField();
		ape_p.setFont(new Font("Arial Black", Font.BOLD, 16));
		ape_p.setColumns(10);
		ape_p.setBounds(202, 199, 185, 56);
		contentPane.add(ape_p);
		
		ape_m = new JTextField();
		ape_m.setFont(new Font("Arial Black", Font.BOLD, 16));
		ape_m.setColumns(10);
		ape_m.setBounds(452, 199, 196, 56);
		contentPane.add(ape_m);
		
		username = new JTextField();
		username.setFont(new Font("Arial Black", Font.BOLD, 16));
		username.setColumns(10);
		username.setBounds(43, 341, 128, 56);
		contentPane.add(username);
		
		pass = new JTextField();
		pass.setFont(new Font("Arial Black", Font.BOLD, 16));
		pass.setColumns(10);
		pass.setBounds(202, 341, 185, 56);
		contentPane.add(pass);
		
		JComboBox depa = new JComboBox();
		depa.setFont(new Font("Arial Black", Font.BOLD, 16));
		depa.setModel(new DefaultComboBoxModel(new String[] {"Admisión", "Sistemas"}));
		depa.setBounds(452, 341, 196, 56);
		contentPane.add(depa);
		
		JComboBox sexo = new JComboBox();
		sexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		sexo.setFont(new Font("Arial Black", Font.BOLD, 16));
		sexo.setBounds(43, 460, 173, 56);
		contentPane.add(sexo);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nam= name.getText();
				String ape_pa= ape_p.getText();
				String ape_ma= ape_m.getText();
				String _username= username.getText();
				String passw= pass.getText();
				String dep=  (String) depa.getSelectedItem();
				String sex=  (String) sexo.getSelectedItem();
				
				Conect_BD insert= new Conect_BD();
				
				menu_principal menu_prin= new menu_principal();
				if(nam.isEmpty() || ape_pa.isEmpty() || ape_ma.isEmpty() || _username.isEmpty()|| passw.isEmpty()) {
					insert_alumno upd= new insert_alumno();
					JOptionPane.showMessageDialog(upd,"Los campos no pueden estar vacios." ,"Error" , JOptionPane.ERROR_MESSAGE);	
				}else {
					if(insert.insertUsers(_username,passw,nam,ape_pa,ape_ma,dep=="Admisión" ? 1 : 2,sex == "Masculino" ? 1:2)) {
						menu_prin.setVisible(true);
						dispose();	
						JOptionPane.showMessageDialog(menu_prin,"Usuario creado exitosamente." ,"Success" , JOptionPane.DEFAULT_OPTION);
					}else {
						menu_prin.setVisible(true);
						dispose();	
						JOptionPane.showMessageDialog(menu_prin,"Ocurrio un error al crear usuario." ,"Error" , JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNewButton.setBounds(458, 460, 225, 56);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Regresar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu_principal menu_prin= new menu_principal();
				menu_prin.setVisible(true);
				dispose();	
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(226, 460, 225, 56);
		contentPane.add(btnNewButton_1);
	}
}
