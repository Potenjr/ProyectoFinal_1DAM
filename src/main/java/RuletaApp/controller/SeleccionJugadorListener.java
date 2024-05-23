package RuletaApp.controller;

import RuletaApp.model.Jugador;
import RuletaApp.model.RuletaModelo;
import RuletaApp.view.RuletaFrame;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class SeleccionJugadorListener implements ListSelectionListener {
	
	private final RuletaFrame frame;
	
	private final RuletaModelo model;
	
	public SeleccionJugadorListener(RuletaFrame frame, RuletaModelo model) {
		this.frame = frame;
		this.model = model;
	}

	@Override
	public void valueChanged(ListSelectionEvent evento) {
		ListSelectionModel lsm = (ListSelectionModel) evento.getSource();
		JTable table = frame.getTablaJugador();
		if (!evento.getValueIsAdjusting()) {
			int row = lsm.getMinSelectionIndex();
			if (table.isRowSelected(row)) {
				String nombre = (String) table.getValueAt(row, 0);
				Jugador jugador = model.getJugador(nombre);
				model.setJugadorSeleccionado(jugador);
			} else {
				model.setJugadorSeleccionado(null);
			}
		}
	}

}
