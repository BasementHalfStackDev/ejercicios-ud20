package josep.pallas.TA20.ejercicio_8;

import java.awt.EventQueue;

class Ejercicio_8_App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_8_GUI frame = new Ejercicio_8_GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
