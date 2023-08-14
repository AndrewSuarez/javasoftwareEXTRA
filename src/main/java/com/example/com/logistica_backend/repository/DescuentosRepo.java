package com.example.com.logistica_backend.repository;

import com.example.com.logistica_backend.model.Descuentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentosRepo extends JpaRepository<Descuentos, Long> {
}
