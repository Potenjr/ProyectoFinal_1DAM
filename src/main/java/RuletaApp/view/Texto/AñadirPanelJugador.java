package RuletaApp.view.Texto;

import RuletaApp.model.FichaRuleta;
import RuletaApp.model.RuletaModelo;
import RuletaApp.model.ValorFicha;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;


public class AñadirPanelJugador {
	
	private final RuletaModelo modelo;
	
	private final JPanel panel;
	
	private DefaultComboBoxModel<FichaRuleta> imagenComboBoxModelo;
	
	private JComboBox<ValorFicha> valorFichaJComboBox;
	private JComboBox<FichaRuleta> fichaRuletaJComboBox;
	
	private JLabel mensajeLabel;
	
	private JTextField CampoCantidad;
	private JTextField CampoNombre;

	public AñadirPanelJugador(RuletaModelo modelo) {
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
		JLabel label = new JLabel("Unir Jugador");
		label.setFont(FuenteTitulo);
		panel.add(label, gbc);
		
		gbc.gridwidth = 1;
		gbc.gridy++;
		label = new JLabel("Nombre:");
		panel.add(label, gbc);
		
		gbc.gridx++;
		CampoNombre = new JTextField(20);
		String text = "Jugador " + (modelo.getJugador().size() + 1);
		CampoNombre.setText(text);
		CampoNombre.setSelectionStart(0);
		CampoNombre.setSelectionEnd(text.length());
		panel.add(CampoNombre, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		label = new JLabel("Color de la ficha:");
		panel.add(label, gbc);
		
		gbc.gridx++;
		imagenComboBoxModelo = new DefaultComboBoxModel<>();
		imagenComboBoxModelo.addAll(modelo.getFichasRuleta().getFichasRuleta());
		fichaRuletaJComboBox = new JComboBox<>(imagenComboBoxModelo);
		fichaRuletaJComboBox.setSelectedIndex(0);
		FichaCellRenderer renderer = new FichaCellRenderer();
		fichaRuletaJComboBox.setRenderer(renderer);
		panel.add(fichaRuletaJComboBox, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		label = new JLabel("Valor Ficha:");
		panel.add(label, gbc);
		
		gbc.gridx++;
		DefaultComboBoxModel<ValorFicha> valueComboBoxModel = new DefaultComboBoxModel<>();
		valueComboBoxModel.addAll(modelo.getValorFichas().getValores());
		valorFichaJComboBox = new JComboBox<>(valueComboBoxModel);
		valorFichaJComboBox.setSelectedIndex(0);
		panel.add(valorFichaJComboBox, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		label = new JLabel("Cantidad:");
		panel.add(label, gbc);
		
		gbc.gridx++;
		CampoCantidad = new JTextField(20);
		CampoCantidad.setHorizontalAlignment(JTextField.TRAILING);
		panel.add(CampoCantidad, gbc);
		
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy++;
		mensajeLabel = new JLabel(" ");
		mensajeLabel.setForeground(Color.RED);
		panel.add(mensajeLabel, gbc);
		
		return panel;
	}

	public JPanel getPanel() {
		return panel;
	}
	
	public JComboBox<ValorFicha> getValorFichaComboBox() {
		return valorFichaJComboBox;
	}

	public JComboBox<FichaRuleta> getImagenFichaComboBox() {
		return fichaRuletaJComboBox;
	}

	public JTextField getCompraCantidad() {
		return CampoCantidad;
	}

	public JTextField getCampoNombre() {
		return CampoNombre;
	}

	public JLabel getMensajeLabel() {
		return mensajeLabel;
	}

	private class FichaCellRenderer implements ListCellRenderer<FichaRuleta> {
		
		private JLabel label = new JLabel();

		@Override
		public Component getListCellRendererComponent(JList<? extends FichaRuleta> list,
													  FichaRuleta valor, int index,
													  boolean isSelected, boolean cellHasFocus) {
			label.setIcon(new ImageIcon(valor.getImagenFicha()));
			return label;
		}

	}

}
