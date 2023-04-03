package josep.pallas.TA20.ejercicio_7;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

class Ejercicio_7_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAmmount;
	private JTextField textFieldResult;
	private JButton btnSwitch;
	private JButton btnCalc;

	public Ejercicio_7_GUI() {
		setTitle("Ejercicio 7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Labels
		JLabel lblCurrencyConverter = new JLabel("Currency Converter");
		lblCurrencyConverter.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrencyConverter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurrencyConverter.setBounds(10, 11, 414, 17);
		contentPane.add(lblCurrencyConverter);

		JLabel lblAmount = new JLabel("Amount to convert");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAmount.setBounds(10, 46, 110, 17);
		contentPane.add(lblAmount);

		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResult.setBounds(250, 46, 38, 17);
		contentPane.add(lblResult);

		// Text fields with to introduce ammount and show result
		textFieldAmmount = new JTextField();
		textFieldAmmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldAmmount.setBounds(130, 45, 86, 20);
		contentPane.add(textFieldAmmount);
		textFieldAmmount.setColumns(10);

		textFieldResult = new JTextField();
		textFieldResult.setEditable(false);
		textFieldResult.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldResult.setColumns(10);
		textFieldResult.setBounds(298, 44, 86, 20);
		contentPane.add(textFieldResult);

		// Buttons to calculate and switch conversion
		btnCalc = new JButton("Euros to Ptas");
		btnCalc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalc.setBounds(88, 75, 128, 31);
		btnCalc.addActionListener(btns);
		contentPane.add(btnCalc);

		btnSwitch = new JButton("Switch");
		btnSwitch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSwitch.setBounds(226, 75, 98, 31);
		btnSwitch.addActionListener(btns);
		contentPane.add(btnSwitch);

		setVisible(true);
	}

	// Action listener for buttons
	ActionListener btns = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			// If its switch button, switch calc button name
			if (e.getSource() == btnSwitch && btnCalc.getText().equals("Euros to Ptas")) {
				btnCalc.setText("Ptas to Euros");
			} else if (e.getSource() == btnSwitch && btnCalc.getText().equals("Ptas to Euros")) {
				btnCalc.setText("Euros to Ptas");
			}

			// Calculate conversion depending on button name
			if (e.getSource() == btnCalc && btnCalc.getText().equals("Euros to Ptas")) {
				double value = Double.parseDouble(textFieldAmmount.getText()) * 166.386;
				String sPtas = String.format("%.2f", value);
				textFieldResult.setText(sPtas);
			} else if (e.getSource() == btnCalc && btnCalc.getText().equals("Ptas to Euros")) {
				double value = Double.parseDouble(textFieldAmmount.getText()) * 0.00601012;
				String sEuros = String.format("%.2f", value);
				textFieldResult.setText(sEuros);
			}

		}

	};

}
