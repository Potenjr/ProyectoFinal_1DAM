package ModelTest;

import RuletaApp.model.Apuesta;
import RuletaApp.model.Jugador;
import RuletaApp.model.TipoApuesta;
import org.junit.jupiter.api.Test;

import java.awt.Point;

import static org.junit.jupiter.api.Assertions.*;

public class ApuestaTest {

    @Test
    public void testEsMismaApuesta() {
        Jugador jugador = new Jugador("Test");
        TipoApuesta tipoApuesta = TipoApuesta.PARES;
        String[] numerosApostados = {"2", "4", "6"};

        Apuesta apuesta1 = new Apuesta(new Point(100, 100), jugador, tipoApuesta, numerosApostados);
        Apuesta apuesta2 = new Apuesta(new Point(100, 100), jugador, tipoApuesta, numerosApostados);
        Apuesta apuesta3 = new Apuesta(new Point(200, 200), jugador, tipoApuesta, numerosApostados);

        assertTrue(apuesta1.EsMismaApuesta(apuesta2));
        assertFalse(apuesta1.EsMismaApuesta(apuesta3));
    }

    @Test
    public void testIsGanador() {
        Jugador jugador = new Jugador("Test");
        TipoApuesta tipoApuesta = TipoApuesta.PARES;
        String[] numerosApostados = {"2", "4", "6"};

        Apuesta apuesta = new Apuesta(new Point(100, 100), jugador, tipoApuesta, numerosApostados);

        assertTrue(apuesta.isGanador("2"));
        assertTrue(apuesta.isGanador("4"));
        assertTrue(apuesta.isGanador("6"));
        assertFalse(apuesta.isGanador("1"));
        assertFalse(apuesta.isGanador("3"));
        assertFalse(apuesta.isGanador("5"));
    }

    @Test
    public void testPonerCantidadApuesta() {
        Jugador jugador = new Jugador("Test");
        TipoApuesta tipoApuesta = TipoApuesta.PARES;
        String[] numerosApostados = {"2", "4", "6"};

        Apuesta apuesta = new Apuesta(new Point(100, 100), jugador, tipoApuesta, numerosApostados);

        apuesta.ponerCantidadApuesta(5, 10);
        assertEquals(5, apuesta.getContadorFichas());
        assertEquals(10, apuesta.getValorFicha());
    }
}
