package com.banquito.cbs.convenios.controlador.mapper;

import com.banquito.cbs.convenios.dto.ConvenioRespuestaDTO;
import com.banquito.cbs.convenios.modelo.Convenio;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;
import java.util.List;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ConvenioMapper {

    @Mapping(target = "fechaInicio", source = "fechaInicio", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(target = "fechaFin", source = "fechaFin", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    ConvenioRespuestaDTO toDto(Convenio convenio);

    @Mapping(target = "fechaInicio", source = "fechaInicio", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(target = "fechaFin", source = "fechaFin", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    Convenio toEntity(ConvenioRespuestaDTO convenioDto);
    
    List<ConvenioRespuestaDTO> toDtoList(List<Convenio> convenios);
    List<Convenio> toEntityList(List<ConvenioRespuestaDTO> dtoList);
}
