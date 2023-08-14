package com.example.com.logistica_backend.repository;

import com.example.com.logistica_backend.model.ProductosEnvio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosEnvioRepo extends JpaRepository<ProductosEnvio, Long> {

    List<ProductosEnvio> findByEnvio_idEnvio(Long id);
}
