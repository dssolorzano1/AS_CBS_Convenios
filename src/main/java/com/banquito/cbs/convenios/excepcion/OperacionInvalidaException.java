package com.banquito.cbs.convenios.excepcion;

public class OperacionInvalidaException extends RuntimeException {
    
    public OperacionInvalidaException(String mensaje) {
        super(mensaje);
    }

    public OperacionInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
} 