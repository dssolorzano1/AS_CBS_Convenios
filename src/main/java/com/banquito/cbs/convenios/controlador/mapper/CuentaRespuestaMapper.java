package com.banquito.cbs.convenios.controlador.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.banquito.cbs.convenios.dto.ConvenioRespuestaDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CuentaRespuestaMapper {   
    ConvenioRespuestaDto toDto(ConvenioRespuestaDto convenioRespuestaDto);
} 