package ar.edu.unahur.obj2.peluqueria.servicios;

public class Coloracion implements Servicio {
    private Boolean darAvisoDeColoracion;

    public Coloracion(Double precioBase, Integer cuposDisponibles){
        super(precioBase, cuposDisponibles){
        this.darAvisoDeColoracion = Boolean.FALSE;
    }
    @Override
    public Boolean darAvisoDeColoracion(){
        return darAvisoDeColoracion;
    }
    @Override 
    protected void registrarExtras(){
        this.darAvisoDeColoracion = Boolean.TRUE;
    }

    @Override 
    protected String generarComprobante(Integer nroTurno){
        return "TRN-COL-" + nroTurno;
    }
    
}
