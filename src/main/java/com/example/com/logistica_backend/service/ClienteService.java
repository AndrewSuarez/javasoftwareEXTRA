package com.example.com.logistica_backend.service;

import com.example.com.logistica_backend.dto.ClienteDTO;
import com.example.com.logistica_backend.model.Cliente;
import com.example.com.logistica_backend.repository.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepo clienteRepo;

    public ClienteDTO create (ClienteDTO clienteDTO){
        Cliente temp = new Cliente();
        temp.setNombre(clienteDTO.getNombre());
        temp.setTelefono(clienteDTO.getTelefono());
        temp.setDireccion(clienteDTO.getDireccion());
        temp.setCorreoElectronico(clienteDTO.getCorreoElectronico());
        clienteRepo.save(temp);
        return clienteDTO;
    }

    public List<Cliente> getAllClientes(){
        return clienteRepo.findAll();
    }

    public void deleteCliente (Long id) {
        clienteRepo.deleteById(id);
    }

    public Cliente findById(Long id){
        return clienteRepo.findById(id).orElseThrow(() -> new RuntimeException("El cliente no existe"));
    }

    public ClienteDTO updateCliente(ClienteDTO clienteDTO, Long id){
        Cliente oldCliente = clienteRepo.findById(id).orElseThrow(() -> new RuntimeException("El cliente no existe"));
        oldCliente.setNombre(clienteDTO.getNombre());
        oldCliente.setDireccion(clienteDTO.getDireccion());
        oldCliente.setTelefono(clienteDTO.getTelefono());
        oldCliente.setCorreoElectronico(clienteDTO.getCorreoElectronico());
        clienteRepo.save(oldCliente);
        return clienteDTO;
    }
}
