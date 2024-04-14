import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class update_carreras extends JFrame {

	private JPanel contentPane;
	private JTextField name_carrera;
	private JTextField clave_carrera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_carreras frame = new update_carreras();
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
	public update_carreras() {
		setTitle("Control Escolar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Universidad Patito");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(202, 10, 272, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblActualizarCarreras = new JLabel("Actualizar carreras");
		lblActualizarCarreras.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblActualizarCarreras.setBounds(202, 91, 272, 46);
		contentPane.add(lblActualizarCarreras);
		
		JComboBox carrera = new JComboBox();
		carrera.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Conect_BD con= new Conect_BD();
				String opcion= (String)carrera.getSelectedItem();
				con.getCarrera(Integer.parseInt(opcion.split("-")[0].trim()),name_carrera, clave_carrera);
			}
		});
		carrera.setFont(new Font("Arial Black", Font.BOLD, 16));
		carrera.setBounds(125, 145, 441, 36);
		contentPane.add(carrera);
		Conect_BD con= new Conect_BD();
		con.getCarreras_update(carrera);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la carrera:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(49, 248, 237, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Clave de la carrera:");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(392, 248, 237, 36);
		contentPane.add(lblNewLabel_1_1);
		
		name_carrera = new JTextField();
		name_carrera.setColumns(10);
		name_carrera.setBounds(49, 297, 237, 36);
		contentPane.add(name_carrera);
		
		clave_carrera = new JTextField();
		clave_carrera.setColumns(10);
		clave_carrera.setBounds(392, 297, 237, 36);
		contentPane.add(clave_carrera);
		
		String opcion= (String)carrera.getSelectedItem();
		con.getCarrera(Integer.parseInt(opcion.split("-")[0].trim()),name_carrera, clave_carrera);
		
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
		btnNewButton_1.setBounds(73, 471, 225, 56);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcion= (String)carrera.getSelectedItem();
				String carrera= name_carrera.getText(), clav= clave_carrera.getText();
				if(carrera.isEmpty() || clav.isEmpty()) {
					update_carreras upd= new update_carreras();
					JOptionPane.showMessageDialog(upd,"Los campos no pueden estar vacios." ,"Error" , JOptionPane.ERROR_MESSAGE);
				}else {
			
					int id= Integer.parseInt(opcion.split("-")[0].trim());
					menu_principal menu_prin= new menu_principal();
					if(con.updateCarreras(id, carrera, clav)) {
						menu_prin.setVisible(true);
						dispose();	
						JOptionPane.showMessageDialog(menu_prin,"Carrera actualizada exitosamente." ,"Success" , JOptionPane.DEFAULT_OPTION);
					}else {
						menu_prin.setVisible(true);
						dispose();	
						JOptionPane.showMessageDialog(menu_prin,"Ocurrio un error al actualizar carrera." ,"Error" , JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(392, 471, 225, 56);
		contentPane.add(btnNewButton);
		
		JButton btnEliminarCarrera = new JButton("Eliminar Carrera");
		btnEliminarCarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcion= (String)carrera.getSelectedItem();
				int id=Integer.parseInt(opcion.split("-")[0].trim());
				menu_principal menu_prin= new menu_principal();
				if(con.elimarCarrera(id)) {
					menu_prin.setVisible(true);
					dispose();	
					JOptionPane.showMessageDialog(menu_prin,"Carrera eliminada exitosamente." ,"Success" , JOptionPane.DEFAULT_OPTION);
				}else {
					menu_prin.setVisible(true);
					dispose();	
					JOptionPane.showMessageDialog(menu_prin,"Ocurrio un error al eliminar carrera." ,"Error" , JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminarCarrera.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnEliminarCarrera.setBackground(new Color(255, 128, 64));
		btnEliminarCarrera.setBounds(222, 378, 238, 56);
		contentPane.add(btnEliminarCarrera);
	}
}
