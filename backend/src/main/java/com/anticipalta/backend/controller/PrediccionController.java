package com.anticipalta.backend.controller;

import com.anticipalta.backend.entity.Prediccion;
import com.anticipalta.backend.service.PrediccionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/predicciones")
@CrossOrigin(origins = "*")
public class PrediccionController {
    private final PrediccionService service;
    public PrediccionController(PrediccionService service) { this.service = service; }

    @GetMapping
    public List<Prediccion> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Prediccion findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Prediccion save(@RequestBody Prediccion p) { return service.save(p); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    @PostMapping("/predecir")
    public Map predecir(@RequestBody Map<String, Object> datos) {
        return service.predecir(datos);
    }
    @PutMapping("/{id}")
    public Prediccion update(@PathVariable Long id, @RequestBody Prediccion prediccion) {
        Prediccion existing = service.findById(id);
        if (prediccion.getRendimientoReal() != null) existing.setRendimientoReal(prediccion.getRendimientoReal());
        if (prediccion.getNotas() != null) existing.setNotas(prediccion.getNotas());
        return service.save(existing);
    }

}