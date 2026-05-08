package com.anticipalta.backend.service;

import com.anticipalta.backend.entity.Prediccion;
import com.anticipalta.backend.repository.PrediccionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

@Service
public class PrediccionService {
    private final PrediccionRepository repo;
    private final RestTemplate restTemplate;
    private static final String ML_URL = "https://anticipalta.onrender.com/predecir";

    public PrediccionService(PrediccionRepository repo, RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
    }

    public List<Prediccion> findAll() { return repo.findAll(); }
    public Prediccion findById(Long id) { return repo.findById(id).orElseThrow(); }
    public Prediccion save(Prediccion p) { return repo.save(p); }
    public void delete(Long id) { repo.deleteById(id); }

    public Map predecir(Map<String, Object> datos) {
        return restTemplate.postForObject(ML_URL, datos, Map.class);
    }
}