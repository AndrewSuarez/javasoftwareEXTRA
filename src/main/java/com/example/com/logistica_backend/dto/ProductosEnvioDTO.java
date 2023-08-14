package com.example.com.logistica_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductosEnvioDTO {

    @JsonProperty(value = "id_producto")
    private Long idProducto;

    @JsonProperty(value = "cantidad")
    private Integer cantidad;

    @JsonProperty(value = "id_envio")
    private Long idEnvio;

}
