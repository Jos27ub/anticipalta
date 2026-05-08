package com.anticipalta.backend.repository;

import com.anticipalta.backend.entity.Fundo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FundoRepository extends JpaRepository<Fundo, Long> {
    List<Fundo> findByUsuario_IdUsuario(Long idUsuario);
}