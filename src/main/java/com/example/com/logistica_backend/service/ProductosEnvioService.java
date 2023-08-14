package com.example.com.logistica_backend.service;


import com.example.com.logistica_backend.dto.ProductosEnvioDTO;
import com.example.com.logistica_backend.model.*;
import com.example.com.logistica_backend.repository.ProductosEnvioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductosEnvioService {

    private final ProductosEnvioRepo productosEnvioRepo;
    private final EnvioService envioService;
    private final ProductosService productosService;
    @Autowired
    public ProductosEnvioService(ProductosEnvioRepo productosEnvioRepo, EnvioService envioService, ProductosService productosService) {
        this.productosEnvioRepo = productosEnvioRepo;
        this.envioService = envioService;
        this.productosService = productosService;
    }

    public ProductosEnvio create (ProductosEnvioDTO productosEnvioDTO) {

        final Productos productos = productosService.findById(productosEnvioDTO.getIdProducto());
        final Envio envio = envioService.findById(productosEnvioDTO.getIdEnvio());

        ProductosEnvio newProductoEnvio = ProductosEnvio.builder()
                .productos(productos)
                .cantidad(productosEnvioDTO.getCantidad())
                .envio(envio)
                .build();

        return productosEnvioRepo.save(newProductoEnvio);
    }

    public List<ProductosEnvio> getAll(){
        return productosEnvioRepo.findAll();
    }

    public void deleteById (Long id) {
        productosEnvioRepo.deleteById(id);
    }

    public List<ProductosEnvio> findByEnvio(Long id){
        return productosEnvioRepo.findByEnvio_idEnvio(id);
    }

    public ProductosEnvioDTO update(ProductosEnvioDTO productosEnvioDTO, Long id) {
        ProductosEnvio temp = productosEnvioRepo.findById(id).orElseThrow(
                () -> new RuntimeException("La entidad que intenta modificar no existe")
        );

        temp.setProductos(productosService.findById(productosEnvioDTO.getIdProducto()));
        temp.setEnvio(envioService.findById(productosEnvioDTO.getIdEnvio()));
        temp.setCantidad(productosEnvioDTO.getCantidad());

        productosEnvioRepo.save(temp);

        return productosEnvioDTO;
    }


}

