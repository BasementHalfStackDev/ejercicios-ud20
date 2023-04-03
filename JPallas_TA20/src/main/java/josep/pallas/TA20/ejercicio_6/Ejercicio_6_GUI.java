package josep.pallas.TA20.ejercicio_6;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Ejercicio_6_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldHeight;
	private JTextField textFieldWeight;
	private JTextField textFieldResult;
	private JButton btnCalc;

	public Ejercicio_6_GUI() {
		setTitle("Ejercicio 6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Labels
		JLabel lblProgramTitle = new JLabel("BMI Calculator");
		lblProgramTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProgramTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgramTitle.setBounds(10, 11, 414, 17);
		contentPane.add(lblProgramTitle);

		JLabel lblHeight = new JLabel("Height (meters)");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHeight.setBounds(10, 56, 93, 14);
		contentPane.add(lblHeight);

		JLabel lblWeight = new JLabel("Weight (kg)");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWeight.setBounds(228, 56, 93, 14);
		contentPane.add(lblWeight);
		
		// Textfields for input
		textFieldHeight = new JTextField();
		textFieldHeight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldHeight.setBounds(102, 53, 86, 20);
		contentPane.add(textFieldHeight);
		textFieldHeight.setColumns(10);

		textFieldWeight = new JTextField();
		textFieldWeight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldWeight.setColumns(10);
		textFieldWeight.setBounds(299, 53, 86, 20);
		contentPane.add(textFieldWeight);
		
		// Textfield for display
		textFieldResult = new JTextField();
		textFieldResult.setEditable(false);
		textFieldResult.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldResult.setColumns(10);
		textFieldResult.setBounds(228, 100, 86, 20);
		contentPane.add(textFieldResult);

		// Button to calculate
		btnCalc = new JButton("Calculate BMI");
		btnCalc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCalc.setBounds(87, 94, 120, 30);
		btnCalc.addActionListener(calcbtn);
		contentPane.add(btnCalc);

		

		setVisible(true);
	}

	// Calculation of BMI on button press
	ActionListener calcbtn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			double height = Double.parseDouble(textFieldHeight.getText());
			double weight = Double.parseDouble(textFieldWeight.getText());

			double IMC = weight / (height * height);
			double roundedIMC = Math.round(IMC * 10.0) / 10.0;
			String sIMC = String.valueOf(roundedIMC);
			textFieldResult.setText(sIMC);
		}

	};
}
