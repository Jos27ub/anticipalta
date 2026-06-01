package com.anticipalta.backend.repository;

import com.anticipalta.backend.entity.Fundo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FundoRepository extends JpaRepository<Fundo, Long> {
    @Query("SELECT f FROM Fundo f JOIN FETCH f.provincia JOIN FETCH f.usuario")
    List<Fundo> findAllWithRelations();
}