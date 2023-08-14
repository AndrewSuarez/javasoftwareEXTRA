package com.example.com.logistica_backend.service;


import com.example.com.logistica_backend.dto.TipoTransporteDTO;
import com.example.com.logistica_backend.model.TipoTransporte;
import com.example.com.logistica_backend.repository.TipoTransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoTransporteService {

    @Autowired
    private TipoTransporteRepository tipoTransporteRepository;

    public TipoTransporte create (TipoTransporteDTO body){
        TipoTransporte tipoTransporte = TipoTransporte.builder().nombre(body.getNombre()).build();
        return tipoTransporteRepository.save(tipoTransporte);
    }

    public List<TipoTransporte> getAll(){
        return tipoTransporteRepository.findAll();
    }

    public void deleteById (Long id) {
        tipoTransporteRepository.deleteById(id);
    }

    public TipoTransporte findById(Long id){
        return tipoTransporteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El tipo de transporte no existe"));
    }

    public TipoTransporteDTO updateTipoTransporte(TipoTransporteDTO tipoTransporteDTO, Long id) {
        TipoTransporte oldTipoTransporte = tipoTransporteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El tipo de transporte no existe"));

        oldTipoTransporte.setNombre(tipoTransporteDTO.getNombre());

        tipoTransporteRepository.save(oldTipoTransporte);

        return tipoTransporteDTO;
    }


}
