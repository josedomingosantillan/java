import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class update_maestro extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField ape_p;
	private JTextField ape_m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_maestro frame = new update_maestro();
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
	public update_maestro() {
		setTitle("Control Escolar");
		Conect_BD con= new Conect_BD();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Universidad Patito");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(207, 10, 272, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblActualizarCarreras = new JLabel("Actualizar Maestros");
		lblActualizarCarreras.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblActualizarCarreras.setBounds(207, 91, 272, 46);
		contentPane.add(lblActualizarCarreras);
		
		JComboBox maestros = new JComboBox();
		maestros.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String opcion= (String)maestros.getSelectedItem();
				con.getMaestrosselect(Integer.parseInt(opcion.split("-")[0].trim()),nombre, ape_p,ape_m);
			}
		});
		maestros.setFont(new Font("Arial Black", Font.BOLD, 16));
		maestros.setBounds(130, 145, 441, 36);
		contentPane.add(maestros);
		
		JLabel dg = new JLabel("Nombre:");
		dg.setFont(new Font("Arial Black", Font.BOLD, 18));
		dg.setBounds(54, 248, 237, 36);
		contentPane.add(dg);
		
		
		con.getMaestros_update(maestros);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(54, 297, 237, 36);
		contentPane.add(nombre);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido Paterno:");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(397, 248, 237, 36);
		contentPane.add(lblNewLabel_1_1);
		
		ape_p = new JTextField();
		ape_p.setColumns(10);
		ape_p.setBounds(397, 297, 237, 36);
		contentPane.add(ape_p);
		
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
		btnNewButton_1.setBounds(77, 509, 225, 56);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String opcion= (String)maestros.getSelectedItem();
				String carrera= nombre.getText(), apep= ape_p.getText(), apem= ape_m.getText();
				if(carrera.isEmpty() || apep.isEmpty()|| apem.isEmpty()) {
					update_maestro upd= new update_maestro();
					JOptionPane.showMessageDialog(upd,"Los campos no pueden estar vacios." ,"Error" , JOptionPane.ERROR_MESSAGE);
				}else {
					int id= Integer.parseInt(opcion.split("-")[0].trim());
					menu_principal menu_prin= new menu_principal();
					if(con.updateMaestro(id, carrera, apep,apem)) {
						menu_prin.setVisible(true);
						dispose();	
						JOptionPane.showMessageDialog(menu_prin,"Alumno actualizado exitosamente." ,"Success" , JOptionPane.DEFAULT_OPTION);
					}else {
						menu_prin.setVisible(true);
						dispose();	
						JOptionPane.showMessageDialog(menu_prin,"Ocurrio un error al actualizar alumno." ,"Error" , JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(396, 509, 225, 56);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellido Materno:");
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(54, 369, 237, 36);
		contentPane.add(lblNewLabel_1_2);
		
		ape_m = new JTextField();
		ape_m.setColumns(10);
		ape_m.setBounds(54, 418, 237, 36);
		contentPane.add(ape_m);
		
		String opcion= (String)maestros.getSelectedItem();
		con.getMaestroInicio(Integer.parseInt(opcion.split("-")[0].trim()),nombre, ape_p, ape_m);
		
		JButton btnEliminarMaestro = new JButton("Eliminar Maestro");
		btnEliminarMaestro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcion= (String)maestros.getSelectedItem();
				int id=Integer.parseInt(opcion.split("-")[0].trim());
				menu_principal menu_prin= new menu_principal();
				if(con.elimarMaestros(id)) {
					menu_prin.setVisible(true);
					dispose();	
					JOptionPane.showMessageDialog(menu_prin,"Alumno eliminado exitosamente." ,"Success" , JOptionPane.DEFAULT_OPTION);
				}else {
					menu_prin.setVisible(true);
					dispose();	
					JOptionPane.showMessageDialog(menu_prin,"Ocurrio un error al eliminar alumno." ,"Error" , JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminarMaestro.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnEliminarMaestro.setBackground(new Color(255, 128, 64));
		btnEliminarMaestro.setBounds(397, 399, 238, 56);
		contentPane.add(btnEliminarMaestro);
	}

}
