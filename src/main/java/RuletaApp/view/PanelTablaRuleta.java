package RuletaApp.view;

import RuletaApp.controller.FichaListener;
import RuletaApp.model.Apuesta;
import RuletaApp.model.Jugador;
import RuletaApp.model.RuletaModelo;
import RuletaApp.model.TablaConConstantesDibujables;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;



public class PanelTablaRuleta extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final int margen;


	
	private final RuletaModelo modelo;
	
	private final ImagenTablaRuleta imagen;

	public PanelTablaRuleta(RuletaFrame frame, RuletaModelo modelo,
							ImagenTablaRuleta imagen) {

		this.modelo = modelo;
		this.imagen = imagen;
		TablaConConstantesDibujables tcd = new TablaConConstantesDibujables();
		this.margen = tcd.getImagenMargen();
		this.setPreferredSize(new Dimension(imagen.getImagen().getWidth() + margen + margen,
				imagen.getImagen().getHeight() + margen + margen));
		this.addMouseListener(new FichaListener(frame, modelo));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagen.getImagen(), margen, margen, this);
		
		for (Apuesta apuesta : modelo.getApuesta()) {
			Jugador jugador = apuesta.getJugador();
			BufferedImage imagenFicha = jugador.getImagenFicha();
			Point point = apuesta.getUbicacionBoard();
			int x = point.x - imagenFicha.getWidth() / 2;
			int y = point.y - imagenFicha.getHeight() / 2;
			g.drawImage(imagenFicha, x, y, this);
		}
	}
	
}
