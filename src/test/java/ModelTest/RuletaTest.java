package ModelTest;

import RuletaApp.model.Ruleta;
import RuletaApp.model.SegmentoRuleta;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

public class RuletaTest {

    @Test
    public void testLength() {
        Ruleta ruleta = new Ruleta();
        assertEquals(38, ruleta.length());
    }

    @Test
    public void testGetSegmento() {
        Ruleta ruleta = new Ruleta();
        SegmentoRuleta segmento = ruleta.getSegmento(0);
        assertNotNull(segmento);
    }

    @Test
    public void testGetSegmentoRuleta() {
        Ruleta ruleta = new Ruleta();
        SegmentoRuleta[] segmentos = ruleta.getSegmentoRuleta();
        assertNotNull(segmentos);
        assertEquals(38, segmentos.length);
    }

    @Test
    public void testGetRangoNumero() {
        Ruleta ruleta = new Ruleta();
        String[] rango = ruleta.getRangoNumero(1, 10);
        assertNotNull(rango);
        assertEquals(10, rango.length);
        assertEquals("1", rango[0]);
        assertEquals("10", rango[9]);
    }

    @Test
    public void testGetImpares() {
        Ruleta ruleta = new Ruleta();
        String[] impares = ruleta.getImpares();
        assertNotNull(impares);
        assertEquals(18, impares.length);
        assertEquals("1", impares[0]);
        assertEquals("35", impares[17]);
    }

    @Test
    public void testGetPares() {
        Ruleta ruleta = new Ruleta();
        String[] pares = ruleta.getPares();
        assertNotNull(pares);
        assertEquals(18, pares.length);
        assertEquals("2", pares[0]);
        assertEquals("36", pares[17]);
    }

    @Test

    public void testGetNumeroNegro() {
        Ruleta ruleta = new Ruleta();
        String[] numerosNegros = ruleta.getNumeroNegro();
        assertEquals("10", numerosNegros[0]);
    }

    @Test
    public void testGetBackgroundColor() {
        Ruleta ruleta = new Ruleta();
        Color color = ruleta.getBackgroundColor(0); // Se espera el color correspondiente al número 10
        assertEquals(new Color(56, 173, 2), color); // Color esperado para el número 10
    }

    @Test
    public void testGetNumerosRojos() {
        Ruleta ruleta = new Ruleta();
        String[] numerosRojos = ruleta.getNumerosRojos();
        assertEquals("27", numerosRojos[0]); // El primer número rojo es "1"
    }
}

