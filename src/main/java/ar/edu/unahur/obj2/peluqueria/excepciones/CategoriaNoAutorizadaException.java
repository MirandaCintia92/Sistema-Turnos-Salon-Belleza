package ar.edu.unahur.obj2.peluqueria.excepciones;

public class CategoriaNoAutorizadaException extends RuntimeException {
    public CategoriaNoAutorizadaException(String mensaje){
        super(mensaje);
    }
}
