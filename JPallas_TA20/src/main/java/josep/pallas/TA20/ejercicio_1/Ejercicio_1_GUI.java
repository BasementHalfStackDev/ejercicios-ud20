package josep.pallas.TA20.ejercicio_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_1_GUI extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_text;
	private JButton btn_minus;
	private JButton btn_plus;

	public Ejercicio_1_GUI() {
		setTitle("Ejercicio 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Text label
		lbl_text = new JLabel("Hello! You can resize this text");
		lbl_text.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_text.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl_text, BorderLayout.CENTER);

		// Buttons to control the text label size
		btn_minus = new JButton("-");
		btn_minus.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_minus.addActionListener(buttons);
		contentPane.add(btn_minus, BorderLayout.WEST);

		btn_plus = new JButton("+");
		btn_plus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_plus.addActionListener(buttons);
		contentPane.add(btn_plus, BorderLayout.EAST);

		setVisible(true);
	}

	// Listener that increases or decreases the label text size depending on the button
	// To a max size of 100 or min of 1
	ActionListener buttons = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int fontsize = lbl_text.getFont().getSize();
			if (e.getSource() == btn_minus && fontsize > 1) {
				lbl_text.setFont(new Font("Tahoma", Font.PLAIN, fontsize - 1));
			} else if (e.getSource()== btn_plus && fontsize < 100) {
				lbl_text.setFont(new Font("Tahoma", Font.PLAIN, fontsize + 1));
			}

		}
	};

}
