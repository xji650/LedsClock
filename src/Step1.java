/*
 * Autors:
 * -Xiaolong Ji
 * -Aticor
 */
import acm.program.GraphicsProgram;
import java.awt.Color;

public class Step1 extends GraphicsProgram {
	private static final double TIMEOUT = 1000.0; //Constant de temps = 1s

	public void run() {
		//Mètode que oculta la barra de menú que hi ha a dalt de la finestra.
		getMenuBar().setVisible (false);
		//Canviar color del fons.
		setBackground (Color.BLACK);
		//Crear una instància ledBox de l'objecte Box.
		Box ledBox = new Box (0.0, 0.0, getWidth(), getHeight());
		//Crear una instància led de l'objecte Led.
		Led led = new Led (ledBox);
		//Afegir la instància led a la pantalla que,
		led.addToGCanvas (getGCanvas());
		//Apaga i encén la llum amb durada de cada cop TIMEOUTS temps
		for (;;) {
			led.on();
			pause (TIMEOUT);
			led.off();
			pause (TIMEOUT);
		}
	}

}
