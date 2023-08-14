package com.example.com.logistica_backend.controller;

import com.example.com.logistica_backend.dto.TransporteDTO;
import com.example.com.logistica_backend.model.Transporte;
import com.example.com.logistica_backend.service.TransporteService;
import com.example.com.logistica_backend.service.TransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transporte")
public class TransporteController {

    @Autowired
    private TransporteService transporteService;

    @PostMapping
    private ResponseEntity<Transporte> guardar (
            @RequestBody TransporteDTO body
    ) {
        try{
            Transporte savedTransporte = transporteService.create(body);
            return ResponseEntity.ok(savedTransporte);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/lista")
    private ResponseEntity<List<Transporte>> listAllTransportes () {
        return ResponseEntity.ok(transporteService.getAll());
    }

    @DeleteMapping(value = "/{id}")
    private ResponseEntity<String> deleteTransporte (@PathVariable Long id){
        transporteService.deleteById(id);
        return ResponseEntity.ok("Eliminado con exito el transporte: " + id);
    }

    @GetMapping (value = "/{id}")
    private ResponseEntity<Transporte> getTransporteById (
            @PathVariable ("id") Long id
    ) {
        return ResponseEntity.ok(transporteService.findById(id));
    }

    @PostMapping(value = "/update/{id}")
    private ResponseEntity<TransporteDTO> update (
            @PathVariable("id") Long id,
            @RequestBody TransporteDTO body
    ) {
        transporteService.updateTransporte(body, id);
        return ResponseEntity.ok(body);
    }

}
