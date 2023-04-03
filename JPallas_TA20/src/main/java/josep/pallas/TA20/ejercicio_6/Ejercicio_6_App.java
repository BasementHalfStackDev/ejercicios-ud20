package josep.pallas.TA20.ejercicio_6;

import java.awt.EventQueue;

class Ejercicio_6_App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_6_GUI frame = new Ejercicio_6_GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
