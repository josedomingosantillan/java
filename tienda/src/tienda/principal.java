package tienda;

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

public class principal extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField precio;
	private JTextField cantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
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
	public principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tienda");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblNewLabel.setBounds(283, 10, 135, 101);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Producto");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1.setBounds(69, 110, 141, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Precio");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(277, 110, 105, 42);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Cantidad");
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(481, 110, 105, 42);
		contentPane.add(lblNewLabel_1_2);
		
		nombre = new JTextField();
		nombre.setBounds(69, 162, 141, 42);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		precio = new JTextField();
		precio.setColumns(10);
		precio.setBounds(277, 162, 141, 42);
		contentPane.add(precio);
		
		cantidad = new JTextField();
		cantidad.setColumns(10);
		cantidad.setBounds(481, 162, 141, 42);
		contentPane.add(cantidad);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal prin= new principal();
				String nom= nombre.getText(), prec= precio.getText(), cant= cantidad.getText();
				if(!nom.isEmpty()&& !prec.isEmpty() && !cant.isEmpty()) {
					guardar_archivo guardar= new guardar_archivo();
					guardar.nombre= nom;
					guardar.precio= prec;
					guardar.cantidad= cant;
					
					if(guardar.escribirArchivo()) {
						JOptionPane.showMessageDialog(prin, "El archivo se creo exitosamente con el nombre de " + nom);
					}else {
						JOptionPane.showMessageDialog(prin, "Ocurrio un error al crear el archivo.");
					}
				}else {
					JOptionPane.showMessageDialog(prin, "Los datos no pueden estar vacios");
				}
				nombre.setText("");
				precio.setText("");
				cantidad.setText("");
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setBounds(283, 260, 135, 56);
		contentPane.add(btnNewButton);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal prin= new principal();
				String nom= nombre.getText();
				if(!nom.isEmpty()) {
					guardar_archivo guardar= new guardar_archivo();
					guardar.nombre= nom;
				
					
					if(guardar.eliminarArchivo()) {
						JOptionPane.showMessageDialog(prin, "El archivo se elimino exitosamente");
					}else {
						JOptionPane.showMessageDialog(prin, "Ocurrio un error al eliminar el archivo.");
					}
				}else {
					JOptionPane.showMessageDialog(prin, "Los datos no pueden estar vacios");
				}
				nombre.setText("");
				precio.setText("");
				cantidad.setText("");
			}
		});
		btnEliminar.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setBounds(283, 349, 141, 56);
		contentPane.add(btnEliminar);
	}
}
