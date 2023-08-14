package com.example.com.logistica_backend.service;


import com.example.com.logistica_backend.dto.AlmacenDTO;
import com.example.com.logistica_backend.model.Almacen;
import com.example.com.logistica_backend.model.TipoAlmacen;
import com.example.com.logistica_backend.repository.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlmacenService {

    private final AlmacenRepository almacenRepository;
    private final TipoAlmacenService tipoAlmacenService;

    @Autowired
    public AlmacenService(AlmacenRepository almacenRepository, TipoAlmacenService tipoAlmacenService) {
        this.almacenRepository = almacenRepository;
        this.tipoAlmacenService = tipoAlmacenService;

    }

    public Almacen create (AlmacenDTO almacenDTO) {

        final TipoAlmacen tipoAlmacen = tipoAlmacenService.findById(almacenDTO.getIdTipoAlmacen());
        Almacen newAlmacen = Almacen.builder()
                .tipoAlmacen(tipoAlmacen)
                .direccion(almacenDTO.getDireccion())
                .build();

        return almacenRepository.save(newAlmacen);
    }

    public List<Almacen> getAll(){
        return almacenRepository.findAll();
    }

    public void deleteById (Long id) {
        almacenRepository.deleteById(id);
    }

    public Almacen findById(Long id){
        return almacenRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El almacen no existe"));
    }

    public AlmacenDTO updateAlmacen(AlmacenDTO almacenDTO, Long id) {
        Almacen temp = almacenRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El almacen no existe")
        );

        TipoAlmacen tipoAlmacen = tipoAlmacenService.findById(almacenDTO.getIdTipoAlmacen());
        temp.setTipoAlmacen(tipoAlmacen);
        temp.setDireccion(almacenDTO.getDireccion());

        almacenRepository.save(temp);

            return almacenDTO;
    }


}
