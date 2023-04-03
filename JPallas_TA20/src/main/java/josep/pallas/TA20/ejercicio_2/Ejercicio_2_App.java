package josep.pallas.TA20.ejercicio_2;

import java.awt.EventQueue;

class Ejercicio_2_App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_2_GUI frame = new Ejercicio_2_GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
