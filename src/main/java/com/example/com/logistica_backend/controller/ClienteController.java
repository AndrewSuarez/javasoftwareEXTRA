package com.example.com.logistica_backend.controller;

import com.example.com.logistica_backend.dto.ClienteDTO;
import com.example.com.logistica_backend.model.Cliente;
import com.example.com.logistica_backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;

    @PostMapping
    private ResponseEntity<ClienteDTO> guardar (@RequestBody ClienteDTO clienteDTO){
        ClienteDTO temp = clienteService.create(clienteDTO);
        return ResponseEntity.ok(temp);
    }


    @GetMapping (value = "/lista")
    private ResponseEntity<List<Cliente>> listAllClientes (){
        return ResponseEntity.ok(clienteService.getAllClientes());
    }
    @DeleteMapping(value = "/{id}")
    private ResponseEntity<Void> deleteCliente (@PathVariable Long id){
        clienteService.deleteCliente(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "/{id}")
    private ResponseEntity<Cliente> listClientesById (@PathVariable ("id") Long id){
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PostMapping(value = "/update/{id}")
    private ResponseEntity<ClienteDTO> update (@RequestBody ClienteDTO clienteDTO, @PathVariable ("id") Long id){
        clienteService.updateCliente(clienteDTO, id);
        return ResponseEntity.ok(clienteDTO);


    }
}
