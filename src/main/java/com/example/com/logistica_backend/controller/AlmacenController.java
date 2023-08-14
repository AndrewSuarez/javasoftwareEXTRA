package com.example.com.logistica_backend.controller;


import com.example.com.logistica_backend.dto.AlmacenDTO;
import com.example.com.logistica_backend.model.Almacen;
import com.example.com.logistica_backend.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/almacen")
public class AlmacenController {

    @Autowired
    private AlmacenService almacenService;

    @PostMapping
    private ResponseEntity<Almacen> guardar (
            @RequestBody AlmacenDTO body
    ) {
        try{
            Almacen savedAlmacen = almacenService.create(body);
            return ResponseEntity.ok(savedAlmacen);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/lista")
    private ResponseEntity<List<Almacen>> listAllAlmacen () {
        return ResponseEntity.ok(almacenService.getAll());
    }

    @DeleteMapping(value = "/{id}")
    private ResponseEntity<String> deleteAlmacen (@PathVariable Long id){
        almacenService.deleteById(id);
        return ResponseEntity.ok("Eliminado con exito el almacen: " + id);
    }

    @GetMapping (value = "/{id}")
    private ResponseEntity<Almacen> getAlmacenById (
            @PathVariable ("id") Long id
    ) {
        return ResponseEntity.ok(almacenService.findById(id));
    }

    @PostMapping(value = "/update/{id}")
    private ResponseEntity<AlmacenDTO> update (
            @PathVariable("id") Long id,
            @RequestBody AlmacenDTO body
    ) {
        almacenService.updateAlmacen(body, id);
        return ResponseEntity.ok(body);
    }

}
