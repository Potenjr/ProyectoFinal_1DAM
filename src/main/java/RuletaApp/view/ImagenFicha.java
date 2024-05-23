package RuletaApp.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ImagenFicha {
	
	private final int radio;
	
	private final BufferedImage imagenFicha;
	
	private final Color colorFicha;
	private final Color colorInterior;

	public ImagenFicha(Color ColorFicha, Color ColorInterior) {
		this.colorFicha = ColorFicha;
		this.colorInterior = ColorInterior;
		this.radio = 21;
		this.imagenFicha = createImagenFicha();
	}
	
	private BufferedImage createImagenFicha() {
		int diametro = radio + radio;
		BufferedImage imagen = new BufferedImage(diametro, diametro, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2d = (Graphics2D) imagen.getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, 
				RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setColor(new Color(255, 255, 255, 0));
		g2d.fillRect(0, 0, imagen.getWidth(), imagen.getHeight());
		
		int x = imagen.getWidth() / 2;
		int y = imagen.getHeight() / 2;
		g2d.setColor(colorFicha);
		g2d.fillOval(x - radio, y - radio, diametro, diametro);
		
		int radioPequeño = radio / 3;
		int radioGrande = 2 * radio / 3;
		
		float[] trazo1 = { 2f, 0f, 0f, 2f };
		BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 
				1.0f, trazo1, 2f);
		g2d.setStroke(bs);
		g2d.setColor(colorInterior);
		g2d.drawOval(x - radioPequeño, y - radioPequeño,
				radioPequeño + radioPequeño, radioPequeño + radioPequeño);
		g2d.drawOval(x - radioGrande, y - radioGrande,
				radioGrande + radioGrande, radioGrande + radioGrande);
		
		g2d.dispose();
		
		return imagen;
	}

	public BufferedImage getImagenFicha() {
		return imagenFicha;
	}

	public Color getColorFicha() {
		return colorFicha;
	}
	
}
