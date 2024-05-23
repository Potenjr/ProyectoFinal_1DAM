package RuletaApp.view.Texto;

import RuletaApp.controller.AñadirJugadorListener;
import RuletaApp.model.RuletaModelo;
import RuletaApp.view.RuletaFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;



public class AñadirJugadorDialogo extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final AñadirPanelJugador AñadirPanelJugador;
	
	public AñadirJugadorDialogo(RuletaFrame frame, RuletaModelo modelo, String titulo) {
		super(frame.getFrame(), true);
		this.AñadirPanelJugador = new AñadirPanelJugador(modelo);
		setTitle(titulo);
		add(createPanelPrincipal(frame, modelo), BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(frame.getFrame());
		setVisible(true);
	}
	
	private JPanel createPanelPrincipal(RuletaFrame frame, RuletaModelo modelo) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(AñadirPanelJugador.getPanel(), BorderLayout.CENTER);
		
		JPanel PanelInterno = new JPanel();
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new AñadirJugadorListener(frame, modelo, this));
		PanelInterno.add(okButton);
		
		JButton boton = new JButton("Cancelar");
		boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
		PanelInterno.add(boton);
		
		okButton.setPreferredSize(boton.getPreferredSize());
		
		panel.add(PanelInterno, BorderLayout.AFTER_LAST_LINE);
		
		return panel;
	}

	public AñadirPanelJugador getAñadirPanelJugador() {
		return AñadirPanelJugador;
	}

}
