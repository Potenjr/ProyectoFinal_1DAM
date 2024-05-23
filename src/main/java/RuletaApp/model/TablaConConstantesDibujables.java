package RuletaApp.model;

public class TablaConConstantesDibujables {
	
	private final int AnchuraSegmento, margen, lineaMargen, imagenMargen;
	
	public TablaConConstantesDibujables() {
		this.imagenMargen = 10;
		this.margen = 30;
		this.lineaMargen = 3;
		this.AnchuraSegmento = 64;
	}

	public int getSegmentoAncho() {
		return AnchuraSegmento;
	}

	public int getMargen() {
		return margen;
	}

	public int getLineaMargen() {
		return lineaMargen;
	}

	public int getImagenMargen() {
		return imagenMargen;
	}

}
