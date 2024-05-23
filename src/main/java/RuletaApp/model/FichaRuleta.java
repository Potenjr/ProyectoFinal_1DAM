package RuletaApp.model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import RuletaApp.view.ImagenFicha;


public class FichaRuleta {
	
	private final BufferedImage ImagenFicha;
	
	private final Color ColorFicha;
	private final Color ColorResaltado;
	
	public FichaRuleta(Color colorFicha, Color ColorResaltado) {
		this.ColorFicha = colorFicha;
		this.ColorResaltado = ColorResaltado;
		this.ImagenFicha = new ImagenFicha(colorFicha, ColorResaltado).getImagenFicha();
	}

	public BufferedImage getImagenFicha() {
		return ImagenFicha;
	}

	public Color getColorFicha() {
		return ColorFicha;
	}

	public Color getColorResaltado() {
		return ColorResaltado;
	}

}
