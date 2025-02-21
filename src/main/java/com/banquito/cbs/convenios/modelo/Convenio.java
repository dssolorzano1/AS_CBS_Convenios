package com.banquito.cbs.convenios.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "convenio")
@Data
@ToString
public class Convenio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "id_cuenta", nullable = false)
    private Integer idCuenta;
    
    @Column(name = "meses_diferidos", precision = 2, nullable = false)
    private Integer mesesDiferidos;
    
    @Column(name = "monto_minimo", precision = 20, scale = 2)
    private BigDecimal montoMinimo;
    
    @Column(name = "tipo_diferido", length = 3)
    private String tipoDiferido;
    
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;
    
    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;
}
