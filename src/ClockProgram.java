/*
 * Autors:
 * -Xiaolong Ji
 * -Aticor
 */
import java.awt.Color;
import acm.program.GraphicsProgram;

public class ClockProgram extends GraphicsProgram {

	private static final double TIMEOUT = 200.0;

	public void run() {
		getMenuBar().setVisible (false); //funció que oculta la barra de menú que hi ha a dalt de la finestra.
		setBackground (Color.BLACK);
		Box clockBox = new Box (0.0, 0.0, getWidth(), getHeight());
		LedsClock ledsClock = new LedsClock (clockBox);
		TimeTeller timeTeller = new TimeTeller();
		ledsClock.addToGCanvas (getGCanvas());
		for (;;) {
			int  hours  = timeTeller.getHours();
			int minutes = timeTeller.getMinutes();
			int seconds = timeTeller.getSeconds();
			ledsClock.render (hours, minutes, seconds);
			pause (TIMEOUT);
		}
	}

}
