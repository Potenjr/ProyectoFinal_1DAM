package RuletaApp.view.Texto;

import RuletaApp.model.Apuesta;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class PanelGanancias {
	
	private final JPanel panel;
	
	private final List<Apuesta> ganancias;
	
	private final String numeros;
	
	public PanelGanancias(List<Apuesta> ganancias, String numero) {
		this.ganancias = ganancias;
		this.numeros = numero;
		this.panel = createPanelPrincipal();
	}
	
	private JPanel createPanelPrincipal() {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		Font FuenteTitulo = panel.getFont().deriveFont(Font.BOLD, 24);
		Font FuenteEncabezado = panel.getFont().deriveFont(Font.BOLD, 16);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridwidth = 3;
		gbc.weightx = 1.0;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel label = new JLabel("Apuestas Ganadoras");
		label.setFont(FuenteTitulo);
		panel.add(label, gbc);
		
		gbc.gridy++;
		label = new JLabel("Numero: " + numeros);
		label.setFont(FuenteEncabezado);
		panel.add(label, gbc);
		
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy++;
		label = new JLabel("Nombre");
		label.setFont(FuenteEncabezado);
		panel.add(label, gbc);
		
		gbc.gridx++;
		label = new JLabel("Tipo Apuesta");
		label.setFont(FuenteEncabezado);
		panel.add(label, gbc);
		
		gbc.gridx++;
		label = new JLabel("Apuesta");
		label.setFont(FuenteEncabezado);
		panel.add(label, gbc);
		
		for (Apuesta Apuesta : ganancias) {
			gbc.gridx = 0;
			gbc.gridy++;
			label = new JLabel(Apuesta.getJugador().getNombre());
			panel.add(label, gbc);
			
			gbc.gridx++;
			label = new JLabel(Apuesta.getTipoApuesta().getDescripcion());
			panel.add(label, gbc);
			
			gbc.gridx++;
			String text = "" + Apuesta.getTipoApuesta().getPago() + " a 1";
			label = new JLabel(text);
			panel.add(label, gbc);
		}
		
		return panel;
	}

	public JPanel getPanel() {
		return panel;
	}

}
