package ar.edu.unahur.obj2.peluqueria.servicio;

public class Coloracion extends Servicio {
    private Boolean avisoDeColoracion;

    public Coloracion(Double precioBase, Integer cuposDisponibles){
        super(precioBase, cuposDisponibles);
        this.avisoDeColoracion = Boolean.FALSE;
    }

    public Boolean getAvisoDeColoracion(){
        return avisoDeColoracion;
    }


    @Override 
    protected void registrarExtras(){
        this.avisoDeColoracion = Boolean.TRUE;
    }

    @Override 
    protected String generarComprobante(Integer nroTurno){
        return "TRN-COL-" + nroTurno;
    }
}

