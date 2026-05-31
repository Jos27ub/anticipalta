package com.anticipalta.backend.controller;

import com.anticipalta.backend.entity.Fundo;
import com.anticipalta.backend.service.FundoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fundos")
@CrossOrigin(origins = "*")
public class FundoController {
    private final FundoService service;
    public FundoController(FundoService service) { this.service = service; }

    @GetMapping
    public List<Fundo> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Fundo findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Fundo save(@RequestBody Fundo f) { return service.save(f); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
    @PutMapping("/{id}")
    public Fundo update(@PathVariable Long id, @RequestBody Fundo fundo) {
        fundo.setIdFundo(id);
        return service.save(fundo);
    }
}