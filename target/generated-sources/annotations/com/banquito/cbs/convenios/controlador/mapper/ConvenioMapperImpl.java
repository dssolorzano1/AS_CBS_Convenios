package com.banquito.cbs.convenios.controlador.mapper;

import com.banquito.cbs.convenios.dto.ConvenioRespuestaDTO;
import com.banquito.cbs.convenios.modelo.Convenio;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-02T14:06:32-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class ConvenioMapperImpl implements ConvenioMapper {

    @Override
    public ConvenioRespuestaDTO toDto(Convenio convenio) {
        if ( convenio == null ) {
            return null;
        }

        ConvenioRespuestaDTO convenioRespuestaDTO = new ConvenioRespuestaDTO();

        convenioRespuestaDTO.setFechaInicio( convenio.getFechaInicio() );
        convenioRespuestaDTO.setFechaFin( convenio.getFechaFin() );
        convenioRespuestaDTO.setId( convenio.getId() );
        convenioRespuestaDTO.setIdCuenta( convenio.getIdCuenta() );
        convenioRespuestaDTO.setMesesDiferidos( convenio.getMesesDiferidos() );
        convenioRespuestaDTO.setMontoMinimo( convenio.getMontoMinimo() );
        convenioRespuestaDTO.setTipoDiferido( convenio.getTipoDiferido() );

        return convenioRespuestaDTO;
    }

    @Override
    public Convenio toEntity(ConvenioRespuestaDTO convenioDto) {
        if ( convenioDto == null ) {
            return null;
        }

        LocalDateTime fechaInicio = null;
        LocalDateTime fechaFin = null;
        Integer idCuenta = null;
        Integer mesesDiferidos = null;
        BigDecimal montoMinimo = null;
        String tipoDiferido = null;

        fechaInicio = convenioDto.getFechaInicio();
        fechaFin = convenioDto.getFechaFin();
        idCuenta = convenioDto.getIdCuenta();
        mesesDiferidos = convenioDto.getMesesDiferidos();
        montoMinimo = convenioDto.getMontoMinimo();
        tipoDiferido = convenioDto.getTipoDiferido();

        Convenio convenio = new Convenio( idCuenta, mesesDiferidos, montoMinimo, tipoDiferido, fechaInicio, fechaFin );

        convenio.setId( convenioDto.getId() );

        return convenio;
    }

    @Override
    public List<ConvenioRespuestaDTO> toDtoList(List<Convenio> convenios) {
        if ( convenios == null ) {
            return null;
        }

        List<ConvenioRespuestaDTO> list = new ArrayList<ConvenioRespuestaDTO>( convenios.size() );
        for ( Convenio convenio : convenios ) {
            list.add( toDto( convenio ) );
        }

        return list;
    }

    @Override
    public List<Convenio> toEntityList(List<ConvenioRespuestaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Convenio> list = new ArrayList<Convenio>( dtoList.size() );
        for ( ConvenioRespuestaDTO convenioRespuestaDTO : dtoList ) {
            list.add( toEntity( convenioRespuestaDTO ) );
        }

        return list;
    }
}
