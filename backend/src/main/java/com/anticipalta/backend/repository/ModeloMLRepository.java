package com.anticipalta.backend.repository;

import com.anticipalta.backend.entity.ModeloML;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloMLRepository extends JpaRepository<ModeloML, Long> {}