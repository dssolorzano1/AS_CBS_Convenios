package com.banquito.cbs.convenios.controlador.mapper;

import com.banquito.cbs.convenios.dto.ConvenioPeticionDTO;
import com.banquito.cbs.convenios.modelo.Convenio;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T04:56:11-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class CuentaPeticionMapperImpl implements CuentaPeticionMapper {

    @Override
    public Convenio toEntity(ConvenioPeticionDTO peticionDTO) {
        if ( peticionDTO == null ) {
            return null;
        }

        Convenio convenio = new Convenio();

        convenio.setIdCuenta( peticionDTO.getIdCuenta() );
        convenio.setMesesDiferidos( peticionDTO.getMesesDiferidos() );
        convenio.setMontoMinimo( peticionDTO.getMontoMinimo() );
        convenio.setTipoDiferido( peticionDTO.getTipoDiferido() );
        convenio.setFechaInicio( peticionDTO.getFechaInicio() );
        convenio.setFechaFin( peticionDTO.getFechaFin() );

        return convenio;
    }

    @Override
    public ConvenioPeticionDTO toDto(Convenio convenio) {
        if ( convenio == null ) {
            return null;
        }

        ConvenioPeticionDTO convenioPeticionDTO = new ConvenioPeticionDTO();

        convenioPeticionDTO.setIdCuenta( convenio.getIdCuenta() );
        convenioPeticionDTO.setMesesDiferidos( convenio.getMesesDiferidos() );
        convenioPeticionDTO.setMontoMinimo( convenio.getMontoMinimo() );
        convenioPeticionDTO.setTipoDiferido( convenio.getTipoDiferido() );
        convenioPeticionDTO.setFechaInicio( convenio.getFechaInicio() );
        convenioPeticionDTO.setFechaFin( convenio.getFechaFin() );

        return convenioPeticionDTO;
    }
}
