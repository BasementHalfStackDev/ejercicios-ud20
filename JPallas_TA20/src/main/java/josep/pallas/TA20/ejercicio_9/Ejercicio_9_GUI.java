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
	private ImageIcon isaac = new ImageIcon(
			Ejercicio_9_GUI.class.getResource("/josep/pallas/TA20/ejercicio_9/assets/isaac.png"));
	private ImageIcon amogus = new ImageIcon(
			Ejercicio_9_GUI.class.getResource("/josep/pallas/TA20/ejercicio_9/assets/AMOGUS.png"));
	private ImageIcon cat = new ImageIcon(
			Ejercicio_9_GUI.class.getResource("/josep/pallas/TA20/ejercicio_9/assets/cattoo.png"));
	private ImageIcon dog = new ImageIcon(
			Ejercicio_9_GUI.class.getResource("/josep/pallas/TA20/ejercicio_9/assets/doggo.png"));
	private ImageIcon kirbo = new ImageIcon(
			Ejercicio_9_GUI.class.getResource("/josep/pallas/TA20/ejercicio_9/assets/kirbyyyy.png"));
	private ImageIcon java = new ImageIcon(
			Ejercicio_9_GUI.class.getResource("/josep/pallas/TA20/ejercicio_9/assets/java.png"));
	private ImageIcon easterEgg = new ImageIcon(
			Ejercicio_9_GUI.class.getResource("/josep/pallas/TA20/ejercicio_9/assets/eggs.png"));
	private ImageIcon tmbs = new ImageIcon(
			Ejercicio_9_GUI.class.getResource("/josep/pallas/TA20/ejercicio_9/assets/tmbs.png"));

	public Ejercicio_9_GUI() {

		setTitle("Pairs Game!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 4));

		JToggleButton btn0_0 = new JToggleButton();
		btn0_0.setSelectedIcon(cat);
		contentPane.add(btn0_0);

		JToggleButton btn0_1 = new JToggleButton();
		btn0_1.setSelectedIcon(dog);
		contentPane.add(btn0_1);

		JToggleButton btn0_2 = new JToggleButton();
		btn0_2.setSelectedIcon(amogus);
		contentPane.add(btn0_2);

		JToggleButton btn0_3 = new JToggleButton();
		btn0_3.setSelectedIcon(easterEgg);
		contentPane.add(btn0_3);

		JToggleButton btn1_0 = new JToggleButton();
		btn1_0.setSelectedIcon(kirbo);
		contentPane.add(btn1_0);

		JToggleButton btn1_1 = new JToggleButton();
		btn1_1.setSelectedIcon(tmbs);
		contentPane.add(btn1_1);

		JToggleButton btn1_2 = new JToggleButton();
		btn1_2.setSelectedIcon(java);
		contentPane.add(btn1_2);

		JToggleButton btn1_3 = new JToggleButton();
		btn1_3.setSelectedIcon(isaac);
		contentPane.add(btn1_3);

		JToggleButton btn2_0 = new JToggleButton();
		btn2_0.setSelectedIcon(cat);
		contentPane.add(btn2_0);

		JToggleButton btn2_1 = new JToggleButton();
		btn2_1.setSelectedIcon(java);
		contentPane.add(btn2_1);

		JToggleButton btn2_2 = new JToggleButton();
		btn2_2.setSelectedIcon(amogus);
		contentPane.add(btn2_2);

		JToggleButton btn2_3 = new JToggleButton();
		btn2_3.setSelectedIcon(easterEgg);
		contentPane.add(btn2_3);

		JToggleButton btn3_0 = new JToggleButton();
		btn3_0.setSelectedIcon(dog);
		contentPane.add(btn3_0);

		JToggleButton btn3_1 = new JToggleButton();
		btn3_1.setSelectedIcon(kirbo);
		contentPane.add(btn3_1);

		JToggleButton btn3_2 = new JToggleButton();
		btn3_2.setSelectedIcon(tmbs);
		contentPane.add(btn3_2);

		JToggleButton btn3_3 = new JToggleButton();
		btn3_3.setSelectedIcon(isaac);
		contentPane.add(btn3_3);

		initialiseButtons();

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
		if (selectedButtons[0].getSelectedIcon().equals(selectedButtons[1].getSelectedIcon())) {
			selectedButtons[0].setEnabled(false);
			selectedButtons[1].setEnabled(false);
		} else {
			// Sleep for 1 second to show selected pairs
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			selectedButtons[0].setSelected(false);
			selectedButtons[1].setSelected(false);
		}
	}

	private void initialiseButtons() {
		for (Component c : contentPane.getComponents()) {
			if (c instanceof JToggleButton) {
				JToggleButton button = (JToggleButton) c;
				button.setIcon(new ImageIcon(
						Ejercicio_9_GUI.class.getResource("/josep/pallas/TA20/ejercicio_9/assets/QuestionMark.png")));
				button.addActionListener(btns);
			}
		}
	}

}
