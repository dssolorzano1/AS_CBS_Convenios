package com.banquito.cbs.convenios.repositorio;

import com.banquito.cbs.convenios.modelo.Convenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si los necesitas
} 