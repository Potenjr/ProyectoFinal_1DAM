package RuletaApp.view;

import RuletaApp.model.RuletaModelo;
import RuletaApp.model.SegmentoRuleta;

import java.awt.BorderLayout;

import javax.swing.JPanel;



public class PanelRuleta {

	
	private final JPanel panel;
	
	private final ImagenTablaRuleta ImagenTablaRuleta;
	
	private final PanelTablaRuleta PanelTablaRuleta;
	
	private final RuletaApp.view.RuletaImagen RuletaImagen;
	
	private final RuletaPanel RuletaPanel;

	public PanelRuleta(RuletaFrame frame, RuletaModelo modelo) {
		this.ImagenTablaRuleta = new ImagenTablaRuleta();
		this.PanelTablaRuleta = new PanelTablaRuleta(frame, modelo, ImagenTablaRuleta);
		this.RuletaImagen = new RuletaImagen(modelo);
		this.RuletaPanel = new RuletaPanel(frame, modelo, RuletaImagen);
		this.panel = createPanelDeControlParaDarVueltas();
	}
	
	private JPanel createPanelDeControlParaDarVueltas() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(RuletaPanel, BorderLayout.BEFORE_LINE_BEGINS);
		panel.add(PanelTablaRuleta, BorderLayout.AFTER_LINE_ENDS);
		
		return panel;
	}
	
	public void inicializarRuleta() {
		RuletaPanel.inicializarRuleta();
	}
	
	public void reposicionarRuleta(SegmentoRuleta SegmentoRuleta, int index) {
		RuletaPanel.reposicionarRuleta(SegmentoRuleta, index);
		RuletaPanel.repaint();
	}
	
	public void rotarRuleta(double angulo) {
		RuletaPanel.rotarRuleta(angulo);
		RuletaPanel.repaint();
	}
	
	public void repintarRuleta() {
		PanelTablaRuleta.repaint();
	}

	public JPanel getPanel() {
		return panel;
	}

}
