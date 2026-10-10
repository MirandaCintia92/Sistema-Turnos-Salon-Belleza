package ar.edu.unahur.obj2.peluqueria.servicio;


import ar.edu.unahur.obj2.peluqueria.cliente.Cliente;
import ar.edu.unahur.obj2.peluqueria.configuracion.ConfiguracionPeluqueria;
import ar.edu.unahur.obj2.peluqueria.turno.*;
import ar.edu.unahur.obj2.peluqueria.excepciones.*;




public abstract class Servicio {
    private Double precioBase;
    private Integer cuposDisponibles;

    public Servicio(Double precioBase, Integer cuposDisponibles){
        this.precioBase = validarPrecio(precioBase);
        this.cuposDisponibles = validarCupos(cuposDisponibles);
    }

    private Integer validarCupos(Integer cupos) {
        if (losCuposSonInvalidos(cupos)){
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
            throw new PrecioNegativoException("el precio no puede ser negativo");
        }
        return precio;
    }


    private boolean esPrecioInvalido(Double precio){
        return precio < 0.0;
        }

    public final Turno confirmarTurno(Cliente cliente, Integer sesiones){
        if (sonSesionesInvalidas(sesiones)){
            throw new CantidadInvalidaException("la cantidad de sesiones debe ser mayores a cero");
        }
        if(sonCuposInsuficientes(sesiones)){
            throw new CantidadInvalidaException("cupos insuficientes para la cantidad de sesiones solicitadas");
        }
        this.cuposDisponibles = cuposDisponibles - sesiones;
        Double precioUnitario = cliente.getCategoria().calcularPrecio(this);
        Double importeTotal = (precioUnitario * sesiones) + ConfiguracionPeluqueria.getInstancia().getRecargoConInsumos();
        Integer nroTurno = ConfiguracionPeluqueria.getInstancia().darSiguienteTurno();
        
        String comprobante = generarComprobante(nroTurno);
        registrarExtras();
        Turno turno = new Turno(cliente, null, sesiones, importeTotal, comprobante);
        cliente.agregarTurnoAlHistorial(turno);
    
        return turno;
    }




    private Boolean sonSesionesInvalidas(Integer sesiones){
        return sesiones == null || sesiones <= 0;
    }
    private Boolean sonCuposInsuficientes(Integer sesiones){
        return this.cuposDisponibles < sesiones;
    }
    protected abstract String generarComprobante(Integer nroTurno); 
    protected void registrarExtras(){}


}