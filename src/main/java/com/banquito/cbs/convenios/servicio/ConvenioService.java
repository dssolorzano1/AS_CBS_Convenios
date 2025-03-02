package com.banquito.cbs.convenios.servicio;

import com.banquito.cbs.convenios.dto.ConvenioRespuestaDTO;
import com.banquito.cbs.convenios.modelo.Convenio;
import com.banquito.cbs.convenios.repositorio.ConvenioRepository;
import com.banquito.cbs.convenios.controlador.mapper.ConvenioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ConvenioService {
    private final ConvenioRepository convenioRepository;
    private final ConvenioMapper convenioMapper;
    private static final Logger logger = LoggerFactory.getLogger(ConvenioService.class);

    public ConvenioService(ConvenioRepository convenioRepository, ConvenioMapper convenioMapper) {
        this.convenioRepository = convenioRepository;
        this.convenioMapper = convenioMapper;
    }

    public Convenio crearConvenio(Convenio convenio) {
        logger.info("Creando convenio: {}", convenio);
        
        if (!convenio.getTipoDiferido().equals("ACT") && !convenio.getTipoDiferido().equals("SIN")) {
            throw new IllegalArgumentException("El tipo de diferido solo puede ser 'ACT' o 'SIN'");
        }
        
        LocalDateTime fechaActual = LocalDateTime.now();
        if (convenio.getFechaInicio().isBefore(fechaActual)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser anterior a la fecha actual");
        }
        
        return convenioRepository.save(convenio);
    }

    public Optional<Convenio> obtenerConvenioPorId(Integer id) {
        logger.info("Obteniendo convenio con id: {}", id);
        return convenioRepository.findById(id);
    }

    public List<ConvenioRespuestaDTO> obtenerConveniosVigentesPorIdCuenta(Integer idCuenta) {
        logger.info("Obteniendo convenios vigentes para la cuenta con ID: {}", idCuenta);
        LocalDateTime fechaActual = LocalDateTime.now();
        List<Convenio> convenios = convenioRepository.findByIdCuentaAndFechaFinAfter(idCuenta, fechaActual);
        return convenioMapper.toDtoList(convenios); // 🔹 Usa el nuevo método en `ConvenioMapper`
    }    

    public Optional<Convenio> actualizarConvenio(Integer id, Convenio convenio) {
        logger.info("Actualizando convenio con id: {}", id);
        
        Optional<Convenio> convenioExistente = convenioRepository.findById(id);
        if (convenioExistente.isPresent()) {
            Convenio convenioDB = convenioExistente.get();
            
            if (convenio.getFechaFin() != null && convenio.getFechaFin().isAfter(convenioDB.getFechaFin())) {
                convenioDB.setFechaFin(convenio.getFechaFin());
            }
            if (convenio.getMontoMinimo() != null && convenio.getMontoMinimo().compareTo(convenioDB.getMontoMinimo()) < 0) {
                convenioDB.setMontoMinimo(convenio.getMontoMinimo());
            }
            if (convenio.getTipoDiferido() != null) {
                convenioDB.setTipoDiferido(convenio.getTipoDiferido());
            }
            
            convenioRepository.save(convenioDB);
            return Optional.of(convenioDB);
        } else {
            logger.warn("No se encontró convenio con ID: {}", id);
            return Optional.empty();
        }
    }

    public ConvenioRespuestaDTO toDto(Convenio convenio) {
        ConvenioRespuestaDTO dto = new ConvenioRespuestaDTO();
        dto.setId(convenio.getId());
        dto.setIdCuenta(convenio.getIdCuenta());
        dto.setMesesDiferidos(convenio.getMesesDiferidos());
        dto.setMontoMinimo(convenio.getMontoMinimo());
        dto.setTipoDiferido(convenio.getTipoDiferido());
        dto.setFechaInicio(convenio.getFechaInicio());
        dto.setFechaFin(convenio.getFechaFin());
        return dto;
    }
}
