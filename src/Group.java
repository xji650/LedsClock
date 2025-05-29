/*
 * Autors:
 * -Xiaolong Ji
 * -Aticor
 */

import acm.graphics.GCanvas;
class Group {
	private Bar[] bars;

	/*
	 * Construeix un grup a la caixa indicada per groupBox, formada per
	 * tantes barres com elements tingui l'arrelament. L'arrelament sizes
	 * conté el nombre de leds que tenen cadascuna de les barres.
	 *
	 * Les barres estan disposades, una damunt l'altra, verticalment.
	 * L'ordre dels sizes es correspon a les mides de les barres de
	 * dalt cap avall.
	 */
	public Group (int[] sizes, Box groupBox) {
		assert groupBox != null; //Assegura que groupBox no estigui buit
		assert sizes.length > 0; //Assegura que l'array de la mida sigui positiu

		//DECLARACIONS
		bars = new Bar[sizes.length];//Crear una instància bars de l'array de l'objecte Bar.

		//INSTRUCCIONS
		//Bucle que distribueix groupBox en size files i es crea l'objecte barBox a sobre
		for (int i = 0; i < sizes.length; i++) {
			//barBox guardar el resultat de groupBox distribuïda en size files
			Box[] barBox = groupBox.distributeVertically(sizes.length);
			//crea bars sobre barBox de size files i ho guarda dins array
			bars[i] = new Bar(sizes[i], barBox[i]);
		}
	}

	// Afegeix totes les barres que formen el grup al canvas gCanvas
	public void addToGCanvas (GCanvas gCanvas) {
		assert gCanvas != null; //Assegura que gCanvas no és buit
		//INSTRUCCIONS
		//Bucle que afegeix les leds a gCanvas
		for (int i = 0; i < bars.length; i++) {
			bars[i].addToGCanvas(gCanvas); //Mètode afegir l'objecte a gCanvas
		}
	}

	/*
	 * Mostra, en cadascuna de les barres del grup, el valor
	 * corresponent de l'array values.
	 *
	 * L'ordre dels elements al vector values és de baix cap
	 * amunt. D'aquesta manera, si volem mostrar el valor d'un número a
	 * partir de les seves xifres, la xifra corresponent a les unitats
	 * estarà en la posició 0 del vector values.
	 */
	public void render (int[] values) {
		assert values.length == bars.length;
		//INSTRUCCIONS
		//Bucle
		for (int i = 0; i < bars.length; i++) {
			int var = i + 1;
			int idx = bars.length - var; //idx pot donar 0 o 1
			bars[i].render(values[idx]);
		}

	}
}