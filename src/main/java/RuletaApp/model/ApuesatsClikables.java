package RuletaApp.model;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class ApuesatsClikables {
	
	private final int medioAncho, CuartoAncho, SegmentoAncho;
	private final int margen, imagenMargen, lineaMargen, MargenTotal;
	
	private final List<ApuestaClikable> apuestaClikables;
	
	private final Ruleta ruleta;
	
	public ApuesatsClikables() {
		TablaConConstantesDibujables tcd = new TablaConConstantesDibujables();
		this.margen = tcd.getMargen();
		this.lineaMargen = tcd.getLineaMargen();
		this.SegmentoAncho = tcd.getSegmentoAncho();
		this.medioAncho = SegmentoAncho / 2;
		this.CuartoAncho = medioAncho / 2;
		this.imagenMargen = tcd.getImagenMargen();
		this.MargenTotal = margen + lineaMargen + imagenMargen;
		this.ruleta = new Ruleta();
		this.apuestaClikables = crearApuestasClikables();
	}
	
	private List<ApuestaClikable> crearApuestasClikables() {
		List<ApuestaClikable> apuestaClikables1 = new ArrayList<>();
		
		String[][] numeros = {
				{ "3", "6", "9", "12", "15", "18", "21", "24", "27", "30", "33", "36" },
				{ "2", "5", "8", "11", "14", "17", "20", "23", "26", "29", "32", "35" },
				{ "1", "4", "7", "10", "13", "16", "19", "22", "25", "28", "31", "34" }
		};
		
		crearApuestasCero(apuestaClikables1);
		createApuestasNumeros(apuestaClikables1, numeros);
		createApuestasColumnas(apuestaClikables1, numeros);
		createApuestaLineas(apuestaClikables1, numeros);
		createApuestasCalle(apuestaClikables1, numeros);
		createApuestaCuatroEsquinas(apuestaClikables1, numeros);
		createApuestaHorizontal(apuestaClikables1, numeros);
		createVerticalApuestaDoble(apuestaClikables1, numeros);
		createApuestaFuera(apuestaClikables1);
		
		return apuestaClikables1;
	}

	private void crearApuestasCero(List<ApuestaClikable> apuestaClikables) {
		int x = MargenTotal + CuartoAncho;
		int y = MargenTotal + CuartoAncho;
		int extraHeight = 3 * SegmentoAncho / 2;
		Rectangle limites = new Rectangle(x, y, medioAncho, SegmentoAncho);
		apuestaClikables.add(new ApuestaClikable(limites, TipoApuesta.NUMERO, "0"));
		
		y += extraHeight;
		limites = new Rectangle(x, y, medioAncho, SegmentoAncho);
		apuestaClikables.add(new ApuestaClikable(limites, TipoApuesta.NUMERO, "00"));
		
		y = MargenTotal + extraHeight - CuartoAncho;
		limites = new Rectangle(x, y, medioAncho, medioAncho);
		String[] numbers = { "0", "00" };
		apuestaClikables.add(new ApuestaClikable(limites, TipoApuesta.APUESTA_DIVIDIDA, numbers));
		
		x = MargenTotal + SegmentoAncho - CuartoAncho;
		y = MargenTotal + SegmentoAncho - CuartoAncho;
		limites = new Rectangle(x, y, medioAncho, medioAncho);
		numbers = new String[] { "0", "2", "3" };
		apuestaClikables.add(new ApuestaClikable(limites, TipoApuesta.TRES_VALORES_0,
				numbers));
		
		y += SegmentoAncho;
		limites = new Rectangle(x, y, medioAncho, medioAncho);
		numbers = new String[] { "00", "1", "2" };
		apuestaClikables.add(new ApuestaClikable(limites, TipoApuesta.TRES_VALORES_00,
				numbers));
	}
	
	private void createApuestaCuatroEsquinas(List<ApuestaClikable> ApuestaClickable,
											 String[][] numbers) {
		int x = MargenTotal + 2 * SegmentoAncho - CuartoAncho;
		int y = MargenTotal + SegmentoAncho - CuartoAncho;
		testCuatroEsquinas(ApuestaClickable, numbers, x, y);
		y += SegmentoAncho;
		testCuatroEsquinas(ApuestaClickable, numbers, x, y);
	}

	private void testCuatroEsquinas(List<ApuestaClikable> ApuestaClikable,
									String[][] numbers, int x, int y) {
		for (int i = 0; i < numbers[1].length - 1; i++) {
			Rectangle limites = new Rectangle(x, y, medioAncho, medioAncho);
			int start = Integer.valueOf(numbers[1][i]);
			int next1 = start + 1;
			int next2 = start + 3;
			int next3 = start + 4;
			String[] rango = { Integer.toString(start), Integer.toString(next1),
					Integer.toString(next2), Integer.toString(next3)}; 
			ApuestaClikable.add(new ApuestaClikable(limites, TipoApuesta.CUATRO_ESQUINAS,
					rango));
			x += SegmentoAncho;
		}
	}
	
	private void createApuestasNumeros(List<ApuestaClikable> apuestaClikables,
									   String[][] numeros) {
		int x = MargenTotal + SegmentoAncho + CuartoAncho;
		for (int i = 0; i < numeros[0].length; i++) {
			int y = MargenTotal + CuartoAncho;
			for (int j = 0; j < numeros.length; j++) {
				Rectangle limites = new Rectangle(x, y, medioAncho, medioAncho);
				apuestaClikables.add(new ApuestaClikable(limites, TipoApuesta.NUMERO,
						numeros[j][i]));
				y += SegmentoAncho;
			}
			x += SegmentoAncho;
		}
	}
	
	private void createApuestaLineas(List<ApuestaClikable> apuestaClikables,
									 String[][] numeros) {
		int x = MargenTotal + 2 * SegmentoAncho - CuartoAncho;
		int y = MargenTotal + 3 * SegmentoAncho - CuartoAncho;
		for (int index = 0; index < numeros[2].length - 1; index++) {
			Rectangle limites = new Rectangle(x, y, medioAncho, medioAncho);
			int start = Integer.valueOf(numeros[2][index]);
			String[] rango = createLineaDeApuesta(start);
			apuestaClikables.add(new ApuestaClikable(limites, TipoApuesta.APUESTA_LINEA, rango));
			x += SegmentoAncho;
		}
	}

	private String[] createLineaDeApuesta(int start) {
		int next = start + 3;
		String[] rango1 = ruleta.getRangoNumero(start, start + 2);
		String[] rango2 = ruleta.getRangoNumero(next, next + 2);
		String[] rango = new String[rango1.length + rango2.length];
		
		int j = 0;
		for (int i = 0; i < rango1.length; i++) {
			rango[j++] = rango1[i];
		}
		for (int i = 0; i < rango2.length; i++) {
			rango[j++] = rango2[i];
		}
		
		return rango;
	}
	
	private void createApuestasCalle(List<ApuestaClikable> apuestaClikables,
									 String[][] numeros) {
		int x = MargenTotal + SegmentoAncho + CuartoAncho;
		int y = MargenTotal + 3 * SegmentoAncho - CuartoAncho;
		for (int index = 0; index < numeros[2].length; index++) {
			Rectangle limites = new Rectangle(x, y, medioAncho, medioAncho);
			int start = Integer.valueOf(numeros[2][index]);
			String[] rango = ruleta.getRangoNumero(start, start + 2);
			apuestaClikables.add(new ApuestaClikable(limites, TipoApuesta.APUESTA_CALLE, rango));
			x += SegmentoAncho;
		}
	}
	
	private void createApuestasColumnas(List<ApuestaClikable> apuestaClikables,
										String[][] numeros) {
		int x = MargenTotal + 13 * SegmentoAncho;
		int y = MargenTotal;
		Rectangle limites = new Rectangle(x, y, SegmentoAncho, SegmentoAncho);
		apuestaClikables.add(new ApuestaClikable(limites, TipoApuesta.APUESTA_COLUMNA,
				numeros[0]));
		
		y += SegmentoAncho;
		limites = new Rectangle(x, y, SegmentoAncho, SegmentoAncho);
		apuestaClikables.add(new ApuestaClikable(limites, TipoApuesta.APUESTA_COLUMNA,
				numeros[1]));
		
		y += SegmentoAncho;
		limites = new Rectangle(x, y, SegmentoAncho, SegmentoAncho);
		apuestaClikables.add(new ApuestaClikable(limites, TipoApuesta.APUESTA_COLUMNA,
				numeros[2]));
	}
	
	private void createApuestaHorizontal(List<ApuestaClikable> apuestaClikables,
										 String[][] numeros) {
		int x = MargenTotal + SegmentoAncho + CuartoAncho;
		int y = MargenTotal + SegmentoAncho - CuartoAncho;
		TestDobleHorizontal(apuestaClikables, numeros, x, y, 0, numeros[0].length, -1);
		y += SegmentoAncho;
		TestDobleHorizontal(apuestaClikables, numeros, x, y, 1, numeros[1].length, -1);
	}
	
	private void createVerticalApuestaDoble(List<ApuestaClikable> apuestaClikables,
											String[][] numeros) {
		int x = MargenTotal + 2 * SegmentoAncho - CuartoAncho;
		int y = MargenTotal + CuartoAncho;
		TestDobleHorizontal(apuestaClikables, numeros, x, y, 0, numeros[0].length - 1, 3);
		y += SegmentoAncho;
		TestDobleHorizontal(apuestaClikables, numeros, x, y, 1, numeros[1].length - 1, 3);
		y += SegmentoAncho;
		TestDobleHorizontal(apuestaClikables, numeros, x, y, 2, numeros[2].length - 1, 3);
	}
	
	private void TestDobleHorizontal(List<ApuestaClikable> apuestaClikables,
									 String[][] numeros, int x, int y, int nivel, int length,
									 int increment) {
		for (int index = 0; index < length; index++) {
			Rectangle limites = new Rectangle(x, y, medioAncho, medioAncho);
			int start = Integer.valueOf(numeros[nivel][index]);
			int next = start + increment;
			String[] rango = { Integer.toString(start), Integer.toString(next) };
			apuestaClikables.add(new ApuestaClikable(limites, TipoApuesta.APUESTA_DIVIDIDA,
					rango));
			x += SegmentoAncho;
		}
	}
	
	private void createApuestaFuera(List<ApuestaClikable> apuestaClikables) {
		int x = MargenTotal + SegmentoAncho;
		int y = MargenTotal + 3 * SegmentoAncho + CuartoAncho;
		int extraAncho = 4 * SegmentoAncho;
		Rectangle limite = new Rectangle(x, y, extraAncho, medioAncho);
		apuestaClikables.add(new ApuestaClikable(limite, TipoApuesta.PRIMEROS12,
				ruleta.getRangoNumero(1, 12)));
		
		x += extraAncho;
		limite = new Rectangle(x, y, extraAncho, medioAncho);
		apuestaClikables.add(new ApuestaClikable(limite, TipoApuesta.SEGUNDOS12,
				ruleta.getRangoNumero(13, 24)));
		
		x += extraAncho;
		limite = new Rectangle(x, y, extraAncho, medioAncho);
		apuestaClikables.add(new ApuestaClikable(limite, TipoApuesta.TERCEROS12,
				ruleta.getRangoNumero(25, 36)));
		
		x = MargenTotal + SegmentoAncho;
		y = MargenTotal + 4 * SegmentoAncho;
		extraAncho = 2 * SegmentoAncho;
		limite = new Rectangle(x, y, extraAncho, SegmentoAncho);
		apuestaClikables.add(new ApuestaClikable(limite, TipoApuesta.PRIMEROS18,
				ruleta.getRangoNumero(1, 18)));
		
		x += extraAncho;
		limite = new Rectangle(x, y, extraAncho, SegmentoAncho);
		apuestaClikables.add(new ApuestaClikable(limite, TipoApuesta.PARES,
				ruleta.getPares()));
		
		x += extraAncho;
		limite = new Rectangle(x, y, extraAncho, SegmentoAncho);
		apuestaClikables.add(new ApuestaClikable(limite, TipoApuesta.ROJO,
				ruleta.getNumerosRojos()));
		
		x += extraAncho;
		limite = new Rectangle(x, y, extraAncho, SegmentoAncho);
		apuestaClikables.add(new ApuestaClikable(limite, TipoApuesta.NEGRO,
				ruleta.getNumeroNegro()));
		
		x += extraAncho;
		limite = new Rectangle(x, y, extraAncho, SegmentoAncho);
		apuestaClikables.add(new ApuestaClikable(limite, TipoApuesta.IMPARES,
				ruleta.getImpares()));
		
		x += extraAncho;
		limite = new Rectangle(x, y, extraAncho, SegmentoAncho);
		apuestaClikables.add(new ApuestaClikable(limite, TipoApuesta.SEGUNDOS18,
				ruleta.getRangoNumero(19, 36)));
	}
	
	public ApuestaClikable contieneApuestaClikable(Point point) {

		for (ApuestaClikable apuestaClikable : apuestaClikables) {
			Rectangle bounds = apuestaClikable.getLimite();
			if (bounds.contains(point)) {
				return apuestaClikable;
			}
		}
			
		return null;
	}

}
