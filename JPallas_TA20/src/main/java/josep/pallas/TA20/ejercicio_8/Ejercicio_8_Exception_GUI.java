package josep.pallas.TA20.ejercicio_8;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Ejercicio_8_Exception_GUI extends JFrame {

	private JPanel contentPane;
	private JButton btnOK;

	public Ejercicio_8_Exception_GUI() {
		setTitle("Error!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 168);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 0, 0);
		contentPane.add(label);
		
		// Title label
		JLabel lblTitle = new JLabel("The inserted number is not valid!");
		lblTitle.setBounds(5, 5, 487, 17);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblTitle);
		
		// Two labels for each line
		JLabel lblNewLabel_1 = new JLabel("Please, make sure that you inserted a numeric value without letters or characters.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(15, 33, 477, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("If the number contains decimals, separate them with a single \".\" dot.");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(10, 58, 482, 14);
		contentPane.add(lblNewLabel_1_1);
		
		// Ok button to dismiss window
		btnOK = new JButton("OK");
		btnOK.setBounds(214, 95, 89, 23);
		btnOK.addActionListener(okbtn);
		contentPane.add(btnOK);
		
		setVisible(true);
	}
	
	// Action listener to go back to dismiss window
	ActionListener okbtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	};
}
