package josep.pallas.TA20.ejercicio_4;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

class Ejercicio_4_GUI extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea_log;
	private int previousState; // Variable to keep track of window state changes

	public Ejercicio_4_GUI() {
		this.addComponentListener(windowAttributes); // Logs window size/position...
		this.addWindowStateListener(windowStatus); // Logs window status

		setTitle("Ejercicio 4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Event log title
		JLabel lbl_log = new JLabel("Event log");
		lbl_log.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_log.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lbl_log, BorderLayout.NORTH);

		// Text area displaying log
		textArea_log = new JTextArea();
		textArea_log.setEditable(false);
		textArea_log.addKeyListener(keyPress); // Logs keys pressed by user
		contentPane.add(textArea_log, BorderLayout.CENTER);
		getContentPane().add(new JScrollPane(textArea_log)); // Scroll bar to text area
		setVisible(true);

	}

	// Component adapter that logs window resizing, moving and hiding/restoring
	// events
	ComponentAdapter windowAttributes = new ComponentAdapter() {
		public void componentResized(ComponentEvent e) {
			textArea_log.append("Window resized to " + getSize().width + "x" + getSize().height + "\n");
		}

		public void componentMoved(ComponentEvent e) {
			textArea_log.append("Window moved to " + getLocation().x + "," + getLocation().y + "\n");
		}

		public void componentHidden(ComponentEvent e) {
			textArea_log.append("Window hidden" + "\n");
		}

		public void componentShown(ComponentEvent e) {
			textArea_log.append("Window restored from hidden" + "\n");
		}
	};

	// Window state listener, logging when the window gets minimised,
	// restored or maximized
	WindowStateListener windowStatus = new WindowStateListener() {
		public void windowStateChanged(WindowEvent e) {
			int newState = e.getNewState();
			if (newState == Frame.ICONIFIED) {
				textArea_log.append("Window minimised" + "\n");
			}

			// Displays a different message depending on previous state
			// (minimised/maximised)
			if (newState == Frame.NORMAL && previousState == Frame.ICONIFIED) {
				textArea_log.append("Window restored from minimised" + "\n");
			} else if (newState == Frame.NORMAL && previousState == Frame.MAXIMIZED_BOTH) {
				textArea_log.append("Window restored from maximized");
			}

			if (e.getNewState() == Frame.MAXIMIZED_BOTH) {
				textArea_log.append("Window maximized" + "\n");
			}

			previousState = newState;

		}
	};

	// Key adapter that logs the keys pressed by the user
	KeyAdapter keyPress = new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			textArea_log.append("Key pressed: " + e.getKeyChar() + "\n");
		}
	};
}
