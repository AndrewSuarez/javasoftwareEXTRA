package com.example.com.logistica_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteDTO {

    @JsonProperty(value = "nombre")
    private String nombre;

    @JsonProperty(value = "direccion")
    private String direccion;

    @JsonProperty(value = "telefono")
    private Integer telefono;

    @JsonProperty(value = "correoElectronico")
    private String correoElectronico;

}