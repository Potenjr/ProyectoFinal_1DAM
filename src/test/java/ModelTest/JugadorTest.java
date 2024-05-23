package ModelTest;

import RuletaApp.model.FichaRuleta;
import RuletaApp.model.Jugador;
import RuletaApp.model.ValorFicha;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JugadorTest {

    @Test
    public void testCompra() {
        Jugador jugador = new Jugador("Test");
        int cantidadCompra = 100;
        ValorFicha valorFicha = new ValorFicha(30);

        jugador.compra(cantidadCompra, valorFicha);

        assertEquals(cantidadCompra, jugador.getBalance());
        assertEquals(cantidadCompra, jugador.getCantidadCompra());
        assertEquals(cantidadCompra / valorFicha.getValor(), jugador.getContadorFicha());
        assertEquals(valorFicha.getValor(), jugador.getValorFicha());
    }

    @Test
    public void testEliminarFicha() {
        Jugador jugador = new Jugador("Test");
        jugador.compra(100, new ValorFicha(30));

        jugador.EliminarFicha(2);

        assertEquals(40, jugador.getBalance());
        assertEquals(40 / 30, jugador.getContadorFicha());
    }

    @Test
    public void testAddFichas() {
        Jugador jugador = new Jugador("Test");
        jugador.compra(100, new ValorFicha(30));

        jugador.addFichas(3);

        assertEquals(190, jugador.getBalance());
        assertEquals(190 / 30, jugador.getContadorFicha());
    }

    @Test
    public void testGetColorFicha() {
        Jugador jugador = new Jugador("Test");
        FichaRuleta fichaRuleta = new FichaRuleta(Color.RED, Color.BLACK);
        jugador.setFichaRuleta(fichaRuleta);

        assertNotNull(jugador.getChipColor());
    }
}

