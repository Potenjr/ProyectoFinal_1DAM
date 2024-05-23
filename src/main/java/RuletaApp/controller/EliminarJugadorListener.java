package RuletaApp.controller;

import RuletaApp.model.Jugador;
import RuletaApp.model.RuletaModelo;
import RuletaApp.view.RuletaFrame;
import RuletaApp.view.Texto.DialogoPanelEliminarJugador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase que maneja el evento de eliminar un jugador
public class EliminarJugadorListener implements ActionListener {

	private final RuletaFrame frame; // Marco principal de la aplicación
	private final RuletaModelo model; // Modelo de la ruleta
	private final DialogoPanelEliminarJugador dialog; // Diálogo para eliminar jugador

	// Constructor que inicializa el listener con el frame, el modelo y el diálogo
	public EliminarJugadorListener(RuletaFrame frame, RuletaModelo model,
								   DialogoPanelEliminarJugador dialog) {
		this.frame = frame;
		this.model = model;
		this.dialog = dialog;
	}

	// Método que se llama cuando se produce una acción (clic en el botón "Eliminar")
	@Override
	public void actionPerformed(ActionEvent event) {
		// Obtener el jugador seleccionado para ser eliminado
		Jugador jugador = model.getEleccionJugador();

		// Desmarcar el jugador seleccionado en el modelo
		model.setJugadorSeleccionado(null);

		// Eliminar el jugador del modelo
		model.removeJugador(jugador);

		// Actualizar el panel de jugadores en el frame
		frame.updatePanelJugador();

		// Cerrar el diálogo
		dialog.dispose();
	}
}