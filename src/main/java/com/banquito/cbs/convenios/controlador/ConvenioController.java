package com.banquito.cbs.convenios.controlador;

import com.banquito.cbs.convenios.servicio.ConvenioService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/convenios")
@CrossOrigin
public class ConvenioController {
    private final ConvenioService convenioService;

    public ConvenioController(ConvenioService convenioService) {
        this.convenioService = convenioService;
    }
} 