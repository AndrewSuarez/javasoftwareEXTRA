package com.example.com.logistica_backend.controller;

import com.example.com.logistica_backend.dto.TipoTransporteDTO;
import com.example.com.logistica_backend.model.TipoTransporte;
import com.example.com.logistica_backend.service.TipoTransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-transporte")
public class TipoTransporteController {

    @Autowired
    private TipoTransporteService tipoTransporteService;

    @PostMapping
    private ResponseEntity<TipoTransporte> guardar (
            @RequestBody TipoTransporteDTO body
    ) {
        try{
            TipoTransporte savedTipoTransporte = tipoTransporteService.create(body);
            return ResponseEntity.ok(savedTipoTransporte);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/lista")
    private ResponseEntity<List<TipoTransporte>> listAllTiposDeTransporte () {
        return ResponseEntity.ok(tipoTransporteService.getAll());
    }

    @DeleteMapping(value = "/{id}")
    private ResponseEntity<String> deleteTipoDeTransporte (@PathVariable Long id){
        tipoTransporteService.deleteById(id);
        return ResponseEntity.ok("Eliminado con exito el tipo de transporte: " + id);
    }

    @GetMapping (value = "/{id}")
    private ResponseEntity<TipoTransporte> getTipoTransporteById (
            @PathVariable ("id") Long id
    ) {
        return ResponseEntity.ok(tipoTransporteService.findById(id));
    }

    @PostMapping(value = "/update/{id}")
    private ResponseEntity<TipoTransporteDTO> update (
            @PathVariable("id") Long id,
            @RequestBody TipoTransporteDTO body
    ) {
        tipoTransporteService.updateTipoTransporte(body, id);
        return ResponseEntity.ok(body);


    }

}
