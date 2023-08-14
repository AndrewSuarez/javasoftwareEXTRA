package com.example.com.logistica_backend.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "descuentos")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Descuentos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_descuento")
    private Long idDescuento;

    @Column(name = "porcentaje")
    private Integer porcentaje;

}