package com.anticipalta.backend.service;

import com.anticipalta.backend.entity.Prediccion;
import com.anticipalta.backend.repository.PrediccionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class PrediccionService {
    private final PrediccionRepository repo;
    private final RestTemplate restTemplate;
    private static final String ML_URL = "https://anticipalta.onrender.com/predecir";

    public PrediccionService(PrediccionRepository repo, RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
    }

public List<Prediccion> findAll() { return repo.findAllWithRelations(); }
    public Prediccion findById(Long id) { return repo.findById(id).orElseThrow(); }
    public Prediccion save(Prediccion p) { return repo.save(p); }
    public void delete(Long id) { repo.deleteById(id); }

    public Map predecir(Map<String, Object> datos) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("Anio",       datos.get("Anio"));
        payload.put("Mes",        datos.get("Mes"));
        payload.put("Fundo",      datos.get("Fundo"));
        payload.put("Lote",       datos.get("Lote"));
        payload.put("Provincia",  datos.get("Provincia"));
        payload.put("Area_Ha",    datos.get("Area_Ha"));
        payload.put("Edad_Anios", datos.get("Edad_Anios"));
        payload.put("Prec_mm",    datos.get("Prec_mm"));
        payload.put("Rad_Solar",  datos.get("Rad_Solar"));
        payload.put("Tipo_Suelo", datos.get("Tipo_Suelo"));
        payload.put("pH_Suelo",   datos.get("pH_Suelo"));
        payload.put("Temp_C",     datos.get("Temp_C"));
        payload.put("Hum_Rel",    datos.get("Hum_Rel"));

        return restTemplate.postForObject(ML_URL, payload, Map.class);
    }
}