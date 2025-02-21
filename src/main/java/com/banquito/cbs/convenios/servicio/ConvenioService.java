package com.banquito.cbs.convenios.servicio;

import com.banquito.cbs.convenios.repositorio.ConvenioRepository;
import org.springframework.stereotype.Service;

@Service
public class ConvenioService {
    private final ConvenioRepository convenioRepository;

    public ConvenioService(ConvenioRepository convenioRepository) {
        this.convenioRepository = convenioRepository;
    }
} 