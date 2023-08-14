package com.example.com.logistica_backend.controller;


import com.example.com.logistica_backend.dto.EnvioDTO;
import com.example.com.logistica_backend.model.Envio;
import com.example.com.logistica_backend.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envio")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @PostMapping
    private ResponseEntity<Envio> guardar (
            @RequestBody EnvioDTO body
    ) {
        try{
            Envio savedEnvio = envioService.create(body);
            return ResponseEntity.ok(savedEnvio);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/lista")
    private ResponseEntity<List<Envio>> listAllEnvios () {
        return ResponseEntity.ok(envioService.getAll());
    }

    @DeleteMapping(value = "/{id}")
    private ResponseEntity<String> deleteEnvio (@PathVariable Long id){
        envioService.deleteById(id);
        return ResponseEntity.ok("Eliminado con exito el envio: " + id);
    }

    @GetMapping (value = "/{id}")
    private ResponseEntity<Envio> getEnvioById (
            @PathVariable ("id") Long id
    ) {
        return ResponseEntity.ok(envioService.findById(id));
    }

    @PostMapping(value = "/update/{id}")
    private ResponseEntity<EnvioDTO> update (
            @PathVariable("id") Long id,
            @RequestBody EnvioDTO body
    ) {
        envioService.updateEnvio(body, id);
        return ResponseEntity.ok(body);
    }

}