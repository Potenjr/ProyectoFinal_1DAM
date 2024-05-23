package RuletaApp.view;

import RuletaApp.model.Ruleta;
import RuletaApp.model.TablaConConstantesDibujables;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;


public class ImagenTablaRuleta {
	
	private final int Ancho, Alto, AnchuraSegmento, margen, lineaMargen;
	
	private final BufferedImage imagen;
	
	private final Color ColorVerde;
	
	private final Ruleta ruleta;
	
	public ImagenTablaRuleta() {
		TablaConConstantesDibujables tcd = new TablaConConstantesDibujables();
		this.margen = tcd.getMargen();
		this.lineaMargen = tcd.getLineaMargen();
		this.AnchuraSegmento = tcd.getSegmentoAncho();
		int relleno = lineaMargen + lineaMargen + margen + margen;
		this.Ancho = 14 * AnchuraSegmento + relleno;
		this.Alto = 5 * AnchuraSegmento + relleno;
		this.ColorVerde = new Color(0, 102, 0);
		this.ruleta = new Ruleta();
		this.imagen = createTablaRuleta();
	}

	private BufferedImage createTablaRuleta() {
		BufferedImage imagen = new BufferedImage(Alto, Ancho, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = (Graphics2D) imagen.getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setColor(ColorVerde);
		g2d.fillRect(0, 0, imagen.getWidth(), imagen.getHeight());

		PintarNumeros(g2d);
		pintarLineasHorizontales(g2d);
		pintarLineaVertical(g2d);

		// Establecer borde negro alrededor de la imagen
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(10)); // Ancho del borde
		g2d.drawRect(0, 0, imagen.getWidth() - 1, imagen.getHeight() - 1);

		g2d.dispose();

		BufferedImage rotatedImage = RotarImagen(imagen);
		g2d = (Graphics2D) rotatedImage.getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);

		PintarApuestaExterna(g2d);

		g2d.dispose();

		return rotatedImage;
	}
	
	private void PintarNumeros(Graphics2D g2d) {
		Font fuente = new Font(Font.SANS_SERIF, Font.BOLD, 36);
		g2d.setFont(fuente);
		
		String StringNumeros = "00";
		int AnchoCero = 3 * AnchuraSegmento / 2;
		int x = 2 * AnchuraSegmento + margen + lineaMargen;
		int y = margen + lineaMargen;
		PintarNumero(g2d, StringNumeros, 0, x, y, AnchoCero, AnchuraSegmento);
		
		StringNumeros = "0";
		AnchoCero = 3 * AnchuraSegmento / 2;
		x = 2 * AnchuraSegmento + margen + lineaMargen + AnchoCero;
		y = margen + lineaMargen;
		PintarNumero(g2d, StringNumeros, 0, x, y, AnchoCero, AnchuraSegmento);
		
		int number = 1;
		y = AnchuraSegmento + margen + lineaMargen;
		for (int Fila = 0; Fila < 12; Fila++) {
			x = AnchuraSegmento + margen + lineaMargen;
			for (int columna = 0; columna < 3; columna++) {
				x += AnchuraSegmento;
				StringNumeros = Integer.toString(number);
				PintarNumero(g2d, StringNumeros, number++, x, y, AnchuraSegmento, AnchuraSegmento);
			}
			y += AnchuraSegmento;
		}
		
		String text = "3 para 1";
		fuente = new Font(Font.SANS_SERIF, Font.BOLD, 16);
		g2d.setFont(fuente);
		x = AnchuraSegmento + margen + lineaMargen;
		for (int columna = 0; columna < 3; columna++) {
			x += AnchuraSegmento;
			pintarTexto(g2d, text, x, y, AnchuraSegmento, AnchuraSegmento);
		}
	}
	
	private void PintarNumero(Graphics2D g2d, String StringNumero, int numero,
							  int x, int y, int anchuraSegmento, int alturaSegmento) {
		FontMetrics metrica = g2d.getFontMetrics(g2d.getFont());
		int ascent = metrica.getAscent();
		
		int width = metrica.stringWidth(StringNumero);
		
		g2d.setColor(ruleta.getBackgroundColor(numero));
		g2d.fillRect(x, y, anchuraSegmento, alturaSegmento);
		
		x += (anchuraSegmento - width) / 2;
		y += (alturaSegmento - ascent) / 2 + ascent;
		
		g2d.setColor(Color.WHITE);
		g2d.drawString(StringNumero, x, y);
	}
	
	private void PintarApuestaExterna(Graphics2D g2d) {

		Font fuente = new Font(Font.SANS_SERIF, Font.BOLD, 32);
		g2d.setFont(fuente);
		
		int x = AnchuraSegmento + margen + lineaMargen;
		int y = 3 * AnchuraSegmento + margen + lineaMargen;
		int extraAncho = 4 * AnchuraSegmento;
		pintarTexto(g2d, "1 a 12", x, y, extraAncho, AnchuraSegmento);
		x += extraAncho;
		pintarTexto(g2d, "13 a 24", x, y, extraAncho, AnchuraSegmento);
		x += extraAncho;
		pintarTexto(g2d, "25 a 36", x, y, extraAncho, AnchuraSegmento);
		

		fuente = new Font(Font.SANS_SERIF, Font.BOLD, 24);
		g2d.setFont(fuente);
		
		x = AnchuraSegmento + margen + lineaMargen;
		y = 4 * AnchuraSegmento + margen + lineaMargen;
		extraAncho = 2 * AnchuraSegmento;
		pintarTexto(g2d, "1 a 18", x, y, extraAncho, AnchuraSegmento);
		x += extraAncho;
		pintarTexto(g2d, "PAR", x, y, extraAncho, AnchuraSegmento);
		x += 3 * extraAncho;
		pintarTexto(g2d, "IMPAR", x, y, extraAncho, AnchuraSegmento);
		x += extraAncho;
		pintarTexto(g2d, "19 a 36", x, y, extraAncho, AnchuraSegmento);
		
		// Draw colors for the red / black bets
		int dobleMargen = 2 * lineaMargen;
		x = 5 * AnchuraSegmento + margen + dobleMargen;
		y = 4 * AnchuraSegmento + margen + dobleMargen;
		drawDiamond(g2d, ruleta.getBackgroundColor(1), x, y,
				extraAncho - dobleMargen, AnchuraSegmento - dobleMargen);
		x += 2 * AnchuraSegmento;
		drawDiamond(g2d, ruleta.getBackgroundColor(2), x, y,
				extraAncho - dobleMargen, AnchuraSegmento - dobleMargen);
	}
	
	private void pintarTexto(Graphics2D g2d, String text,
							 int x, int y, int AnchoSegmento, int AlturaSegmento) {
		FontMetrics metrica = g2d.getFontMetrics(g2d.getFont());
		int ascent = metrica.getAscent();
		int ancho = metrica.stringWidth(text);
		
		x += (AnchoSegmento - ancho) / 2;
		y += (AlturaSegmento - ascent) / 2 + ascent;
		
		g2d.setColor(Color.WHITE);
		g2d.drawString(text, x, y);
	}
	
	private void drawDiamond(Graphics2D g2d, Color color, int x, int y, int anchura, int altura) {
		Polygon poligono = new Polygon();
		poligono.addPoint(x + anchura / 2, y);
		poligono.addPoint(x + anchura, y + altura / 2);
		poligono.addPoint(x + anchura / 2 , y + altura);
		poligono.addPoint(x, y + altura / 2);
		
		g2d.setColor(color);
		g2d.fillPolygon(poligono);
	}
	
	private void pintarLineasHorizontales(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke(5f));
		g2d.setColor(Color.WHITE);
		
		int y = margen + lineaMargen;
		PintarSegmentosLineaHorizontal(g2d, 2, 5, y);
		y = PintarLineaVertical(g2d, y);
		y = PintarLineaVertical(g2d, y);
		y = PintarLineaVertical(g2d, y);
		PintarSegmentosLineaHorizontal(g2d, 2, 5, y);
		y += AnchuraSegmento;
		PintarSegmentosLineaHorizontal(g2d, 0, 5, y);
		y += AnchuraSegmento;
		PintarSegmentosLineaHorizontal(g2d, 2, 5, y);
	}

	private int PintarLineaVertical(Graphics2D g2d, int y) {
		y += AnchuraSegmento;
		PintarSegmentosLineaHorizontal(g2d, 0, 5, y);
		y += AnchuraSegmento;
		PintarSegmentosLineaHorizontal(g2d, 2, 5, y);
		y += AnchuraSegmento;
		PintarSegmentosLineaHorizontal(g2d, 0, 1, y);
		PintarSegmentosLineaHorizontal(g2d, 2, 5, y);
		y += AnchuraSegmento;
		PintarSegmentosLineaHorizontal(g2d, 2, 5, y);
		return y;
	}
	
	private void PintarSegmentosLineaHorizontal(Graphics2D g2d, int c1, int c2, int y) {
		int x1 = c1 * AnchuraSegmento + margen + lineaMargen;
		int x2 = c2 * AnchuraSegmento + margen + lineaMargen;
		g2d.drawLine(x1, y, x2, y);
	}
	
	private void pintarLineaVertical(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke(5f));
		g2d.setColor(Color.WHITE);
		

		int x = 2 * AnchuraSegmento + margen + lineaMargen;
		PintarSegmentosLineaVertical(g2d, x, 0, 14);
		x += 3 * AnchuraSegmento;
		PintarSegmentosLineaVertical(g2d, x, 0, 14);
		

		x = margen + lineaMargen;
		PintarSegmentosLineaVertical(g2d, x, 1, 13);
		x += AnchuraSegmento;
		PintarSegmentosLineaVertical(g2d, x, 1, 13);
		x += 2 * AnchuraSegmento;
		PintarSegmentosLineaVertical(g2d, x, 1, 14);
		x += AnchuraSegmento;
		PintarSegmentosLineaVertical(g2d, x, 1, 14);
		

		x = 7 * AnchuraSegmento / 2 + margen + lineaMargen;
		PintarSegmentosLineaVertical(g2d, x, 0, 1);
	}
	
	private void PintarSegmentosLineaVertical(Graphics2D g2d, int x, int c1, int c2) {
		int y1 = c1 * AnchuraSegmento + margen + lineaMargen;
		int y2 = c2 * AnchuraSegmento + margen + lineaMargen;
		g2d.drawLine(x, y1, x, y2);
	}
	
	private BufferedImage RotarImagen(BufferedImage image) {
		BufferedImage outputImage = new BufferedImage(Ancho, Alto, BufferedImage.TYPE_INT_RGB);
		
		// Rotate image 90 degrees counter-clockwise
		for (int i = 0; i < Alto; i++) {
			for (int j = 0; j < Ancho; j++) {
				outputImage.setRGB(j, Alto - 1 - i, image.getRGB(i, j));
			}
		}
	
		return outputImage;
	}

	public BufferedImage getImagen() {
		return imagen;
	}
	
}
