package com.anticipalta.backend.service;

import com.anticipalta.backend.entity.Provincia;
import com.anticipalta.backend.repository.ProvinciaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProvinciaService {
    private final ProvinciaRepository repo;
    public ProvinciaService(ProvinciaRepository repo) { this.repo = repo; }

    public List<Provincia> findAll() { return repo.findAll(); }
    public Provincia findById(Long id) { return repo.findById(id).orElseThrow(); }
    public Provincia save(Provincia p) { return repo.save(p); }
    public void delete(Long id) { repo.deleteById(id); }
}