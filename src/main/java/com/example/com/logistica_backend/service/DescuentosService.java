package com.example.com.logistica_backend.service;

import com.example.com.logistica_backend.dto.DescuentosDTO;
import com.example.com.logistica_backend.model.Descuentos;
import com.example.com.logistica_backend.repository.DescuentosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescuentosService {
    @Autowired
    private DescuentosRepo descuentosRepo;

    public DescuentosDTO create (DescuentosDTO descuentosDTO){
        Descuentos temp = new Descuentos();
        temp.setPorcentaje(descuentosDTO.getPorcentaje());
        descuentosRepo.save(temp);
        return descuentosDTO;
    }

    public List<Descuentos> getAllDescuentos(){
        return descuentosRepo.findAll();
    }

    public void deleteDescuentos (Long id) {
        descuentosRepo.deleteById(id);
    }

    public Descuentos findById(Long id){
        return descuentosRepo.findById(id).orElseThrow(() -> new RuntimeException("El descuento no existe"));
    }

    public DescuentosDTO updateDescuentos(DescuentosDTO descuentosDTO, Long id){
        Descuentos oldDescuentos = descuentosRepo.findById(id).orElseThrow(() -> new RuntimeException("El descuento no existe"));
        oldDescuentos.setPorcentaje(descuentosDTO.getPorcentaje());
        descuentosRepo.save(oldDescuentos);
        return descuentosDTO;
    }
}