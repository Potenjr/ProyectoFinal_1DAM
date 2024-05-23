package RuletaApp.controller;

import RuletaApp.model.Apuesta;
import RuletaApp.model.Jugador;
import RuletaApp.model.JugadorApuestaError;
import RuletaApp.model.RuletaModelo;
import RuletaApp.view.RuletaFrame;
import RuletaApp.view.Texto.DialogoGanancias;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.Timer;


public class RuletaListener implements ActionListener {

	private int index;

	private final RuletaFrame frame;

	private final RuletaModelo model;

	private Timer timer;

	private RuletaApp.model.SegmentoRuleta SegmentoRuleta;

	public RuletaListener(RuletaFrame frame, RuletaModelo model) {
		this.frame = frame;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JugadorApuestaError JugApuestaErr = model.ApuestaValida();

		if (JugApuestaErr.getErrorCode() == 0) {
			this.index = model.getRandomIndex();
			this.SegmentoRuleta = model.getSegmentoRuleta(index);
			RuletasListener listener = new RuletasListener();
			timer = new Timer(40, listener);
			listener.setTimer(timer);
			timer.start();
			return;
		}

		if (JugApuestaErr.getErrorCode() == 1) {
			String s = "No se han realizado apuestas";
			JOptionPane.showMessageDialog(frame.getFrame(), s, "No se han realizado apuestas",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (JugApuestaErr.getErrorCode() == 2) {
			Jugador player = JugApuestaErr.getJugador();
			String s = player.getNombre() + " No se ha colocado el minimo de €" +
					String.format("%,.2f", (double) model.getApuestaMinima()) + ".";
			JOptionPane.showMessageDialog(frame.getFrame(), s, "No se han realizado apuestas",
					JOptionPane.ERROR_MESSAGE);
			model.LimpiarApuesta();
			frame.rehacerTabladeApuestas();
			return;
		}

		if (JugApuestaErr.getErrorCode() == 3) {
			Jugador player = JugApuestaErr.getJugador();
			String s = player.getNombre() + ", Puedes apostar un maximo de $" +
					String.format("%,.2f", (double) model.getApuestaMaximaInterna()) +
					" en apuesta interna.";
			JOptionPane.showMessageDialog(frame.getFrame(), s, "Exceso de apuesta Interna",
					JOptionPane.ERROR_MESSAGE);
			model.LimpiarApuesta();
			frame.rehacerTabladeApuestas();
			return;
		}

		if (JugApuestaErr.getErrorCode() == 4) {
			Jugador player = JugApuestaErr.getJugador();
			String s = player.getNombre() + ", Puedes apostar un maximo de $" +
					String.format("%,.2f", (double) model.getApuestaMaximaExterna()) +
					" en una apuesta externa.";
			JOptionPane.showMessageDialog(frame.getFrame(), s, "Exceso Apuesta Externa",
					JOptionPane.ERROR_MESSAGE);
			model.LimpiarApuesta();
			frame.rehacerTabladeApuestas();
			return;
		}

		if (JugApuestaErr.getErrorCode() == 5) {
			Jugador jugador = JugApuestaErr.getJugador();
			String s = jugador.getNombre() + ", No apuestes mas de lo que tienes.";
			JOptionPane.showMessageDialog(frame.getFrame(), s, "Apuesta demasiado grande",
					JOptionPane.ERROR_MESSAGE);
			model.LimpiarApuesta();
			frame.rehacerTabladeApuestas();
			return;
		}
	}

	private class RuletasListener implements ActionListener {

		private int contador, limite;

		private Timer timer;

		private RuletasListener() {

			Random random = new Random();
			this.contador = 0;
			this.limite = 200 + random.nextInt(100);
		}

		public void setTimer(Timer timer) {
			this.timer = timer;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			frame.inicializarRuleta();
			frame.RotarRuleta(8.0);
			contador++;
			if (contador >= limite) {
				frame.reposicionarRuleta(SegmentoRuleta, index);
				String numeros = SegmentoRuleta.getNumeroRuleta();
				frame.addLlamada(numeros, SegmentoRuleta.getColorFondo(),
						SegmentoRuleta.getColorFondo().equals(Color.BLACK));

				List<Apuesta> ganancias = model.getGanancias(numeros);
				model.LimpiarApuesta();

				if (ganancias.size() > 0) {
					new DialogoGanancias(frame, ganancias, numeros, "Ganancias");
				}

				for (Apuesta ganador : ganancias) {
					Jugador jugador = ganador.getJugador();
					int contadorFichas = ganador.getContadorFichas();
					int pago = ganador.getTipoApuesta().getPago();
					int totalPago = pago * contadorFichas;
					jugador.addFichas(totalPago);
				}

				frame.updatePanelJugador();
				frame.rehacerTabladeApuestas();
				timer.stop();
			}
		}

	}

}
