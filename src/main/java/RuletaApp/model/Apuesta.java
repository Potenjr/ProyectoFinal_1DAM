package RuletaApp.model;

import java.awt.Point;

public class Apuesta {
	
	private boolean EsApuestaGanadora;
	
	private int ContadorFichas;
	private int ValorFicha;
	
	private final Point UbicacionBoard;
	
	private final Jugador jugador;
	
	private final String[] numerosApostados;
	
	private final RuletaApp.model.TipoApuesta TipoApuesta;

	public Apuesta(Point ubicacionBoard, Jugador jugador, TipoApuesta tipoApuesta,
				   String... numerosApostados) {
		this.UbicacionBoard = ubicacionBoard;
		this.jugador = jugador;
		this.TipoApuesta = tipoApuesta;
		this.numerosApostados = numerosApostados;
		this.EsApuestaGanadora = false;
	}
	
	
	public boolean EsMismaApuesta(Apuesta otraApuesta) {
		return UbicacionBoard.x == otraApuesta.UbicacionBoard.x &&
				UbicacionBoard.y == otraApuesta.UbicacionBoard.y;
	}

	public void ponerCantidadApuesta(int contadorFichas, int valorFichas) {
		this.ContadorFichas = contadorFichas;
		this.ValorFicha = valorFichas;
	}
	
	public boolean isGanador(String numero) {
		for (String s : numerosApostados) {
			if (s.equals(numero)) {
				return true;
			}
		}
		
		return false;
	}

	public boolean isEsApuestaGanadora() {
		return EsApuestaGanadora;
	}

	public void setEsApuestaGanadora(boolean isApuestaGanadora) {
		this.EsApuestaGanadora = isApuestaGanadora;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void incrementarContadorFichas(int increment) {
		this.ContadorFichas += increment;
	}
	
	public int getContadorFichas() {
		return ContadorFichas;
	}

	public int getValorFicha() {
		return ValorFicha;
	}

	public Point getUbicacionBoard() {
		return UbicacionBoard;
	}

	public RuletaApp.model.TipoApuesta getTipoApuesta() {
		return TipoApuesta;
	}

}
