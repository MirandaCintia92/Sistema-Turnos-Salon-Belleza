package ar.edu.unahur.obj2.peluqueria.turno;

import ar.edu.unahur.obj2.peluqueria.cliente.*;
import ar.edu.unahur.obj2.peluqueria.servicio.*;

public class Turno {
    private final Cliente cliente;
    private final Servicio servicio;
    private Integer sesiones;
    private final Double importeTotal;
    private final String comprobante;
    

    public Turno (Cliente cliente, Servicio servicio, Integer sesiones, Double importeTotal, String comprobante ){
        this.cliente = cliente;
        this.servicio = servicio;
        this.sesiones = sesiones;
        this.importeTotal = importeTotal;
        this.comprobante = comprobante;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public Servicio getServicio(){
        return servicio;
    
    }

    public Integer getSesiones(){
        return sesiones;
    }

    public Double getImporteTotal(){
        return importeTotal;
    }
    public String getComprobante(){
        return comprobante;
    }

}
