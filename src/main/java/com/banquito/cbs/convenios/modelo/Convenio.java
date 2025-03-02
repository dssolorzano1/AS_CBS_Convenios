package com.banquito.cbs.convenios.modelo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@ToString
@Document(collection = "CONVENIOS")
public class Convenio {
    @MongoId
    private Integer id;
    private Integer idCuenta;
    private Integer mesesDiferidos;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal montoMinimo;

    private String tipoDiferido;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    
    public Convenio(Integer idCuenta, Integer mesesDiferidos, BigDecimal montoMinimo, String tipoDiferido, 
                    LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.idCuenta = idCuenta;
        this.mesesDiferidos = mesesDiferidos;
        this.montoMinimo = montoMinimo;
        this.tipoDiferido = tipoDiferido;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}
