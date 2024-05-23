package RuletaApp.view;

import RuletaApp.controller.RuletaListener;
import RuletaApp.model.RuletaModelo;
import RuletaApp.view.Texto.AñadirJugadorDialogo;
import RuletaApp.view.Texto.DialogoApuestas;
import RuletaApp.view.Texto.DialogoPanelEliminarJugador;
import RuletaApp.view.Texto.InstruccionesDialogo;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MenuPanel {
	
	private final RuletaFrame frame;
	
	private final RuletaModelo modelo;
	
	private final JPanel panel;

	public MenuPanel(RuletaFrame frame, RuletaModelo modelo) {
		this.frame = frame;
		this.modelo = modelo;
		this.panel = createMenuPanel();
	}
	
	private JPanel createMenuPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 25, 5);
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JButton button = new JButton("Ruleta");
		button.addActionListener(new RuletaListener(frame, modelo));
		panel.add(button, gbc);
		
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridy++;
		button = new JButton("Añadir Jugador");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (modelo.getJugador().size() >= 8) {
					JOptionPane.showMessageDialog(frame.getFrame(),
						    "Como maximo tiene que haber 8 jugadores.",
						    "Maximum Players Error",
						    JOptionPane.ERROR_MESSAGE);
				} else {
					new AñadirJugadorDialogo(frame, modelo, "Añadir Jugador");
				}
			}
		});
		panel.add(button, gbc);
		
		gbc.insets = new Insets(5, 5, 25, 5);
		gbc.gridy++;
		button = new JButton("Sacar Dinero");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				new DialogoPanelEliminarJugador(frame, modelo, "Sacar Dinero");
			}
		});
		panel.add(button, gbc);
		
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridy++;
		button = new JButton("Instrucciones");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InstruccionesDialogo(frame, "Instrucciones");
			}
		});
		panel.add(button, gbc);
		
		gbc.gridy++;
		button = new JButton("Tipos de apuesta");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DialogoApuestas(frame, "Tipos de apuesta");
			}
		});
		panel.add(button, gbc);
		
		return panel;
	}

	public JPanel getPanel() {
		return panel;
	}

}
