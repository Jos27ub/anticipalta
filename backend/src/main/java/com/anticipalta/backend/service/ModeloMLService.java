package com.anticipalta.backend.service;

import com.anticipalta.backend.entity.ModeloML;
import com.anticipalta.backend.repository.ModeloMLRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ModeloMLService {
    private final ModeloMLRepository repo;
    public ModeloMLService(ModeloMLRepository repo) { this.repo = repo; }

    public List<ModeloML> findAll() { return repo.findAll(); }
    public ModeloML findById(Long id) { return repo.findById(id).orElseThrow(); }
    public ModeloML save(ModeloML m) { return repo.save(m); }
    public void delete(Long id) { repo.deleteById(id); }
}