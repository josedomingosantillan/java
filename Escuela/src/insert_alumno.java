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
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class insert_alumno extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField ape_p;
	private JTextField ape_m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insert_alumno frame = new insert_alumno();
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
	public insert_alumno() {
		setTitle("Control Escolar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarAlumno = new JLabel("Agregar Alumno");
		lblAgregarAlumno.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblAgregarAlumno.setBounds(202, 66, 272, 46);
		contentPane.add(lblAgregarAlumno);
		
		JLabel lblNewLabel = new JLabel("Universidad Patito");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(202, 10, 272, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(21, 133, 237, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido Paterno:");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(364, 133, 237, 36);
		contentPane.add(lblNewLabel_1_1);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(21, 182, 237, 36);
		contentPane.add(name);
		
		ape_p = new JTextField();
		ape_p.setColumns(10);
		ape_p.setBounds(364, 182, 237, 36);
		contentPane.add(ape_p);
		
		ape_m = new JTextField();
		ape_m.setColumns(10);
		ape_m.setBounds(21, 300, 237, 36);
		contentPane.add(ape_m);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Carrera:");
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(364, 251, 237, 36);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellido Materno:");
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(21, 251, 237, 36);
		contentPane.add(lblNewLabel_1_2);
		
		JComboBox carrera = new JComboBox();
		carrera.setFont(new Font("Arial Black", Font.BOLD, 16));
		carrera.setBounds(364, 296, 237, 36);
		contentPane.add(carrera);
		Conect_BD con= new Conect_BD();
		con.getCarreras(carrera);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nam= name.getText();
				String ape_pa= ape_p.getText();
				String ape_ma= ape_m.getText();
				String carre= (String)carrera.getSelectedItem();
				
				Conect_BD insert= new Conect_BD();
				
				if(nam.isEmpty() || ape_pa.isEmpty() || ape_ma.isEmpty() || carre.isEmpty()) {
					insert_alumno upd= new insert_alumno();
					JOptionPane.showMessageDialog(upd,"Los campos no pueden estar vacios." ,"Error" , JOptionPane.ERROR_MESSAGE);	
				}else {
					menu_principal menu_prin= new menu_principal();
					if(insert.insertAlumno(nam,ape_pa,ape_ma,carre)) {
						menu_prin.setVisible(true);
						dispose();	
						JOptionPane.showMessageDialog(menu_prin,"Alumno creado exitosamente." ,"Success" , JOptionPane.DEFAULT_OPTION);
					}else {
						menu_prin.setVisible(true);
						dispose();	
						JOptionPane.showMessageDialog(menu_prin,"Ocurrio un error al crear alumno." ,"Error" , JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(352, 386, 225, 56);
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
		btnNewButton_1.setBounds(59, 386, 225, 56);
		contentPane.add(btnNewButton_1);
		
	
	}
}
