package ar.edu.unahur.obj2.peluqueria.excepciones;

public class CategoriaInvalidaException extends RuntimeException {
    public CategoriaInvalidaException(String mensaje){
        super(mensaje);
    }
}
