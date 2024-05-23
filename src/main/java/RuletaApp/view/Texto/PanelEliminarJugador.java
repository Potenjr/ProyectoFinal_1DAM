package RuletaApp.view.Texto;

import RuletaApp.model.RuletaModelo;
import RuletaApp.view.RuletaFrame;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class PanelEliminarJugador {
	
	private RuletaModelo modelo;
	
	private JPanel panel;
	
	private JTextField CampoNombre;
	private JTextField retirarDineroCampo;

	public PanelEliminarJugador(RuletaFrame frame, RuletaModelo modelo) {
		if (modelo.getEleccionJugador() == null) {
			String s = "Selecciona un jugador por favor.";
			JOptionPane.showMessageDialog(frame.getFrame(), s, "No se ha seleccionado jugador",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		this.modelo = modelo;
		this.panel = createPanelPrincipal();
	}
	
	private JPanel createPanelPrincipal() {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		Font FuenteTitulo = panel.getFont().deriveFont(Font.BOLD, 24);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridwidth = 2;
		gbc.weightx = 1.0;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel label = new JLabel("Retirar Dinero");
		label.setFont(FuenteTitulo);
		panel.add(label, gbc);
		
		gbc.gridwidth = 1;
		gbc.gridy++;
		label = new JLabel("Nombre: ");
		panel.add(label, gbc);
		
		gbc.gridx++;
		CampoNombre = new JTextField(20);
		CampoNombre.setEditable(false);
		CampoNombre.setText(modelo.getEleccionJugador().getNombre());
		panel.add(CampoNombre, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		label = new JLabel("Cantidad retirada:");
		panel.add(label, gbc);
		
		gbc.gridx++;
		retirarDineroCampo = new JTextField(20);
		retirarDineroCampo.setEditable(false);
		String text = "$" + String.format("%,.2f", 
				(double) modelo.getEleccionJugador().getBalance());
		retirarDineroCampo.setText(text);
		panel.add(retirarDineroCampo, gbc);
		
		return panel;
	}

	public JPanel getPanel() {
		return panel;
	}

}
