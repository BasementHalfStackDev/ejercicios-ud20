package josep.pallas.TA20.ejercicio_1;

import java.awt.EventQueue;

class Ejercicio_1_App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_1_GUI frame = new Ejercicio_1_GUI();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
