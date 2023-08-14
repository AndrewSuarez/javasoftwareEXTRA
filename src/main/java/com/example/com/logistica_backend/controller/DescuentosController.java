package com.example.com.logistica_backend.controller;


import com.example.com.logistica_backend.dto.DescuentosDTO;
import com.example.com.logistica_backend.model.Descuentos;
import com.example.com.logistica_backend.service.DescuentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/descuentos")
public class DescuentosController {

    @Autowired
    private DescuentosService descuentosService;

    @PostMapping
    private ResponseEntity<DescuentosDTO> guardar (@RequestBody DescuentosDTO descuentosDTO){
        DescuentosDTO temp = descuentosService.create(descuentosDTO);
        return ResponseEntity.ok(temp);
    }

    @GetMapping(value = "/lista")
    private ResponseEntity<List<Descuentos>> listAllDescuentos (){
        return ResponseEntity.ok(descuentosService.getAllDescuentos());
    }
    @DeleteMapping(value = "/{id}")
    private ResponseEntity<Void> deleteDescuento (@PathVariable Long id){
        descuentosService.deleteDescuentos(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "/{id}")
    private ResponseEntity<Descuentos> listDescuentosById (@PathVariable ("id") Long id){
        return ResponseEntity.ok(descuentosService.findById(id));
    }

    @PostMapping(value = "/update/{id}")
    private ResponseEntity<DescuentosDTO> update (@RequestBody DescuentosDTO descuentosDTO, @PathVariable ("id") Long id){
        descuentosService.updateDescuentos(descuentosDTO, id);
        return ResponseEntity.ok(descuentosDTO);


    }
}