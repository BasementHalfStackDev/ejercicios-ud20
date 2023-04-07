package josep.pallas.TA20.ejercicio_9;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

class Ejercicio_9_GUI extends JFrame {

	private JPanel contentPane;
	private int selectedCounter;
	private JToggleButton[] selectedButtons = new JToggleButton[2];

	public Ejercicio_9_GUI() {
		
		setTitle("Pairs Game!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 4));

		JToggleButton btn0_0 = new JToggleButton("Amogus");
		btn0_0.setIcon(new ImageIcon(Ejercicio_9_GUI.class.getResource("/josep/pallas/TA20/ejercicio_9/assets/adad.png")));
		btn0_0.setSelectedIcon(new ImageIcon(Ejercicio_9_GUI.class.getResource("/josep/pallas/TA20/ejercicio_9/assets/black.png")));
		contentPane.add(btn0_0);

		JToggleButton btn0_1 = new JToggleButton("Bus");
		contentPane.add(btn0_1);

		JToggleButton btn0_2 = new JToggleButton("Isaac");
		contentPane.add(btn0_2);

		JToggleButton btn0_3 = new JToggleButton("Isaac");
		contentPane.add(btn0_3);

		JToggleButton btn1_0 = new JToggleButton("Cat");
		contentPane.add(btn1_0);

		JToggleButton btn1_1 = new JToggleButton("Java");
		contentPane.add(btn1_1);

		JToggleButton btn1_2 = new JToggleButton("Doggo");
		contentPane.add(btn1_2);

		JToggleButton btn1_3 = new JToggleButton("Amogus");
		contentPane.add(btn1_3);

		JToggleButton btn2_0 = new JToggleButton("Meme");
		contentPane.add(btn2_0);

		JToggleButton btn2_1 = new JToggleButton("EasterEgg");
		contentPane.add(btn2_1);

		JToggleButton btn2_2 = new JToggleButton("EasterEgg");
		contentPane.add(btn2_2);

		JToggleButton btn2_3 = new JToggleButton("Java");
		contentPane.add(btn2_3);

		JToggleButton btn3_0 = new JToggleButton("Bus");
		contentPane.add(btn3_0);

		JToggleButton btn3_1 = new JToggleButton("Meme");
		contentPane.add(btn3_1);

		JToggleButton btn3_2 = new JToggleButton("Cat");
		contentPane.add(btn3_2);

		JToggleButton btn3_3 = new JToggleButton("Doggo");
		contentPane.add(btn3_3);
		
		addActionListenerToButtons();

		setVisible(true);
	}

	ActionListener btns = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			JToggleButton btn1 = (JToggleButton) e.getSource();
			btn1.setSelected(true);

			if (checkPairs()) {
				getPairs();
				calculate();
			}

		}

	};

	private boolean checkPairs() {
		selectedCounter = 0;
		for (Component c : contentPane.getComponents()) {
			if (c instanceof JToggleButton) {
				JToggleButton button = (JToggleButton) c;
				if (button.isSelected() && button.isEnabled()) {
					selectedCounter++;
				}
			}
		}

		if (selectedCounter == 2) {
			selectedCounter = 0;
			return true;
		} else {
			selectedCounter = 0;
			return false;
		}
	}

	private void getPairs() {
		int i = 0;
		for (Component c : contentPane.getComponents()) {
			if (c instanceof JToggleButton) {
				JToggleButton button = (JToggleButton) c;
				if (button.isSelected() && button.isEnabled()) {
					selectedButtons[i] = button;
					i++;
				}
			}
		}
	}

	private void calculate() {
		if (selectedButtons[0].getText().equals(selectedButtons[1].getText())) {
			selectedButtons[0].setEnabled(false);
			selectedButtons[1].setEnabled(false);
		} else {
			selectedButtons[0].setSelected(false);
			selectedButtons[1].setSelected(false);
		}
	}
	
	private void addActionListenerToButtons(){
		for (Component c : contentPane.getComponents()) {
			if (c instanceof JToggleButton) {
				JToggleButton button = (JToggleButton) c;
				button.addActionListener(btns);
			}
		}
	}

}
