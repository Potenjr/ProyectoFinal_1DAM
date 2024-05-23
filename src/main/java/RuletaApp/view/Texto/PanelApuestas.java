package RuletaApp.view.Texto;

import RuletaApp.model.TipoApuesta;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class PanelApuestas {
	
	private final JPanel panel;

	public PanelApuestas() {
		this.panel = createPanelApuesta();
	}
	
	private JPanel createPanelApuesta() {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		Font FuenteTitulo = panel.getFont().deriveFont(Font.BOLD, 24);
		Font fuente = panel.getFont().deriveFont(Font.BOLD, 16);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 25);
		gbc.gridwidth = 2;
		gbc.weightx = 1.0;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel label = new JLabel("Apuestas");
		label.setFont(FuenteTitulo);
		panel.add(label, gbc);
		
		gbc.gridwidth = 1;
		gbc.gridy++;
		label = new JLabel("Tipo Apuesta");
		label.setFont(fuente);
		panel.add(label, gbc);
		
		gbc.gridx++;
		label = new JLabel("Apuestas");
		label.setFont(fuente);
		panel.add(label, gbc);
		
		for (TipoApuesta TipoApuesta : TipoApuesta.values()) {
			gbc.gridx = 0;
			gbc.gridy++;
			label = new JLabel(TipoApuesta.getDescripcion());
			panel.add(label, gbc);
			
			gbc.gridx++;
			String text = "" + TipoApuesta.getPago() + " a 1";
			label = new JLabel(text);
			panel.add(label, gbc);
		}
		
		return panel;
	}

	public JPanel getPanel() {
		return panel;
	}

}
