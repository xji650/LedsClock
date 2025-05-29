/*
 * Autors:
 * -Xiaolong Ji
 * -Aticor
 */
import acm.program.GraphicsProgram;
import java.awt.Color;

public class Step2 extends GraphicsProgram {
	private static final int BAR_SIZE = 4; //Constant mida de barres
	private static final double TIMEOUT = 1000.0; //Constant de temps = 1s

	public void run() {
		//Mètode que oculta la barra de menú que hi ha a dalt de la finestra.
		getMenuBar().setVisible (false);
		//Canviar color del fons.
		setBackground (Color.BLACK);
		//Crear una instància ledBox de l'objecte Box.
		Box ledsBox = new Box (0.0, 0.0, getWidth(), getHeight());
		//Crear una instància leds de l'objecte Bar.
		Bar leds = new Bar (BAR_SIZE, ledsBox);
		//Afegir la instància leds a la pantalla
		leds.addToGCanvas (getGCanvas());
		/*
		 * Apaga i encén la llum amb durada de cada cop TIMEOUTS
		 * temps en cada una de les barres successivament.
		 */
		for (;;) {
			for (int i = 0; i < BAR_SIZE; i++) {
				leds.render(i); //Apaga i encén la llum amb durada de cada cop TIMEOUTS temps
				pause (TIMEOUT);
			}
		}
	}

}
