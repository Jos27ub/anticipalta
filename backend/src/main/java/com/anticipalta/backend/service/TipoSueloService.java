package com.anticipalta.backend.service;

import com.anticipalta.backend.entity.TipoSuelo;
import com.anticipalta.backend.repository.TipoSueloRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoSueloService {
    private final TipoSueloRepository repo;
    public TipoSueloService(TipoSueloRepository repo) { this.repo = repo; }

    public List<TipoSuelo> findAll() { return repo.findAll(); }
    public TipoSuelo findById(Long id) { return repo.findById(id).orElseThrow(); }
    public TipoSuelo save(TipoSuelo t) { return repo.save(t); }
    public void delete(Long id) { repo.deleteById(id); }
}