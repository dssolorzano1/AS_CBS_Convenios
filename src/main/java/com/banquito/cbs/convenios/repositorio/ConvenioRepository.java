package com.banquito.cbs.convenios.repositorio;

import com.banquito.cbs.convenios.modelo.Convenio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConvenioRepository extends MongoRepository<Convenio, Integer> {
    List<Convenio> findByIdCuenta(Integer idCuenta);
    List<Convenio> findByIdCuentaAndFechaFinAfter(Integer idCuenta, LocalDateTime fechaFin);
}
