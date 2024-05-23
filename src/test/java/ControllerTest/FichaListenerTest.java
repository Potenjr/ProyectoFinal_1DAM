package ControllerTest;

import RuletaApp.controller.FichaListener;
import RuletaApp.model.*;
import RuletaApp.view.RuletaFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FichaListenerTest {

    private RuletaFrame frame;
    private RuletaModelo model;
    private FichaListener listener;
    private Jugador jugador;

    @BeforeEach
    public void setUp() {
        frame = mock(RuletaFrame.class);
        model = mock(RuletaModelo.class);
        listener = new FichaListener(frame, model);
        jugador = new Jugador("TestPlayer");
    }

    @Test
    public void testAddApuesta_WhenApuestaClikableIsNull() {
        Point point = new Point(100, 100);
        when(model.contieneApuestaClikable(point)).thenReturn(null);

        listener.addApuesta(jugador, point);

        // Verifica que no se realizó ninguna acción en el jugador
        assertEquals(0, jugador.getContadorFicha());
    }

}