import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class insertar_carreras extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField clave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertar_carreras frame = new insertar_carreras();
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
	public insertar_carreras() {
		setTitle("Control Escolar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Universidad Patito");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(202, 10, 272, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblAgregarCarreras = new JLabel("Agregar Carrera");
		lblAgregarCarreras.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblAgregarCarreras.setBounds(202, 70, 272, 44);
		contentPane.add(lblAgregarCarreras);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la carrera:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(44, 186, 237, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Clave de la carrera:");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(387, 186, 237, 36);
		contentPane.add(lblNewLabel_1_1);
		
		name = new JTextField();
		name.setBounds(44, 235, 237, 36);
		contentPane.add(name);
		name.setColumns(10);
		
		clave = new JTextField();
		clave.setColumns(10);
		clave.setBounds(387, 235, 237, 36);
		contentPane.add(clave);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nam= name.getText();
				String clav= clave.getText();
				
				Conect_BD insert= new Conect_BD();
				
				
				menu_principal menu_prin= new menu_principal();
				if(nam.isEmpty() || clav.isEmpty()) {
					insert_alumno upd= new insert_alumno();
					JOptionPane.showMessageDialog(upd,"Los campos no pueden estar vacios." ,"Error" , JOptionPane.ERROR_MESSAGE);	
				}else {
					if(insert.insertCarrera(nam,clav)) {
						menu_prin.setVisible(true);
						dispose();	
						JOptionPane.showMessageDialog(menu_prin,"Carrera creada exitosamente." ,"Success" , JOptionPane.DEFAULT_OPTION);
					}else {
						menu_prin.setVisible(true);
						dispose();	
						JOptionPane.showMessageDialog(menu_prin,"Ocurrio un error al crear carrera." ,"Error" , JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(387, 355, 225, 56);
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
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(68, 355, 225, 56);
		contentPane.add(btnNewButton_1);
	}
}
