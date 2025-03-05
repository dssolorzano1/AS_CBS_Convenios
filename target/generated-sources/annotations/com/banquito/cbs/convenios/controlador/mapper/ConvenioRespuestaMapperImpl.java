package com.banquito.cbs.convenios.controlador.mapper;

import com.banquito.cbs.convenios.dto.ConvenioRespuestaDTO;
import com.banquito.cbs.convenios.modelo.Convenio;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-04T21:32:21-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class ConvenioRespuestaMapperImpl implements ConvenioRespuestaMapper {

    @Override
    public ConvenioRespuestaDTO toDto(Convenio convenio) {
        if ( convenio == null ) {
            return null;
        }

        ConvenioRespuestaDTO convenioRespuestaDTO = new ConvenioRespuestaDTO();

        convenioRespuestaDTO.setFechaInicio( convenio.getFechaInicio() );
        convenioRespuestaDTO.setFechaFin( convenio.getFechaFin() );
        if ( convenio.getTipoDiferido() != null ) {
            convenioRespuestaDTO.setTipoDiferido( convenio.getTipoDiferido() );
        }
        else {
            convenioRespuestaDTO.setTipoDiferido( "ACT" );
        }
        convenioRespuestaDTO.setId( convenio.getId() );
        convenioRespuestaDTO.setIdCuenta( convenio.getIdCuenta() );
        convenioRespuestaDTO.setMesesDiferidos( convenio.getMesesDiferidos() );
        convenioRespuestaDTO.setMontoMinimo( convenio.getMontoMinimo() );

        return convenioRespuestaDTO;
    }

    @Override
    public Convenio toEntity(ConvenioRespuestaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LocalDateTime fechaInicio = null;
        LocalDateTime fechaFin = null;
        String tipoDiferido = null;
        Integer idCuenta = null;
        Integer mesesDiferidos = null;
        BigDecimal montoMinimo = null;

        fechaInicio = dto.getFechaInicio();
        fechaFin = dto.getFechaFin();
        if ( dto.getTipoDiferido() != null ) {
            tipoDiferido = dto.getTipoDiferido();
        }
        else {
            tipoDiferido = "ACT";
        }
        idCuenta = dto.getIdCuenta();
        mesesDiferidos = dto.getMesesDiferidos();
        montoMinimo = dto.getMontoMinimo();

        Convenio convenio = new Convenio( idCuenta, mesesDiferidos, montoMinimo, tipoDiferido, fechaInicio, fechaFin );

        convenio.setId( dto.getId() );

        return convenio;
    }
}
