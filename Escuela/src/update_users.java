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

public class update_users extends JFrame {

	private JPanel contentPane;
	private JTextField ape_p;
	private JTextField ape_m;
	private JTextField nombre;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_users frame = new update_users();
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
	public update_users() {
		setTitle("Control Escolar");
		Conect_BD con= new Conect_BD();
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
		
		JLabel lblActualizarUsuarios = new JLabel("Actualizar Usuarios");
		lblActualizarUsuarios.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblActualizarUsuarios.setBounds(202, 91, 272, 46);
		contentPane.add(lblActualizarUsuarios);
		
		JComboBox usuarios = new JComboBox();
		usuarios.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String opcion= (String)usuarios.getSelectedItem();
				con.getUsersselect(Integer.parseInt(opcion.split("-")[0].trim()),nombre, ape_p,ape_m,pass);
			}
		});
		usuarios.setFont(new Font("Arial Black", Font.BOLD, 16));
		usuarios.setBounds(125, 145, 441, 36);
		contentPane.add(usuarios);
		
		JLabel dg = new JLabel("Nombre:");
		dg.setFont(new Font("Arial Black", Font.BOLD, 18));
		dg.setBounds(49, 191, 237, 36);
		contentPane.add(dg);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido Paterno:");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(392, 191, 237, 36);
		contentPane.add(lblNewLabel_1_1);
		
		con.getUsuarios_update(usuarios);
		
		ape_p = new JTextField();
		ape_p.setColumns(10);
		ape_p.setBounds(392, 240, 237, 36);
		contentPane.add(ape_p);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellido Materno:");
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(49, 312, 237, 36);
		contentPane.add(lblNewLabel_1_2);
		
		ape_m = new JTextField();
		ape_m.setColumns(10);
		ape_m.setBounds(49, 361, 237, 36);
		contentPane.add(ape_m);
		
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
		btnNewButton_1.setBounds(72, 509, 225, 56);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcion= (String)usuarios.getSelectedItem();
				String carrera= nombre.getText(), apep= ape_p.getText(), apem= ape_m.getText(), passw= pass.getText();
				if(carrera.isEmpty() || apep.isEmpty()|| apem.isEmpty()|| passw.isEmpty()) {
					update_users upd= new update_users();
					JOptionPane.showMessageDialog(upd,"Los campos no pueden estar vacios." ,"Error" , JOptionPane.ERROR_MESSAGE);
				}else {
			
					int id= Integer.parseInt(opcion.split("-")[0].trim());
					menu_principal menu_prin= new menu_principal();
					if(con.updateUsers(id, carrera, apep,apem,passw)) {
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
		btnNewButton.setBounds(391, 509, 225, 56);
		contentPane.add(btnNewButton);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(49, 237, 237, 36);
		contentPane.add(nombre);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Contraseña:");
		lblNewLabel_1_2_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(392, 312, 237, 36);
		contentPane.add(lblNewLabel_1_2_1);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(392, 361, 237, 36);
		contentPane.add(pass);
		
		String opcion= (String)usuarios.getSelectedItem();
		con.getUsuarioInicio(Integer.parseInt(opcion.split("-")[0].trim()),nombre, ape_p, ape_m,pass);
		
		JButton btnEliminarUsuarios = new JButton("Eliminar Usuario");
		btnEliminarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcion= (String)usuarios.getSelectedItem();
				int id=Integer.parseInt(opcion.split("-")[0].trim());
				menu_principal menu_prin= new menu_principal();
				if(con.elimarUsuario(id)) {
					menu_prin.setVisible(true);
					dispose();	
					JOptionPane.showMessageDialog(menu_prin,"Usuario eliminado exitosamente." ,"Success" , JOptionPane.DEFAULT_OPTION);
				}else {
					menu_prin.setVisible(true);
					dispose();	
					JOptionPane.showMessageDialog(menu_prin,"Ocurrio un error al eliminar usuario." ,"Error" , JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminarUsuarios.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnEliminarUsuarios.setBackground(new Color(255, 128, 64));
		btnEliminarUsuarios.setBounds(224, 424, 238, 56);
		contentPane.add(btnEliminarUsuarios);
	}

}
