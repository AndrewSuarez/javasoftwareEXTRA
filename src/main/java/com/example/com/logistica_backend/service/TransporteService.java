package com.example.com.logistica_backend.service;


import com.example.com.logistica_backend.dto.TransporteDTO;
import com.example.com.logistica_backend.model.TipoTransporte;
import com.example.com.logistica_backend.model.Transporte;
import com.example.com.logistica_backend.repository.TransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransporteService {

    private final TransporteRepository transporteRepository;
    private final TipoTransporteService tipoTransporteService;

    @Autowired
    public TransporteService(TransporteRepository transporteRepository, TipoTransporteService tipoTransporteService) {
        this.transporteRepository = transporteRepository;
        this.tipoTransporteService = tipoTransporteService;

    }

    public Transporte create (TransporteDTO transporteDTO) {

        final TipoTransporte tipoTransporte = tipoTransporteService.findById(transporteDTO.getIdTipoTransporte());
        Transporte newTransporte = Transporte.builder()
                .tipoTransporte(tipoTransporte)
                .identificador(transporteDTO.getIdentificador())
                .build();

        return transporteRepository.save(newTransporte);
    }

    public List<Transporte> getAll(){
        return transporteRepository.findAll();
    }

    public void deleteById (Long id) {
        transporteRepository.deleteById(id);
    }

    public Transporte findById(Long id){
        return transporteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El transporte no existe"));
    }

    public TransporteDTO updateTransporte(TransporteDTO transporteDTO, Long id) {
        Transporte temp = transporteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El transporte no existe")
        );

        TipoTransporte tipoTransporte = tipoTransporteService.findById(transporteDTO.getIdTipoTransporte());
        temp.setTipoTransporte(tipoTransporte);
        temp.setIdentificador(transporteDTO.getIdentificador());

        transporteRepository.save(temp);


        return transporteDTO;
    }


}
