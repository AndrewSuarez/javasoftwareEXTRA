package com.example.com.logistica_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TipoTransporteDTO {

    @JsonProperty(value = "nombre")
    private String nombre;

}
