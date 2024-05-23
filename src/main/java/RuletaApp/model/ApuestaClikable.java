package RuletaApp.model;

import java.awt.Point;
import java.awt.Rectangle;

public class ApuestaClikable {
	
	private final Rectangle limite;
	
	private final String[] numeros;
	
	private final TipoApuesta TipoApuesta;

	public ApuestaClikable(Rectangle limite, TipoApuesta tipoApuesta, String... numeros) {
		this.limite = limite;
		this.TipoApuesta = tipoApuesta;
		this.numeros = numeros;
	}



    public Point getPuntoMedio() {
		int x = limite.x + limite.width / 2;
		int y = limite.y + limite.height / 2;
		return new Point(x, y);
	}
	

	public Point getPoint(int position) {
		int x = limite.x + position * limite.width / 4;
		int y = limite.y + limite.height / 2;
		return new Point(x, y);
	}

	public Rectangle getLimite() {
		return limite;
	}

	public String[] getNumeros() {
		return numeros;
	}

	public TipoApuesta getTipoApuesta() {
		return TipoApuesta;
	}

}
