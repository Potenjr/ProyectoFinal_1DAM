package RuletaApp.controller;

import RuletaApp.model.FichaRuleta;
import RuletaApp.model.Jugador;
import RuletaApp.model.RuletaModelo;
import RuletaApp.model.ValorFicha;
import RuletaApp.view.RuletaFrame;
import RuletaApp.view.Texto.AñadirJugadorDialogo;
import RuletaApp.view.Texto.AñadirPanelJugador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

// Clase que maneja el evento de añadir un nuevo jugador
public class AñadirJugadorListener implements ActionListener {

	private final AñadirJugadorDialogo dialog; // Diálogo para añadir jugador
	private final RuletaFrame frame; // Marco principal de la aplicación
	private final RuletaModelo model; // Modelo de la ruleta

	// Constructor que inicializa el listener con el frame, el modelo y el diálogo
	public AñadirJugadorListener(RuletaFrame frame, RuletaModelo model, AñadirJugadorDialogo dialog) {
		this.frame = frame;
		this.model = model;
		this.dialog = dialog;
	}

	// Método que se llama cuando se produce una acción (clic en el botón "Añadir")
	@Override
	public void actionPerformed(ActionEvent evento) {
		AñadirPanelJugador panel = dialog.getAñadirPanelJugador(); // Obtener el panel de añadir jugador del diálogo
		JTextField CompraCantidad = panel.getCompraCantidad(); // Campo de texto para la cantidad de compra
		double cantidad = valueOf(CompraCantidad.getText().trim()); // Obtener y convertir la cantidad de compra

		// Verificar que la cantidad de compra sea válida
		if (cantidad == Double.MIN_VALUE) {
			CompraCantidad.setForeground(Color.RED); // Cambiar el color del texto a rojo si es inválido
			panel.getMensajeLabel().setText("La compra debe ser en € sin decimales"); // Mostrar mensaje de error
			return;
		} else {
			CompraCantidad.setForeground(Color.BLACK); // Restablecer el color del texto si es válido
			panel.getMensajeLabel().setText(" "); // Limpiar el mensaje de error
		}

		JTextField nombreCampo = panel.getCampoNombre(); // Campo de texto para el nombre del jugador
		String nombre = panel.getCampoNombre().getText().trim(); // Obtener el nombre del jugador

		// Verificar que el nombre del jugador no esté en uso
		if (model.getJugador(nombre) == null) {
			nombreCampo.setForeground(Color.BLACK); // Restablecer el color del texto si es válido
			panel.getMensajeLabel().setText(" "); // Limpiar el mensaje de error
		} else {
			nombreCampo.setForeground(Color.RED); // Cambiar el color del texto a rojo si es inválido
			panel.getMensajeLabel().setText("No puedes tener el nombre de otro jugador"); // Mostrar mensaje de error
			return;
		}

		// Obtener la ficha seleccionada del combo box
		JComboBox<FichaRuleta> FichaComboBox = panel.getImagenFichaComboBox();

		// Redondear la cantidad de compra y obtener el valor de la ficha seleccionada
		int CantidadCompra = (int) Math.round(cantidad);
		ValorFicha valorFicha = (ValorFicha) panel.getValorFichaComboBox().getSelectedItem();
		FichaRuleta FichaRuleta = (FichaRuleta) FichaComboBox.getSelectedItem();

		// Eliminar la ficha seleccionada del modelo
		model.EliminarFicha(FichaRuleta);

		// Crear un nuevo jugador con el nombre, cantidad de compra y ficha seleccionada
		Jugador jugador = new Jugador(nombre);
		jugador.compra(CantidadCompra, valorFicha);
		jugador.setFichaRuleta(FichaRuleta);
		model.addJugador(jugador); // Añadir el jugador al modelo
		frame.updatePanelJugador(); // Actualizar el panel de jugadores en el frame

		dialog.dispose(); // Cerrar el diálogo
	}

	// Método para convertir una cadena a un valor double, con manejo de excepciones
	public double valueOf(String number) {
		try {
			return Double.valueOf(number); // Convertir cadena a double
		} catch (NumberFormatException e) {
			return Double.MIN_VALUE; // Retornar un valor mínimo en caso de error
		}
	}
}