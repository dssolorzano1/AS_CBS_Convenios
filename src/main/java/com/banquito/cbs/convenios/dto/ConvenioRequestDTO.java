package com.banquito.cbs.convenios.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ConvenioRequestDTO {
    private Integer id;
    private Integer idCuenta;
    private Integer mesesDiferidos;
    private BigDecimal montoMinimo;
    private String tipoDiferido;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
}
