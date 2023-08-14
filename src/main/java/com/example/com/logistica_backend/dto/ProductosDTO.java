package com.example.com.logistica_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductosDTO {

    @JsonProperty(value = "tipo_producto")
    private String tipoProducto;

}
