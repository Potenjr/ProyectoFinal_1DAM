package RuletaApp.model;

import java.awt.Color;
import java.awt.Point;

public class Ruleta {
	
	private Color rojo;
	private Color verde;
	
	private final SegmentoRuleta[] segmentoRuleta;
	
	public Ruleta() {
		this.rojo = new Color(205, 29, 33);
		this.verde = new Color(56, 173, 2);
		this.segmentoRuleta = definirSegmento();
	}
	
	private SegmentoRuleta[] definirSegmento() {
		SegmentoRuleta[] SegmentosRuleta = new SegmentoRuleta[38];
		SegmentosRuleta[0] = new SegmentoRuleta("00", verde, new Point(12, 10));
		SegmentosRuleta[1] = new SegmentoRuleta("27", rojo, new Point(12, 10));
		SegmentosRuleta[2] = new SegmentoRuleta("10", Color.BLACK, new Point(12, 10));
		SegmentosRuleta[3] = new SegmentoRuleta("25", rojo, new Point(12, 10));
		SegmentosRuleta[4] = new SegmentoRuleta("29", Color.BLACK, new Point(12, 10));
		SegmentosRuleta[5] = new SegmentoRuleta("12", rojo, new Point(11, 11));
		SegmentosRuleta[6] = new SegmentoRuleta("8", Color.BLACK, new Point(7, 10));
		SegmentosRuleta[7] = new SegmentoRuleta("19", rojo, new Point(10, 10));
		SegmentosRuleta[8] = new SegmentoRuleta("31", Color.BLACK, new Point(12, 10));
		SegmentosRuleta[9] = new SegmentoRuleta("18", rojo, new Point(10, 12));
		SegmentosRuleta[10] = new SegmentoRuleta("6", Color.BLACK, new Point(6, 12));
		SegmentosRuleta[11] = new SegmentoRuleta("21", rojo, new Point(12, 10));
		SegmentosRuleta[12] = new SegmentoRuleta("33", Color.BLACK, new Point(12, 10));
		SegmentosRuleta[13] = new SegmentoRuleta("16", rojo, new Point(12, 10));
		SegmentosRuleta[14] = new SegmentoRuleta("4", Color.BLACK, new Point(6, 10));
		SegmentosRuleta[15] = new SegmentoRuleta("23", rojo, new Point(10, 10));
		SegmentosRuleta[16] = new SegmentoRuleta("35", Color.BLACK, new Point(10, 10));
		SegmentosRuleta[17] = new SegmentoRuleta("14", rojo, new Point(10, 10));
		SegmentosRuleta[18] = new SegmentoRuleta("2", Color.BLACK, new Point(4, 10));
		SegmentosRuleta[19] = new SegmentoRuleta("0", verde, new Point(4, 10));
		SegmentosRuleta[20] = new SegmentoRuleta("28", Color.BLACK, new Point(10, 10));
		SegmentosRuleta[21] = new SegmentoRuleta("9", rojo, new Point(4, 8));
		SegmentosRuleta[22] = new SegmentoRuleta("26", Color.BLACK, new Point(10, 8));
		SegmentosRuleta[23] = new SegmentoRuleta("30", rojo, new Point(9, 9));
		SegmentosRuleta[24] = new SegmentoRuleta("11", Color.BLACK, new Point(10, 8));
		SegmentosRuleta[25] = new SegmentoRuleta("7", rojo, new Point(6, 10));
		SegmentosRuleta[26] = new SegmentoRuleta("20", Color.BLACK, new Point(10, 8));
		SegmentosRuleta[27] = new SegmentoRuleta("32", rojo, new Point(10, 8));
		SegmentosRuleta[28] = new SegmentoRuleta("17", Color.BLACK, new Point(12, 10));
		SegmentosRuleta[29] = new SegmentoRuleta("5", rojo, new Point(6, 10));
		SegmentosRuleta[30] = new SegmentoRuleta("22", Color.BLACK, new Point(12, 10));
		SegmentosRuleta[31] = new SegmentoRuleta("34", rojo, new Point(12, 10));
		SegmentosRuleta[32] = new SegmentoRuleta("15", Color.BLACK, new Point(12, 10));
		SegmentosRuleta[33] = new SegmentoRuleta("3", rojo, new Point(6, 10));
		SegmentosRuleta[34] = new SegmentoRuleta("24", Color.BLACK, new Point(12, 10));
		SegmentosRuleta[35] = new SegmentoRuleta("36", rojo, new Point(12, 10));
		SegmentosRuleta[36] = new SegmentoRuleta("13", Color.BLACK, new Point(12, 10));
		SegmentosRuleta[37] = new SegmentoRuleta("1", rojo, new Point(8, 10));
		
		return SegmentosRuleta;
	}
	
	public int length() {
		return segmentoRuleta.length;
	}
	
	public SegmentoRuleta getSegmento(int index) {
		return segmentoRuleta[index];
	}

	public SegmentoRuleta[] getSegmentoRuleta() {
		return segmentoRuleta;
	}
	
	public String[] getRangoNumero(int start, int fin) {
		String[] output = new String[fin - start + 1];
		int index = 0;
		for (int valor = start; valor <= fin; valor++) {
			output[index++] = Integer.toString(valor);
		}
		
		return output;
	}
	
	public String[] getImpares() {
		String[] output = new String[18];
		int index = 0;
		for (int valor = 1; valor < 36; valor += 2) {
			output[index++] = Integer.toString(valor);
		}
		
		return output;
	}
	
	public String[] getPares() {
		String[] output = new String[18];
		int index = 0;
		for (int valor = 2; valor <= 36; valor += 2) {
			output[index++] = Integer.toString(valor);
		}
		
		return output;
	}
	
	public String[] getNumerosRojos() {
		String[] output = new String[18];
		int index = 0;
		for (SegmentoRuleta SegmentoRuleta : segmentoRuleta) {
			if (SegmentoRuleta.getColorFondo().equals(rojo)) {
				output[index++] = SegmentoRuleta.getNumeroRuleta();
			}
		}
		
		return output;
	}
	
	public String[] getNumeroNegro() {
		String[] output = new String[18];
		int index = 0;
		for (SegmentoRuleta SegmentoRuleta : segmentoRuleta) {
			if (SegmentoRuleta.getColorFondo().equals(Color.BLACK)) {
				output[index++] = SegmentoRuleta.getNumeroRuleta();
			}
		}
		
		return output;
	}
	
	public Color getRojo() {
		return rojo;
	}
	
	public Color getVerde() {
		return verde;
	}
	
	public Color getBackgroundColor(int numero) {
		String StringNumero = Integer.toString(numero);
		for (SegmentoRuleta SegmentoRuleta : segmentoRuleta) {
			if (StringNumero.equals(SegmentoRuleta.getNumeroRuleta())) {
				return SegmentoRuleta.getColorFondo();
			}
		}
		
		return verde;
	}

}
