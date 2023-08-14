package com.example.com.logistica_backend.controller;

import com.example.com.logistica_backend.dto.TipoAlmacenDTO;
import com.example.com.logistica_backend.model.TipoAlmacen;
import com.example.com.logistica_backend.service.TipoAlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipoAlmacen")
public class TipoAlmacenController {

    @Autowired
    private TipoAlmacenService tipoAlmacenService;

    @PostMapping
    private ResponseEntity<TipoAlmacenDTO> guardar (@RequestBody TipoAlmacenDTO tipoAlmacenDTO){
        TipoAlmacenDTO temp = tipoAlmacenService.create(tipoAlmacenDTO);
        return ResponseEntity.ok(temp);
    }

    @GetMapping(value = "/lista")
    private ResponseEntity<List<TipoAlmacen>> listAllTipoAlmacen (){
        return ResponseEntity.ok(tipoAlmacenService.getAllTipoAlmacenes());
    }
    @DeleteMapping(value = "/{id}")
    private ResponseEntity<Void> deleteTipoAlmacen (@PathVariable Long id){
        tipoAlmacenService.deleteTipoAlmacen(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "/{id}")
    private ResponseEntity<TipoAlmacen> listTipoAlmacenById (@PathVariable ("id") Long id){
        return ResponseEntity.ok(tipoAlmacenService.findById(id));
    }

    @PostMapping(value = "/update/{id}")
    private ResponseEntity<TipoAlmacenDTO> update (@RequestBody TipoAlmacenDTO tipoAlmacenDTO, @PathVariable ("id") Long id){
        tipoAlmacenService.updateTipoAlmacen(tipoAlmacenDTO, id);
        return ResponseEntity.ok(tipoAlmacenDTO);


    }
}
