import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ver_carreras extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ver_carreras frame = new ver_carreras();
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
	public ver_carreras() {
		setTitle("Control Escolar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuarios = new JLabel("Carreras");
		lblUsuarios.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblUsuarios.setBounds(258, 91, 272, 46);
		contentPane.add(lblUsuarios);
		
		JLabel lblNewLabel = new JLabel("Universidad Patito");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(202, 10, 272, 46);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Arial", Font.BOLD, 16));
		table.setBounds(23, 133, 643, 406);
		contentPane.add(table);
		
		Conect_BD con= new Conect_BD();
		con.getCarreras(table);
		
		btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu_principal menu_prin= new menu_principal();
				menu_prin.setVisible(true);
				dispose();	
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(82, 552, 225, 56);
		contentPane.add(btnNewButton);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_carreras carrera_upt= new update_carreras();
				carrera_upt.setVisible(true);
				dispose();
			}
		});
		btnActualizar.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnActualizar.setBackground(new Color(255, 255, 0));
		btnActualizar.setBounds(370, 552, 225, 56);
		contentPane.add(btnActualizar);
	}
}
