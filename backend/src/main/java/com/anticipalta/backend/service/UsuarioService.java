package com.anticipalta.backend.service;

import com.anticipalta.backend.entity.Usuario;
import com.anticipalta.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo) { this.repo = repo; }

    public List<Usuario> findAll() { return repo.findAll(); }
    public Usuario findById(Long id) { return repo.findById(id).orElseThrow(); }
    public Usuario save(Usuario u) { return repo.save(u); }
    public void delete(Long id) { repo.deleteById(id); }

    public Usuario update(Long id, Usuario datos) {
        Usuario existente = repo.findById(id).orElseThrow();
        if (datos.getEstado() != null) {
            existente.setEstado(datos.getEstado());
        }
        return repo.save(existente);
    }
}