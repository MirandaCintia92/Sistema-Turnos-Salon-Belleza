package ar.edu.unahur.obj2.peluqueria.configuracion;
import  ar.edu.unahur.obj2.peluqueria.excepciones.*;

public  class ConfiguracionPeluqueria {
    private static ConfiguracionPeluqueria instancia;
    private Double recargoConInsumos;
    private Integer contadorTurnos;

    private ConfiguracionPeluqueria(){
        this.recargoConInsumos = 0.0;
        this.contadorTurnos =  0;
    }
    

public  ConfiguracionPeluqueria getInstancia(){


    if (instancia ==  null) {
        instancia = new ConfiguracionPeluqueria();
    }
    return instancia;

}

public Double getRecargoInsumos(){
    return recargoInsumos;
}


public void setRecargoInsumos(Double recargoInsumos){
    if (esRecargoInvalido(recargoInsumos)){
        throw new PrecioNegativoException("el recargo no puede ser negativo");
    }
    this.recargoInsumos = recargoInsumos;
}
private Boolean esRecargoInvalido(Double recargo){
    return  recargo < 0;
}

public Integer getContadorTurnosInteger(){
    return contadorTurnos;
}

public Integer darSiguienteTurno(){
    this.contadorTurnos = contadorTurnos + 1;
    return this.contadorTurnos;

}

public void reiniciar(){
    this.contadorTurnos = 0;
    this.recargoInsumos = 0.0;
}

}