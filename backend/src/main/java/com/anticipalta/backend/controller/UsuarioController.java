package com.anticipalta.backend.controller;

import com.anticipalta.backend.entity.Usuario;
import com.anticipalta.backend.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    private final UsuarioService service;
    public UsuarioController(UsuarioService service) { this.service = service; }

    @GetMapping
    public List<Usuario> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Usuario save(@RequestBody Usuario u) { return service.save(u); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}