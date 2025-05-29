/*
 * Autors:
 * -Xiaolong Ji
 * -Aticor
 */
public class Box {

	private final double x;
	private final double y;
	private final double width;
	private final double height;

	public Box (double x, double y, double width, double height) {
		assert 0 <= x;
		assert 0 <= y;
		assert 0 <= width;
		assert 0 <= height;

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public Box withPadding (Padding padding) {
		double top    = height * padding.getTop();
		double right  = width  * padding.getRight();
		double bottom = height * padding.getBottom();
		double left   = width  * padding.getLeft();
		return new Box (x + left,
							 y + top,
							 width  - left - right,
							 height - top  - bottom);
	}

	/*
	 * Distribueix de forma uniforme l'espai indicat a la caixa
	 * (Box) de l'objecte receptor en tantes caixes com el numColumns.
	 *
	 * Les caixes resultants estan col·locades horitzontalment de forma
     * contigua. Es retorna el vector de referències a aquestes caixes.
     *
     * No cal tenir en compte el marge, ja que l'objecte Led ja duu marge.
	 */

	public Box[] distributeHorizontally (int numColumns) {
		assert numColumns > 0; //Assegura que numColumns és positiu

		// DECLARACIONS
		Box[] boxes = new Box[numColumns]; //Array de caixes de numColumns posicions
		double width = this.getWidth()/numColumns; //Amplada de cada columna
		double x; //Punt x de la figura

		//INSTRUCCIONS
		//Bucle
		for (int i = 0; i < numColumns; i++) {
			//Trobar les posicions de tots els punts X de les columnes dividits
			/*
			 * Sigui n = numColumns
			 * Si n = 1 col, X és X actual
			 * Si n = 2 col, X és X actual + amplada de la figura/2
			 * Si n = 3 col, X és X actual + amplada de la figura/3 + amplada de la figura/3
			 *				 X és X actual + 2 * (amplada de la figura/3)
			 * Si n col, X es X actual + (n-1) * (amplada de la figura/n)
			 */
			x = this.getX() + i * width; //i = numColumns - 1

			//Crea la figura i ho guarda en un array
			boxes[i] = new Box(x, this.getY(), width, this.getHeight());
		}
		return boxes;
	}

    /*
     * Distribueix de forma uniforme l'espai indicat a la caixa
	 * (Box) de l'objecte receptor en tantes caixes com el numRows.
	 *
	 * Les caixes resultants estan col·locades verticalment de forma
	 * contigua. Es retorna el vector de referències a aquestes caixes.
	 *
	 * No cal tenir en compte el marge, ja que l'objecte Led ja duu marge.
	 */
	public Box[] distributeVertically (int numRows) {
		assert numRows > 0; //Assegura que numRows sigui positiu

		//DECLARACIONS
		Box[] boxes = new Box[numRows]; //Array de caixes de numRows posicions
		double height = this.getHeight()/numRows; //Amplada de cada columna
		double y; //Punt y de la figura

		//INSTRUCCIONS
		/*
		 * Bucle que trobar les posicions de tots els punts y de les files dividits
		 * i crea les noves figura i ho guarden en un array.
		 */
		for (int i = 0; i < numRows; i++) {
			y = this.getY() + i * height;
			//Crea la figura i ho guarda en un array
			boxes[i] = new Box(this.getX(), y, this.getWidth(),height );
		}
		return boxes;
	}


}
