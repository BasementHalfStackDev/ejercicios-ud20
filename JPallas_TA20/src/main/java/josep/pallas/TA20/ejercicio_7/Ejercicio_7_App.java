package josep.pallas.TA20.ejercicio_7;

import java.awt.EventQueue;

class Ejercicio_7_App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_7_GUI frame = new Ejercicio_7_GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
