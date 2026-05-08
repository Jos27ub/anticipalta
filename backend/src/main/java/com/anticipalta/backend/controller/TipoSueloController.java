package com.anticipalta.backend.controller;

import com.anticipalta.backend.entity.TipoSuelo;
import com.anticipalta.backend.service.TipoSueloService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-suelo")
@CrossOrigin(origins = "*")
public class TipoSueloController {
    private final TipoSueloService service;
    public TipoSueloController(TipoSueloService service) { this.service = service; }

    @GetMapping
    public List<TipoSuelo> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public TipoSuelo findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public TipoSuelo save(@RequestBody TipoSuelo t) { return service.save(t); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}