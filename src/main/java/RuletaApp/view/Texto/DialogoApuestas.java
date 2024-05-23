package RuletaApp.view.Texto;

import RuletaApp.view.RuletaFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;



public class DialogoApuestas extends JDialog{

	private static final long serialVersionUID = 1L;

	public DialogoApuestas(RuletaFrame frame, String titulo) {
		super(frame.getFrame(), true);
		setTitle(titulo);
		add(createPanelPrincipal(), BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(frame.getFrame());
		setVisible(true);
	}
	
	private JPanel createPanelPrincipal() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(new PanelApuestas().getPanel(), BorderLayout.CENTER);
		
		JPanel PanelInterior = new JPanel();
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
		PanelInterior.add(button);
		
		panel.add(PanelInterior, BorderLayout.AFTER_LAST_LINE);
		
		return panel;
	}
	
}
