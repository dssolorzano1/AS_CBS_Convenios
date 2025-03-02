package com.banquito.cbs.convenios.controlador.mapper;

import com.banquito.cbs.convenios.dto.ConvenioRespuestaDTO;
import com.banquito.cbs.convenios.modelo.Convenio;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ConvenioRespuestaMapper {

    @Mapping(target = "fechaInicio", source = "fechaInicio", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(target = "fechaFin", source = "fechaFin", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(target = "tipoDiferido", defaultValue = "ACT")
    ConvenioRespuestaDTO toDto(Convenio convenio);

    @Mapping(target = "fechaInicio", source = "fechaInicio", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(target = "fechaFin", source = "fechaFin", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(target = "tipoDiferido", defaultValue = "ACT")
    Convenio toEntity(ConvenioRespuestaDTO dto);
}

