package com.banquito.cbs.convenios.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ConvenioPeticionDTO {
    private Integer idCuenta;
    private Integer mesesDiferidos;
    private BigDecimal montoMinimo;
    private String tipoDiferido;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}