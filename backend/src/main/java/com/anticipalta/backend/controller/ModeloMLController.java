package com.anticipalta.backend.controller;

import com.anticipalta.backend.entity.ModeloML;
import com.anticipalta.backend.service.ModeloMLService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/modelos-ml")
@CrossOrigin(origins = "*")
public class ModeloMLController {
    private final ModeloMLService service;
    public ModeloMLController(ModeloMLService service) { this.service = service; }

    @GetMapping
    public List<ModeloML> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ModeloML findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public ModeloML save(@RequestBody ModeloML m) { return service.save(m); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}