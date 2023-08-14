package com.example.com.logistica_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DescuentosDTO {

    @JsonProperty(value = "porcentaje")
    private Integer porcentaje;

}
