package com.example.com.logistica_backend.repository;

import com.example.com.logistica_backend.model.TipoAlmacen;
import com.example.com.logistica_backend.model.TipoTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTransporteRepository extends JpaRepository<TipoTransporte, Long> {
}
