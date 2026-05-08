package com.anticipalta.backend.controller;

import com.anticipalta.backend.entity.Rol;
import com.anticipalta.backend.service.RolService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolController {
    private final RolService service;
    public RolController(RolService service) { this.service = service; }

    @GetMapping
    public List<Rol> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Rol findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Rol save(@RequestBody Rol rol) { return service.save(rol); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}