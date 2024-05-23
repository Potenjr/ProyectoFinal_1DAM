package ModelTest;

import RuletaApp.model.ValorFicha;
import RuletaApp.model.ValorFichas;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ValorFichasTest {

    @Test
    public void testGetValores() {
        ValorFichas valorFichas = new ValorFichas();
        List<ValorFicha> valores = valorFichas.getValores();

        assertNotNull(valores);
        assertEquals(3, valores.size());

        assertEquals(1, valores.get(0).getValor());
        assertEquals(5, valores.get(1).getValor());
        assertEquals(25, valores.get(2).getValor());
    }
}
