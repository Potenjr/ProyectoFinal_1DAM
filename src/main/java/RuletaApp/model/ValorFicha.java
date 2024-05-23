package RuletaApp.model;

public class ValorFicha {
	
	private final int valor;
	
	public ValorFicha(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "$" + String.format("%,d", valor) + ".00";
	}
	
}

