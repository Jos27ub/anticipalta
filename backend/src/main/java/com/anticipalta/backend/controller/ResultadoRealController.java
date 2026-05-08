package com.anticipalta.backend.controller;

import com.anticipalta.backend.entity.ResultadoReal;
import com.anticipalta.backend.service.ResultadoRealService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/resultados-reales")
@CrossOrigin(origins = "*")
public class ResultadoRealController {
    private final ResultadoRealService service;
    public ResultadoRealController(ResultadoRealService service) { this.service = service; }

    @GetMapping
    public List<ResultadoReal> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResultadoReal findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public ResultadoReal save(@RequestBody ResultadoReal r) { return service.save(r); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}