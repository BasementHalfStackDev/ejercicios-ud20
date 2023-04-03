package josep.pallas.TA20.ejercicio_3;

import java.awt.EventQueue;

class Ejercicio_3_App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_3_GUI frame = new Ejercicio_3_GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
