package josep.pallas.TA20.ejercicio_4;

import java.awt.EventQueue;

class Ejercicio_4_App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_4_GUI frame = new Ejercicio_4_GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
