package ar.edu.unahur.obj2.peluqueria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.peluqueria.servicio.CorteDeCabello;
import ar.edu.unahur.obj2.peluqueria.turno.Turno;
import ar.edu.unahur.obj2.peluqueria.categoria.Frecuente;
import ar.edu.unahur.obj2.peluqueria.categoria.Ocasional;
import ar.edu.unahur.obj2.peluqueria.cliente.Cliente;

public class CorteDeCabelloTest {

    private Cliente clienteOcasional;
    private Cliente clienteFrecuente;
    private CorteDeCabello corte;

    @BeforeEach 
    void setUp(){
        clienteOcasional = new Cliente("sofia", new Ocasional());
        clienteFrecuente = new Cliente("Camila", new Frecuente());

    }
    @Test 
    public void dadoPrecioBaseYCuposValidos_alCrearElServicio_quedanRegistrados() {
        assertEquals(1000.0, corte.getPrecioBase());
        assertEquals(5, corte.getCuposDisponibles());
    }
    @Test 
    public void alConfirmarTurnoOcasional_calcularImporteYComprobante(){
        Turno turno = corte.confirmarTurno(clienteOcasional,1);

        assertEquals(1000.0, turno.getImporteTotal());
        assertEquals("TRN-COR-1", turno.getComprobante());
    }

    @Test 
    public void alConfirmarTurnoFrecuente_aplicarDescuentoDelDiezPorCiento(){
        Turno turno = corte.confirmarTurno(clienteFrecuente, 1);
        assertEquals(900.0, turno.getImporteTotal());    
    }


}
