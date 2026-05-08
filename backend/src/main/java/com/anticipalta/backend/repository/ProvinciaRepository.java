package com.anticipalta.backend.repository;

import com.anticipalta.backend.entity.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
    java.util.List<Provincia> findByDepartamento_IdDepartamento(Long idDepartamento);
}