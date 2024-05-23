package ViewTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTable;
import RuletaApp.model.RuletaModelo;
import RuletaApp.model.SegmentoRuleta;
import RuletaApp.view.RuletaFrame;

class RuletaFrameTest {

    @Test
    void testAddLlamada() {
        RuletaModelo modelo = new RuletaModelo();
        RuletaFrame frame = new RuletaFrame(modelo);
        frame.addLlamada("10", Color.RED, true);
        // Verificar si se agregó la llamada correctamente

    }


    @Test
    void testGetTablaJugador() {
        RuletaModelo modelo = new RuletaModelo();
        RuletaFrame frame = new RuletaFrame(modelo);
        JTable tabla = frame.getTablaJugador();
        // Verificar si la tabla devuelta no es nula
        assertNotNull(tabla);
        // Podríamos hacer más pruebas para asegurarnos de que la tabla tiene el modelo esperado, columnas, etc.
    }


    @Test
    void testGetFrame() {
        RuletaModelo modelo = new RuletaModelo();
        RuletaFrame frame = new RuletaFrame(modelo);
        JFrame frameObtenido = frame.getFrame();
        // Verificar si el marco devuelto no es nulo
        assertNotNull(frameObtenido);
        // Podríamos hacer más pruebas para asegurarnos de que el marco tiene el título, tamaño, etc., esperados.
    }
}