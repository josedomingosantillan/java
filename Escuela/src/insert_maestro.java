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

public class insert_maestro extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField ape_p;
	private JTextField ape_m;
	private JTextField carrera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insert_maestro frame = new insert_maestro();
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
	public insert_maestro() {
		setTitle("Control Escolar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Universidad Patito");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(202, 10, 272, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblAgregarMaestros = new JLabel("Agregar maestro");
		lblAgregarMaestros.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblAgregarMaestros.setBounds(202, 66, 272, 46);
		contentPane.add(lblAgregarMaestros);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(41, 157, 237, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido Paterno:");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(384, 157, 237, 36);
		contentPane.add(lblNewLabel_1_1);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(41, 206, 237, 36);
		contentPane.add(name);
		
		ape_p = new JTextField();
		ape_p.setColumns(10);
		ape_p.setBounds(384, 206, 237, 36);
		contentPane.add(ape_p);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellido Materno:");
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(41, 275, 237, 36);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Carrera:");
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(384, 275, 237, 36);
		contentPane.add(lblNewLabel_1_1_1);
		
		ape_m = new JTextField();
		ape_m.setColumns(10);
		ape_m.setBounds(41, 324, 237, 36);
		contentPane.add(ape_m);
		
		carrera = new JTextField();
		carrera.setColumns(10);
		carrera.setBounds(384, 324, 237, 36);
		contentPane.add(carrera);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nam= name.getText();
				String ape_pa= ape_p.getText();
				String ape_ma= ape_m.getText();
				String carre= carrera.getText();
				
				Conect_BD insert= new Conect_BD();
				menu_principal menu_prin= new menu_principal();
				if(nam.isEmpty() || ape_pa.isEmpty() || ape_ma.isEmpty() || carre.isEmpty()) {
					insert_alumno upd= new insert_alumno();
					JOptionPane.showMessageDialog(upd,"Los campos no pueden estar vacios." ,"Error" , JOptionPane.ERROR_MESSAGE);	
				}else {
					if(insert.insertMaestro(nam,ape_pa,ape_ma,carre)) {
						menu_prin.setVisible(true);
						dispose();	
						JOptionPane.showMessageDialog(menu_prin,"Maestro creado exitosamente." ,"Success" , JOptionPane.DEFAULT_OPTION);
					}else {
						menu_prin.setVisible(true);
						dispose();	
						JOptionPane.showMessageDialog(menu_prin,"Ocurrio un error al crear maestro." ,"Error" , JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(359, 408, 225, 56);
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
		btnNewButton_1.setBounds(70, 408, 225, 56);
		contentPane.add(btnNewButton_1);
	}

}
