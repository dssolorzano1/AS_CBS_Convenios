package com.banquito.cbs.convenios.excepcion;

public class EntidadDuplicadaException extends RuntimeException {
    
    public EntidadDuplicadaException(String mensaje) {
        super(mensaje);
    }

    public EntidadDuplicadaException(String entidad, String campo, Object valor) {
        super(String.format("Ya existe %s con %s: %s", entidad, campo, valor));
    }
} 