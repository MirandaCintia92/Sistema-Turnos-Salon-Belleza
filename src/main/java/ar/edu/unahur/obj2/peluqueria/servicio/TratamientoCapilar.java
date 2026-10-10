package ar.edu.unahur.obj2.peluqueria.servicio;


public class TratamientoCapilar extends Servicio {
    public TratamientoCapilar(Double precioBase, Integer cuposDisponibles){
        super(precioBase, cuposDisponibles);
    }
    @Override 
    protected String generarComprobante(Integer nroTurno){
    return "TRN-COR-" + nroTurno;
}
}
