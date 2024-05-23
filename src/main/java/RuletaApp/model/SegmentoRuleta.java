package RuletaApp.model;

import java.awt.Color;
import java.awt.Point;

public class SegmentoRuleta {
	
	private final Color colorFondo;
	
	private final Point Delta;
	
	private final String NumeroRuleta;

	public SegmentoRuleta(String NumeroRuleta, Color colorFondo, Point Delta) {
		this.NumeroRuleta = NumeroRuleta;
		this.colorFondo = colorFondo;
		this.Delta = Delta;
	}

	public Color getColorFondo() {
		return colorFondo;
	}

	public Point getDelta() {
		return Delta;
	}

	public String getNumeroRuleta() {
		return NumeroRuleta;
	}

}
