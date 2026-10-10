package ar.edu.unahur.obj2.peluqueria.categoria;

import ar.edu.unahur.obj2.peluqueria.servicio.Servicio;

public class Vip implements Categoria{

    
    @Override 
    public Double calcularPrecio(Servicio servicio){
        return servicio.getPrecioBase() * 0.80;
    }
}


