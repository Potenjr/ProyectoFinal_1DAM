package RuletaApp.view;

import RuletaApp.model.RuletaModelo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;



public class PanelDeControl {
	
	private final PanelDeLlamadas panelDeLlamadas;
	
	private final MenuPanel menuPanel;
	
	private final JugadorPanel JugadorPanel;

	
	private final JPanel panel;

	public PanelDeControl(RuletaFrame frame, RuletaModelo modelo) {
		this.panelDeLlamadas = new PanelDeLlamadas(modelo);
		this.menuPanel = new MenuPanel(frame, modelo);
		this.JugadorPanel = new JugadorPanel(frame, modelo);
		this.panel = createPaneldeControl();
	}
	
	private JPanel createPaneldeControl() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JPanel PanelInterno = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 5));
		PanelInterno.add(panelDeLlamadas.getPanel());
		PanelInterno.add(JugadorPanel.getPanel());

		
		panel.add(PanelInterno, BorderLayout.BEFORE_LINE_BEGINS);
		panel.add(menuPanel.getPanel(), BorderLayout.AFTER_LINE_ENDS);
		return panel;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void addLlamada(String numeroString, Color colorFondo, boolean isNegro) {
		panelDeLlamadas.addLlamada(numeroString, colorFondo, isNegro);
	}
	
	public void ActualizarJugadorPanel() {
		JugadorPanel.ActualizarModeloTabla();
	}
	
	public JTable getTablaJugador() {
		return JugadorPanel.getTabla();
	}

}
