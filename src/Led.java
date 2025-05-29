/*
 * Autors:
 * -Xiaolong Ji
 * -Aticor
 */
import acm.graphics.GCanvas;
import acm.graphics.GRect;
import java.awt.Color;

class Led {

	private static final double PADDING = 0.1;
	private final GRect rect;

	public Led (Box ledBox) {
		assert ledBox != null;

		Box rectBox = ledBox.withPadding (Padding.regular(PADDING));
		rect = new GRect (rectBox.getX(),
								rectBox.getY(),
								rectBox.getWidth(),
								rectBox.getHeight());
		rect.setColor (Color.YELLOW);
		rect.setFilled (true);
		rect.setFillColor (Color.BLACK);
	}
	public void addToGCanvas (GCanvas gCanvas) {
		assert gCanvas != null; //assegura gCanvas no és null (assert, assegura), si no és així no funciona
		gCanvas.add (rect);
	}
	public void on() {
		rect.setFillColor (Color.RED);
	}

	public void off() {
		rect.setFillColor (Color.BLACK);
	}

}
