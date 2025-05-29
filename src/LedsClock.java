/*
 * Autors:
 * -Xiaolong Ji
 * -Aticor
 */

import acm.graphics.GCanvas;
class LedsClock {
	//Declara la referència a l'objecte Group
	private Group hoursGrup, minutsGrup,secondsGrup;

	/*
	 * Construeix un rellotge que fa servir tres grups de barres de leds per
	 * indicar hores, minuts i segons i el col·loca a la caixa indicada
	 * per ledBox.
	 */
	public LedsClock (Box ledBox) {
		assert ledBox != null; //Assegura que ledBox no sigui buit

		//DECLARACIONS
		//Variables d'amplada i altura del grup
		double groupWidth,groupHeight;
		//Declara la referència a l'objecte Box
		Box hoursBox, minutesBox,secondsBox;
		//Mida de cada grup
		//Primer grup format per 2 barres de 3 i 10 leds respectivament
		int[] hoursSizes = {3, 10};
		//Segon grup format per 2 barres de 6 i 10 leds respectivament
		int[] minutesSizes = {6, 10};
		//Tercer grup format per 2 barres de 6 i 10 leds respectivament
		int[] secondsSizes = {6, 10};

		//INSTRUCCIONS
		//Amplada de cada grup
		groupWidth = ledBox.getWidth();
		//Alçada de cada
		groupHeight = ledBox.getHeight()/3;
		//Assignació d'objectes Box
		hoursBox = new Box(ledBox.getX(),
				ledBox.getY(),
				groupWidth,
				groupHeight);
		minutesBox = new Box(ledBox.getX(),
				hoursBox.getY() + groupHeight,
				groupWidth,
				groupHeight);
		secondsBox = new Box(ledBox.getX(),
				minutesBox.getY() + groupHeight,
				groupWidth,
				groupHeight);
		//Assignació d'objectes Group
		hoursGrup 	= new Group(hoursSizes, hoursBox);
		minutsGrup 	= new Group(minutesSizes, minutesBox);
		secondsGrup = new Group(secondsSizes, secondsBox);
	}

	// Afegeix els grups de barres de leds al canvas gCanvas.
	public void addToGCanvas (GCanvas gCanvas) {
		assert gCanvas !=null; //Assegura que gCanvas no és buit
		//INSTRUCCIONS
		//Afegeix els grups a gCanvas
		hoursGrup.addToGCanvas(gCanvas);
		minutsGrup.addToGCanvas(gCanvas);
		secondsGrup.addToGCanvas(gCanvas);
	}

	// Mostra l'hora indicada
	public void render (int hours, int minutes, int seconds) {
		//Assegura que compleixen aquestes condicions
		assert 0 <= hours   &&   hours <= 23;
		assert 0 <= minutes && minutes <= 59;
		assert 0 <= seconds && seconds <= 59;
		//DECLARACIONS
		int[] hora,minuto,segundo;

		//INSTRUCCIONS
		hora = new int[] {hours % 10, hours/10};
		minuto = new int[] {minutes % 10, minutes/10};
		segundo = new int[] {seconds % 10, seconds/10};

		hoursGrup.render(hora);
		minutsGrup.render(minuto);
		secondsGrup.render(segundo);
	}
}