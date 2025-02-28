package com.banquito.cbs.convenios.controlador.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.banquito.cbs.convenios.dto.ConvenioPeticionDTO;
import com.banquito.cbs.convenios.modelo.Convenio;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CuentaPeticionMapper {
    
    Convenio toEntity(ConvenioPeticionDTO peticionDTO);
    
    ConvenioPeticionDTO toDto(Convenio convenio);
} 