package com.example.com.logistica_backend.service;


import com.example.com.logistica_backend.dto.EnvioDTO;
import com.example.com.logistica_backend.model.*;
import com.example.com.logistica_backend.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnvioService {

    private final EnvioRepository envioRepository;
    private final ClienteService clienteService;
    private final TransporteService transporteService;
    private final AlmacenService almacenService;
    private final DescuentosService descuentosService;
    @Autowired
    public EnvioService(EnvioRepository envioRepository, ClienteService clienteService, TransporteService transporteService, AlmacenService almacenService, DescuentosService descuentosService) {
        this.envioRepository = envioRepository;
        this.clienteService = clienteService;
        this.transporteService = transporteService;
        this.almacenService = almacenService;
        this. descuentosService = descuentosService;

    }

    public Envio create (EnvioDTO envioDTO) {

        final Cliente cliente = clienteService.findById(envioDTO.getIdCliente());
        final Transporte transporte = transporteService.findById(envioDTO.getIdTransporte());
        final Almacen almacen = almacenService.findById(envioDTO.getIdAlmacen());
        final Descuentos descuentos = descuentosService.findById(envioDTO.getIdDescuento());

        Envio newEnvio = Envio.builder()
                .cliente(cliente)
                .tipoDeEnvio(envioDTO.getTipoDeEnvio())
                .fechaRegistro(envioDTO.getFechaRegistro())
                .fechaEntrega(envioDTO.getFechaEntrega())
                .transporte(transporte)
                .almacen(almacen)
                .precioEnvio(envioDTO.getPrecioEnvio())
                .descuento(descuentos)
                .build();

        return envioRepository.save(newEnvio);
    }

    public List<Envio> getAll(){
        return envioRepository.findAll();
    }

    public void deleteById (Long id) {
        envioRepository.deleteById(id);
    }

    public Envio findById(Long id){
        return envioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El envio no existe"));
    }

    public EnvioDTO updateEnvio(EnvioDTO envioDTO, Long id) {
        Envio temp = envioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El envio no existe")
        );

        temp.setCliente(clienteService.findById(envioDTO.getIdCliente()));
        temp.setTransporte(transporteService.findById(envioDTO.getIdTransporte()));
        temp.setAlmacen(almacenService.findById(envioDTO.getIdAlmacen()));
        temp.setDescuento(descuentosService.findById(envioDTO.getIdDescuento()));
        temp.setTipoDeEnvio(envioDTO.getTipoDeEnvio());
        temp.setFechaRegistro(envioDTO.getFechaRegistro());
        temp.setFechaEntrega(envioDTO.getFechaEntrega());
        temp.setPrecioEnvio(envioDTO.getPrecioEnvio());

        envioRepository.save(temp);

        return envioDTO;
    }


}
