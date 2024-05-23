package RuletaApp.view;

import RuletaApp.model.RuletaModelo;
import RuletaApp.model.SegmentoRuleta;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;



public class RuletaImagen {
	
	private BufferedImage imagen;
	
	private Color ColorSueloRuleta;
	private Color ColorHierroRuleta;
	
	private SegmentoRuleta[] SegmentosRuleta;
	
	public RuletaImagen(RuletaModelo modelo) {
		this.ColorSueloRuleta = new Color(30, 104, 2);
		this.ColorHierroRuleta = new Color(194, 164, 164);
		this.SegmentosRuleta = modelo.getSegmentoRuleta();
		this.imagen = createRuleta();
	}

	private BufferedImage createRuleta() {
		BufferedImage imagen = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = (Graphics2D) imagen.getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
				RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setColor(ColorSueloRuleta);
		g2d.fillRect(0, 0, imagen.getWidth(), imagen.getHeight());

		pintarSegmentos(g2d);

		g2d.setColor(ColorSueloRuleta);
		g2d.setStroke(new BasicStroke(5f));
		g2d.fillOval(75, 75, 250, 250);

		g2d.setColor(ColorHierroRuleta);
		g2d.setStroke(new BasicStroke(9f));
		g2d.drawOval(5, 5, 388, 388);
		g2d.setStroke(new BasicStroke(5f));
		g2d.drawOval(35, 35, 330, 330);
		g2d.setStroke(new BasicStroke(13f));
		g2d.drawOval(75, 75, 250, 250);

		g2d.dispose();

		return imagen;
	}

	private void pintarSegmentos(Graphics2D g2d) {
		double IncrementarAngulo = 360.0 / SegmentosRuleta.length;
		double angulo = 270.0;
		Point UltimoPuntoInterno = null;
		Point UltimoPuntoExterno = null;
		Point PuntoInternoOriginal = null;
		Point PuntoExternoOriginal = null;
		Point centro = new Point(200, 200);
		
		for (int i = 0; i < SegmentosRuleta.length; i++) {
			Point puntoInterior = Cartesiano(angulo, 125.0, centro);
			Point puntoExterior = Cartesiano(angulo, 194.0, centro);
			if (i > 0) {
				pintarPoligono(g2d, UltimoPuntoInterno, UltimoPuntoExterno, i, puntoInterior, puntoExterior);
			} else {
				PuntoInternoOriginal = new Point(puntoInterior.x, puntoInterior.y);
				PuntoExternoOriginal = new Point(puntoExterior.x, puntoExterior.y);
			}
			angulo += IncrementarAngulo;
			UltimoPuntoInterno = new Point(puntoInterior.x, puntoInterior.y);
			UltimoPuntoExterno = new Point(puntoExterior.x, puntoExterior.y);
		}
		
		pintarPoligono(g2d, UltimoPuntoInterno, UltimoPuntoExterno, SegmentosRuleta.length,
				PuntoInternoOriginal, PuntoExternoOriginal);
		
		angulo = IncrementarAngulo * 0.5;
		for (int index = 0; index < SegmentosRuleta.length; index++) {
			BufferedImage image = createNumeroRuleta(SegmentosRuleta[index].getNumeroRuleta(),
					SegmentosRuleta[index].getColorFondo(), angulo);
			double radio = 178.0;
			Point point = Cartesiano(270.0 + angulo,
					radio, centro);
			Point correction = SegmentosRuleta[index].getDelta();
			g2d.drawImage(image, point.x - correction.x, point.y - correction.y, null);
			angulo += IncrementarAngulo;
		}
		
		angulo = 270.0;
		g2d.setStroke(new BasicStroke(3f));
		g2d.setColor(ColorHierroRuleta);
		for (int i = 0; i <= SegmentosRuleta.length; i++) {
			Point innerPoint = Cartesiano(angulo, 125.0, centro);
			Point outerPoint = Cartesiano(angulo, 195.0, centro);
			g2d.drawLine(innerPoint.x, innerPoint.y, outerPoint.x, outerPoint.y);
			angulo += IncrementarAngulo;
		}
	}

	private void pintarPoligono(Graphics2D g2d, Point ultimoPuntoInterior, Point ultimoPuntoExterior,
								int index, Point innerPoint, Point outerPoint) {
		Polygon poligono = new Polygon();
		poligono.addPoint(ultimoPuntoInterior.x, ultimoPuntoInterior.y);
		poligono.addPoint(ultimoPuntoExterior.x, ultimoPuntoExterior.y);
		poligono.addPoint(outerPoint.x, outerPoint.y);
		poligono.addPoint(innerPoint.x, innerPoint.y);
		g2d.setColor(SegmentosRuleta[index - 1].getColorFondo());
		g2d.fillPolygon(poligono);
	}
	
	private BufferedImage createNumeroRuleta(String numero, Color backgroundColor,
											 double angle) {
		Font fuente = new Font(Font.SANS_SERIF, Font.BOLD, 18);

		BufferedImage imagen = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = (Graphics2D) imagen.getGraphics();
		FontMetrics metrica = g2d.getFontMetrics(fuente);
		int height = metrica.getAscent();
		int width = metrica.stringWidth(numero);
		g2d.dispose();
		
		BufferedImage image = new BufferedImage(width + 2, height + 2,
				BufferedImage.TYPE_INT_RGB);
		g2d = (Graphics2D) image.getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, 
				RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setColor(backgroundColor);
		g2d.fillRect(0, 0, image.getWidth(), image.getHeight());
		g2d.setColor(Color.WHITE);
		g2d.setFont(fuente);
		g2d.drawString(numero, 2, image.getHeight() - 5);
		g2d.dispose();
		
		AffineTransform xfrm = new AffineTransform();
        xfrm = AffineTransform.getRotateInstance(Math.toRadians(angle), 
        		image.getWidth() / 2, image.getHeight() / 2);
        BufferedImageOp op = new AffineTransformOp(xfrm,
        		AffineTransformOp.TYPE_BILINEAR);
        BufferedImage outputImage = op.filter(image, null);
		
        return outputImage;
	}
	
	private Point Cartesiano(double angulo, double radio, Point centro) {
		double theta = Math.toRadians(angulo);
		int x = (int) Math.round(Math.cos(theta) * radio) + centro.x;
		int y = (int) Math.round(Math.sin(theta) * radio) + centro.y;
		return new Point(x, y);
	}
	
	public BufferedImage getImagen() {
		return imagen;
	}

}
