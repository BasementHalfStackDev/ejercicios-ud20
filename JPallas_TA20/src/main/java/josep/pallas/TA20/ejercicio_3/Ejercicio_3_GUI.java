package josep.pallas.TA20.ejercicio_3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio_3_GUI extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_btn1Counter;
	private JLabel lbl_btn2Counter;
	private JButton btn_1;
	private JButton btn_2;
	private int counter1;
	private int counter2;

	public Ejercicio_3_GUI() {
		setTitle("Ejercicio 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 134);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Label to count button 1 clicks
		lbl_btn1Counter = new JLabel("You pressed button 1: 0 times");
		lbl_btn1Counter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_btn1Counter.setBounds(10, 11, 207, 14);
		contentPane.add(lbl_btn1Counter);

		// Label to count button 2 clicks
		lbl_btn2Counter = new JLabel("You pressed button 2: 0 times");
		lbl_btn2Counter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_btn2Counter.setBounds(217, 11, 207, 14);
		contentPane.add(lbl_btn2Counter);

		// Buttons
		btn_1 = new JButton("Button 1");
		btn_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_1.setBounds(10, 36, 174, 42);
		btn_1.addActionListener(buttons);
		contentPane.add(btn_1);

		btn_2 = new JButton("Button 2");
		btn_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_2.setBounds(217, 36, 174, 42);
		contentPane.add(btn_2);
		btn_2.addActionListener(buttons);

		setVisible(true);
	}

	// Adds one click to the counter after each click depending on the button
	// pressed
	ActionListener buttons = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn_1) {
				counter1++;
				lbl_btn1Counter.setText("You pressed button 1: " + counter1 + " times");
			} else if (e.getSource() == btn_2) {
				counter2++;
				lbl_btn2Counter.setText("You pressed button 2: " + counter2 + " times");
			}
		}
	};

}
