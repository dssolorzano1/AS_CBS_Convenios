package com.banquito.cbs.convenios.controlador;

import com.banquito.cbs.convenios.controlador.mapper.ConvenioMapper;
import com.banquito.cbs.convenios.dto.ConvenioRespuestaDTO;
import com.banquito.cbs.convenios.modelo.Convenio;
import com.banquito.cbs.convenios.servicio.ConvenioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/convenios")
public class ConvenioController {
    private final ConvenioService convenioService;
    private final ConvenioMapper convenioMapper;
    private static final Logger logger = LoggerFactory.getLogger(ConvenioController.class);

    public ConvenioController(ConvenioService convenioService, ConvenioMapper convenioMapper) {
        this.convenioService = convenioService;
        this.convenioMapper = convenioMapper;
    }

    @Operation(summary = "Crear un nuevo convenio")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Convenio creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping
    public ResponseEntity<ConvenioRespuestaDTO> crearConvenio(@RequestBody Convenio convenio) {
        logger.info("Solicitud para crear convenio: {}", convenio);
        Convenio nuevoConvenio = convenioService.crearConvenio(convenio);
        return ResponseEntity.ok(convenioMapper.toDto(nuevoConvenio));
    }

    @Operation(summary = "Obtener un convenio por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Convenio encontrado"),
        @ApiResponse(responseCode = "404", description = "Convenio no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ConvenioRespuestaDTO> obtenerConvenioPorId(@PathVariable Integer id) {
        logger.info("Solicitud para obtener convenio con id: {}", id);
        Optional<Convenio> convenio = convenioService.obtenerConvenioPorId(id);
        return convenio.map(c -> ResponseEntity.ok(convenioMapper.toDto(c)))
                       .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Obtener convenios vigentes por ID de cuenta")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Convenios obtenidos exitosamente"),
        @ApiResponse(responseCode = "404", description = "No se encontraron convenios vigentes")
    })
    @GetMapping("/cuenta/{idCuenta}")
    public ResponseEntity<List<ConvenioRespuestaDTO>> obtenerConveniosVigentesPorIdCuenta(@PathVariable Integer idCuenta) {
        logger.info("Solicitud para obtener convenios vigentes con idCuenta: {}", idCuenta);
        List<ConvenioRespuestaDTO> convenios = convenioService.obtenerConveniosVigentesPorIdCuenta(idCuenta);
        return convenios.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(convenios);
    }


    @Operation(summary = "Actualizar un convenio existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Convenio actualizado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Convenio no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ConvenioRespuestaDTO> actualizarConvenio(@PathVariable Integer id, @RequestBody Convenio convenio) {
        logger.info("Solicitud para actualizar convenio con id: {}", id);
        Optional<Convenio> convenioActualizado = convenioService.actualizarConvenio(id, convenio);
        return convenioActualizado.map(c -> ResponseEntity.ok(convenioMapper.toDto(c)))
                                  .orElse(ResponseEntity.notFound().build());
    }
}
