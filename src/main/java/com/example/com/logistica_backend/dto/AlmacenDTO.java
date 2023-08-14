package com.example.com.logistica_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlmacenDTO {

    @JsonProperty(value = "id_tipo_almacen")
    private Long idTipoAlmacen;

    @JsonProperty(value = "direccion")
    private String direccion;

}
