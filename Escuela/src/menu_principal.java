import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;

public class menu_principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu_principal frame = new menu_principal();
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
	public menu_principal() {
		setTitle("Control Escolar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Universidad Patito");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(227, 10, 273, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblBienvenidoMenPrincipal = new JLabel("Bienvenido Menú Principal");
		lblBienvenidoMenPrincipal.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblBienvenidoMenPrincipal.setBounds(178, 80, 322, 37);
		contentPane.add(lblBienvenidoMenPrincipal);
		
		JLabel lblNewLabel_1 = new JLabel("Alumnos");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(58, 184, 195, 61);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Carreras");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(58, 376, 195, 61);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Maestros");
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(395, 184, 195, 61);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Usuarios");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1_1_1_1.setBounds(395, 376, 195, 61);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert_alumno alumno = new insert_alumno();
				alumno.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(207, 255, 116, 43);
		contentPane.add(btnNewButton);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ver_alumnos alumno= new ver_alumnos();
				alumno.setVisible(true);
				dispose();
			}
		});
		btnVisualizar.setBounds(207, 323, 116, 43);
		contentPane.add(btnVisualizar);
		
		JButton btnNewButton_1_1 = new JButton("Visualizar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ver_carreras carrera= new ver_carreras();
				carrera.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setBounds(207, 503, 116, 43);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertar_carreras carrera= new insertar_carreras();
				carrera.setVisible(true);
				dispose();
			}
		});
		btnAgregar.setBounds(207, 435, 116, 43);
		contentPane.add(btnAgregar);
		
		JButton btnNewButton_1_2 = new JButton("Visualizar");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ver_usuarios usuario= new ver_usuarios();
				usuario.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2.setBounds(544, 503, 116, 43);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnAgregar_2 = new JButton("Agregar");
		btnAgregar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert_usuarios usuarios= new insert_usuarios();
				usuarios.setVisible(true);
				dispose();	
			}
		});
		btnAgregar_2.setBounds(544, 435, 116, 43);
		contentPane.add(btnAgregar_2);
		
		JButton btnNewButton_1_3 = new JButton("Visualizar");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ver_maestros maestros= new ver_maestros();
				maestros.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_3.setBounds(544, 323, 116, 43);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnAgregar_1 = new JButton("Agregar");
		btnAgregar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert_maestro maestro= new insert_maestro();
				maestro.setVisible(true);
				dispose();	
			}
		});
		btnAgregar_1.setBounds(544, 255, 116, 43);
		contentPane.add(btnAgregar_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cerrar sesión");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login log= new login();
				log.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel_2.setBounds(548, 14, 135, 37);
		contentPane.add(lblNewLabel_2);
		Conect_BD conectar= new Conect_BD();
	}
}
