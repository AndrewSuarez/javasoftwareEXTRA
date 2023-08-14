package com.example.com.logistica_backend.service;


import com.example.com.logistica_backend.dto.ProductosDTO;
import com.example.com.logistica_backend.model.Productos;
import com.example.com.logistica_backend.repository.ProductosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService {
    @Autowired
    private ProductosRepo productosRepo;

    public ProductosDTO create (ProductosDTO productosDTO){
        Productos temp = new Productos();
        temp.setTipoProducto(productosDTO.getTipoProducto());
        productosRepo.save(temp);
        return productosDTO;
    }

    public List<Productos> getAllProductos(){
        return productosRepo.findAll();
    }

    public void deleteProductos (Long id) {
        productosRepo.deleteById(id);
    }

    public Productos findById(Long id){
        return productosRepo.findById(id).orElseThrow(
                () -> new RuntimeException("El producto no existe"));
    }

    public ProductosDTO updateProductos(ProductosDTO productosDTO, Long id){
        Productos oldProductos = productosRepo.findById(id).orElseThrow(
                () -> new RuntimeException("El producto no existe"));
        oldProductos.setTipoProducto(productosDTO.getTipoProducto());
        productosRepo.save(oldProductos);
        return productosDTO;
    }
}