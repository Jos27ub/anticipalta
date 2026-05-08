package com.anticipalta.backend.repository;

import com.anticipalta.backend.entity.ResultadoReal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ResultadoRealRepository extends JpaRepository<ResultadoReal, Long> {
    Optional<ResultadoReal> findByPrediccion_IdPrediccion(Long idPrediccion);
}