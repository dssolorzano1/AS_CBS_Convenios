package com.banquito.cbs.convenios.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.banquito.cbs.convenios.controlador.mapper.CuentaPeticionMapper;
import com.banquito.cbs.convenios.dto.ConvenioPeticionDTO;
import com.banquito.cbs.convenios.modelo.Convenio;
import com.banquito.cbs.convenios.servicio.ConvenioService;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/v1/convenios")
@RequiredArgsConstructor
public class ConvenioController {

    private final ConvenioService convenioService;
    private final CuentaPeticionMapper mapper;

    @PostMapping
    public Convenio crear(@RequestBody ConvenioPeticionDTO peticion) {
        return convenioService.crear(mapper.toEntity(peticion));
    }

    @GetMapping("/cuenta/{idCuenta}")
    public List<Convenio> listarPorCuenta(@PathVariable Integer idCuenta) {
        return convenioService.listarConveniosVigentes(idCuenta);
    }

    @GetMapping("/{id}")
    public Convenio buscarPorId(@PathVariable Integer id) {
        return convenioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Convenio> actualizarConvenio(@PathVariable Integer id, @RequestBody Convenio convenio) {
        Convenio convenioActualizado = convenioService.actualizarConvenio(id, convenio);
        return ResponseEntity.ok(convenioActualizado);
    }
} 