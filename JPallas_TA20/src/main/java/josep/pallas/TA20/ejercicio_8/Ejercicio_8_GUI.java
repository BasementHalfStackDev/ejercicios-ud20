package josep.pallas.TA20.ejercicio_8;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

class Ejercicio_8_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAmmount;
	private JTextField textFieldResult;
	private JButton btnSwitch;
	private JButton btnCalc;
	private JButton btnDel;

	public Ejercicio_8_GUI() {
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
		textFieldAmmount.addKeyListener(navigation); // Added navigation
		textFieldAmmount.setColumns(10);

		textFieldResult = new JTextField();
		textFieldResult.setEditable(false);
		textFieldResult.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldResult.setColumns(10);
		textFieldResult.setBounds(298, 44, 86, 20);
		textFieldResult.setFocusable(false); // Set to false to the user cannot navigate to it
		contentPane.add(textFieldResult);

		// Buttons to calculate, switch conversion and clear
		btnCalc = new JButton("Euros to Ptas");
		btnCalc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalc.setBounds(20, 75, 128, 31);
		btnCalc.addActionListener(btns);
		btnCalc.addKeyListener(navigation); // Added navigation
		contentPane.add(btnCalc);

		btnSwitch = new JButton("Switch");
		btnSwitch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSwitch.setBounds(179, 75, 98, 31);
		btnSwitch.addActionListener(btns);
		btnSwitch.addKeyListener(navigation); // Added navigation
		contentPane.add(btnSwitch);

		btnDel = new JButton("Clear");
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDel.setBounds(308, 75, 98, 31);
		btnDel.addActionListener(btns);
		btnDel.addKeyListener(navigation); // Added navigation
		contentPane.add(btnDel);

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

			// If it's delete button, clears fields
			if (e.getSource() == btnDel) {
				textFieldResult.setText("");
				textFieldAmmount.setText("");
			}

			// Calculate conversion depending on button name
			try {
				if (e.getSource() == btnCalc && btnCalc.getText().equals("Euros to Ptas")) {
					double value = Double.parseDouble(textFieldAmmount.getText()) * 166.386;
					String sPtas = String.format("%.2f", value);
					textFieldResult.setText(sPtas);
				} else if (e.getSource() == btnCalc && btnCalc.getText().equals("Ptas to Euros")) {
					double value = Double.parseDouble(textFieldAmmount.getText()) * 0.00601012;
					String sEuros = String.format("%.2f", value);
					textFieldResult.setText(sEuros);
				}
			} catch (NumberFormatException ex) { // If number is invalid, throw exception
				Ejercicio_8_Exception_GUI exception = new Ejercicio_8_Exception_GUI();
			}
		}
	};

	// Navigation KeyAdapter
	KeyAdapter navigation = new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) { // Left arrow key to go back
				Component comp = (Component) e.getSource();
				comp.transferFocusBackward();
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // Right arrow key to go forward
				Component comp = (Component) e.getSource();
				comp.transferFocus();
			} else if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Enter key to press button
				Component comp = (Component) e.getSource();
				if (comp instanceof JButton) {
					JButton button = (JButton) comp;
					button.doClick();
				}
			} else if (e.getKeyCode() == KeyEvent.VK_DELETE) { // Suprimir/Del to clear
				btnDel.doClick();
			}
		}
	};
}
