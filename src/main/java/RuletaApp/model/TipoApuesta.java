package RuletaApp.model;

public enum TipoApuesta {
	NUMERO(36, true, "Numero a apostar"),
	APUESTA_DIVIDIDA(18, true, "Apostar entre 2 numeros"),
	TRES_VALORES_00(12, true, "00, 1, 2 combinacion"),
	TRES_VALORES_0(12, true, "0, 2, 3 combinacion"),
	APUESTA_CALLE(12, true, "Apuesta por cualquier fila de tres números"),
	CUATRO_ESQUINAS(9, true, "Apuesta 4 numeros de las esquinas"),
	APUESTA_LINEA(6, true, "Culaquir par de una linea"),
	APUESTA_COLUMNA(3, false, "Apostar la columna"),
	PRIMEROS12(3, false, "Los numeros del 1 al 12"),
	SEGUNDOS12(3, false, "Los numeros del 13 al 24"),
	TERCEROS12(3, false, "Los numeros del 25 al 36"),
	PRIMEROS18(2, false, "Los numeros del 1 al 18"),
	SEGUNDOS18(2, false, "Los numeros del 19 al 36"),
	IMPARES(2, false, "Apuesta a impares"),
	PARES(2, false, "Apuesta a pares"),
	ROJO(2, false, "Apuesta a rojos"),
	NEGRO(2, false, "Apuesta a negros");

	private final boolean ApuestaInterna;
	
	private final int pago;
	
	private final String descripcion;

	private TipoApuesta(int pago, boolean ApuestaInterna, String descripcion) {
		this.pago = pago;
		this.ApuestaInterna = ApuestaInterna;
		this.descripcion = descripcion;
	}

	public int getPago() {
		return pago;
	}

	public boolean isApuestaInterna() {
		return ApuestaInterna;
	}

	public String getDescripcion() {
		return descripcion;
	}


}
