package com.banquito.cbs.convenios.excepcion;

import com.banquito.cbs.convenios.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorExcepcionesConvenios {
    
    @ExceptionHandler(EntidadNoEncontradaException.class)
    public ResponseEntity<ErrorDTO> handleEntidadNoEncontradaException(EntidadNoEncontradaException ex) {
        ErrorDTO error = new ErrorDTO();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(EntidadDuplicadaException.class)
    public ResponseEntity<ErrorDTO> handleEntidadDuplicadaException(EntidadDuplicadaException ex) {
        ErrorDTO error = new ErrorDTO();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(OperacionInvalidaException.class)
    public ResponseEntity<ErrorDTO> handleOperacionInvalidaException(OperacionInvalidaException ex) {
        ErrorDTO error = new ErrorDTO();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
