package ar.edu.unahur.obj2.peluqueria.servicios;

public class CorteDeCabello extends Servicio{
    public CorteDeCabello(Double precioBase, Integer cuposDisponibles){
    super(precioBase, cuposDisponibles);
}

@Override 
protected String generarComprobante(Integer nroTurno){
    return "TRN-COR-" + nroTurno;
}
}