package factorial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class factorial {

	private JFrame frame;
	private JTextField numero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					factorial window = new factorial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public factorial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresa un número");
		lblNewLabel.setBounds(10, 10, 87, 58);
		frame.getContentPane().add(lblNewLabel);
		
		numero = new JTextField();
		numero.setBounds(116, 21, 161, 38);
		frame.getContentPane().add(numero);
		numero.setColumns(10);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facto fac= new Facto();
				fac.numero= Integer.parseInt(numero.getText());
				int valor= fac.calcular();
				JOptionPane.showMessageDialog(btnNewButton, valor);
			}
		});
		btnNewButton.setBounds(158, 94, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}
}
