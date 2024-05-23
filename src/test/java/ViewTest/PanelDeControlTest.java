package ViewTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import javax.swing.JTable;

import RuletaApp.model.RuletaModelo;
import RuletaApp.view.PanelDeControl;
import RuletaApp.view.RuletaFrame;

class PanelDeControlTest {

    private RuletaFrame frame;
    private RuletaModelo modelo;
    private PanelDeControl panelDeControl;

    @BeforeEach
    void setUp() {
        //frame = new RuletaFrame();
        modelo = new RuletaModelo();
        panelDeControl = new PanelDeControl(frame, modelo);
    }

    @Test
    void testGetPanel() {
        assertNotNull(panelDeControl.getPanel());
    }


    @Test
    void testActualizarJugadorPanel() {
        panelDeControl.ActualizarJugadorPanel();
        // Aquí podrías añadir más validaciones específicas si lo deseas
    }

    @Test
    void testGetTablaJugador() {
        assertNotNull(panelDeControl.getTablaJugador());
    }
}