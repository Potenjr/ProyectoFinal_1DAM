package ModelTest;

import RuletaApp.model.SegmentoRuleta;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.awt.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SegmentoRuletaTest {

    @Test
    public void testConstructorAndGetters() {
        Color colorFondo = Color.RED;
        Point delta = new Point(1, 1);
        String numeroRuleta = "1";

        SegmentoRuleta segmento = new SegmentoRuleta(numeroRuleta, colorFondo, delta);

        assertEquals(colorFondo, segmento.getColorFondo());
        assertEquals(delta, segmento.getDelta());
        assertEquals(numeroRuleta, segmento.getNumeroRuleta());
    }

    @Test
    public void testGettersNotNull() {
        Color colorFondo = Color.BLACK;
        Point delta = new Point(2, 2);
        String numeroRuleta = "27";

        SegmentoRuleta segmento = new SegmentoRuleta(numeroRuleta, colorFondo, delta);

        assertNotNull(segmento.getColorFondo());
        assertNotNull(segmento.getDelta());
        assertNotNull(segmento.getNumeroRuleta());
    }
}
