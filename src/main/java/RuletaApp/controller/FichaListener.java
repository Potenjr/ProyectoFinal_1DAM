package RuletaApp.controller;

import RuletaApp.model.Apuesta;
import RuletaApp.model.ApuestaClikable;
import RuletaApp.model.Jugador;
import RuletaApp.model.RuletaModelo;
import RuletaApp.view.RuletaFrame;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

// Clase que gestiona las interacciones del mouse para realizar apuestas
public class FichaListener extends MouseAdapter {

	private final RuletaFrame frame; // Marco principal de la aplicación
	private final RuletaModelo model; // Modelo de la ruleta

	// Constructor que inicializa el listener con el frame y el modelo
	public FichaListener(RuletaFrame frame, RuletaModelo model) {
		this.frame = frame;
		this.model = model;
	}

	// Método que se llama cuando se suelta el botón del mouse
	@Override
	public void mouseReleased(MouseEvent event) {
		Jugador player = model.getEleccionJugador();
		if (player == null) {
			return;
		}
		Point point = event.getPoint();

		if (MouseEvent.BUTTON1 == event.getButton()) {
			addApuesta(player, point); // Agregar apuesta con el botón izquierdo del mouse
		} else if (MouseEvent.BUTTON3 == event.getButton()) {
			eliminarApuesta(player, point); // Eliminar apuesta con el botón derecho del mouse
		}
	}

	// Método para agregar una apuesta en la posición indicada
	public void addApuesta(Jugador jugador, Point point) {
		ApuestaClikable apuestaClikable = model.contieneApuestaClikable(point);
		if (apuestaClikable != null) {
			Apuesta apuesta = new Apuesta(apuestaClikable.getPuntoMedio(), jugador,
					apuestaClikable.getTipoApuesta(), apuestaClikable.getNumeros());
			apuesta.ponerCantidadApuesta(1, jugador.getValorFicha());
			model.addApuesta(apuesta);
			frame.rehacerTabladeApuestas(); // Actualizar la tabla de apuestas en el marco principal
		}
	}

	// Método para eliminar una apuesta en la posición indicada
	public void eliminarApuesta(Jugador jugador, Point point) {
		ApuestaClikable apuestaClikable = model.contieneApuestaClikable(point);
		if (apuestaClikable != null) {
			Point centerPoint = apuestaClikable.getPuntoMedio();
			List<Apuesta> apuestas = model.getApuesta();
			for (int index = apuestas.size() - 1; index >= 0; index--) {
				Apuesta apuesta = apuestas.get(index);
				if (apuesta.getJugador().getNombre().equals(jugador.getNombre())
						&& apuesta.getUbicacionBoard().equals(centerPoint)) {
					if (apuesta.getContadorFichas() > 1) {
						apuesta.incrementarContadorFichas(-1); // Reducir la cantidad de fichas en la apuesta
					} else {
						apuestas.remove(index); // Eliminar la apuesta si solo tiene una ficha
					}
				}
			}
			frame.rehacerTabladeApuestas(); // Actualizar la tabla de apuestas en el marco principal
		}
	}
}