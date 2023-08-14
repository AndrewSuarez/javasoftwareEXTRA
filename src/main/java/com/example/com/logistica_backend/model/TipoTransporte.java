package com.example.com.logistica_backend.model;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tipo_transporte")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TipoTransporte {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_tipo_transporte")
    private Long idTipoTransporte;

    @Column(name = "nombre")
    private String nombre;

}
