package com.anticipalta.backend.service;

import com.anticipalta.backend.entity.ResultadoReal;
import com.anticipalta.backend.repository.ResultadoRealRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResultadoRealService {
    private final ResultadoRealRepository repo;
    public ResultadoRealService(ResultadoRealRepository repo) { this.repo = repo; }

    public List<ResultadoReal> findAll() { return repo.findAll(); }
    public ResultadoReal findById(Long id) { return repo.findById(id).orElseThrow(); }
    public ResultadoReal save(ResultadoReal r) { return repo.save(r); }
    public void delete(Long id) { repo.deleteById(id); }
}