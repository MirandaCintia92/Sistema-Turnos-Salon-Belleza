package ar.edu.unahur.obj2.peluqueria.cliente;
import  java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.peluqueria.categoria.Categoria;
import ar.edu.unahur.obj2.peluqueria.categoria.Ocasional;
import  ar.edu.unahur.obj2.peluqueria.categoria.Vip;
import  ar.edu.unahur.obj2.peluqueria.excepciones.*;
import ar.edu.unahur.obj2.peluqueria.turno.Turno;



public class Cliente {
    private final String nombre;
    private Categoria categoria;
    private List<Turno> hitorialTurnos;




    public Cliente(String nombre, Categoria categoria){
        this.nombre = nombre;
        this.categoria = new Ocasional();
        this.hitorialTurnos = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }

    public Categoria getCategoria(){
        return this.categoria;
    }

    public void setCategoria(Categoria nuevaCategoria){
        if (esVipNoAutorizado(nuevaCategoria)){
            throw new CategoriaNoAutorizadaException("no se puede asignar la categoria Vip");
        }
        this.categoria = nuevaCategoria;
    }

    private boolean esVipNoAutorizado(Categoria nuevCategoria){
        return nuevCategoria instanceof Vip && this.hitorialTurnos.isEmpty();
    }


    public void agregarTurnoAlHistorial(Turno turno){
        this.hitorialTurnos.add(turno);
    }
    public  List<Turno> getHistorialTurnos(){
        if(this.hitorialTurnos.isEmpty()){
            throw new ClienteSinTurnosException("El cliente no posee turnos en su historial");
        }
        return this.hitorialTurnos;
    }
    public Double getCostoTotalTurnos(){
        Double total = 0.0;
        for(Turno turno : this.hitorialTurnos){
            total += turno.getImporteTotal();
        }
        return total;
    }
}
