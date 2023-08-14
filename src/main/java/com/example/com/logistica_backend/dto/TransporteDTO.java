package com.example.com.logistica_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransporteDTO {

    @JsonProperty(value = "id_tipo_transporte")
    private Long idTipoTransporte;

    @JsonProperty(value = "identificador")
    private String identificador;

}
