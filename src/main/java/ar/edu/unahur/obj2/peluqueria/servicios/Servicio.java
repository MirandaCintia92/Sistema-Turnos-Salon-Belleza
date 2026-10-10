package ar.edu.unahur.obj2.peluqueria.servicios;

import ar.edu.unahur.obj2.peluqueria.*;
import ar.edu.unahur.obj2.peluqueria.excepciones.*;
import ar.edu.unahur.obj2.peluqueria.clientes.*


public abstract class Servicio {
    private Double precioBase;
    private Integer cuposDisponibles;

    public Servicio(Double precioBase, Integer cuposDisponibles){
        this.precioBase = validarPrecio(precioBase);
        this.cuposDisponibles = validarCupos(cuposDisponibles);
    }

private Integer validarCupos(Integer cupos) {
    if (losCuposSonInvalidos(cupos))
        throw new CantidadInvalidaException("los cupos disponibles no son validos, no pueden ser negativos");

    }
    return cupos; 
}

private Boolean losCuposSonInvalidos(Integer cupos){
    return cupos == null || cupos < 0;
}

public Integer getCuposDisponibles(){
    return cuposDisponibles;
}


public Double getPrecioBase(){
    return precioBase;
}

private Double validarPrecio(Double precio){
    if (esPrecioInvalido(precio)){
        throw new PrecioNegativoException("el precio no puede ser negativ0")
}
private Integer esPrecioInvalido(Double precio){
    return precio < 0.0;
    }

protected String generarComprobante(Integer nroTurno) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'generarComprobante'");
}

}