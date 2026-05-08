package com.anticipalta.backend.service;

import com.anticipalta.backend.entity.Rol;
import com.anticipalta.backend.repository.RolRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolService {
    private final RolRepository repo;
    public RolService(RolRepository repo) { this.repo = repo; }

    public List<Rol> findAll() { return repo.findAll(); }
    public Rol findById(Long id) { return repo.findById(id).orElseThrow(); }
    public Rol save(Rol rol) { return repo.save(rol); }
    public void delete(Long id) { repo.deleteById(id); }
}