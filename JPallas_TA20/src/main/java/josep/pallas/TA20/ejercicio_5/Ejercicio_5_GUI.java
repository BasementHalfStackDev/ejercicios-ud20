package josep.pallas.TA20.ejercicio_5;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

class Ejercicio_5_GUI extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea_log;
	private JButton btnClear;

	public Ejercicio_5_GUI() {
		setTitle("Ejercicio 5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.addActionListener(buttonAction);
		contentPane.add(btnClear, BorderLayout.NORTH);

		textArea_log = new JTextArea();
		textArea_log.setEditable(false);
		textArea_log.addMouseListener(mouseListen);
		contentPane.add(textArea_log, BorderLayout.CENTER);
		getContentPane().add(new JScrollPane(textArea_log)); // Scroll bar to text area
		setVisible(true);

		setVisible(true);
	}

	ActionListener buttonAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			textArea_log.setText("");
		}
	};

	MouseListener mouseListen = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
			textArea_log.append("Mouse clicked\n");
		}

		public void mousePressed(MouseEvent e) {
			textArea_log.append("Mouse pressed\n");
		}

		public void mouseReleased(MouseEvent e) {
			textArea_log.append("Mouse released\n");
		}

		public void mouseEntered(MouseEvent e) {
			textArea_log.append("Mouse entered the area\n");
		}

		public void mouseExited(MouseEvent e) {
			textArea_log.append("Mouse exited the area\n");
		}
	};

}
