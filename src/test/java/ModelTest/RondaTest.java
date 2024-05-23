package ModelTest;

import RuletaApp.model.Apuesta;
import RuletaApp.model.Jugador;
import RuletaApp.model.Ronda;
import RuletaApp.model.TipoApuesta;
import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RondaTest {

    @Test
    public void testAddApuesta() {
        Ronda ronda = new Ronda();
        Jugador jugador = new Jugador("Test");
        Apuesta apuesta = new Apuesta(new Point(100, 100), jugador, null, "1", "2", "3");

        ronda.addApuesta(apuesta);

        List<Apuesta> apuestas = ronda.getApuesta();
        assertEquals(1, apuestas.size());
        assertEquals(apuesta, apuestas.get(0));
    }



    @Test
    public void testGetApuestaGanadora() {
        Ronda ronda = new Ronda();
        Jugador jugador = new Jugador("Test");
        Apuesta apuestaGanadora = new Apuesta(new Point(100, 100), jugador, null, "1", "2", "3");
        ronda.addApuesta(apuestaGanadora);

        List<Apuesta> apuestasGanadoras = ronda.getApuestaGanadora("1");

        assertEquals(1, apuestasGanadoras.size());
        assertTrue(apuestasGanadoras.contains(apuestaGanadora));
    }

    @Test
    public void testGetApuesta() {
        Ronda ronda = new Ronda();
        Jugador jugador = new Jugador("Test");
        Apuesta apuesta = new Apuesta(new Point(100, 100), jugador, null, "1", "2", "3");
        ronda.addApuesta(apuesta);

        List<Apuesta> apuestasJugador = ronda.getApuesta(jugador);

        assertEquals(1, apuestasJugador.size());
        assertTrue(apuestasJugador.contains(apuesta));
    }
}
