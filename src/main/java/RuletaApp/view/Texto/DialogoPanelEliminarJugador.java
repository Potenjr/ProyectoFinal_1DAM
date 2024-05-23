package RuletaApp.view.Texto;

import RuletaApp.controller.EliminarJugadorListener;
import RuletaApp.model.RuletaModelo;
import RuletaApp.view.RuletaFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;



public class DialogoPanelEliminarJugador extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private final PanelEliminarJugador EliminarJugador;
	
	public DialogoPanelEliminarJugador(RuletaFrame frame, RuletaModelo modelo, String titulo) {
		super(frame.getFrame(), true);
		this.EliminarJugador = new PanelEliminarJugador(frame, modelo);
		if (EliminarJugador.getPanel() == null) {
			return;
		}
		
		setTitle(titulo);
		add(createMainPanel(frame, modelo), BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(frame.getFrame());
		setVisible(true);
	}
	
	private JPanel createMainPanel(RuletaFrame frame, RuletaModelo modelo) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(EliminarJugador.getPanel(), BorderLayout.CENTER);
		
		JPanel PanelInterior = new JPanel();
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new EliminarJugadorListener(frame, modelo, this));
		PanelInterior.add(okButton);
		
		JButton boton = new JButton("Cancelar");
		boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
		PanelInterior.add(boton);
		
		okButton.setPreferredSize(boton.getPreferredSize());
		
		panel.add(PanelInterior, BorderLayout.AFTER_LAST_LINE);
		
		return panel;
	}

	public PanelEliminarJugador getEliminarJugador() {
		return EliminarJugador;
	}

}
