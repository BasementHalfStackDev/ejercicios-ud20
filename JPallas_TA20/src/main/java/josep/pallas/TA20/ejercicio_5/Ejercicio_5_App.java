package josep.pallas.TA20.ejercicio_5;

import java.awt.EventQueue;

class Ejercicio_5_App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_5_GUI frame = new Ejercicio_5_GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
