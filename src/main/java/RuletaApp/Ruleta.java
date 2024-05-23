package RuletaApp;

import RuletaApp.model.RuletaModelo;
import RuletaApp.view.RuletaFrame;

import javax.swing.SwingUtilities;



public class Ruleta implements Runnable {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Ruleta());
	}

	@Override
	public void run() {
		new RuletaFrame(new RuletaModelo());
	}

}
