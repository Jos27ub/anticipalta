package com.anticipalta.backend.repository;

import com.anticipalta.backend.entity.Prediccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface PrediccionRepository extends JpaRepository<Prediccion, Long> {
    List<Prediccion> findByUsuario_IdUsuario(Long idUsuario);
    List<Prediccion> findByFundo_IdFundo(Long idFundo);
        @Query("SELECT p FROM Prediccion p LEFT JOIN FETCH p.fundo LEFT JOIN FETCH p.usuario LEFT JOIN FETCH p.modelo LEFT JOIN FETCH p.tipoSuelo")
        List<Prediccion> findAllWithRelations();
}