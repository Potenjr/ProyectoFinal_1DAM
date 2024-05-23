package RuletaApp.model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RuletaModelo {
	
	private final int ApuestaMinima;
	private final int ApuestaMaximaInterna;
	private final int ApuestaMaximaExterna;
	
	private final ValorFichas valorFichas;
	
	private final ApuesatsClikables apuestasClikables;
	
	private final List<Jugador> jugador;
	
	private Jugador JugadorSeleccionado;
	
	private final Random random;
	
	private final Ronda ronda;
	
	private final FichasRuleta fichasRuleta;
	
	private final Ruleta ruleta;
	
	public RuletaModelo() {
		this.valorFichas = new ValorFichas();
		this.fichasRuleta = new FichasRuleta();
		this.ruleta = new Ruleta();
		this.random = new Random();
		this.ronda = new Ronda();
		this.ApuestaMinima = 4;
		this.ApuestaMaximaInterna = 25;
		this.ApuestaMaximaExterna = 200;
		this.jugador = new ArrayList<>();
		this.JugadorSeleccionado = null;
		this.apuestasClikables = new ApuesatsClikables();
	}

	public ApuestaClikable contieneApuestaClikable(Point point) {
		return apuestasClikables.contieneApuestaClikable(point);
	}
	
	public void addJugador(Jugador jugador) {
		this.jugador.add(jugador);
	}
	
	public void removeJugador(Jugador jugador) {
		FichaRuleta fichaRuleta = jugador.getFichaRuleta();
		this.fichasRuleta.addFichaRuleta(fichaRuleta);
		this.jugador.remove(jugador);
	}
	
	public List<Jugador> getJugador() {
		return jugador;
	}
	
	public Jugador getJugador(String nombre) {
		for (Jugador jugador : jugador) {
			if (jugador.getNombre().equals(nombre)) {
				return jugador;
			}
		}
		
		return null;
	}
	

	public JugadorApuestaError ApuestaValida() {
		List<Apuesta> apuesta = ronda.getApuesta();
		if (apuesta.size() <= 0) {
			return new JugadorApuestaError(1, null);
		}
		
		for (Jugador jugador : jugador) {
			List<Apuesta> Apostadores = ronda.getApuesta(jugador);
			int cantidad = 0;
			for (Apuesta Apuesta : Apostadores) {
				cantidad += Apuesta.getContadorFichas() * Apuesta.getValorFicha();
				if (Apuesta.getTipoApuesta().isApuestaInterna()) {
					int CantidadInterna = Apuesta.getContadorFichas() * Apuesta.getValorFicha();
					if (CantidadInterna > ApuestaMaximaInterna) {
						return new JugadorApuestaError(3, jugador);
					}
				} else {
					int outerAmount = Apuesta.getContadorFichas() * Apuesta.getValorFicha();
					if (outerAmount > ApuestaMaximaExterna) {
						return new JugadorApuestaError(4, jugador);
					}
				}
			}
			
			if (cantidad < ApuestaMinima) {
				return new JugadorApuestaError(2, jugador);
			}
			
			if (cantidad > jugador.getBalance()) {
				return new JugadorApuestaError(5, jugador);
			}
			
		}
		
		return new JugadorApuestaError(0, null);
	}
	
	public Jugador getEleccionJugador() {
		return JugadorSeleccionado;
	}

	public void setJugadorSeleccionado(Jugador jugadorSeleccionado) {
		this.JugadorSeleccionado = jugadorSeleccionado;
	}

	public void addFichaRuleta(FichaRuleta fichaRuleta) {
		fichasRuleta.addFichaRuleta(fichaRuleta);
	}

	public void EliminarFicha(FichaRuleta fichaRuleta) {
		fichasRuleta.removeFichaRuleta(fichaRuleta);
	}
	
	public FichasRuleta getFichasRuleta() {
		return fichasRuleta;
	}
	
	public List<Apuesta> getApuesta() {
		return ronda.getApuesta();
	}
	
	public List<Apuesta> getGanancias(String number) {
		return ronda.getApuestaGanadora(number);
	}

	public void addApuesta(Apuesta apuesta) {
		ronda.addApuesta(apuesta);
	}
	
	public void LimpiarApuesta() {
		ronda.limpiarApuesta();
	}
	
	public int getApuestaMinima() {
		return ApuestaMinima;
	}

	public int getApuestaMaximaInterna() {
		return ApuestaMaximaInterna;
	}

	public int getApuestaMaximaExterna() {
		return ApuestaMaximaExterna;
	}

	public ValorFichas getValorFichas() {
		return valorFichas;
	}

	public Color getColorRojo() {
		return ruleta.getRojo();
	}
	
	public Color getColorVerde() {
		return ruleta.getVerde();
	}
	
	public SegmentoRuleta[] getSegmentoRuleta() {
		return ruleta.getSegmentoRuleta();
	}
	
	public int getTamañoSegmento() {
		return ruleta.length();
	}
	
	public int getRandomIndex() {
		return random.nextInt(ruleta.length());
	}
	
	public SegmentoRuleta getSegmentoRuleta(int index) {
		return ruleta.getSegmento(index);
	}

}
