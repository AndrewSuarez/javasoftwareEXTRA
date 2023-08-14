package com.example.com.logistica_backend.controller;


import com.example.com.logistica_backend.dto.ProductosEnvioDTO;
import com.example.com.logistica_backend.model.ProductosEnvio;
import com.example.com.logistica_backend.service.ProductosEnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productosEnvio")
public class ProductosEnvioController {

    @Autowired
    private ProductosEnvioService productosEnvioService;

    @PostMapping
    private ResponseEntity<ProductosEnvio> guardar (
            @RequestBody ProductosEnvioDTO body
    ) {
        try{
            ProductosEnvio savedProductosEnvio = productosEnvioService.create(body);
            return ResponseEntity.ok(savedProductosEnvio);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/lista")
    private ResponseEntity<List<ProductosEnvio>> listAllProductoEnvio () {
        return ResponseEntity.ok(productosEnvioService.getAll());
    }

    @DeleteMapping(value = "/{id}")
    private ResponseEntity<String> deleteProductoEnvio (@PathVariable Long id){
        productosEnvioService.deleteById(id);
        return ResponseEntity.ok("Eliminado con exito: " + id);
    }

    @GetMapping (value = "/{id}")
    private ResponseEntity<List<ProductosEnvio>> getByEnvios (
            @PathVariable ("id") Long id
    ) {
        return ResponseEntity.ok(productosEnvioService.findByEnvio(id));
    }

    @PostMapping(value = "/update/{id}")
    private ResponseEntity<ProductosEnvioDTO> update (
            @PathVariable("id") Long id,
            @RequestBody ProductosEnvioDTO body
    ) {
        productosEnvioService.update(body, id);
        return ResponseEntity.ok(body);
    }

}