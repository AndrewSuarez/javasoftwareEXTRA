package com.example.com.logistica_backend.controller;

import com.example.com.logistica_backend.dto.ProductosDTO;
import com.example.com.logistica_backend.model.Productos;
import com.example.com.logistica_backend.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @PostMapping
    private ResponseEntity<ProductosDTO> guardar (@RequestBody ProductosDTO productosDTO){
        ProductosDTO temp = productosService.create(productosDTO);
            return ResponseEntity.ok(temp);
    }

    @GetMapping(value = "/lista")
    private ResponseEntity<List<Productos>> listAllProductos (){
        return ResponseEntity.ok(productosService.getAllProductos());
    }
    @DeleteMapping(value = "/{id}")
    private ResponseEntity<Void> deleteProductos (@PathVariable Long id){
        productosService.deleteProductos(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "/{id}")
    private ResponseEntity<Productos> listProductosById (@PathVariable ("id") Long id){
        return ResponseEntity.ok(productosService.findById(id));
    }

    @PostMapping(value = "/update/{id}")
    private ResponseEntity<ProductosDTO> update (@RequestBody ProductosDTO productosDTO, @PathVariable ("id") Long id){
        productosService.updateProductos(productosDTO, id);
        return ResponseEntity.ok(productosDTO);


    }
}