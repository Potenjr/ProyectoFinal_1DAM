package ControllerTest;



import RuletaApp.controller.EliminarJugadorListener;
import RuletaApp.model.Jugador;
import RuletaApp.model.RuletaModelo;
import RuletaApp.view.RuletaFrame;
import RuletaApp.view.Texto.DialogoPanelEliminarJugador;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class EliminarJugadorListenerTest {

    @Mock
    private RuletaFrame mockFrame;
    @Mock
    private RuletaModelo mockModel;
    @Mock
    private DialogoPanelEliminarJugador mockDialog;

    private EliminarJugadorListener listener;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initialize the mock objects
        listener = new EliminarJugadorListener(mockFrame, mockModel, mockDialog);
    }

    @Test
    public void testActionPerformed() {
        // Mock the Jugador object
        Jugador jugador = new Jugador("TestPlayer");

        // Mock the model to return the Jugador object
        when(mockModel.getEleccionJugador()).thenReturn(jugador);

        // Call the actionPerformed method
        listener.actionPerformed(null);

        // Verify that the methods in the model and frame were called
        verify(mockModel).setJugadorSeleccionado(null);
        verify(mockModel).removeJugador(jugador);
        verify(mockFrame).updatePanelJugador();
        verify(mockDialog).dispose();
    }



}