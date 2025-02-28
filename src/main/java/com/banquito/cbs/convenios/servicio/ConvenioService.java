package com.banquito.cbs.convenios.servicio;

import org.springframework.stereotype.Service;
import com.banquito.cbs.convenios.modelo.Convenio;
import com.banquito.cbs.convenios.repositorio.ConvenioRepository;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConvenioService {
    
    private final ConvenioRepository convenioRepository;
    
    public Convenio crear(Convenio convenio) {
        if (convenio.getFechaInicio().isAfter(convenio.getFechaFin())) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha fin");
        }
        
        String estado = determinarEstado(convenio.getFechaFin());
        convenio.setTipoDiferido(estado);
        return convenioRepository.save(convenio);
    }

    private String determinarEstado(LocalDate fechaFin) {
        return fechaFin.isAfter(LocalDate.now()) ? "ACT" : "INA";
    }

    public List<Convenio> listarConveniosVigentes(Integer idCuenta) {
        return convenioRepository.findByIdCuentaAndTipoDiferido(idCuenta, "ACT");
    }

    public Convenio buscarPorId(Integer id) {
        return convenioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Convenio no encontrado"));
    }
    public Convenio actualizarConvenio(Integer id, Convenio convenioActualizado) {
        Convenio convenioExistente = convenioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Convenio no encontrado"));

        if (convenioActualizado.getFechaInicio().isAfter(convenioActualizado.getFechaFin())) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha fin");
        }

        convenioExistente.setFechaInicio(convenioActualizado.getFechaInicio());
        convenioExistente.setFechaFin(convenioActualizado.getFechaFin());
        convenioExistente.setTipoDiferido(determinarEstado(convenioActualizado.getFechaFin()));
        // Actualiza otros campos según sea necesario

        return convenioRepository.save(convenioExistente);
    }
} 