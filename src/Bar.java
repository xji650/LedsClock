/*
 * Autors:
 * -Xiaolong Ji
 * -Aticor
 */

import acm.graphics.GCanvas;

class Bar {
	private int size; //Nombre de leds en la barra
	private Led[] leds;//Array de leds on guarda leds (conjunt de leds == bar)

	/*
	 * Construeix una barra a la caixa indicada per barBox, formada per
	 * size leds de la mateixa mida col·locats horitzontalment
	 */
	public Bar(int size, Box barBox) {
		assert barBox != null; //Assegura que barBox no estigui buit
		assert size > 0; //Assegura que la mida és més gran que 0
		this.size = size;

		//DECLARACIONS
		leds = new Led[size];//Crear una instància leds de l'array de l'objecte Led.

		//INSTRUCCIONS
		//Bucle que distribueix barBox en size columnes i es crea l'objecte ledBox a sobre
		for (int i = 0; i < size; i++) {
			//ledBox guardar el resultat de barBox distribuïda en size columnes
			Box[] ledBox=barBox.distributeHorizontally(size);
			//crea leds sobre ledBox de size columnes i ho guarda dins array
			leds[i] = new Led(ledBox[i]);
		}
	}

	// Afegeix tots els leds que formen la barra al canvas gCanvas
	public void addToGCanvas(GCanvas gCanvas) {
		assert gCanvas != null;
		//INSTRUCCIONS
		//Bucle que afegeix les leds a gCanvas
		for (int i = 0; i < leds.length; i++) {
			leds[i].addToGCanvas(gCanvas); //Mètode afegir l'objecte a gCanvas
		}
	}

	/*
	 * Il·lumina el led indicat per value a la barra, comptant des de 0
	 * d'esquerra a dreta.
	 */
	public void render(int value) {
		assert value == size;
		//INSTRUCCIONS
		//Bucle
		for (int i =0; i < size; i++) {
			if (i==value) {
				leds[i].on();
			}
			else {
				leds[i].off();
			}
		}
	}

}
