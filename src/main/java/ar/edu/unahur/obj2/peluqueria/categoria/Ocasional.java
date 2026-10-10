package ar.edu.unahur.obj2.peluqueria.categoria;

import ar.edu.unahur.obj2.peluqueria.servicio.Servicio;

public class Ocasional implements Categoria {
    
    @Override 
    public Double calcularPrecio(Servicio servicio){
        return servicio.getPrecioBase();
    }
}
