package RuletaApp.model;

public class JugadorApuestaError {
	
	private final int errorCode;
	
	private final Jugador jugador;

	public JugadorApuestaError(int errorCode, Jugador jugador) {
		this.errorCode = errorCode;
		this.jugador = jugador;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public Jugador getJugador() {
		return jugador;
	}

}
