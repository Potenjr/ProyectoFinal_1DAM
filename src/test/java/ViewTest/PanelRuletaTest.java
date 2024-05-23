package ViewTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import RuletaApp.model.RuletaModelo;
import RuletaApp.model.SegmentoRuleta;
import RuletaApp.view.PanelRuleta;
import RuletaApp.view.RuletaFrame;

import javax.swing.JPanel;

class PanelRuletaTest {

    private RuletaFrame frame;
    private RuletaModelo modelo;
    private PanelRuleta panelRuleta;

    @BeforeEach
    void setUp() {
        //frame = new RuletaFrame();
        modelo = new RuletaModelo();
        panelRuleta = new PanelRuleta(frame, modelo);
    }

    @Test
    void testInicializarRuleta() {
        panelRuleta.inicializarRuleta();
        // Verificar que la ruleta se inicializó correctamente
        assertNotNull(panelRuleta.getPanel());

    }


    @Test
    void testRotarRuleta() {
        panelRuleta.rotarRuleta(90);
        // Verificar que la ruleta se rotó correctamente en el ángulo especificado

    }

    @Test
    void testRepintarRuleta() {
        //una prueba simple para verificar si el método no produce errores
        assertDoesNotThrow(() -> panelRuleta.repintarRuleta());

    }

    @Test
    void testGetPanel() {
        JPanel panel = panelRuleta.getPanel();
        assertNotNull(panel);

    }
}