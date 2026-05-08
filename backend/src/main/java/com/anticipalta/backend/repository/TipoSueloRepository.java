package com.anticipalta.backend.repository;

import com.anticipalta.backend.entity.TipoSuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSueloRepository extends JpaRepository<TipoSuelo, Long> {}