package RuletaApp.view.Texto;

import RuletaApp.view.RuletaFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class InstruccionesDialogo extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final CancelarAccion CancelarAccion;
	
	private JEditorPane EditarPanel;
	
	public InstruccionesDialogo(RuletaFrame Vista, String Titulo) {
		super(Vista.getFrame(), Titulo, true);
		this.CancelarAccion = new CancelarAccion();
		
		add(createPanelPrincipal(), BorderLayout.CENTER);
		add(createButtonPanel(), BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(Vista.getFrame());
		setVisible(true);
	}
	
	private JPanel createPanelPrincipal() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
		
		URL url = InstruccionesDialogo.class.getResource("/instrucciones.html");
		
		EditarPanel = new JEditorPane();
		EditarPanel.setEditable(false);
		EditarPanel.setContentType("text/html");
		try {
			EditarPanel.setPage(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JScrollPane scrollPane = new JScrollPane(EditarPanel);
		scrollPane.setPreferredSize(new Dimension(600, 480));
		panel.add(scrollPane, BorderLayout.CENTER);
		
		return panel;
	}
	
	private JPanel createButtonPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));

		
		JButton boton = new JButton("Ok");
		boton.addActionListener(CancelarAccion);
		panel.add(boton);
		
		return panel;
	}
	
	private class CancelarAccion extends AbstractAction {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent event) {
			dispose();
		}
		
	}

}
