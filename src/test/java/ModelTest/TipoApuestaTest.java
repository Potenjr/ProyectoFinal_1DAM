package ModelTest;

import RuletaApp.model.TipoApuesta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipoApuestaTest {

    @Test
    public void testPago() {
        assertEquals(36, TipoApuesta.NUMERO.getPago());
        assertEquals(18, TipoApuesta.APUESTA_DIVIDIDA.getPago());
        assertEquals(12, TipoApuesta.TRES_VALORES_00.getPago());
        assertEquals(12, TipoApuesta.TRES_VALORES_0.getPago());
        assertEquals(12, TipoApuesta.APUESTA_CALLE.getPago());
        assertEquals(9, TipoApuesta.CUATRO_ESQUINAS.getPago());
        assertEquals(6, TipoApuesta.APUESTA_LINEA.getPago());
        assertEquals(3, TipoApuesta.APUESTA_COLUMNA.getPago());
        assertEquals(3, TipoApuesta.PRIMEROS12.getPago());
        assertEquals(3, TipoApuesta.SEGUNDOS12.getPago());
        assertEquals(3, TipoApuesta.TERCEROS12.getPago());
        assertEquals(2, TipoApuesta.PRIMEROS18.getPago());
        assertEquals(2, TipoApuesta.SEGUNDOS18.getPago());
        assertEquals(2, TipoApuesta.IMPARES.getPago());
        assertEquals(2, TipoApuesta.PARES.getPago());
        assertEquals(2, TipoApuesta.ROJO.getPago());
        assertEquals(2, TipoApuesta.NEGRO.getPago());
    }

    @Test
    public void testApuestaInterna() {
        assertEquals(true, TipoApuesta.NUMERO.isApuestaInterna());
        assertEquals(true, TipoApuesta.APUESTA_DIVIDIDA.isApuestaInterna());
        assertEquals(true, TipoApuesta.TRES_VALORES_00.isApuestaInterna());
        assertEquals(true, TipoApuesta.TRES_VALORES_0.isApuestaInterna());
        assertEquals(true, TipoApuesta.APUESTA_CALLE.isApuestaInterna());
        assertEquals(true, TipoApuesta.CUATRO_ESQUINAS.isApuestaInterna());
        assertEquals(true, TipoApuesta.APUESTA_LINEA.isApuestaInterna());
        assertEquals(false, TipoApuesta.APUESTA_COLUMNA.isApuestaInterna());
        assertEquals(false, TipoApuesta.PRIMEROS12.isApuestaInterna());
        assertEquals(false, TipoApuesta.SEGUNDOS12.isApuestaInterna());
        assertEquals(false, TipoApuesta.TERCEROS12.isApuestaInterna());
        assertEquals(false, TipoApuesta.PRIMEROS18.isApuestaInterna());
        assertEquals(false, TipoApuesta.SEGUNDOS18.isApuestaInterna());
        assertEquals(false, TipoApuesta.IMPARES.isApuestaInterna());
        assertEquals(false, TipoApuesta.PARES.isApuestaInterna());
        assertEquals(false, TipoApuesta.ROJO.isApuestaInterna());
        assertEquals(false, TipoApuesta.NEGRO.isApuestaInterna());
    }
}

