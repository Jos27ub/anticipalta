package com.anticipalta.backend.controller;

import com.anticipalta.backend.entity.Provincia;
import com.anticipalta.backend.service.ProvinciaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/provincias")
@CrossOrigin(origins = "*")
public class ProvinciaController {
    private final ProvinciaService service;
    public ProvinciaController(ProvinciaService service) { this.service = service; }

    @GetMapping
    public List<Provincia> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Provincia findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Provincia save(@RequestBody Provincia p) { return service.save(p); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}