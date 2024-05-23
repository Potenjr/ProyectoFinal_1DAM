package ControllerTest;

import static org.junit.Assert.*;

import RuletaApp.controller.AñadirJugadorListener;
import RuletaApp.model.RuletaModelo;
import RuletaApp.view.RuletaFrame;
import RuletaApp.view.Texto.AñadirJugadorDialogo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class AñadirListenerJugadorTest {

    @Mock
    private RuletaFrame mockFrame;
    @Mock
    private RuletaModelo mockModel;
    @Mock
    private AñadirJugadorDialogo mockDialog;

    private AñadirJugadorListener listener;

    @Before
    public void setUp() {
        listener = new AñadirJugadorListener(mockFrame, mockModel, mockDialog);
    }

    @Test
    public void testValueOfValidNumber() {
        double result = listener.valueOf("50");
        assertEquals(50.0, result, 0.01);
    }

    @Test
    public void testValueOfInvalidNumber() {
        double result = listener.valueOf("abc");
        assertEquals(Double.MIN_VALUE, result, 0.01);
    }

}