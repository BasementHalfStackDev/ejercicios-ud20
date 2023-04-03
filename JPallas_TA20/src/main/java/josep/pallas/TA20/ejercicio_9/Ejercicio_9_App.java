package josep.pallas.TA20.ejercicio_9;

import java.awt.EventQueue;

class Ejercicio_9_App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_9_GUI frame = new Ejercicio_9_GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
