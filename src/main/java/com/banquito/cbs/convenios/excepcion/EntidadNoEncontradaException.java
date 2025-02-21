package com.banquito.cbs.convenios.excepcion;

public class EntidadNoEncontradaException extends RuntimeException {
    
    public EntidadNoEncontradaException(String mensaje) {
        super(mensaje);
    }

    public EntidadNoEncontradaException(String entidad, String campo, Object valor) {
        super(String.format("No existe %s con %s: %s", entidad, campo, valor));
    }
} 