package com.example.com.logistica_backend.service;

import com.example.com.logistica_backend.dto.TipoAlmacenDTO;
import com.example.com.logistica_backend.model.TipoAlmacen;
import com.example.com.logistica_backend.repository.TipoAlmacenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoAlmacenService {
    @Autowired
    private TipoAlmacenRepo tipoAlmacenRepo;

    public TipoAlmacenDTO create (TipoAlmacenDTO tipoAlmacenDTO){
        TipoAlmacen temp = new TipoAlmacen();
        temp.setNombre(tipoAlmacenDTO.getNombre());
        tipoAlmacenRepo.save(temp);
        return tipoAlmacenDTO;
    }

    public List<TipoAlmacen> getAllTipoAlmacenes(){
        return tipoAlmacenRepo.findAll();
    }

    public void deleteTipoAlmacen (Long id) {
        tipoAlmacenRepo.deleteById(id);
    }

    public TipoAlmacen findById(Long id){
        return tipoAlmacenRepo.findById(id).orElseThrow(
                () -> new RuntimeException("El tipo de almacen no existe"));
    }

    public TipoAlmacenDTO updateTipoAlmacen(TipoAlmacenDTO tipoAlmacenDTO, Long id){
        TipoAlmacen oldTipoAlmacen = tipoAlmacenRepo.findById(id).orElseThrow(
                () -> new RuntimeException("El tipo de almacen no existe"));
        oldTipoAlmacen.setNombre(tipoAlmacenDTO.getNombre());
        tipoAlmacenRepo.save(oldTipoAlmacen);
        return tipoAlmacenDTO;
    }
}
