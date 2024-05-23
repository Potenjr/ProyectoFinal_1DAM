package RuletaApp.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class FichasRuleta {
	
	private final List<FichaRuleta> fichasRuleta;
	
	public FichasRuleta() {
		this.fichasRuleta = GenerearFicha();
	}
	
	private List<FichaRuleta> GenerearFicha() {
		List<FichaRuleta> fichasRuleta = new ArrayList<>();

		fichasRuleta.add(new FichaRuleta(Color.BLUE, Color.YELLOW));
		fichasRuleta.add(new FichaRuleta(Color.ORANGE, Color.BLACK));
		fichasRuleta.add(new FichaRuleta(Color.CYAN, Color.BLUE));
		fichasRuleta.add(new FichaRuleta(Color.LIGHT_GRAY, Color.BLACK));
		fichasRuleta.add(new FichaRuleta(Color.BLACK, Color.WHITE));
		fichasRuleta.add(new FichaRuleta(Color.PINK, Color.BLACK));
		fichasRuleta.add(new FichaRuleta(Color.YELLOW, Color.BLUE));
		fichasRuleta.add(new FichaRuleta(Color.GREEN, Color.BLUE));
		
		return fichasRuleta;
	}
	
	public void addFichaRuleta(FichaRuleta fichaRuleta) {
		this.fichasRuleta.add(fichaRuleta);
	}
	
	public void removeFichaRuleta(FichaRuleta fichaRuleta) {
		this.fichasRuleta.remove(fichaRuleta);
	}

	public List<FichaRuleta> getFichasRuleta() {
		return fichasRuleta;
	}

}
