package josep.pallas.TA20.ejercicio_4;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

class Ejercicio_4_GUI extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea_log;

	public Ejercicio_4_GUI() {
		setTitle("Ejercicio 4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lbl_log = new JLabel("Event log");
		lbl_log.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_log.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lbl_log, BorderLayout.NORTH);

		textArea_log = new JTextArea();
		textArea_log.setEditable(false);
		textArea_log.addComponentListener(compLog);
		contentPane.add(textArea_log, BorderLayout.CENTER);
		setVisible(true);

	}

	ComponentAdapter compLog = new ComponentAdapter() {
		public void componentResized(ComponentEvent e) {
			textArea_log.append("Window resized to " + getSize().width + "x" + getSize().height + "\n");
		}

		public void componentMoved(ComponentEvent e) {
			textArea_log.append("Window moved to " + getLocation().x + "," + getLocation().y + "\n");
		}

		public void componentHidden(ComponentEvent e) {
			textArea_log.append("Window minimized" + "\n");
		}

		public void componentShown(ComponentEvent e) {
			textArea_log.append("Window restored from minimized" + "\n");
		}
	};
}
