package com.example.com.logistica_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EnvioDTO {

    @JsonProperty(value = "id_cliente")
    private Long idCliente;

    @JsonProperty(value = "tipo_de_envio")
    private String tipoDeEnvio;

    @JsonProperty(value = "fecha_registro")
    private String fechaRegistro;

    @JsonProperty(value = "fecha_entrega")
    private String fechaEntrega;

    @JsonProperty(value = "id_transporte")
    private Long idTransporte;

    @JsonProperty(value = "id_almacen")
    private Long idAlmacen;

    @JsonProperty(value = "precio_envio")
    private Integer precioEnvio;

    @JsonProperty(value = "id_descuento")
    private Long idDescuento;

}
