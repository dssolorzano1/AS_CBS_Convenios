package com.banquito.cbs.convenios.controlador.mapper;

import com.banquito.cbs.convenios.dto.ConvenioRespuestaDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T04:56:12-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class CuentaRespuestaMapperImpl implements CuentaRespuestaMapper {

    @Override
    public ConvenioRespuestaDto toDto(ConvenioRespuestaDto convenioRespuestaDto) {
        if ( convenioRespuestaDto == null ) {
            return null;
        }

        ConvenioRespuestaDto convenioRespuestaDto1 = new ConvenioRespuestaDto();

        return convenioRespuestaDto1;
    }
}
