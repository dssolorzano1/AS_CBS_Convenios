package com.banquito.cbs.convenios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banquito.cbs.convenios.modelo.Convenio;
import java.util.List;

public interface ConvenioRepository extends JpaRepository<Convenio, Integer> {
    List<Convenio> findByIdCuentaAndTipoDiferido(Integer idCuenta, String tipoDiferido);
} 