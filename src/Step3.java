/*
 * Autors:
 * -Xiaolong Ji
 * -Aticor
 */
import acm.program.GraphicsProgram;
import java.awt.Color;

public class Step3 extends GraphicsProgram {

	private static final int BASE = 10; //Constant mida de barres al segon nivell
	private static final int[] SIZES = new int[] { 4, 10 }; //Array que conté números de barres
	private static final int MAX_COUNTER = 3 * BASE + BASE - 1; //Num màx comptador
	private static final double TIMEOUT = 1000.0; //Constant de temps = 1s

	public void run() {
		//Mètode que oculta la barra de menú que hi ha a dalt de la finestra.
		getMenuBar().setVisible (false);
		//Canviar color del fons.
		setBackground (Color.BLACK);
		//Crear una instància ledBox de l'objecte Box.
		Box ledBox = new Box (0.0, 0.0, getWidth(), getHeight());
		//Crear una instància ledsNum de l'objecte Grup.
		Group ledsNum = new Group (SIZES, ledBox);
		//Afegir la instància ledsNum a la pantalla
		ledsNum.addToGCanvas (getGCanvas());
		/*
		 * Apaga i encén la llum amb durada de cada cop TIMEOUTS
		 * temps en cada una de les barres successivament.
		 */
		int counter = 0; //Comptador
		for (;;) {
			//Apaga i encén la llum amb durada de cada cop TIMEOUTS temp
			//Si les barres del segon nivell arribés al final de l'array,
			//incrementa una posició a les barres del primer nivell.
			//Si les barres del primer nivell arribés al final del nivell
			//es torna a començar el programa
			ledsNum.render (new int[] { counter % BASE, counter / BASE });
			pause (TIMEOUT);
			counter += 1;
			if (counter > MAX_COUNTER) {
				counter = 0;
			}
		}
	}

}
