package com.anticipalta.backend.controller;

import com.anticipalta.backend.entity.Departamento;
import com.anticipalta.backend.service.DepartamentoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
@CrossOrigin(origins = "*")
public class DepartamentoController {
    private final DepartamentoService service;
    public DepartamentoController(DepartamentoService service) { this.service = service; }

    @GetMapping
    public List<Departamento> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Departamento findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Departamento save(@RequestBody Departamento d) { return service.save(d); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}