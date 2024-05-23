package RuletaApp.view.Texto;

import RuletaApp.model.Apuesta;
import RuletaApp.view.RuletaFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;



public class DialogoGanancias extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final PanelGanancias panelGanancias;
	
	public DialogoGanancias(RuletaFrame frame, List<Apuesta> ganadores,
							String numero, String titulo) {
		super(frame.getFrame(), true);
		this.panelGanancias = new PanelGanancias(ganadores, numero);
		setTitle(titulo);
		add(createPanelPrincipal(), BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(frame.getFrame());
		setVisible(true);
	}
	
	private JPanel createPanelPrincipal() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(panelGanancias.getPanel(), BorderLayout.CENTER);
		
		JPanel PanelInterior = new JPanel();
		
		JButton boton = new JButton("OK");
		boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
		PanelInterior.add(boton);
		
		panel.add(PanelInterior, BorderLayout.AFTER_LAST_LINE);
		
		return panel;
	}

	public PanelGanancias getPanelGanancias() {
		return panelGanancias;
	}

}
