package RuletaApp.model;

import java.util.ArrayList;
import java.util.List;

public class ValorFichas {
	
	private final List<ValorFicha> valores;
	
	public ValorFichas() {
		this.valores = new ArrayList<>();
		valores.add(new ValorFicha(1));
		valores.add(new ValorFicha(5));
		valores.add(new ValorFicha(25));
	}

	public List<ValorFicha> getValores() {
		return valores;
	}
	
}

