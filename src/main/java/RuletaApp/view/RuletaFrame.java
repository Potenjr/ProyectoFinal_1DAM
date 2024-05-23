package RuletaApp.view;

import RuletaApp.model.RuletaModelo;
import RuletaApp.model.SegmentoRuleta;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTable;


public class RuletaFrame {

	private final PanelDeControl PanelControl;



	private final PanelRuleta PanelRuleta;

	private final JFrame frame;

	public RuletaFrame(RuletaModelo modelo) {

		this.PanelControl = new PanelDeControl(this, modelo);
		this.PanelRuleta = new PanelRuleta(this, modelo);
		this.frame = crearMostrarGUI();
	}

	private JFrame crearMostrarGUI() {
		JFrame frame = new JFrame("Ruleta");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(PanelRuleta.getPanel(), BorderLayout.BEFORE_FIRST_LINE);
		frame.add(PanelControl.getPanel(), BorderLayout.AFTER_LAST_LINE);

		frame.pack();
		frame.setResizable(false);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

		System.out.println(frame.getSize());

		return frame;
	}

	public void addLlamada(String numeroString, Color ColorFondo, boolean EsNegro) {
		PanelControl.addLlamada(numeroString, ColorFondo, EsNegro);
	}

	public void updatePanelJugador() {
		PanelControl.ActualizarJugadorPanel();
	}

	public JTable getTablaJugador() {
		return PanelControl.getTablaJugador();
	}

	public void inicializarRuleta() {
		PanelRuleta.inicializarRuleta();
	}

	public void reposicionarRuleta(SegmentoRuleta wheelSegment, int index) {
		PanelRuleta.reposicionarRuleta(wheelSegment, index);
	}

	public void RotarRuleta(double angle) {
		PanelRuleta.rotarRuleta(angle);
	}

	public void rehacerTabladeApuestas() {
		PanelRuleta.repintarRuleta();
	}

	public JFrame getFrame() {
		return frame;
	}

}
