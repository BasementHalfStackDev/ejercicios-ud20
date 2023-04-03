package josep.pallas.TA20.ejercicio_2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JButton;

class Ejercicio_2_GUI extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_dynamic;
	private JButton btn_1;
	private JButton btn_2;

	public Ejercicio_2_GUI() {
		setTitle("Ejercicio 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 135);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Dynamic label
		lbl_dynamic = new JLabel("Click a button");
		lbl_dynamic.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_dynamic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_dynamic.setBounds(10, 11, 414, 17);
		contentPane.add(lbl_dynamic);

		// Button 1
		btn_1 = new JButton("Button 1");
		btn_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_1.setBounds(10, 39, 206, 36);
		btn_1.addActionListener(buttons);
		contentPane.add(btn_1);
		
		// Button 2
		btn_2 = new JButton("Button 2");
		btn_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_2.setBounds(226, 39, 198, 36);
		btn_2.addActionListener(buttons);
		contentPane.add(btn_2);
		setVisible(true);
	}

	// Changes the label depending on the button pressed
	ActionListener buttons = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn_1) {
				lbl_dynamic.setText("You pressed the button 1");
			} else if (e.getSource() == btn_2) {
				lbl_dynamic.setText("You pressed the button 2");
			}

		}
	};

}
