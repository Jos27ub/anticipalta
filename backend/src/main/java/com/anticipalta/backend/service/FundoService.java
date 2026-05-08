package com.anticipalta.backend.service;

import com.anticipalta.backend.entity.Fundo;
import com.anticipalta.backend.repository.FundoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FundoService {
    private final FundoRepository repo;
    public FundoService(FundoRepository repo) { this.repo = repo; }

    public List<Fundo> findAll() { return repo.findAll(); }
    public Fundo findById(Long id) { return repo.findById(id).orElseThrow(); }
    public Fundo save(Fundo f) { return repo.save(f); }
    public void delete(Long id) { repo.deleteById(id); }
}