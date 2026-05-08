package com.anticipalta.backend.service;

import com.anticipalta.backend.entity.Departamento;
import com.anticipalta.backend.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartamentoService {
    private final DepartamentoRepository repo;
    public DepartamentoService(DepartamentoRepository repo) { this.repo = repo; }

    public List<Departamento> findAll() { return repo.findAll(); }
    public Departamento findById(Long id) { return repo.findById(id).orElseThrow(); }
    public Departamento save(Departamento d) { return repo.save(d); }
    public void delete(Long id) { repo.deleteById(id); }
}