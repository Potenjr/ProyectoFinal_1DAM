package RuletaApp.model;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
	
	private final List<Apuesta> Apuesta;
	
	public Ronda() {
		this.Apuesta = new ArrayList<>();
	}
	
	public List<Apuesta> getApuesta() {
		return Apuesta;
	}
	
	public List<Apuesta> getApuestaGanadora(String numero) {
		List<Apuesta> ganadores = new ArrayList<>();
		for (Apuesta apuesta : Apuesta) {
			if (apuesta.isGanador(numero)) {
				apuesta.setEsApuestaGanadora(true);
				ganadores.add(apuesta);
			}
		}
		
		return ganadores;
	}

	public void addApuesta(Apuesta apuesta) {
		Jugador jugador = apuesta.getJugador();
		for (Apuesta anteriorApuesta : Apuesta) {
			Jugador apostador = anteriorApuesta.getJugador();
			if (jugador.getNombre().equals(apostador.getNombre())) {
				if (anteriorApuesta.EsMismaApuesta(apuesta)) {
					anteriorApuesta.incrementarContadorFichas(apuesta.getContadorFichas());
					return;
				}
			}
		}
		
		this.Apuesta.add(apuesta);
	}
	
	public void limpiarApuesta() {
		for (Apuesta apuesta : Apuesta) {
			Jugador jugador = apuesta.getJugador();
			int contadorFichas = apuesta.getContadorFichas();
			jugador.EliminarFicha(contadorFichas);
		}
		
		for (int i = Apuesta.size() - 1; i >= 0; i--) {
			Apuesta apuesta = Apuesta.get(i);
			if (apuesta.isEsApuestaGanadora()) {
				apuesta.setEsApuestaGanadora(false);
			} else {
				Apuesta.remove(i);
			}
		}
	}
	
	public List<Apuesta> getApuesta(Jugador jugador) {
		List<Apuesta> Apostadores = new ArrayList<>();
		for (Apuesta apuesta : Apuesta) {
			if (apuesta.getJugador().getNombre().equals(jugador.getNombre())) {
				Apostadores.add(apuesta);
			}
		}
		
		return Apostadores;
	}

}
