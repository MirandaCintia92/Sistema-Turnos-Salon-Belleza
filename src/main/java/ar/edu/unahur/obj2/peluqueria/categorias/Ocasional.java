package ar.edu.unahur.obj2.peluqueria.categorias;

import ar.edu.unahur.obj2.peluqueria.servicios.Servicio;

public class Ocasional implements Categoria {
    
    @Override 
    public Double calcularPrecio(Servicio servicio){
        return servicio.getPrecioBase();
    }
}
