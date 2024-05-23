package RuletaApp.view;

import RuletaApp.model.RuletaModelo;
import RuletaApp.model.SegmentoRuleta;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;



public class RuletaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private double AcumuladordeAngulos;
	
	private final int margen;
	
	private BufferedImage ImagenOriginal;
	private BufferedImage rotarImagen;
	
	private final Color colorFondo;


	public RuletaPanel(RuletaFrame frame, RuletaModelo modelo,
					   RuletaImagen imagen) {

		this.margen = 10;
		this.colorFondo = new Color(30, 104, 2);
		this.AcumuladordeAngulos = 0.0;
		this.ImagenOriginal = imagen.getImagen();
		this.rotarImagen = imagen.getImagen();
		this.setPreferredSize(new Dimension(imagen.getImagen().getWidth() + margen + margen,
				imagen.getImagen().getHeight() + margen + margen));
	}
	
	public void rotarRuleta(double angulo) {
		this.AcumuladordeAngulos += angulo;
		rotarRuletaPrivada(rotarImagen, angulo);
	}
	
	public void reposicionarRuleta(SegmentoRuleta wheelSegment, int index) {
		BufferedImage copiarImagen = new BufferedImage(ImagenOriginal.getWidth(),
				ImagenOriginal.getHeight(), ImagenOriginal.getType());
		Graphics2D g2d = (Graphics2D) copiarImagen.getGraphics();
		g2d.drawImage(ImagenOriginal, 0, 0, this);
		double AnguloSegmento = 360.0 / 38.0;
		double angulo = index * AnguloSegmento + AnguloSegmento * 0.5  - 90.0;
		Point point = Cartesiano(angulo, 140.0, new Point(copiarImagen.getWidth() / 2,
				copiarImagen.getHeight() / 2));
		g2d.setColor(Color.WHITE);
		g2d.fillOval(point.x - 8, point.y - 8, 16, 16);
		
		this.AcumuladordeAngulos %= 360.0;
		rotarRuletaPrivada(copiarImagen, AcumuladordeAngulos);
	}
	
	public void inicializarRuleta() {
		this.AcumuladordeAngulos %= 360.0;
		rotarRuletaPrivada(ImagenOriginal, AcumuladordeAngulos);
	}
	
	private Point Cartesiano(double angulo, double radio, Point centerPoint) {
		double theta = Math.toRadians(angulo);
		int x = (int) Math.round(Math.cos(theta) * radio) + centerPoint.x;
		int y = (int) Math.round(Math.sin(theta) * radio) + centerPoint.y;
		return new Point(x, y);
	}

	private void rotarRuletaPrivada(BufferedImage bufferedImage, double angulo) {
		double theta = Math.toRadians(angulo);
		double locationX = bufferedImage.getWidth() / 2;
		double locationY = bufferedImage.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(theta, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BICUBIC);
		BufferedImage outputImage = new BufferedImage(bufferedImage.getWidth(),
				bufferedImage.getHeight(), bufferedImage.getType());
		Graphics g = outputImage.getGraphics();
		g.setColor(colorFondo);
		g.fillRect(0, 0, outputImage.getWidth(), outputImage.getHeight());
		g.dispose();
		
		op.filter(bufferedImage, outputImage);
		this.rotarImagen = outputImage;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(rotarImagen, margen, margen, this);
	}

}
